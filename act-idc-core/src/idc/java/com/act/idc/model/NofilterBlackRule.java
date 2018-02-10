package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.NofilterBlackRuleDao;
import com.act.idc.entity.NofilterBlackRuleEntity;
import java.util.HashMap;

public class NofilterBlackRule extends NofilterBlackRuleEntity {

    public static NofilterBlackRule getByKey(long idccommandid, long commandid, String serviceCode, String datatype, String type, String operationtype, String valuestart) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("idccommandid",idccommandid);
        params.put("commandid",commandid);
        params.put("serviceCode",serviceCode);
        params.put("datatype",datatype);
        params.put("type",type);
        params.put("operationtype",operationtype);
        params.put("valuestart",valuestart);
        return (NofilterBlackRule)BaseEntity.getByKey(NofilterBlackRule.class, params);
    }

    public static NofilterBlackRuleDao getDao() {
        return (NofilterBlackRuleDao)BaseEntity.getDao(NofilterBlackRule.class);
    }
}