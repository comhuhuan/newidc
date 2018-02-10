/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.idc.model.TabServiceInformation;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.ServiceRoomService;
import com.act.web.module.basedata.vo.ServiceRoomVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>ServiceRoomController</code> 机房信息 tab_service_information
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/common/tabServiceInformation")//TODO
public class ServiceRoomController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(ServiceRoomController.class);

	@Resource
	private ServiceRoomService serviceRoomService;

	/**
	 * 分页查询tab_service_information
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param idcOperatorVo
	 *            {@code ServiceRoomVo}查询条件
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "机房信息管理", opDesc = "列表展示")
	public Object pagingList(PageResult<ServiceRoomVo> page, ServiceRoomVo serviceRoomVo) {
		try {
			//树节点 TODU 放在vo
			Map<String,Object> houseTree = new HashMap<String,Object>();	
			//构造树
			Map<String,Object> tree = serviceRoomService.getHouseTree();
			//列表 
			page = serviceRoomService.pagingList(page, serviceRoomVo);				
			tree.put("pageList",page);
			houseTree.put("firstList",tree);
			return ajax(Status.success, houseTree);
		} catch (Exception e) {
			log.error("分页查询tab_service_information失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(TabServiceInformation tabServiceInformation, String commonFlag) {
		try {
			// 新增
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增时判断ID是否存在，若存在，给提示已存在，不能新增
				boolean isExistId = serviceRoomService.isExistId(Integer.valueOf(tabServiceInformation.getIdcid()));
				if (isExistId) {
					return ajax(Status.error, "ID已存在，不能执行新增操作");
				} else {
					serviceRoomService.insert(tabServiceInformation);
					return ajax(Status.success, "新增成功");
				}
			}
			// 修改
			if ("update".equalsIgnoreCase(commonFlag)) {
				serviceRoomService.update(tabServiceInformation);
				return ajax(Status.success, "修改成功");
			}
			return null;
		} catch (Exception e) {
			log.error("操作表tab_service_information失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			serviceRoomService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除失败!", e);
			return ajax(Status.error, "删除失败!");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/findDetailById.do")
	public Object findDetailById(String id) {
		try{
			//根据id查找机房信息
			TabServiceInformation tabServiceInformation=serviceRoomService.findDetailById(id);
			return ajax(Status.success, tabServiceInformation);
		}catch(Exception e){
			log.error("查找机房失败!", e);
			return ajax(Status.error, "查找机房失败!");
		}
	}
	
	
	

}
