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
import com.act.idc.model.IsmxbGatewayInfo;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.InternetGatewayInfoService;
import com.act.web.module.basedata.vo.InternetGatewayInfoVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>InternetGatewayInfoController</code> 互联网出入口信息 ismxb_gatewayinfo
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/basedata/internetGateway")
public class InternetGatewayInfoController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(InternetGatewayInfoController.class);

	@Resource
	private InternetGatewayInfoService internetGatewayInfoService;

	/**
	 * 分页查询ismxb_gatewayinfo
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param idcOperatorVo
	 *            {@code InternetGatewayInfoVo}查询条件
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "互联网出入口信息管理", opDesc = "列表展示")
	public Object pagingList(PageResult<InternetGatewayInfoVo> page, InternetGatewayInfoVo internetGatewayInfoVo) {
		try {
			page = internetGatewayInfoService.pagingList(page, internetGatewayInfoVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("分页查询ismxb_gatewayinfo失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(IsmxbGatewayInfo ismxbGatewayInfo, String commonFlag) {
		try {
			// 新增
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增时判断ID是否存在，若存在，给提示已存在，不能新增
				boolean isExistId = internetGatewayInfoService.isExistId(ismxbGatewayInfo.getGatewayid());
				if (isExistId) {
					return ajax(Status.error, "ID已存在，不能执行新增操作");
				} else {
					internetGatewayInfoService.insert(ismxbGatewayInfo);
					return ajax(Status.success, "新增成功");
				}
			}
			// 修改
			if ("update".equalsIgnoreCase(commonFlag)) {
				internetGatewayInfoService.update(ismxbGatewayInfo);
				return ajax(Status.success, "修改成功");
			}
			return null;
		} catch (Exception e) {
			log.error("操作表ismxb_gatewayinfo失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			internetGatewayInfoService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除失败!", e);
			return ajax(Status.error, "删除失败!");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/findGatewayInfoByIdcId.do")
	public Object findGatewayInfoByIdcId(String idcId){
		try{
			//根据idcId查找互联网出入口信息,先获取servicecode,在根据servicecode获取互联网出入口信息
			List<IsmxbGatewayInfo> gatewayInfoList=internetGatewayInfoService.findGatewayInfoByIdcId(idcId);
			return ajax(Status.success, gatewayInfoList);
		}catch(Exception e){
			log.error("根据机房id查找互联网出入口信息失败!", e);
			return ajax(Status.error, "根据机房id查找互联网出入口信息失败!");
		}
	}

}
