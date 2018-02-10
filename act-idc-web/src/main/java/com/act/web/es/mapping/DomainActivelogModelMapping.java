package com.act.web.es.mapping;

import com.act.util.beanConvert.Mapping;
import com.act.web.es.type.DomainActivelogModel;
import com.act.web.module.activelog.vo.ActiveDoaminLogVo;
/**
 * 
 * 
 * <p>Title: IpActivelogModelMapping.java
 * <p>Description:活跃ip model转vo
 * @author zhufj
 * @date 2018年2月5日 下午6:28:44
 */
public class DomainActivelogModelMapping {
	
	@Mapping(sourceProp={"domain","firsttime","ip","lasttime","visitscount"},targetProp ={"domain","firstTime","ip","lastTime","visitCount"})
	public Object copyProperties(DomainActivelogModel source, ActiveDoaminLogVo target) {
		return null;
	}

}
