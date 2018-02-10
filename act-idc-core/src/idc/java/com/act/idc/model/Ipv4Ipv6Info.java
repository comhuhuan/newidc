package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.Ipv4Ipv6InfoDao;
import com.act.idc.entity.Ipv4Ipv6InfoEntity;

public class Ipv4Ipv6Info extends Ipv4Ipv6InfoEntity {

    public static Ipv4Ipv6Info getByKey(int ipv4) {
        return (Ipv4Ipv6Info)BaseEntity.getByKey(Ipv4Ipv6Info.class, ipv4);
    }

    public static Ipv4Ipv6InfoDao getDao() {
        return (Ipv4Ipv6InfoDao)BaseEntity.getDao(Ipv4Ipv6Info.class);
    }
}