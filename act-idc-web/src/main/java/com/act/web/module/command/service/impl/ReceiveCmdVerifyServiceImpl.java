package com.act.web.module.command.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.web.enums.CmdSystemEnum;
import com.act.web.enums.CmdTypeEnum;
import com.act.web.enums.CmdVerifyEnum;
import com.act.web.module.command.service.ReceiveCmdVerifyService;
import com.act.web.module.command.vo.ReceiveCmdVerifyVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: ReceiveCmdVerifyServiceImpl.java
 * <p>Description: 接收指令校验服务层接口完成类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:50:58
 */ 
@Service
public class ReceiveCmdVerifyServiceImpl implements ReceiveCmdVerifyService {

    @Override
    public PageResult<ReceiveCmdVerifyVo> findList(String curSystem, PageResult<ReceiveCmdVerifyVo> page,
            ReceiveCmdVerifyVo receiveCmdVerifyVo) {
        StringBuffer sql = new StringBuffer(" select model.commandSequence as commandSequence, model.idcID as idcId, ");
        sql.append(
                " model.commandID as commandId, model.command as command, model.commandType as commandType, model.resultCode as resultCode, ")
                .append("(case model.compressionFormat when '0' then '无压缩' when '1' then 'Zip压缩格式' end) as compressionFormat, ")
                .append(" (case model.encryptAlgorithm when '0' then '不进行加密,明文传输' when '1' then 'AES加密算法' end) as encryptAlgorithm, ")
                .append(" (case model.hashAlgorithm when '0' then 'SHA-1' when '1' then 'MD5' end) as hashAlgorithm, ")
                .append(" model.commandVersion as commandVersion, date_format(model.curtime,'%Y-%m-%d %H:%i%s') as curTime, ")
                .append(" model.msg as resultMsg from ismsm_getidccommand model ");

        // 指令来源0=smms;1=cu;2=eu;3=du
        if (CmdSystemEnum.EU_ACK.getType().equals(curSystem)) {
            sql.append(" WHERE model.cmdFlag=1 ");
        } else {
            sql.append(" WHERE model.cmdFlag=0 ");
        }

        List<Object> params = new ArrayList<Object>();
        if (receiveCmdVerifyVo != null) {
            String cmdCheckQuery = receiveCmdVerifyVo.getCmdCheckQuery();
            String commandIdQuery = receiveCmdVerifyVo.getCommandIdQuery();
            String commandTypeQuery = receiveCmdVerifyVo.getCommandTypeQuery();
            String endDateQuery = receiveCmdVerifyVo.getEndDateQuery();
            String startDateQuery = receiveCmdVerifyVo.getStartDateQuery();
            // 开始时间、结束时间查询
            if (StringUtils.isNotEmpty(startDateQuery) && StringUtils.isNotEmpty(endDateQuery)) {
                sql.append(
                        " AND DATE_FORMAT(model.curtime,'%Y-%m-%d') <= ? AND DATE_FORMAT(model.curtime,'%Y-%m-%d') >= ? ");
                params.add(endDateQuery);
                params.add(startDateQuery);
            }
            // 指令验证查询
            if (StringUtils.isNotEmpty(cmdCheckQuery)) {
                sql.append(" AND model.resultCode = ? ");
                params.add(cmdCheckQuery);
            }
            //指令id查询
            if (StringUtils.isNotEmpty(commandIdQuery)) {
                sql.append(" AND model.commandID like ? ");
                params.add("%" + commandIdQuery.trim() + "%");
            }
            //指令类型查询
            if (StringUtils.isNotEmpty(commandTypeQuery)) {
                sql.append(" AND model.commandType = ? ");
                params.add(commandTypeQuery);
            }
        }

        sql.append(" ORDER BY model.curtime DESC");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), ReceiveCmdVerifyVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

    @Override
    public Map<String, List<SelectVo<String>>> init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(2);
        try {
            List<SelectVo<String>> cmdTypeList = new ArrayList<>();
            for (CmdTypeEnum cmdType : CmdTypeEnum.values()) {
                SelectVo<String> enumToObject = new SelectVo<String>();
                enumToObject.setLabel(cmdType.getExplain());
                enumToObject.setValue(cmdType.getType());
                cmdTypeList.add(enumToObject);
            }
            List<SelectVo<String>> cmdVerifyList = new ArrayList<>();
            for (CmdVerifyEnum verify : CmdVerifyEnum.values()) {
                SelectVo<String> enumToObject = new SelectVo<String>();
                enumToObject.setLabel(verify.getExplain());
                enumToObject.setValue(verify.getType());
                cmdVerifyList.add(enumToObject);
            }
            map.put("cmdTypeList", cmdTypeList);
            map.put("cmdVerifyList", cmdVerifyList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
