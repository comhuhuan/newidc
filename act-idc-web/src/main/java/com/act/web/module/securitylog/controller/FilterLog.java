package com.act.web.module.securitylog.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.securitylog.service.FilterLogService;
import com.act.web.module.securitylog.vo.FilterLogVo;
import com.act.web.module.sso.vo.SessionVo;
/**
 * 
 * 
 * <p>Title: FilterLog.java
 * <p>Description:过滤日志控制器
 * @author zhufj
 * @date 2018年2月5日 上午9:23:22
 */
@Controller
@RequestMapping("/securitylog/filterLog")
public class FilterLog extends BaseController{
	private final Logger log = LoggerFactory.getLogger(FilterLog.class);
	@Resource
	private FilterLogService filterLogService;
	
	@ResponseBody
    @RequestMapping(value = "/pagingList.do")
	public Object pagingList(HttpServletRequest request,PageResult<FilterLogVo> page,FilterLogVo filterVo){
		try {
			SessionVo sessionVo = sessionInfo(request.getSession());
			page = filterLogService.findList(sessionVo,page,filterVo);
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
	public Object urlContentViews(FilterLogVo filterVo){
		try {
			return ajax(Status.success, filterLogService.urlContentViews(filterVo));
		} catch (Exception e) {
			log.error("查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
	/**
	 * 
	 * <p>Title: checkisstopView
	 * <p>Description:处置记录
	 * @author zhufj
	 * @date 2018年2月5日 下午2:56:01
	 * @param page //分页对象
	 * @param filterVo //请求对象
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/checkisstopView.do")
	public Object checkisstopView(PageResult<FilterLogVo> page,FilterLogVo filterVo){
		try {
			page = filterLogService.findBySchemeId(page,filterVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
		
	}
	/**
	 * 获取机房列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/getServiceCode.do")
	public Object getServiceCode(){
		try {
			Map<String,String> map = filterLogService.getServiceCode();
			return ajax(Status.error, map);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
}
