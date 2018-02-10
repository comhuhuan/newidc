package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IsmscIdcCommandDao;
import com.act.idc.entity.IsmscIdcCommandEntity;
import java.util.HashMap;

public class IsmscIdcCommand extends IsmscIdcCommandEntity {

    public static IsmscIdcCommand getByKey(long idccommandid, long commandid, String ctype, String operationtype) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("idccommandid",idccommandid);
        params.put("commandid",commandid);
        params.put("ctype",ctype);
        params.put("operationtype",operationtype);
        return (IsmscIdcCommand)BaseEntity.getByKey(IsmscIdcCommand.class, params);
    }

    public static IsmscIdcCommandDao getDao() {
        return (IsmscIdcCommandDao)BaseEntity.getDao(IsmscIdcCommand.class);
    }
}