package com.act.web.es.mapping;

import com.act.idc.model.IsmsxIsstopsign;
import com.act.util.beanConvert.Mapping;
import com.act.web.module.securitylog.vo.FilterLogVo;
/**
 * 
 * @Description 过滤日志-封堵entity转vo
 * @author zhufj
 * @date 2018年1月27日 下午3:00:41
 *
 */
public class FilterLogModelMapping {
	
	@Mapping(sourceProp={"userid","utype","content","stopsign","userip","curTime","localIp","localMac","localMachine"},targetProp ={"userId","uType","content","stopSign","userIp","curTime","localIp","localMac","localMachine"})
	public Object copyProperties(IsmsxIsstopsign source, FilterLogVo target) {
		return null;
	}
}
