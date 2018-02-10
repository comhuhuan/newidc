package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.TabServiceInformationDao;
import com.act.idc.entity.TabServiceInformationEntity;

public class TabServiceInformation extends TabServiceInformationEntity {

    public static TabServiceInformation getByKey(String serviceCode) {
        return (TabServiceInformation)BaseEntity.getByKey(TabServiceInformation.class, serviceCode);
    }

    public static TabServiceInformationDao getDao() {
        return (TabServiceInformationDao)BaseEntity.getDao(TabServiceInformation.class);
    }
}