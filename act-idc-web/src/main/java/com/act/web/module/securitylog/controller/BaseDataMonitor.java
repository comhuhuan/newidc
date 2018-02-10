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
import com.act.web.module.securitylog.service.BaseDataMonitorService;
import com.act.web.module.securitylog.vo.BaseDataMonitorVo;
import com.act.web.module.securitylog.vo.IsmsxIsstopsignVo;
import com.act.web.module.sso.vo.SessionVo;
import com.act.web.util.IpUtils;
/**
 * 
 * @Description 信安日志-基础数据监测
 * @author zhufj
 * @date 2018年1月27日 上午11:41:13
 *
 */
@Controller
@RequestMapping("/securitylog/baseDataMonitor")
public class BaseDataMonitor extends BaseController{
	private final Logger log = LoggerFactory.getLogger(BaseDataMonitor.class);
	@Resource
    private BaseDataMonitorService baseDataMonitorService;
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
	public Object pagingList(PageResult<BaseDataMonitorVo> page,BaseDataMonitorVo baseDataMonitorVo){
		try {
			page = baseDataMonitorService.findList(page, baseDataMonitorVo);
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
			Map<String,String> map = baseDataMonitorService.getServiceCode();
			return ajax(Status.error, map);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
	@RequestMapping(value="/checkisstopView.do")
	public Object getListDetail(PageResult<IsmsxIsstopsignVo> page,IsmsxIsstopsignVo ismsxIsstopsignVo){
		try {
			page = baseDataMonitorService.getListDetail(page, ismsxIsstopsignVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询详情失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
	/**
	 * 
	 * @Description 封堵
	 * @author zhufj
	 * @param baseDataMonitorVo
	 * @return
	 */
	@RequestMapping(value="/sendBlockCmd.do")
	public Object sendBlockCmd(HttpServletRequest request,BaseDataMonitorVo baseDataMonitorVo){
		try {
			SessionVo sessionVo = sessionInfo(request.getSession());
			String ipAddr = IpUtils.getIpAddrByRequest(request);
			baseDataMonitorService.sendBlockCmd(ipAddr,sessionVo,baseDataMonitorVo);
			return ajax(Status.success, "查询成功!");
		} catch (Exception e) {
			log.error("查询详情失败!", e);
            return ajax(Status.error, "查询失败!");
		}
	}
}
