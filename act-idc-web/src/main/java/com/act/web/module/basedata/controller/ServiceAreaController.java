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
import com.act.idc.model.ResRooms;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.ServiceAreaService;
import com.act.web.module.basedata.vo.ServiceAreaVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>serviceArea</code> 机房区域信息 res_rooms
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/basedata/serviceArea")
public class ServiceAreaController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(ServiceAreaController.class);

	@Resource
	private ServiceAreaService serviceAreaService;

	/**
	 * 分页查询res_rooms
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param idcOperatorVo
	 *            {@code ServiceAreaVo}查询条件
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "机房区域信息管理", opDesc = "列表展示")
	public Object pagingList(PageResult<ServiceAreaVo> page, ServiceAreaVo serviceAreaVo) {
		try {
			page = serviceAreaService.pagingList(page, serviceAreaVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("分页查询res_rooms失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(ResRooms resRooms, String commonFlag) {
		try {
			// 新增
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增时判断ID是否存在，若存在，给提示已存在，不能新增
				boolean isExistId = serviceAreaService.isExistId(resRooms.getRoomid());
				if (isExistId) {
					return ajax(Status.error, "ID已存在，不能执行新增操作");
				} else {
					serviceAreaService.insert(resRooms);
					return ajax(Status.success, "新增成功");
				}
			}
			// 修改
			if ("update".equalsIgnoreCase(commonFlag)) {
				serviceAreaService.update(resRooms);
				return ajax(Status.success, "修改成功");
			}
			return null;
		} catch (Exception e) {
			log.error("操作表res_rooms失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			serviceAreaService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除失败!", e);
			return ajax(Status.error, "删除失败!");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/findResRoomsByIdcId.do")
	public Object findResRoomsByIdcId(String idcId){
		try{
			//根据idcId查找机房区域信息,先获取servicecode,在根据servicecode获取机房区域信息
			List<ResRooms> resRoomsList=serviceAreaService.findResRoomsByIdcId(idcId);
			return ajax(Status.success, resRoomsList);
		}catch(Exception e){
			log.error("根据机房id查找机房区域信息失败!", e);
			return ajax(Status.error, "根据机房id查找机房区域信息失败!");
		}
	}

}
