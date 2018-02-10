package com.act.web.module.activelog.service;

import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.activelog.vo.ActiveIpLogVo;
import com.act.web.module.sso.vo.SessionVo;
/**
 * 
 * 
 * <p>Title: ActiveDoaminLogService.java
 * <p>Description: 活跃域名
 * @author zhufj
 * @date 2018年2月5日 下午4:49:53
 */
public interface ActiveIpLogService {
	/**
	 * 
	 * <p>Title: findIPLogs
	 * <p>Description:分页查询ip日志
	 * @author zhufj
	 * @date 2018年2月5日 下午4:50:48
	 * @param sessionVo //用户信息session
	 * @param page //活跃日志分页对象
	 * @param activeDoaminLogVo //请求对象
	 * @return
	 * @throws Exception
	 */
	public PageResult<ActiveIpLogVo> findIPLogs(SessionVo sessionoVo,PageResult<ActiveIpLogVo> page,ActiveIpLogVo activeDoaminLogVo) throws Exception;
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
