package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.ResDomainIpSchemeidDao;
import com.act.idc.entity.ResDomainIpSchemeidEntity;
import java.util.HashMap;

public class ResDomainIpSchemeid extends ResDomainIpSchemeidEntity {

    public static ResDomainIpSchemeid getByKey(byte[] content, String serviceCode) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("content",content);
        params.put("serviceCode",serviceCode);
        return (ResDomainIpSchemeid)BaseEntity.getByKey(ResDomainIpSchemeid.class, params);
    }

    public static ResDomainIpSchemeidDao getDao() {
        return (ResDomainIpSchemeidDao)BaseEntity.getDao(ResDomainIpSchemeid.class);
    }
}