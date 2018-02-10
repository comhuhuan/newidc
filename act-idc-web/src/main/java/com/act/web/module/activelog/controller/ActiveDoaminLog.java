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
import com.act.web.module.activelog.service.ActiveDoaminLogService;
import com.act.web.module.activelog.vo.ActiveDoaminLogVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.securitylog.vo.BaseDataMonitorVo;
import com.act.web.module.securitylog.vo.IsmsxIsstopsignVo;
import com.act.web.module.sso.vo.SessionVo;
import com.act.web.util.IpUtils;
/**
 * 
 * 
 * <p>Title: ActiveDoaminLog.java
 * <p>Description:活跃域名控制器
 * @author zhufj
 * @date 2018年2月5日 下午4:34:04
 */
@Controller
@RequestMapping("/activelog/activeDoaminLog")
public class ActiveDoaminLog extends BaseController{
		private final Logger log = LoggerFactory.getLogger(ActiveDoaminLog.class);
		@Resource
	    private ActiveDoaminLogService activeDoaminLogService;
		/**
		 * 
		 * <p>Title: pagingList
		 * <p>Description:分页查询列表
		 * @author zhufj
		 * @date 2018年2月5日 下午8:23:31
		 * @param page //分页对象
		 * @param activeDoaminLogVo //活跃域名日志Vo
		 * @return
		 */
		@ResponseBody
	    @RequestMapping(value = "/pagingList.do")
		public Object pagingList(PageResult<ActiveDoaminLogVo> page,ActiveDoaminLogVo activeDoaminLogVo){
			try {
				page = activeDoaminLogService.findChildDomainLogs(page, activeDoaminLogVo);
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
				Map<String,String> map = activeDoaminLogService.getServiceCode();
				return ajax(Status.error, map);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("分页查询失败!", e);
	            return ajax(Status.error, "查询失败!");
			}
		}
}
