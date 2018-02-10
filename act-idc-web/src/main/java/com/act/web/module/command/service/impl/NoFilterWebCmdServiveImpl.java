package com.act.web.module.command.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.TabServiceInformation;
import com.act.web.enums.ButtonEnum;
import com.act.web.enums.CmdSystemEnum;
import com.act.web.enums.ExcStateEnum;
import com.act.web.enums.NoFilterTypeEnum;
import com.act.web.enums.OperationTypeEnum;
import com.act.web.module.command.service.NoFilterWebCmdServive;
import com.act.web.module.command.vo.NoFilterWebCmdVo;
import com.act.web.module.command.vo.NoFilterWebRuleVo;
import com.act.web.module.command.vo.OperationButtonVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * *********************************************************
 * <code>The NoFilterWebCmdServiveImpl</code>
 * 
 * @description：免过滤网站指令服务层接口实现类
 * @author chenxin
 * @since V5040
 * @Date 2018年1月26日 下午1:43:05 * * * * * * * * * * * * * * *
 * ******************************************
 */
@Service
public class NoFilterWebCmdServiveImpl implements NoFilterWebCmdServive {
    /**
     * 部分处理成功
     */
    String partSuccess = "5";

    @Override
    public Map<String, List<SelectVo<String>>> init() {
        //免过滤类型
        List<SelectVo<String>> noFilterTypeList = new ArrayList<>();
        for (NoFilterTypeEnum returnDataType : NoFilterTypeEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(returnDataType.getExplain());
            enumToObject.setValue(returnDataType.getType());
            noFilterTypeList.add(enumToObject);
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
        object.put("noFilterTypeList", noFilterTypeList);
        object.put("excStateList", excStateList);
        object.put("serviceCodeList", serviceCodeList);
        return object;

    }

    @Override
    public PageResult<NoFilterWebCmdVo> findList(String curSystem, PageResult<NoFilterWebCmdVo> page,
            NoFilterWebCmdVo noFilterWebCmdVo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT infb.idcCommandID as idcCommandId,infb.commandId as commandId, ")
                .append(" infb.nofilterblack_name as noFilterName, infb.type as noFilterType,infb.operationType as operationType, ")
                .append(" date_format(infb.timeStamp,'%Y-%m-%d %H:%i:%s') as createTime,infb.status as excState FROM")
                .append(" (SELECT SUBSTRING_INDEX(GROUP_CONCAT(DISTINCT nfb.idcCommandID ORDER BY nfb.TIMESTAMP DESC),',',1) AS idcCommandId  ")
                .append(" FROM ismsc_nofilterblack nfb ")
                .append(" INNER JOIN ismsc_nofilterblackrule nfbr ON nfb.idcCommandID = nfbr.idcCommandID WHERE 1=1 ")
                .append(" AND nfb.datatype = '1' ");

        List<Object> params = new ArrayList<>();
        if (noFilterWebCmdVo != null) {
            // 1-域名 2-IP
            String noFilterTypeQuery = noFilterWebCmdVo.getNoFilterTypeQuery();
            if (StringUtils.isNotEmpty(noFilterTypeQuery)) {
                sql.append("AND nfb.type = ? ");
                params.add(noFilterTypeQuery);
            }
            // 指令Id
            Long commandIdQuery = noFilterWebCmdVo.getCommandId();
            if (commandIdQuery != null) {
                sql.append("AND nfb.commandId = ? ");
                params.add(Long.valueOf(commandIdQuery));
            }
            // 机房id
            String serviceCodeQuery = noFilterWebCmdVo.getServiceCodeQuery();
            if (StringUtils.isNotEmpty(serviceCodeQuery)) {
                sql.append("AND model.service_code = ? ");
                params.add(serviceCodeQuery);
            }
            // 开始时间-结束时间
            String startDateQuery = noFilterWebCmdVo.getStartDateQuery();
            String endDateQuery = noFilterWebCmdVo.getEndDateQuery();
            if (StringUtils.isNotEmpty(startDateQuery) && StringUtils.isNotEmpty(endDateQuery)) {
                sql.append("AND SUBSTR(nfb.timeStamp,1,10) >= ? ");
                sql.append("AND SUBSTR(nfb.timeStamp,1,10) <= ? ");
                params.add(startDateQuery);
                params.add(endDateQuery);
            }
            // 指令来源：0-SMMS(上级),1-CU（本级）
            if (StringUtils.isNotEmpty(curSystem)) {
                String cmdSource = curSystem;
                if (CmdSystemEnum.CU.getType().equals(curSystem)) {
                    cmdSource = CmdSystemEnum.SMMS.getType();
                } else if (CmdSystemEnum.EU_ACK.getType().equals(curSystem)) {
                    cmdSource = CmdSystemEnum.CU.getType();
                }
                sql.append("AND nfb.cmdFlag = ? ");
                params.add(cmdSource);
            }
            // 下发状态查询
            String excStateQuery = noFilterWebCmdVo.getExcStateQuery();
            if (StringUtils.isNotEmpty(excStateQuery)) {
                List<Long> idcCommandIDList = InfoSecurityCmdServiceImpl.selectCommandId(excStateQuery,
                        "ismsc_nofilterblackrule");
                sql.append("AND nfb.idcCommandId IN (0 ");
                if (CollectionUtils.isNotEmpty(idcCommandIDList)) {
                    for (int i = 0; i < idcCommandIDList.size(); i++) {
                        sql.append(",").append(idcCommandIDList.get(i));
                    }
                }
                sql.append(") ");
            }
        }
        sql.append("GROUP BY nfb.commandid) tmp ")
                .append(" INNER JOIN ismsc_nofilterblack infb ON tmp.idcCommandID = infb.idcCommandID ")
                .append(" ORDER BY infb.timeStamp DESC ");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), NoFilterWebCmdVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        // 设置按钮
        setOperationButton(page.getRows(), curSystem);
        // 设置执行状态
        handleExcState(page.getRows());
        return page;
    }

