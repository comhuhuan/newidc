/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.idc.model.IsmsxIdcBasicInfo;
import com.act.util.operatelog.OperateLog;
import com.act.web.module.basedata.service.IdcOperatorService;
import com.act.web.module.basedata.vo.IdcOperatorVo;
import com.act.web.module.common.controller.BaseController;

/**
 * The <code>IdcOperatorController</code> IDC经营者管理页信息 ismsx_idcbasicinfo
 *
 * @author xuliang
 * @since v2.0
 */
@Controller
@RequestMapping("/basedata/idcOperator")
public class IdcOperatorController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(IdcOperatorController.class);

	@Resource
	private IdcOperatorService idcOperatorService;

	/**
	 * 分页查询ismsx_idcbasicinfo
	 * 
	 * @param page
	 *            {@code PageResult}分页属性
	 * @param idcOperatorVo
	 *            {@code IdcOperatorVo}查询条件
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pagingList.do")
	@OperateLog(opObject = "IDC经营者管理", opDesc = "列表展示")
	public Object pagingList(PageResult<IdcOperatorVo> page, IdcOperatorVo idcOperatorVo) {
		try {
			page = idcOperatorService.pagingList(page, idcOperatorVo);
			return ajax(Status.success, page);
		} catch (Exception e) {
			log.error("分页查询ismsx_idcbasicinfo失败!", e);
			return ajax(Status.error, "查询失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/save.do")
	public Object save(IsmsxIdcBasicInfo ismsxIdcBasicInfo, String commonFlag) {
		try {
			// 设置SendFlag默认值,0表示未发送过，1表示已发送过了
			ismsxIdcBasicInfo.setSendFlag(0);
			//设置Ftpstatus默认值,0表示已上报,1表示未上报
			ismsxIdcBasicInfo.setFtpstatus(1);
			ismsxIdcBasicInfo.setTimestamp(Timestamp
					.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())));			
			if ("add".equalsIgnoreCase(commonFlag)) {
				// 新增
				idcOperatorService.insert(ismsxIdcBasicInfo);
				return ajax(Status.success, "新增成功");
			} else {
				//修改
				idcOperatorService.update(ismsxIdcBasicInfo);
				return ajax(Status.success, "修改成功");
			}
		} catch (Exception e) {
			log.error("操作经营者表ismsx_idcbasicinfo失败", e);
			return ajax(Status.error, "新增或修改失败!");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/remove.do")
	public Object remove(String deleteIds) {
		try {
			idcOperatorService.remove(deleteIds);
			return ajax(Status.success, "删除成功");
		} catch (Exception e) {
			log.error("删除经营者信息失败!", e);
			return ajax(Status.error, "删除失败!");
		}

	}

	@ResponseBody
	@RequestMapping(value = "/findDetailById.do")
	public Object findDetailById(String idcid) {
		try {
			HashMap<String,Object> detailMap = idcOperatorService.findDetailById(idcid);
			return ajax(Status.success, detailMap);
		} catch (Exception e) {
			log.error("查看经营者信息失败!", e);
			return ajax(Status.error, "查看详情失败!");
		}
	}

}
