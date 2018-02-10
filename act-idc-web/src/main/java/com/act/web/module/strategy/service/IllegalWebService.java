/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.service;

import com.act.framework.util.PageResult;
import com.act.web.module.strategy.vo.IllegalWebVo;

/**
 * <p>
 * Title:IllegalWebService
 * <p>
 * Description: 违法网站service,ismsc_nofilterblack,ismsc_nofilterblackrule
 *
 * @author FMJ
 * @date 2018/2/7 17:36
 */
public interface IllegalWebService {

	/**
	 * <p>
	 * Title: init
	 * <p>
	 * Description: 初始化免过滤网站
	 *
	 * @param userId
	 *            当前用户
	 * @param isAdmin
	 *            是否为管理员
	 * @return 指令来源/匹配模式列表/机房列表
	 * @throws Exception
	 * @author FMJ
	 * @date 2018/2/2 10:39
	 */
	IllegalWebVo init(String userId, boolean isAdmin) throws Exception;

	/**
	 * <p>
	 * Title: pagingList
	 * <p>
     * Description: 分页查询 违法网站列表 ismsc_nofilterblack.datatype =2/ismsc_nofilterblackrule
     * 列表展示：违法网站名称/违法网站指令ID/违法网站类型/违法违规情况/
     * 操作人员/创建时间/过期时间/监测状态/封堵状态/操作/处置
     *
     * @param page
     *            分页属性
     * @param illegalWebVo
     *            查询条件
     * @return 分页结果集
	 * @throws Exception
     * @author FMJ
	 * @date 2018/2/2 10:39
     *
	 */
	PageResult<IllegalWebVo> pagingList(PageResult<IllegalWebVo> page, IllegalWebVo illegalWebVo) throws Exception;
}