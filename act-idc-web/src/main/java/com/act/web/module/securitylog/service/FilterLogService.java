package com.act.web.module.securitylog.service;

import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.securitylog.vo.FilterLogVo;
import com.act.web.module.sso.vo.SessionVo;
/**
 * 
 * 
 * <p>Title: FilterLogService.java
 * <p>Description: 过滤日志服务层接口
 * @author zhufj
 * @date 2018年2月5日 上午9:25:49
 */
public interface FilterLogService {
	/**
	 * 
	 * <p>Title: findList
	 * <p>Description: 获取过滤日志列表
	 * @author zhufj
	 * @date 2018年2月5日 上午9:25:47
	 * @param page 过滤日志分页对象
	 * @param baseDataMonitorVo 过滤日志请求对象
	 * @return
	 */
	public PageResult<FilterLogVo> findList(SessionVo sessionVo,PageResult<FilterLogVo> page,FilterLogVo filterLogVo)throws Exception;
	/**
	 * 
	 * <p>Title: urlContentViews
	 * <p>Description:快照详情
	 * @author zhufj
	 * @date 2018年2月5日 上午9:37:19
	 * @param filterLogVo //请求对象
	 * @return
	 * @throws Exception
	 */
	public Object urlContentViews(FilterLogVo filterLogVo)throws Exception;
	/**
	 * 
	 * <p>Title: findBySchemeId
	 * <p>Description: 通过策略id获取过滤日志对象
	 * @author zhufj
	 * @date 2018年2月5日 下午1:44:53
	 * @param filterLogVo
	 * @return
	 * @throws Exception
	 */
	public PageResult<FilterLogVo> findBySchemeId(PageResult<FilterLogVo> page,FilterLogVo filterLogVo)throws Exception;
	/**
	 * 
	 * <p>Title: getServiceCode
	 * <p>Description: 获取机房列表
	 * @author zhufj
	 * @date 2018年2月5日 下午3:10:22
	 * @return
	 */
	public Map<String,String> getServiceCode()throws Exception;
}
