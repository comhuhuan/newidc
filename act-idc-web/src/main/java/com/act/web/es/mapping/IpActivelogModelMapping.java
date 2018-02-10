package com.act.web.es.mapping;

import com.act.util.beanConvert.Mapping;
import com.act.web.es.type.IpActivelogModel;
import com.act.web.module.activelog.vo.ActiveIpLogVo;
/**
 * 
 * 
 * <p>Title: IpActivelogModelMapping.java
 * <p>Description:活跃ip model转vo
 * @author zhufj
 * @date 2018年2月5日 下午6:28:44
 */
public class IpActivelogModelMapping {
	
	@Mapping(sourceProp={"ip","service_code","port","protocol","firsttime","lasttime","visitscount"},targetProp ={"ip","serviceCode","port","protocol","firstTime","lastTime","visitCount"})
	public Object copyProperties(IpActivelogModel source, ActiveIpLogVo target) {
		return null;
	}

}
