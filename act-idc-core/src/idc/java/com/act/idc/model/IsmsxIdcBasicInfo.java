package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IsmsxIdcBasicInfoDao;
import com.act.idc.entity.IsmsxIdcBasicInfoEntity;

public class IsmsxIdcBasicInfo extends IsmsxIdcBasicInfoEntity {

    public static IsmsxIdcBasicInfo getByKey(String idcid) {
        return (IsmsxIdcBasicInfo)BaseEntity.getByKey(IsmsxIdcBasicInfo.class, idcid);
    }

    public static IsmsxIdcBasicInfoDao getDao() {
        return (IsmsxIdcBasicInfoDao)BaseEntity.getDao(IsmsxIdcBasicInfo.class);
    }
}