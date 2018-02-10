package com.act.web.module.securitylog.service;

import com.act.framework.util.PageResult;
import com.act.web.module.securitylog.vo.BaseDataMonitorVo;
import com.act.web.module.securitylog.vo.FilterLogVo;
import com.act.web.module.securitylog.vo.MonitorLogVo;
import com.act.web.module.sso.vo.SessionVo;
/**
 * 
 * @Description 监控日志业务层接口
 * @author zhufj
 * @date 2018年1月31日 上午10:18:55
 *
 */
public interface MonitorLogService {
	/**
	 * 
	 * @Description 监控日志分页
	 * @author zhufj
	 * @param page
	 * @param baseDataMonitorVo
	 * @return
	 * @throws Exception
	 */
	public PageResult<MonitorLogVo> findDetailList(SessionVo vo,PageResult<MonitorLogVo> page,MonitorLogVo monitorLogVo)throws Exception;
	/**
	 * 
	 * <p>Title: urlContentViews
	 * <p>Description:快照详情
	 * @author zhufj
	 * @date 2018年2月5日 上午9:37:19
	 * @param monitorLogVo //请求对象
	 * @return
	 * @throws Exception
	 */
	public Object urlContentViews(MonitorLogVo monitorLogVo)throws Exception;
}
