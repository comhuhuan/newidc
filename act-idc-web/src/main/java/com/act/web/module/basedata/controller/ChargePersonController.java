/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.idc.model.CardType;
import com.act.idc.model.IdcuserInfo;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.ChargePersonService;
import com.act.web.module.basedata.vo.ChargePersonVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>ChargePersonController</code> 责任人信息 ismsx_idcuserinfo
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/basedata/chargePerson")
public class ChargePersonController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(ChargePersonController.class);

	@Resource
	private ChargePersonService chargePersonService;

	/**
	 * 分页查询ismsx_idcuserinfo
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param idcOperatorVo
	 *            {@code ChargePersonVo}查询条件
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "责任人信息管理", opDesc = "列表展示")
	public Object pagingList(PageResult<ChargePersonVo> page, ChargePersonVo chargePersonVo) {
		try {
			page = chargePersonService.pagingList(page, chargePersonVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("分页查询ismsx_idcuserinfo失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(IdcuserInfo idcuserInfo, String commonFlag) {
		try {
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增
				chargePersonService.insert(idcuserInfo);
				return ajax(Status.success, "新增成功");
			} else {
				// 修改
				chargePersonService.update(idcuserInfo);
				return ajax(Status.success, "修改成功");
			}
		} catch (Exception e) {
			log.error("操作表ismsx_idcuserinfo失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			chargePersonService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除失败!", e);
			return ajax(Status.error, "删除失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/findIdenType.do")
	public Object findIdenType() {
		try {
			// 获取证件类型，条件：sfyxmk=1 证件有效
			List<CardType> cardTypeList = chargePersonService.findIdenType();
			return ajax(Status.success, cardTypeList);
		} catch (Exception e) {
			log.error("获取证件类型失败!", e);
			return ajax(Status.error, "获取证件类型失败!");
		}
	}

}
