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
import com.act.web.enums.ReturnDataTypeEnum;
import com.act.web.enums.ReturnExcStateEnum;
import com.act.web.enums.ReturnReasonEnum;
import com.act.web.module.command.service.ReturnBackDataService;
import com.act.web.module.command.vo.ReturnBackDataVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: ReturnBackDataServiceImpl.java
 * <p>Description: 基础数据查询指令服务层接口完成类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:06:43
 */ 
@Service
public class ReturnBackDataServiceImpl implements ReturnBackDataService {

    @Override
    public PageResult<ReturnBackDataVo> findList(PageResult<ReturnBackDataVo> page, ReturnBackDataVo returnBackDataVo) {

        StringBuilder sql = new StringBuilder("select date_format(model.timeStamp,'%Y-%m-%d %H:%i:%s') as createTime,");
        sql.append(
                " model.excstate as excState, date_format(model.exctime,'%Y-%m-%d %H:%i:%s') as excTime,model.id as id, ")
                .append(" idc.idcName as idcName, model.returncode as returnCode, model.datatype as dataType, ")
                .append(" model.returnmsg as returnMsg, service.service_code as serviceCode,")
                .append(" service.service_name as serviceName from ismsm_returninfodata model ")
                .append(" left join ismsx_idcbasicinfo idc on idc.idcID = model.idcid ")
                .append(" left join tab_service_information service on service.service_code = model.service_code ")
                .append(" where 1=1 ");

        List<Object> params = new ArrayList<Object>();
        if (returnBackDataVo != null) {
            String serviceCodeQuery = returnBackDataVo.getServiceCodeQuery();
            String dataTypeQuery = returnBackDataVo.getDataTypeQuery();
            String excStateQuery = returnBackDataVo.getExcStateQuery();
            String returnCodeQuery = returnBackDataVo.getReturnCodeQuery();
            String startDateQuery = returnBackDataVo.getStartDateQuery();
            String endDateQuery = returnBackDataVo.getEndDateQuery();
            // 机房名称查询
            if (StringUtils.isNotEmpty(serviceCodeQuery)) {
                sql.append(" AND model.service_code = ? ");
                params.add(serviceCodeQuery);
            }
            // 退回数据类型查询
            if (StringUtils.isNotEmpty(dataTypeQuery)) {
                sql.append(" AND model.datatype = ? ");
                params.add(dataTypeQuery);
            }
            // 退回原因分类查询
            if (StringUtils.isNotEmpty(returnCodeQuery)) {
                sql.append(" AND model.returncode = ? ");
                params.add(returnCodeQuery);
            }
            // 处理状态查询
            if (StringUtils.isNotEmpty(excStateQuery)) {
                sql.append(" AND model.excstate = ? ");
                params.add(excStateQuery);
            }
            // 开始时间和结束时间查询
            if (StringUtils.isNotEmpty(startDateQuery) && StringUtils.isNotEmpty(endDateQuery)) {
                sql.append(" AND DATE_FORMAT(model.timestamp,'%Y-%m-%d') <= ? ")
                        .append(" AND DATE_FORMAT(model.timestamp,'%Y-%m-%d') >= ? ");
                params.add(endDateQuery);
                params.add(startDateQuery);
            }
        }

        sql.append(" ORDER BY model.id DESC");
        Object[] param = new Object[params.size()];
        for (int i = 0; i < params.size(); i++) {
            param[i] = params.get(i);
        }
        page = DbUtil.queryPageForObjectPageResult(sql.toString(), ReturnBackDataVo.class, page.getPageIndex(),
                page.getPageSize(), param);
        return page;
    }

    @Override
    public Map<String, List<SelectVo<String>>> init() {
        //执行状态
        List<SelectVo<String>> excStateList = new ArrayList<>();
        for (ReturnExcStateEnum excState : ReturnExcStateEnum.values()) {
            SelectVo<String> selectVo = new SelectVo<String>();
            selectVo.setLabel(excState.getExplain());
            selectVo.setValue(excState.getType());
            excStateList.add(selectVo);
        }
        //回退原因类型
        List<SelectVo<String>> returnReasonList = new ArrayList<>();
        for (ReturnReasonEnum returnReasonEnum : ReturnReasonEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(returnReasonEnum.getExplain());
            enumToObject.setValue(returnReasonEnum.getType());
            returnReasonList.add(enumToObject);
        }
        //回退数据类型
        List<SelectVo<String>> returnTypeList = new ArrayList<>();
        for (ReturnDataTypeEnum returnDataType : ReturnDataTypeEnum.values()) {
            SelectVo<String> enumToObject = new SelectVo<String>();
            enumToObject.setLabel(returnDataType.getExplain());
            enumToObject.setValue(returnDataType.getType());
            returnTypeList.add(enumToObject);
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

        Map<String, List<SelectVo<String>>> object = new HashMap<>(4);
        object.put("excStateList", excStateList);
        object.put("returnReasonList", returnReasonList);
        object.put("returnTypeList", returnTypeList);
        object.put("serviceCodeList", serviceCodeList);
        return object;

    }

    @Override
    public ReturnBackDataVo viewDetail(Integer id) {
        StringBuilder sql = new StringBuilder(" SELECT service.servicename as appServiceName, ");
        sql.append(" date_format(model.`timeStamp`,'%Y-%m-%d %H:%i:%s') as createDate,model.custid as custId, ")
                .append(" if(cus.`name`,cus.`name`,cushis.`name`) as custName,model.datatype as dataType, ")
                .append(" domain.domain as domainName,date_format(model.exctime,'%Y-%m-%d %H:%i:%s') as excTime, ")
                .append(" frame.cabname as frameName, gate.gatewayIP as gatewayName,model.id as id,idc.idcName as idcName, ")
                .append(" CONCAT(seg.startIP,'-',seg.endIP) as ipSegName, `server`.`name` as occupyServiceName, ")
                .append(" model.returnmsg as returnMsg,model.returncode as returnCode,model.service_code as serviceCode,  ")
                .append(" if(room.service_name,room.service_name,roomhis.service_name) as serviceName ")
                .append(" from ismsm_returninfodata model ")
                .append(" LEFT JOIN res_services service on service.serviceid = model.serviceid ")
                .append(" LEFT JOIN res_customer cus on cus.custid = model.custid ")
                .append(" LEFT JOIN res_customer_history cushis on cushis.custid = model.custid ")
                .append(" LEFT JOIN ismsm_servicesdomain domain on domain.sdomainid = model.domainid ")
                .append(" LEFT JOIN res_cabinets frame on frame.cabid = model.frameinfoid ")
                .append(" LEFT JOIN ismxb_gatewayinfo gate on gate.gatewayID = model.gatewayid ")
                .append(" LEFT JOIN ismsx_idcbasicinfo idc on idc.idcID = model.idcid ")
                .append(" LEFT JOIN ismsx_ipseginfo seg on seg.ipID = model.ipsegid ")
                .append(" LEFT JOIN res_servers server on `server`.serverid = model.hhid ")
                .append(" LEFT JOIN tab_service_information room on room.service_code = model.service_code ")
                .append(" LEFT JOIN tab_service_information_history roomhis on roomhis.service_code = model.service_code ")
                .append(" where model.id = ").append(id);

        ReturnBackDataVo returnBackDataVo = DbUtil.queryForObject(sql.toString(), ReturnBackDataVo.class);
        return returnBackDataVo;
    }
}
