package com.act.web.module.command.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.web.enums.ExcStateEnum;
import com.act.web.module.command.service.CodeListIssuseCmdService;
import com.act.web.module.command.vo.CodeListIssuseCmdVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: CodeListIssuseCmdServiceImpl.java
 * <p>Description: 代码表发布指令服务层完成类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:00:58
 */ 
@Service
public class CodeListIssuseCmdServiceImpl implements CodeListIssuseCmdService {

    @Override
    public PageResult<CodeListIssuseCmdVo> findList(PageResult<CodeListIssuseCmdVo> page,
            CodeListIssuseCmdVo codeListIssuseCmdVo) {

        StringBuilder sql = new StringBuilder(" SELECT model.commandID as commandId, ");
        sql.append("date_format(model.timeStamp,'%Y-%m-%d %H:%i:%s') as createTime,")
                .append(" model.excstate AS excState, date_format(model.exctime,'%Y-%m-%d %H:%i:%s') as excTime ")
                .append(" FROM ismsm_codelist model WHERE 1=1 ");

        List<Object> params = new ArrayList<>();
        if (codeListIssuseCmdVo != null) {
            String createDateQuery = codeListIssuseCmdVo.getCreateDateQuery();
            String excStateQuery = codeListIssuseCmdVo.getExcStateQuery();
            // 生成时间查询
            if (StringUtils.isNotEmpty(createDateQuery)) {
                sql.append("AND substr(model.timeStamp,1,10) = ? ");
                params.add(createDateQuery);
            }
            // 执行状态查询
            if (StringUtils.isNotEmpty(excStateQuery)) {
                if (ExcStateEnum.WAIT_HANDLE.getType().equalsIgnoreCase(excStateQuery)) {
                    sql.append(" AND model.excstate IN ('', '1', 'N') ");
                } else {
                    sql.append(" AND model.excstate  = ? ");
                    params.add(excStateQuery);
                }
            }
        }
        sql.append(" ORDER BY model.timeStamp DESC");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), CodeListIssuseCmdVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

    @Override
    public Map<String, List<SelectVo<String>>> init() {
        //执行状态
        List<SelectVo<String>> excStateList = new ArrayList<>();
        for (ExcStateEnum excState : ExcStateEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(excState.getExplain());
            enumToObject.setValue(excState.getType());
            excStateList.add(enumToObject);
        }

        Map<String, List<SelectVo<String>>> object = new HashMap<>(1);
        object.put("excStateList", excStateList);
        return object;
    }
}
