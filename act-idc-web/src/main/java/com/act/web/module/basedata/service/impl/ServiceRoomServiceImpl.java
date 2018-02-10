/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.TabServiceInformation;
import com.act.web.module.basedata.service.ServiceRoomService;
import com.act.web.module.basedata.vo.ServiceRoomVo;

/**
 * The <code>ServiceRoomServiceImpl</code> 机房管理 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class ServiceRoomServiceImpl implements ServiceRoomService {

	@Override
	public PageResult<ServiceRoomVo> pagingList(PageResult<ServiceRoomVo> page,
			ServiceRoomVo serviceRoomVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.idcID,a.source_code,a.webstatus,a.service_code,a.service_name,a.houseType,a.houseOfficer,");
		sql.append(
				" a.area_code,a.comm_code,a.parent_comm_code,a.address,a.zip,a.principal,a.principal_tel,a.unit_nature_code,");
		sql.append(
				" a.safetyman,a.safetyman_tel,a.safetyman_email,a.isp_code,a.service_state,a.terminal_number,a.server_number,a.ip,");
		sql.append(
				" a.access_mode_code,a.practitioner_number,a.net_monitor_department,a.net_monitor_man,a.net_monitor_man_tel,a.punishment_resut,a.service_kind,a.create_time,");
		sql.append(" a.remark,a.send_flag,a.monstatus,a.ftpstatus,a.checkdata,a.ip_range,a.ba_status,a.cons_area,");
		sql.append(
				" a.house_id,a.deploy_site_name,a.excstate,a.exctime,a.msg FROM tab_service_information a where 1 = 1");
		List<Object> params = new ArrayList<>();
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), ServiceRoomVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public boolean isExistId(int id) {
		List<String> idList = DbUtil.queryForObjectList("select idcID from tab_service_information where idcID = ? ",
				String.class, id);
		if (idList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void insert(TabServiceInformation tabServiceInformation) {
		tabServiceInformation.insert();
	}

	@Override
	public void update(TabServiceInformation tabServiceInformation) {
		TabServiceInformation oldServiceInformation = TabServiceInformation.getByKey(tabServiceInformation.getIdcid());
		try {
			PropertyUtils.copyProperties(oldServiceInformation, tabServiceInformation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldServiceInformation.update();
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for (String deleteId : deleteIdsArr) {
			DbUtil.update("delete from tab_service_information where idcID = ? ", deleteId);
		}
	}

	public List<Map<String,Object>> findAllHouses() {
		List<Map<String,Object>> houseList = DbUtil.queryForList("select idcID,service_code,service_name from tab_service_information where 1=1 ");		
		return houseList;
	}

	@Override
	//TODU放在缓存中
	@Cacheable(value = "myCache", key = "#root.methodName")
	public Map<String, Object> getHouseTree() {
		//第一层，所有机房 TODU
		Map<String,Object> firstList = new HashMap<String,Object>();
		//第二层
		Map<String,Object> secondList = new HashMap<String,Object>();	
		//第三层
		Map<String,Object> threeMap = new HashMap<String,Object>();	
		List<Map<String,Object>> threeList = new ArrayList<Map<String,Object>>();
		//获取机房编号和机房名称
		List<Map<String,Object>> houseList = this.findAllHouses();		
		secondList.put("houseList", houseList);			
		threeMap.put("ipAddrSeg", "IP地址段");
		threeMap.put("serviceArea", "机房区域");
		threeMap.put("netGateway", "互联网出入口");	
		threeList.add(threeMap);	
		secondList.put("threeList", threeList);
		firstList.put("root","所有机房");
		firstList.put("secondList",secondList);	
		return firstList;
	}

	@Override
	public TabServiceInformation findDetailById(String id) {
		TabServiceInformation serviceInformation = DbUtil.queryForObject("select * from tab_service_information where idcID = ? ",TabServiceInformation.class, id);
		return serviceInformation;
	}
}
