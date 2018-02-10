/*
 * Copyright (c) 2018, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.sso.controller;

import com.act.rpc.SsoService;
import com.act.vo.SsoVo;
import com.act.web.constant.SessionContant;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.sso.vo.SessionVo;
import com.act.web.util.SpringContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * <p>
 * Title:SsoController
 * <p>
 * Description:单点登入实现
 *
 * @author lenovo
 * @date 2018/1/31 9:51
 */
@Controller
@RequestMapping("/sso/sso")
public class SsoController extends BaseController {

    private final Logger log = Logger.getLogger(SsoController.class);

    /**
     * <p>Title: index
     * <p>Description: 跳转至子系统
     * @param request 跳转请求
     * @return 重定向值子系统入口页面
     */
    @RequestMapping(value = "/index.do")
    public String index(HttpServletRequest request) {
        String ticket = request.getParameter("ticket");
        request.getSession().setAttribute(SessionContant.SESSION_TICKET, ticket);
        return "redirect:/index.html";
    }

    /**
     * <p>Title: initSub
     * <p>Description: 加载子系统
     * @param request 存放session
     * @return 菜单权限,以及初始化需要的参数
     */
	@ResponseBody
	@RequestMapping(value = "/initSub.do")
	public Object initSub(HttpServletRequest request) {
		try {
			SsoService ssoService = SpringContextUtil.getBean("ssoService");
			SsoVo result = ssoService
					.initSub(request.getSession().getAttribute(SessionContant.SESSION_TICKET).toString());
			// 将用户信息存入session
			request.getSession().setAttribute(SessionContant.SESSION_INFO,
					new SessionVo(result.getUserId(), result.isAdmin(), request.getParameter("local_ip"),
							request.getParameter("local_mac"), request.getParameter("local_machine")));
			return ajax(Status.success, result);
		} catch (Exception e) {
			log.error("登入子系统失败", e);
			return ajax(Status.error, "登入子系统失败!");
		}
	}


    /**
     * TODO 方便本地模拟登入无需请求平台 后期会注释
     * <p>Title: initTest
     * <p>Description: 模拟加载子系统
     * @param request 存放session
     * @return 菜单权限,以及初始化需要的参数
     */
    @ResponseBody
    @RequestMapping(value = "/initTest.do")
    public Object initTest(HttpServletRequest request) {
        try {
            // 将用户信息存入session
            request.getSession().setAttribute(SessionContant.SESSION_INFO,
                    new SessionVo("admin", true, request.getParameter("local_ip"),
                            request.getParameter("local_mac"), request.getParameter("local_machine")));
            return ajax(Status.success, "模拟登入成功");
        } catch (Exception e) {
            log.error("模拟登入失败", e);
            return ajax(Status.error, "模拟登入失败");
        }
    }

}