    public void handleExcState(List<NoFilterWebCmdVo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<Long> commandIdList = new ArrayList<>();
            for (NoFilterWebCmdVo vo : list) {
                if (!commandIdList.contains(vo.getCommandId())) {
                    commandIdList.add(vo.getCommandId());
                }
            }
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT idcCommandId as idccommandid, COUNT(*) as total, ")
                    .append(" SUM(CASE excstate WHEN 3 THEN 1 ELSE 0 END) excsucnum, ")
                    .append(" SUM(CASE unexcstate WHEN 3 THEN 1 ELSE 0 END) unexcsucnum, ")
                    .append(" SUM(CASE excstate WHEN 5 THEN 1 ELSE 0 END) excpartnum, ")
                    .append(" SUM(CASE unexcstate WHEN 5 THEN 1 ELSE 0 END) unexcpartnum, ")
                    .append(" SUM(CASE excstate WHEN 2 THEN 1 ELSE 0 END) excingnum, ")
                    .append(" SUM(CASE unexcstate WHEN 2 THEN 1 ELSE 0 END) unexcingnum ")
                    .append(" FROM ismsc_nofilterblackrule WHERE idcCommandId in (0  ");
            for (int i = 0; i < commandIdList.size(); i++) {
                sql.append(",").append(commandIdList.get(i));
            }
            sql.append(" ) GROUP BY idcCommandID ");
            List<Map<String, Object>> excList = DbUtil.queryForMapList(sql.toString());
            if (CollectionUtils.isNotEmpty(excList)) {
                for (NoFilterWebCmdVo vo : list) {
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
                            }
                        }
                    }
                }
            }
        }
    }

    public void setOperationButton(List<NoFilterWebCmdVo> list, String curSystem) {
        if (CmdSystemEnum.CU.getType().equals(curSystem)) {
            if (CollectionUtils.isNotEmpty(list)) {
                for (NoFilterWebCmdVo vo : list) {
                    List<OperationButtonVo> buttonList = new ArrayList<>();
                    buttonList.add(new OperationButtonVo(true, ButtonEnum.CHECK_EU));
                    // 操作类型：新增
                    if (OperationTypeEnum.INSERT.getType().equals(vo.getOperationType())) {
                        // 正在处理或处理成功
                        if (ExcStateEnum.IS_HANDLING.getType().equals(vo.getExcState())
                                || ExcStateEnum.HANDLE_SUCCESS.getType().equals(vo.getExcState())) {
                            buttonList.add(new OperationButtonVo(false, ButtonEnum.SENDING));
                        } else {
                            buttonList.add(new OperationButtonVo(true, ButtonEnum.SEND));
                        }
                    }
                    // 操作类型：删除
                    if (OperationTypeEnum.DELETE.getType().equals(vo.getOperationType())) {
                        // 处理失败或部分处理成功
                        if (ExcStateEnum.HANDLE_FAIL.getType().equals(vo.getExcState())
                                || partSuccess.equals(vo.getExcState())) {
                            buttonList.add(new OperationButtonVo(true, ButtonEnum.CANCEL_SEND));
                        } else {
                            buttonList.add(new OperationButtonVo(false, ButtonEnum.CANCEL_SUCCESS));
                        }
                    }
                    vo.setOperationButton(buttonList);
                }
            }
        }
    }

    @Override
    public PageResult<NoFilterWebRuleVo> viewDetail(PageResult<NoFilterWebRuleVo> page,
            NoFilterWebRuleVo noFilterWebRuleVo) {
        StringBuilder sql = new StringBuilder("select model.idcCommandID as idcCommandId, ");
        sql.append(" model.commandId as commandId, ")
                .append(" model.excstate as excState, date_format(model.exctime,'%Y-%m-%d %H:%i:%s') as excTime, ")
                .append(" service.service_name as serviceName,if(valueEnd, CONCAT_WS('-',valueStart, valueEnd), valueStart) as content, ")
                .append(" model.type as type,model.operationType as operationType from ismsc_nofilterblackrule model ")
                .append(" left join tab_service_information service on model.service_code = service.service_code where model.idcCommandId = ?");
        List<Object> params = new ArrayList<>();
        params.add(noFilterWebRuleVo.getIdcCommandId());
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), NoFilterWebRuleVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

}
