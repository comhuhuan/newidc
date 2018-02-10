package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.ResCabinetsDao;
import com.act.idc.entity.ResCabinetsEntity;

public class ResCabinets extends ResCabinetsEntity {

    public static ResCabinets getByKey(int cabid) {
        return (ResCabinets)BaseEntity.getByKey(ResCabinets.class, cabid);
    }

    public static ResCabinetsDao getDao() {
        return (ResCabinetsDao)BaseEntity.getDao(ResCabinets.class);
    }
}