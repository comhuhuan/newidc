package com.act.web.module.activelog.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.web.module.activelog.service.ActiveIpLogService;
import com.act.web.module.activelog.vo.ActiveIpLogVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.sso.vo.SessionVo;

/**
 * 
 * 
 * <p>Title: ActiveIpLog.java
 * <p>Description: 活跃Ip日志控制器
 * @author zhufj
 * @date 2018年2月5日 下午4:59:47
 */
@Controller
@RequestMapping("/activelog/activeIpLog")
public class ActiveIpLog extends BaseController{
	private final Logger log = LoggerFactory.getLogger(ActiveDoaminLog.class);
	@Resource
    private ActiveIpLogService activeIpLogService;
	/**
	 * 
	 * @Description 查询列表
	 * @author zhufj
	 * @param pageIndex
	 * @param pageSize
	 * @param baseDataMonitorVo
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/pagingList.do")
	public Object pagingList(HttpServletRequest request,PageResult<ActiveIpLogVo> page,ActiveIpLogVo activeDoaminLogVo){
		try {
			SessionVo sessionVo = sessionInfo(request.getSession());
			page = activeIpLogService.findIPLogs(sessionVo,page,activeDoaminLogVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
		
	}
	/**
	 * 获取机房名称
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/getServiceCode.do")
	public Object getServiceCode(){
		try {
			Map<String,String> map = activeIpLogService.getServiceCode();
			return ajax(Status.error, map);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
}
