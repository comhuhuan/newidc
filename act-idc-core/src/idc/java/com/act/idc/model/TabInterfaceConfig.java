package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.TabInterfaceConfigDao;
import com.act.idc.entity.TabInterfaceConfigEntity;

public class TabInterfaceConfig extends TabInterfaceConfigEntity {

    public static TabInterfaceConfig getByKey(int interfaceId) {
        return (TabInterfaceConfig)BaseEntity.getByKey(TabInterfaceConfig.class, interfaceId);
    }

    public static TabInterfaceConfigDao getDao() {
        return (TabInterfaceConfigDao)BaseEntity.getDao(TabInterfaceConfig.class);
    }
}