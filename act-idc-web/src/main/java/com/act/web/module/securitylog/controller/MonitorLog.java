package com.act.web.module.securitylog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.securitylog.service.MonitorLogService;
import com.act.web.module.securitylog.vo.MonitorLogVo;
import com.act.web.module.sso.vo.SessionVo;
/**
 * 
 * @Description 监控日志
 * @author zhufj
 * @date 2018年1月31日 上午10:13:28
 *
 */
@Controller
@RequestMapping("/securitylog/monitorLog")
public class MonitorLog  extends BaseController{
	private final Logger log = LoggerFactory.getLogger(MonitorLog.class);
	@Resource
	private MonitorLogService monitorLogService;
	/**
	 * 
	 * <p>Title: pagingList
	 * <p>Description:首页查询
	 * @author zhufj
	 * @date 2018年2月5日 下午3:12:18
	 * @param request //请求
	 * @param page 分页对象
	 * @param monitorLogVo 请求对象
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/pagingList.do")
	public Object pagingList(HttpServletRequest request,PageResult<MonitorLogVo> page,MonitorLogVo monitorLogVo){
		try {
			SessionVo sessionVo = sessionInfo(request.getSession());
			page = monitorLogService.findDetailList(sessionVo,page, monitorLogVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
	/**
	 * 
	 * <p>Title: urlContentViews
	 * <p>Description:快照详情
	 * @author zhufj
	 * @date 2018年2月5日 上午9:37:52
	 * @param filterVo //页面请求对象-过滤日志
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/urlContentViews.do")
	public Object urlContentViews(MonitorLogVo monitorLogVo){
		try {
			return ajax(Status.success, monitorLogService.urlContentViews(monitorLogVo));
		} catch (Exception e) {
			log.error("查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
}
