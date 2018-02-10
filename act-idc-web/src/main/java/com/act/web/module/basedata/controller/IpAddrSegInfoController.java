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
import com.act.idc.model.IsmsxIpSegInfo;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.IpAddrSegInfoService;
import com.act.web.module.basedata.vo.IpAddrSegInfoVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>IpAddrSegInfoController</code> ip地址段信息 ismsx_ipseginfo
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/basedata/ipAddrSegInfo")
public class IpAddrSegInfoController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(IpAddrSegInfoController.class);

	@Resource
	private IpAddrSegInfoService ipAddrSegInfoService;

	/**
	 * 分页查询ismsx_ipseginfo
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param ipAddrSegInfoVo
	 *            {@code IpAddrSegInfoVo}查询条件
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "ip地址段信息", opDesc = "列表展示")
	public Object pagingList(PageResult<IpAddrSegInfoVo> page, IpAddrSegInfoVo ipAddrSegInfoVo) {
		try {
			page = ipAddrSegInfoService.pagingList(page, ipAddrSegInfoVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("分页查询ismsx_ipseginfo失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(IsmsxIpSegInfo ismsxIpSegInfo, String commonFlag) {
		try {
			// 新增
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增时判断ID是否存在，若存在，给提示已存在，不能新增
				boolean isExistId = ipAddrSegInfoService.isExistId(ismsxIpSegInfo.getIpid());
				if (isExistId) {
					return ajax(Status.error, "ID已存在，不能执行新增操作");
				} else {
					ipAddrSegInfoService.insert(ismsxIpSegInfo);
					return ajax(Status.success, "新增成功");
				}
			}
			// 修改
			if ("update".equalsIgnoreCase(commonFlag)) {
				ipAddrSegInfoService.update(ismsxIpSegInfo);
				return ajax(Status.success, "修改成功");
			}
			return null;
		} catch (Exception e) {
			log.error("操作经营者表ismsx_idcbasicinfo失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			ipAddrSegInfoService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除ip地址信息失败!", e);
			return ajax(Status.error, "删除失败!");
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/findDetailById.do")
	public Object findDetailById(String id) {
		try{
			//根据ip地址id查找ip信息
			IsmsxIpSegInfo ipSegInfo=ipAddrSegInfoService.findDetailById(id);
			return ajax(Status.success, ipSegInfo);
		}catch(Exception e){
			log.error("查找ip信息失败!", e);
			return ajax(Status.error, "查找ip信息失败!");
		}
	}	
	
	@ResponseBody
	@RequestMapping(value = "/findIpAddrSegByIdcId.do")
	public Object findIpAddrSegByIdcId(String idcId){
		try{
			//根据idcId查找ip信息,先获取servicecode,在根据servicecode获取ip信息
			List<IsmsxIpSegInfo> ipSegInfoList=ipAddrSegInfoService.findIpAddrSegByIdcId(idcId);
			return ajax(Status.success, ipSegInfoList);
		}catch(Exception e){
			log.error("根据机房id查找ip信息失败!", e);
			return ajax(Status.error, "根据机房id查找ip信息失败!");
		}
	}
	
}
