package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IsmsxIsstopsignDao;
import com.act.idc.entity.IsmsxIsstopsignEntity;

public class IsmsxIsstopsign extends IsmsxIsstopsignEntity {

    public static IsmsxIsstopsign getByKey(int id) {
        return (IsmsxIsstopsign)BaseEntity.getByKey(IsmsxIsstopsign.class, id);
    }

    public static IsmsxIsstopsignDao getDao() {
        return (IsmsxIsstopsignDao)BaseEntity.getDao(IsmsxIsstopsign.class);
    }
}