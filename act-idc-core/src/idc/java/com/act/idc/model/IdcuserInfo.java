package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IdcuserInfoDao;
import com.act.idc.entity.IdcuserInfoEntity;
import java.util.HashMap;

public class IdcuserInfo extends IdcuserInfoEntity {

    public static IdcuserInfo getByKey(int userid, String serviceCode) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("userid",userid);
        params.put("serviceCode",serviceCode);
        return (IdcuserInfo)BaseEntity.getByKey(IdcuserInfo.class, params);
    }

    public static IdcuserInfoDao getDao() {
        return (IdcuserInfoDao)BaseEntity.getDao(IdcuserInfo.class);
    }
}