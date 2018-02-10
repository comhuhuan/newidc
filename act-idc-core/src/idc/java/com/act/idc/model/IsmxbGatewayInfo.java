package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IsmxbGatewayInfoDao;
import com.act.idc.entity.IsmxbGatewayInfoEntity;
import java.util.HashMap;

public class IsmxbGatewayInfo extends IsmxbGatewayInfoEntity {

    public static IsmxbGatewayInfo getByKey(int gatewayid, String serviceCode) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("gatewayid",gatewayid);
        params.put("serviceCode",serviceCode);
        return (IsmxbGatewayInfo)BaseEntity.getByKey(IsmxbGatewayInfo.class, params);
    }

    public static IsmxbGatewayInfoDao getDao() {
        return (IsmxbGatewayInfoDao)BaseEntity.getDao(IsmxbGatewayInfo.class);
    }
}