package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.IsmscIdcCommandRuleDao;
import com.act.idc.entity.IsmscIdcCommandRuleEntity;
import java.util.HashMap;

public class IsmscIdcCommandRule extends IsmscIdcCommandRuleEntity {

    public static IsmscIdcCommandRule getByKey(long idccommandid, long commandid, String serviceCode, String ctype, String subtype, String operationtype, String valuestart, long schemeId) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("idccommandid",idccommandid);
        params.put("commandid",commandid);
        params.put("serviceCode",serviceCode);
        params.put("ctype",ctype);
        params.put("subtype",subtype);
        params.put("operationtype",operationtype);
        params.put("valuestart",valuestart);
        params.put("schemeId",schemeId);
        return (IsmscIdcCommandRule)BaseEntity.getByKey(IsmscIdcCommandRule.class, params);
    }

    public static IsmscIdcCommandRuleDao getDao() {
        return (IsmscIdcCommandRuleDao)BaseEntity.getDao(IsmscIdcCommandRule.class);
    }
}