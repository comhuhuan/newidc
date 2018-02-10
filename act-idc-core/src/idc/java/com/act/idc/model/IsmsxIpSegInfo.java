package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IsmsxIpSegInfoDao;
import com.act.idc.entity.IsmsxIpSegInfoEntity;
import java.util.HashMap;

public class IsmsxIpSegInfo extends IsmsxIpSegInfoEntity {

    public static IsmsxIpSegInfo getByKey(int ipid, String serviceCode) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("ipid",ipid);
        params.put("serviceCode",serviceCode);
        return (IsmsxIpSegInfo)BaseEntity.getByKey(IsmsxIpSegInfo.class, params);
    }

    public static IsmsxIpSegInfoDao getDao() {
        return (IsmsxIpSegInfoDao)BaseEntity.getDao(IsmsxIpSegInfo.class);
    }
}