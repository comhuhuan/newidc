/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.idc.model.ResCabinets;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.CabinetInfoService;
import com.act.web.module.basedata.vo.CabinetInfoVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>cabinetInfo</code> 机柜信息 res_cabinets
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/basedata/cabinetInfo")
public class CabinetInfoController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(CabinetInfoController.class);

	@Resource
	private CabinetInfoService cabinetInfoService;

	/**
	 * 分页查询res_cabinets
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param idcOperatorVo
	 *            {@code CabinetInfoVo}查询条件
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "机柜信息管理", opDesc = "列表展示")
	public Object pagingList(PageResult<CabinetInfoVo> page, CabinetInfoVo cabinetInfoVo) {
		try {
			page = cabinetInfoService.pagingList(page, cabinetInfoVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("分页查询res_cabinets失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(ResCabinets resCabinets, String commonFlag) {
		try {
			// 新增
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增时判断ID是否存在，若存在，给提示已存在，不能新增
				boolean isExistId = cabinetInfoService.isExistId(resCabinets.getRoomid());
				if (isExistId) {
					return ajax(Status.error, "ID已存在，不能执行新增操作");
				} else {
					cabinetInfoService.insert(resCabinets);
					return ajax(Status.success, "新增成功");
				}
			}
			// 修改
			if ("update".equalsIgnoreCase(commonFlag)) {
				cabinetInfoService.update(resCabinets);
				return ajax(Status.success, "修改成功");
			}
			return null;
		} catch (Exception e) {
			log.error("操作表res_cabinets失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			cabinetInfoService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除失败!", e);
			return ajax(Status.error, "删除失败!");
		}
	}

}
