package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.TabSysOperateLogDao;
import com.act.idc.entity.TabSysOperateLogEntity;

public class TabSysOperateLog extends TabSysOperateLogEntity {

    public static TabSysOperateLog getByKey(int opId) {
        return (TabSysOperateLog)BaseEntity.getByKey(TabSysOperateLog.class, opId);
    }

    public static TabSysOperateLogDao getDao() {
        return (TabSysOperateLogDao)BaseEntity.getDao(TabSysOperateLog.class);
    }
}