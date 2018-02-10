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
public class MonitorLogModelMapping {
	
	@Mapping(sourceProp={"service_code","scheme_id","in_ip","in_port","out_ip","host","url","cur_time"},targetProp ={"serviceCode","ruleIdentifier","inIp","inPort","outIp","host","url","curTime"})
	public Object copyProperties(IsmsmHousemonitorModel source, BaseDataMonitorVo target) {
		return null;
	}
}
