package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.TsQueryCmdLogDao;
import com.act.idc.entity.TsQueryCmdLogEntity;

public class TsQueryCmdLog extends TsQueryCmdLogEntity {

    public static TsQueryCmdLog getByKey(int id) {
        return (TsQueryCmdLog)BaseEntity.getByKey(TsQueryCmdLog.class, id);
    }

    public static TsQueryCmdLogDao getDao() {
        return (TsQueryCmdLogDao)BaseEntity.getDao(TsQueryCmdLog.class);
    }
}