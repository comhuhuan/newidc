/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.util.operation.ResultContant;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.strategy.service.IllegalWebService;
import com.act.web.module.strategy.vo.IllegalWebVo;

/**
 * <p>
 * Title:IllegalWebController
 * <p>
 * Description: 违法网站控制层,ismsc_nofilterblack,ismsc_nofilterblackrule
 *
 * @author FMJ
 * @date 2018/2/7 14:51
 */
@Controller
@RequestMapping("/strategy/illegalWeb")
public class IllegalWebController extends BaseController {

	private final Logger log = Logger.getLogger(IllegalWebController.class);

	@Resource
	private IllegalWebService illegalWebService;

	/**
	 * <p>
	 * Title: init
	 * <p>
	 * Description: 初始化免过滤网站
	 * 
	 * @return 指令来源/匹配模式列表/机房列表
	 * @author FMJ
	 * @date 2018/2/2 10:39
	 */
    @ResponseBody
    @RequestMapping(value = "/init.do")
	public Object init(HttpSession httpSession) {
		try {
			// 初始化 指令来源/匹配模式列表/机房列表
			IllegalWebVo result = illegalWebService.init(sessionInfo(httpSession).getUserId(),sessionInfo(httpSession).getAdmin());
			return ajax(Status.success, result);
		} catch (Exception e) {
			log.error("查询机房列表失败", e);
			return ajax(Status.error, ResultContant.INIT_ERROR);
		}
	}

    /**
     * <p>
     * Title: pagingList
     * <p>
     * Description: 分页查询 违法网站列表 ismsc_nofilterblack.datatype =2/ismsc_nofilterblackrule
     * 列表展示：违法网站名称/违法网站指令ID/违法网站类型/违法违规情况/
     * 操作人员/创建时间/过期时间/监测状态/封堵状态/操作/处置
     * @author FMJ
     * @date 2018/2/2 10:39
     * @param page
     *            分页属性
     * @param illegalWebVo
     *            查询条件
     * @return 分页结果集
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<IllegalWebVo> page, IllegalWebVo illegalWebVo) {
        try {
            PageResult<IllegalWebVo> result = illegalWebService.pagingList(page, illegalWebVo);
            return ajax(Status.success, result);
        } catch (Exception e) {
            log.error("分页查询ismsc_nofilterblack/ismsc_nofilterblackrule失败", e);
            return ajax(Status.error, ResultContant.QUERY_ERROR);
        }
    }

}