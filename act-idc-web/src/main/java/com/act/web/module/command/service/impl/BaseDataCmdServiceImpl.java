package com.act.web.module.command.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.TabServiceInformation;
import com.act.web.enums.BaseDataCmdTypeEnum;
import com.act.web.enums.ExcStateEnum;
import com.act.web.module.command.service.BaseDataCmdService;
import com.act.web.module.command.vo.BaseDataCmdVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: BaseDataCmdServiceImpl.java
 * <p>Description: 基础数据查询指令服务层完成类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:47:39
 */ 
@Service
public class BaseDataCmdServiceImpl implements BaseDataCmdService {

    @Override
    public PageResult<BaseDataCmdVo> findList(PageResult<BaseDataCmdVo> page, BaseDataCmdVo baseDataCmdVo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT basic.idcName as idcName, model.commandID as commandId, ")
                .append(" date_format(model.queryMonitorDayFrom,'%Y-%m-%d %H:%i:%s') as queryStartDate, ")
                .append(" date_format(model.queryMonitorDayTo,'%Y-%m-%d 23:59:59') as queryEndTime, ")
                .append(" model.type as type, model.excstate as excState,serinfo.service_name as serviceName,")
                .append(" date_format(model.exctime,'%Y-%m-%d %H:%i:%s') as excTime, ")
                .append(" date_format(model.timeStamp,'%Y-%m-%d %H:%i:%s') as createTime")
                .append(" FROM ismsx_idcbiomanage model ")
                .append(" LEFT JOIN ismsx_idcbasicinfo as basic ON model.idcID = basic.idcID ")
                .append(" LEFT JOIN tab_service_information as serinfo ON model.service_code = serinfo.service_code ")
                .append(" WHERE 1=1 ");

        List<Object> params = new ArrayList<>();
        if (baseDataCmdVo != null) {
            String cmdTypeQuery = baseDataCmdVo.getCmdTypeQuery();
            String serviceCodeQuery = baseDataCmdVo.getServiceCodeQuery();
            String excStateQuery = baseDataCmdVo.getExcStateQuery();
            String startDateQuery = baseDataCmdVo.getStartDateQuery();
            String endDateQuery = baseDataCmdVo.getEndDateQuery();
            // 指令类型查询
            if (StringUtils.isNotEmpty(cmdTypeQuery)) {
                sql.append(" AND model.type  = ? ");
                params.add(cmdTypeQuery);
            }
            // 机房名称查询
            if (StringUtils.isNotEmpty(serviceCodeQuery)) {
                sql.append(" AND model.service_code  = ? ");
                params.add(serviceCodeQuery);
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
            // 生成起始时间和结束时间查询
            if (StringUtils.isNotEmpty(startDateQuery) && StringUtils.isNotEmpty(endDateQuery)) {
                sql.append(" AND substr(model.timeStamp,1,10) >= ? AND  substr(model.timeStamp,1,10) <= ? ");
                params.add(startDateQuery);
                params.add(endDateQuery);
            }
        }

        sql.append(" ORDER BY model.timeStamp DESC");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), BaseDataCmdVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

    @Override
    public Map<String, List<SelectVo<String>>> init() {
        //基础数据指令类型
        List<SelectVo<String>> cmdTypeList = new ArrayList<>();
        for (BaseDataCmdTypeEnum baseData : BaseDataCmdTypeEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(baseData.getExplain());
            enumToObject.setValue(baseData.getType());
            cmdTypeList.add(enumToObject);
        }
        //执行状态
        List<SelectVo<String>> excStateList = new ArrayList<>();
        for (ExcStateEnum excState : ExcStateEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(excState.getExplain());
            enumToObject.setValue(excState.getType());
            excStateList.add(enumToObject);
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
}
