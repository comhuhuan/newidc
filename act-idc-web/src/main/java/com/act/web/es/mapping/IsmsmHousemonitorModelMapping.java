package com.act.web.es.mapping;

import com.act.util.beanConvert.Mapping;
import com.act.web.es.type.IsmsmHousemonitorModel;
import com.act.web.module.securitylog.vo.BaseDataMonitorVo;
/**
 * 
 * @Description 基础数据监测-entity转vo
 * @author zhufj
 * @date 2018年1月27日 下午3:00:41
 *
 */
public class IsmsmHousemonitorModelMapping {
	
	@Mapping(sourceProp={"domain","error","firstfind_time","icperror","ip","lastfind_time","port","realUseType","regDomain","service_code","currentState","useType"},targetProp ={"domain","error","firstfindTime","icperror","ip","lastfindTime","port","realUseType","regDomain","serviceCode","state","useType"})
	public Object copyProperties(IsmsmHousemonitorModel source, BaseDataMonitorVo target) {
		return null;
	}
}
