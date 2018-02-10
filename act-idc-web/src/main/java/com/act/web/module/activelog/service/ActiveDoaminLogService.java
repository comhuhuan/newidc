package com.act.web.module.activelog.service;

import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.activelog.vo.ActiveDoaminLogVo;
import com.act.web.module.activelog.vo.ActiveIpLogVo;
/**
 * 
 * 
 * <p>Title: ActiveDoaminLogService.java
 * <p>Description: 活跃域名
 * @author zhufj
 * @date 2018年2月5日 下午4:49:53
 */
public interface ActiveDoaminLogService {
	/**
	 * 
	 * <p>Title: findIPLogs
	 * <p>Description:分页查询ip日志
	 * @author zhufj
	 * @date 2018年2月5日 下午4:50:48
	 * @param page //活跃域名日志分页对象
	 * @param activeDoaminLogVo //请求对象
	 * @return
	 * @throws Exception
	 */
	public PageResult<ActiveDoaminLogVo> findChildDomainLogs(PageResult<ActiveDoaminLogVo> page,ActiveDoaminLogVo activeDoaminLogVo) throws Exception;
	/**
	 * 
	 * <p>Title: getServiceCode
	 * <p>Description:获取机房列表
	 * @author zhufj
	 * @date 2018年2月5日 下午5:05:56
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getServiceCode()throws Exception;
}
