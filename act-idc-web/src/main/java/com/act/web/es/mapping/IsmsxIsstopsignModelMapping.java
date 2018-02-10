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
public class IsmsxIsstopsignModelMapping {
	
	@Mapping(sourceProp={"service_name","userid","utype","content","stopsign","userip","cur_time","local_ip","local_mac","local_machine"},targetProp ={"serviceName","userId","uType","content","stopSign","userIp","curTime","localIp","localMac","localMachine"})
	public Object copyProperties(IsmsmHousemonitorModel source, BaseDataMonitorVo target) {
		return null;
	}
}
