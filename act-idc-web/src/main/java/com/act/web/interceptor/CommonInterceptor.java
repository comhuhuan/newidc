/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.interceptor;

import com.act.util.json.JacksonUtil;
import com.act.web.constant.SessionContant;
import com.act.web.util.ConfigLoadUtil;
import com.act.web.util.SpringContextUtil;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * The <code>CommonInterceptor</code>用于拦截系统请求
 * <p> 拦截路径在spring-mvc.xml配置</p>
 *
 * @author FMJ
 * @since v1.0
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    /**
     * 打印拦截器日志
     */
    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);


    /**
     * 拦截器处理逻辑,是否开启拦截通过 <b>config.properties</b>中isInterceptor来进行配置,Y表示拦截器开启
     * 当session请求头包含X-Requested-With时,表示为ajax请求,处理逻辑为向response输出sessionOut
     *
     * @param request  {@code HttpServletRequest}  通过request中是否包含{@link com.act.web.constant.SessionContant#SESSION_TICKET}
     *                 来判断是否session过期.
     * @param response {@code HttpServletResponse} 用于session过期后请求转发和重定向.
     * @param handler  {@code Object}
     * @return <tt>true</tt> if <tt>用户session不为空或者拦截器在配置文件中关闭</tt>, otherwise<tt>false</tt>
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        ConfigLoadUtil conf = SpringContextUtil.getBean("configLoadUtil");
        // 如果 config.properties 中 isInterceptor等于Y 表示需要拦截
        String isInterceptor = "Y";
        if (isInterceptor.equals(conf.getIsInterceptor())) {
            String requestUri = request.getRequestURI();
            String contextPath = request.getContextPath();
            String url = requestUri.substring(contextPath.length());
            // 无需拦截的请求
            String[] allow = {"/sso/sso/index.do"};
            if (ArrayUtils.contains(allow,url)) {
                return true;
            }
            Object object = request.getSession().getAttribute(SessionContant.SESSION_TICKET);
            if (null == object) {
                //header属性 ajax标识 前段每次ajax请求会赋值header
                String ajaxHeader = "X-Requested-With";
                if (request.getHeader(ajaxHeader) != null
                        && "XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
                    log.info("Interceptor: ajax拦截session过期!");
                    PrintWriter out = response.getWriter();
                    out.append(JacksonUtil.putValue("sessionOut", true));
                    return false;
                } else {
                    log.info("Interceptor：跳转到login页面!");
                    request.getRequestDispatcher("/index.jsp").forward(request,
                            response);
                    return false;
                }
            }
        }
        return true;

    }

}
