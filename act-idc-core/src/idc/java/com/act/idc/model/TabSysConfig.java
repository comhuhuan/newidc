package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.TabSysConfigDao;
import com.act.idc.entity.TabSysConfigEntity;

public class TabSysConfig extends TabSysConfigEntity {

    public static TabSysConfig getByKey(String configid) {
        return (TabSysConfig)BaseEntity.getByKey(TabSysConfig.class, configid);
    }

    public static TabSysConfigDao getDao() {
        return (TabSysConfigDao)BaseEntity.getDao(TabSysConfig.class);
    }
}