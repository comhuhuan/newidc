package com.act.web.module.command.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.IsmscIdcCommand;
import com.act.idc.model.IsmscIdcCommandRule;
import com.act.idc.model.TabServiceInformation;
import com.act.mapper.entity.Example;
import com.act.mapper.entity.Example.Criteria;
import com.act.util.validate.ValidatorUtil;
import com.act.web.enums.ButtonEnum;
import com.act.web.enums.CmdSystemEnum;
import com.act.web.enums.ExcStateEnum;
import com.act.web.enums.InfoSecuCmdTypeEnum;
import com.act.web.enums.OperationTypeEnum;
import com.act.web.enums.SendStateEnum;
import com.act.web.module.command.service.InfoSecurityCmdService;
import com.act.web.module.command.vo.InfoSecurityCmdVo;
import com.act.web.module.command.vo.OperationButtonVo;
import com.act.web.module.command.vo.ViewEuVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: InfoSecurityCmdServiceImpl.java
 * <p>Description: 信息安全管理指令服务层接口实现类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:01:28
 */ 
@Service
public class InfoSecurityCmdServiceImpl implements InfoSecurityCmdService {
    /**
     * 部分处理成功
     */
    String partSuccess = "5";

    @Override
    public PageResult<InfoSecurityCmdVo> findList(String curSystem, PageResult<InfoSecurityCmdVo> page,
            InfoSecurityCmdVo infoSecurityCmdVo) {
        StringBuilder sql = new StringBuilder("select model.idcCommandID as idcCommandId,");
        sql.append(" model.ctype as commandType, date_format(model.timeStamp,'%Y-%m-%d %H:%i:%s') as createTime, ")
                .append(" model.commandID as commandId, model.`owner` AS owner, model.operationType as operationType, ")
                .append(" (case model.visible when '0' then '不可读' when '1' then '可读' end) AS visible,")
                .append(" '' as excState, '' as excTime, UNIX_TIMESTAMP(model.expiredTime)*1000 as expiredTime ")
                .append(" FROM ismsc_idccommand model  WHERE 1=1 ");

        List<Object> params = new ArrayList<>();
        if (StringUtils.isNotEmpty(curSystem)) {
            String cmdSource = curSystem;
            // 0-SMMS(上级) 1-CU (本级)
            if (CmdSystemEnum.CU.getType().equals(curSystem)) {
                cmdSource = CmdSystemEnum.SMMS.getType();
            } else if (CmdSystemEnum.EU_ACK.getType().equals(curSystem)) {
                cmdSource = CmdSystemEnum.CU.getType();
            }
            sql.append(" AND cmdFlag = ? ");
            params.add(cmdSource);
        }

        if (infoSecurityCmdVo != null) {
            String commandTypeQuery = infoSecurityCmdVo.getCommandTypeQuery();
            String excStateQuery = infoSecurityCmdVo.getExcStateQuery();
            String createDateQuery = infoSecurityCmdVo.getCreateDateQuery();
            String serviceCodeQuery = infoSecurityCmdVo.getServiceCodeQuery();
            // 指令类型查询
            if (StringUtils.isNotEmpty(commandTypeQuery)) {
                sql.append(" AND model.ctype = ? ");
                params.add(commandTypeQuery.trim());
            }
            // 机房名称查询
            if (StringUtils.isNotEmpty(serviceCodeQuery)) {
                sql.append(" AND model.idcCommandID IN ")
                        .append("(SELECT DISTINCT idcCommandID FROM ismsc_idccommandrule WHERE service_code = ")
                        .append(serviceCodeQuery).append(") ");
            }
            // 生成时间查询
            if (StringUtils.isNotEmpty(createDateQuery)) {
                sql.append(" AND substr(model.timeStamp,1,10) = ? ");
                params.add(createDateQuery);
            }
            // 下发状态查询
            if (StringUtils.isNotEmpty(excStateQuery)) {
                // 得出查询的下发状态所对应的commandId
                List<Long> idcCommandIDList = selectCommandId(excStateQuery, "ismsc_idccommandrule");
                sql.append("  AND model.idcCommandID IN (0 ");
                if (CollectionUtils.isNotEmpty(idcCommandIDList)) {
                    for (int i = 0; i < idcCommandIDList.size(); i++) {
                        sql.append(",").append(idcCommandIDList.get(i));
                    }
                }
                sql.append(" ) ");
            }
        }
        sql.append(" ORDER BY model.timeStamp DESC");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        // 分页查询
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), InfoSecurityCmdVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        // 处理下发时间和下发状态
        handleExcState(page.getRows());
        // 添加下发、取消下发、查看eu按钮
        setOperationButton(page.getRows(), curSystem);
        return page;
    }

    /**
     * 处理下发时间和下发状态
     * 
     * @param list
     */
    public void handleExcState(List<InfoSecurityCmdVo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<Long> commandIdList = new ArrayList<>();
            //获取不重复的commandId
            for (InfoSecurityCmdVo vo : list) {
                if (!commandIdList.contains(vo.getCommandId())) {
                    commandIdList.add(vo.getCommandId());
                }
            }
            StringBuilder subSql = new StringBuilder();
            subSql.append("SELECT idcCommandID as idccommandid, COUNT(*) as total,")
                    .append(" MAX(exctime) as excTime,MAX(unexctime) as unexctime, ")
                    .append(" SUM(CASE excstate WHEN 3 THEN 1 ELSE 0 END) excsucnum, ")
                    .append(" SUM(CASE unexcstate WHEN 3 THEN 1 ELSE 0 END) unexcsucnum, ")
                    .append(" SUM(CASE excstate WHEN 5 THEN 1 ELSE 0 END) excpartnum, ")
                    .append(" SUM(CASE unexcstate WHEN 5 THEN 1 ELSE 0 END) unexcpartnum, ")
                    .append(" SUM(CASE excstate WHEN 2 THEN 1 ELSE 0 END) excingnum, ")
                    .append(" SUM(CASE unexcstate WHEN 2 THEN 1 ELSE 0 END) unexcingnum ")
                    .append(" FROM ismsc_idccommandrule WHERE commandid in (0 ");
            for (int i = 0; i < commandIdList.size(); i++) {
                subSql.append(",").append(commandIdList.get(i));
            }
            subSql.append(" ) GROUP BY idcCommandID ");
            List<Map<String, Object>> excList = DbUtil.queryForMapList(subSql.toString());
            if (CollectionUtils.isNotEmpty(excList)) {
                for (InfoSecurityCmdVo vo : list) {
                    for (Map<String, Object> map : excList) {
                        if (vo.getIdcCommandId().equals(Long.valueOf(map.get("idccommandid").toString()))) {
                            // 新增类型
                            if (OperationTypeEnum.INSERT.getType().equals(vo.getOperationType())) {
                                // 下发
                                if (map.get("total").toString().equals(map.get("excsucnum").toString())) {
                                    vo.setExcState(ExcStateEnum.HANDLE_SUCCESS.getType());
                                } else {
                                    // 还存在正在下发策略
                                    if (Integer.valueOf(map.get("excingnum").toString()) > 0) {
                                        vo.setExcState(ExcStateEnum.IS_HANDLING.getType());
                                    } else {
                                        // 机房中部分EU下发成功条数大于0或者部分下发成功数>0
                                        if (Integer.valueOf(map.get("excsucnum").toString()) > 0
                                                || Integer.valueOf(map.get("excpartnum").toString()) > 0) {
                                            vo.setExcState(partSuccess);
                                        } else {
                                            // 下发失败
                                            vo.setExcState(ExcStateEnum.HANDLE_FAIL.getType());
                                        }
                                    }
                                }
                                String excTime = map.get("exctime").toString();
                                if (StringUtils.isNotEmpty(excTime)) {
                                    vo.setExcTime(excTime);
                                } else {
                                    vo.setExcTime("");
                                }
                                // 删除类型
                            } else if (OperationTypeEnum.DELETE.getType().equals(vo.getOperationType())) {
                                // 取消下发成功
                                if (map.get("total").toString().equals(map.get("unexcsucnum").toString())) {
                                    vo.setExcState(ExcStateEnum.HANDLE_SUCCESS.getType());
                                } else {
                                    // 还存在正在取消的策略
                                    if (Integer.valueOf(map.get("unexcingnum").toString()) > 0) {
                                        vo.setExcState(ExcStateEnum.IS_HANDLING.getType());
                                    } else {
                                        // 机房中部分EU取消成功或者取消成功条数大于0
                                        if (Integer.valueOf(map.get("unexcsucnum").toString()) > 0
                                                || Integer.valueOf(map.get("unexcpartnum").toString()) > 0) {
                                            vo.setExcState(partSuccess);
                                        } else {
                                            vo.setExcState(ExcStateEnum.HANDLE_FAIL.getType());
                                        }
                                    }
                                }
                                String unExcTime = map.get("unexctime").toString();
                                if (StringUtils.isNotEmpty(unExcTime)) {
                                    vo.setExcTime(unExcTime);
                                } else {
                                    vo.setExcTime("");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 下发状态查询的处理
     * 
     * @param excStateQuery
     * @return List<Long>
     */
    public static List<Long> selectCommandId(String excStateQuery, String tabName) {
        StringBuffer sqlForRule = new StringBuffer("SELECT idcCommandID as idccommandid, COUNT(*) total, ")
                .append(" SUM(CASE (CASE operationType WHEN 0 THEN excstate WHEN 1 THEN unexcstate END ) WHEN 4 THEN 1 ELSE 0 END) failnum, ")
                .append(" SUM(CASE (CASE operationType WHEN 0 THEN excstate WHEN 1 THEN unexcstate END ) WHEN 3 THEN 1 ELSE 0 END) sucnum, ")
                .append(" SUM(CASE (CASE operationType WHEN 0 THEN excstate WHEN 1 THEN unexcstate END ) WHEN 2 THEN 1 ELSE 0 END) nonum, ")
                .append(" SUM(CASE (CASE operationType WHEN 0 THEN excstate WHEN 1 THEN unexcstate END ) WHEN 1 THEN 1 ELSE 0 END) waitnum ")
                .append(" FROM ").append(tabName).append("GROUP BY idcCommandID ");
        List<Map<String, Object>> list = DbUtil.queryForMapList(sqlForRule.toString());
        List<Long> idcCommandIDList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            // 1=等待处理
            if (ExcStateEnum.WAIT_HANDLE.getType().equals(excStateQuery)) {
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = list.get(i);
                    // 总数=正在处理的个数
                    if (map.get("total").toString().equals(map.get("waitnum").toString())) {
                        idcCommandIDList.add(Long.valueOf(map.get("idcCommandId").toString()));
                    }
                }
                // 2=正在处理
            } else if (ExcStateEnum.IS_HANDLING.getType().equals(excStateQuery)) {
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = list.get(i);
                    // 正在处理的个数>0
                    if (Integer.valueOf(map.get("nonum").toString()) > 0) {
                        idcCommandIDList.add(Long.valueOf(map.get("idcCommandId").toString()));
                    }
                }
                // 3=处理成功
            } else if (ExcStateEnum.HANDLE_SUCCESS.getType().equals(excStateQuery)) {
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = list.get(i);
                    // 处理失败个数=正在处理的个数
                    if (map.get("sucnum").toString().equals(map.get("total").toString())) {
                        idcCommandIDList.add(Long.valueOf(map.get("idcCommandId").toString()));
                    }
                }
                // 4=处理失败
            } else if (ExcStateEnum.HANDLE_FAIL.getType().equals(excStateQuery)) {
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = list.get(i);
                    // 处理失败的个数=处理成功个数
                    if (map.get("failnum").toString().equals(map.get("total").toString())) {
                        idcCommandIDList.add(Long.valueOf(map.get("idcCommandId").toString()));
                    }
                }
            }
        }
        return idcCommandIDList;
    }

    /**
     * 添加按钮的处理
     * 
     * @param list
     * @param curSystem
     */
    public void setOperationButton(List<InfoSecurityCmdVo> list, String curSystem) {
        if (CmdSystemEnum.CU.getType().equals(curSystem)) {
            if (CollectionUtils.isNotEmpty(list)) {
                for (InfoSecurityCmdVo vo : list) {
                    List<OperationButtonVo> buttonList = new ArrayList<>();
                    buttonList.add(new OperationButtonVo(true, ButtonEnum.CHECK_EU));
                    // 新增类型
                    if (OperationTypeEnum.INSERT.getType().equals(vo.getOperationType())) {
                        // 是否过期
                        if (vo.getExpiredTime() >= System.currentTimeMillis()) {
                            // 正在处理或者处理成功
                            if (ExcStateEnum.IS_HANDLING.getType().equals(vo.getExcState())
                                    || ExcStateEnum.HANDLE_SUCCESS.getType().equals(vo.getExcState())) {
                                buttonList.add(new OperationButtonVo(false, ButtonEnum.SENDING));
                            } else {
                                buttonList.add(new OperationButtonVo(true, ButtonEnum.SEND));
                            }
                        } else {
                            // 已过期
                            buttonList.add(new OperationButtonVo(false, ButtonEnum.EXPIRED));
                        }
                    }
                    // 删除类型
                    if (OperationTypeEnum.DELETE.getType().equals(vo.getOperationType())) {
                        // 是否过期
                        if (vo.getExpiredTime() >= System.currentTimeMillis()) {
                            // 处理失败或部分处理成功
                            if (ExcStateEnum.HANDLE_FAIL.getType().equals(vo.getExcState())
                                    || partSuccess.equals(vo.getExcState())) {
                                buttonList.add(new OperationButtonVo(true, ButtonEnum.CANCEL_SEND));
                            } else {
                                buttonList.add(new OperationButtonVo(false, ButtonEnum.CANCEL_SUCCESS));
                            }
                        } else {
                            // 已过期
                            buttonList.add(new OperationButtonVo(false, ButtonEnum.EXPIRED));
                        }
                    }
                    vo.setOperationButton(buttonList);
                }
            }
        }
    }

    @Override
    public Map<String, List<SelectVo<String>>> init() {
        //回退数据类型
        List<SelectVo<String>> cmdTypeList = new ArrayList<>();
        for (InfoSecuCmdTypeEnum returnDataType : InfoSecuCmdTypeEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(returnDataType.getExplain());
            enumToObject.setValue(returnDataType.getType());
            cmdTypeList.add(enumToObject);
        }
        //执行状态
        List<SelectVo<String>> excStateList = new ArrayList<>();
        for (ExcStateEnum excState : ExcStateEnum.values()) {
            SelectVo<String> selectVo = new SelectVo<String>();
            selectVo.setLabel(excState.getExplain());
            selectVo.setValue(excState.getType());
            excStateList.add(selectVo);
        }
        //机房名称
        List<SelectVo<String>> serviceCodeList = new ArrayList<>();
        List<TabServiceInformation> service = TabServiceInformation.getDao().selectAll();
        for (TabServiceInformation tabServiceInformation : service) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(tabServiceInformation.getServiceName());
            enumToObject.setValue(tabServiceInformation.getServiceCode());
            serviceCodeList.add(enumToObject);
        }

        Map<String, List<SelectVo<String>>> object = new HashMap<>(3);
        object.put("cmdTypeList", cmdTypeList);
        object.put("excStateList", excStateList);
        object.put("serviceCodeList", serviceCodeList);
        return object;
    }

    @Override
    public PageResult<ViewEuVo> viewEu(PageResult<ViewEuVo> page, ViewEuVo viewEuVo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT tsi.service_name as serviceName,tic.interface_name as euName, ")
                .append(" iie.result_code as resultCode,iie.cur_time as curTime,iie.msg_info as msgInfo ")
                .append("FROM ismsc_idccommand_eu iie, ")
                .append("tab_interface_config tic,tab_service_information tsi ")
                .append("WHERE iie.eu_id = tic.interface_id AND iie.service_code = tsi.service_code ");

        List<Object> params = new ArrayList<Object>();
        Long idcCommandId = viewEuVo.getIdcCommandId();
        if (idcCommandId != null) {
            sql.append("AND iie.idccommand_id = ? ");
            params.add(idcCommandId);
        }
        Long commandId = viewEuVo.getCommandId();
        if (commandId != null) {
            sql.append("AND iie.command_id = ? ");
            params.add(commandId);
        }
        /* START 搜索条件 */
        // 机房名称
        String serviceCodeQuery = viewEuVo.getServiceCodeQuery();
        if (StringUtils.isNotEmpty(serviceCodeQuery)) {
            sql.append("AND iie.service_code = ? ");
            params.add(serviceCodeQuery);
        }
        // eu名称
        String euNameQuery = viewEuVo.getEuNameQuery();
        if (StringUtils.isNotEmpty(euNameQuery)) {
            sql.append("AND tic.interface_name like ? ");
            params.add("%" + euNameQuery.trim() + "%");
        }
        // 状态
        String resultCodeQuery = viewEuVo.getResultCodeQuery();
        if (StringUtils.isNotEmpty(resultCodeQuery)) {
            // 状态为：下发成功或者取消成功
            if (SendStateEnum.SEND_SUCCESS.getType().equals(resultCodeQuery)
                    || SendStateEnum.CANCEL_SUCCESS.getType().equals(resultCodeQuery)) {
                sql.append("AND iie.result_code = ? ");
                params.add(resultCodeQuery);
            } else {
                sql.append("AND iie.result_code != ? ");
                params.add(SendStateEnum.SEND_SUCCESS.getType());
                sql.append("AND iie.result_code != ? ");
                params.add(SendStateEnum.CANCEL_SUCCESS.getType());
            }
        }
        /* END 搜索条件 */
        sql.append("ORDER BY cur_time desc ");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), ViewEuVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

    @Override
    public PageResult<InfoSecurityCmdVo> viewDetail(PageResult<InfoSecurityCmdVo> page,
            InfoSecurityCmdVo infoSecurityCmdVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select model.idcCommandID as idcCommandId, model.commandID as commandId, ")
                .append(" model.ctype as commandType, model.subtype as subType, model.valueStart as valueStart, ")
                .append("model.valueEnd as valueEnd,model.operationType as operationType, ")
                .append("(case model.operationType when '0' then model.excstate when '1' then model.unexcstate end) as excState, ")
                .append("(case model.operationType when '0' then model.exctime when '1' then model.unexctime end) as excTime, ")
                .append("b.service_name as serviceName ").append(" from ismsc_idccommandrule model ")
                .append("left join tab_service_information b on model.service_code = b.service_code ")
                .append("WHERE model.idcCommandID=? AND model.commandID=? AND model.operationType = ? ");

        Object[] param = new Object[3];
        param[0] = infoSecurityCmdVo.getIdcCommandId();
        param[1] = infoSecurityCmdVo.getCommandId();
        param[2] = infoSecurityCmdVo.getOperationType();
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), InfoSecurityCmdVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

    @Override
    public Map<String, List<SelectVo<String>>> euInit() {
        // 下发状态
        List<SelectVo<String>> sendStateList = new ArrayList<>();
        for (SendStateEnum sendState : SendStateEnum.values()) {
            SelectVo<String> selectVo = new SelectVo<String>();
            selectVo.setLabel(sendState.getExplain());
            selectVo.setValue(sendState.getType());
            sendStateList.add(selectVo);
        }
        // 机房名称
        List<SelectVo<String>> serviceCodeList = new ArrayList<>();
        List<TabServiceInformation> service = TabServiceInformation.getDao().selectAll();
        for (TabServiceInformation tabServiceInformation : service) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(tabServiceInformation.getServiceName());
            enumToObject.setValue(tabServiceInformation.getServiceCode());
            serviceCodeList.add(enumToObject);
        }
        Map<String, List<SelectVo<String>>> object = new HashMap<>(3);
        object.put("sendStateList", sendStateList);
        object.put("serviceCodeList", serviceCodeList);
        return object;
    }

    public void updateExcstate(String cmdType, String operationType, Long idcCommandId, Long commandId) {
        /************* START 更新信安指令 ****************/
        IsmscIdcCommand record = IsmscIdcCommand.getByKey(idcCommandId, commandId, cmdType, operationType);
        record.setStatus(ExcStateEnum.IS_HANDLING.getType());
        record.setStatustime(new Date());
        record.update();
        /************* END 更新信安指令 ****************/

        /************* START 更新信安子规则 ****************/
        Example example = new Example(IsmscIdcCommandRule.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idcCommandID", idcCommandId);
        criteria.andEqualTo("commandID", commandId);
        criteria.andEqualTo("operationType", operationType);
        criteria.andEqualTo("ctype", cmdType);
        if (OperationTypeEnum.INSERT.getType().equals(operationType)) {
            criteria.andNotEqualTo("excstate", ExcStateEnum.HANDLE_SUCCESS.getType());
        } else {
            criteria.andNotEqualTo("unexcstate", ExcStateEnum.HANDLE_SUCCESS.getType());
        }
        List<IsmscIdcCommandRule> rules = IsmscIdcCommandRule.getDao().selectByExample(example);
        if (CollectionUtils.isNotEmpty(rules)) {
            for (IsmscIdcCommandRule ismscIdcCommandRule : rules) {
                if (OperationTypeEnum.INSERT.getType().equals(operationType)) {
                    ismscIdcCommandRule.setExcstate(ExcStateEnum.IS_HANDLING.getType());
                    ismscIdcCommandRule.setUnexcstate(ExcStateEnum.WAIT_HANDLE.getType());
                } else {
                    ismscIdcCommandRule.setUnexcstate(ExcStateEnum.IS_HANDLING.getType());
                }
                ismscIdcCommandRule.setUnexctime(new Date());
                ismscIdcCommandRule.update();
            }
        }
        /************* END 更新信安子规则 ****************/
    }

    public void updateExcstate(String cmdType, String operationType, Long commandId) {
        /************* START 更新信安指令 ****************/
        IsmscIdcCommand record = new IsmscIdcCommand();
        List<IsmscIdcCommand> records = IsmscIdcCommand.getDao().select(record);
        if (CollectionUtils.isNotEmpty(records)) {
            for (IsmscIdcCommand ismscIdcCommand : records) {
                ismscIdcCommand.setStatus(ExcStateEnum.IS_HANDLING.getType());
                ismscIdcCommand.setStatustime(new Date());
                ismscIdcCommand.update();
            }
        }
        /************* END 更新信安指令 ****************/

        /************* START 更新信安子规则 ****************/
        Example example = new Example(IsmscIdcCommandRule.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commandID", commandId);
        criteria.andEqualTo("operationType", operationType);
        criteria.andEqualTo("ctype", cmdType);
        if (OperationTypeEnum.INSERT.getType().equals(operationType)) {
            criteria.andNotEqualTo("excstate", ExcStateEnum.HANDLE_SUCCESS.getType());
        } else {
            criteria.andNotEqualTo("unexcstate", ExcStateEnum.HANDLE_SUCCESS.getType());
        }
        List<IsmscIdcCommandRule> rules = IsmscIdcCommandRule.getDao().selectByExample(example);
        if (CollectionUtils.isNotEmpty(rules)) {
            for (IsmscIdcCommandRule ismscIdcCommandRule : rules) {
                if (OperationTypeEnum.INSERT.getType().equals(operationType)) {
                    ismscIdcCommandRule.setExcstate(ExcStateEnum.IS_HANDLING.getType());
                    ismscIdcCommandRule.setUnexcstate(ExcStateEnum.WAIT_HANDLE.getType());
                } else {
                    ismscIdcCommandRule.setUnexcstate(ExcStateEnum.IS_HANDLING.getType());
                }
                ismscIdcCommandRule.setUnexctime(new Date());
                ismscIdcCommandRule.update();
            }
        }
        /************* END 更新信安子规则 ****************/
    }

    @Override
    public void sendOrCancel(Long commandId, Long idcCommandId) {
        // TODO Auto-generated method stub
    }
}
