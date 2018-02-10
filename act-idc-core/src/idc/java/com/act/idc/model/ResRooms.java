package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.ResRoomsDao;
import com.act.idc.entity.ResRoomsEntity;

public class ResRooms extends ResRoomsEntity {

    public static ResRooms getByKey(int roomid) {
        return (ResRooms)BaseEntity.getByKey(ResRooms.class, roomid);
    }

    public static ResRoomsDao getDao() {
        return (ResRoomsDao)BaseEntity.getDao(ResRooms.class);
    }
}