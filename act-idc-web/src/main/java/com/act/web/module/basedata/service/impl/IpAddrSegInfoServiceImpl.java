/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.IsmsxIpSegInfo;
import com.act.web.module.basedata.service.IpAddrSegInfoService;
import com.act.web.module.basedata.vo.IpAddrSegInfoVo;

/**
 * The <code>IpAddrSegInfoServiceImpl</code> ip地址段信息 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class IpAddrSegInfoServiceImpl implements IpAddrSegInfoService {

	@Override
	public PageResult<IpAddrSegInfoVo> pagingList(PageResult<IpAddrSegInfoVo> page, IpAddrSegInfoVo ipAddrSegInfoVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.ipID AS ipID,a.service_code AS serviceCode,a.startIP AS startIP,a.endIP AS endIP,a.pstartIP AS pstartIP,");
		sql.append(" a.pendIP AS pendIP,a.type AS type,a.user AS user,a.IDtype AS IDtype, ");
		sql.append(
				" a.IDnumber AS IDnumber,a.sourceUnit AS sourceUnit,a.allocationU AS allocationU, a.useTime AS useTime,a.usertype AS usertype,a.ftpstatus AS ftpstatus,a.serverid AS serverid FROM ismsx_ipseginfo a where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		if (ipAddrSegInfoVo != null) {
			// 根据ip地址模糊查询，包括起始ip地址和终止ip地址
			String ipAddrQuery = ipAddrSegInfoVo.getIpAddrQuery();
			if (StringUtils.isNotEmpty(ipAddrQuery)) {
				sql.append(" and a.startIP like ?");
				params.add("%" + ipAddrQuery.trim() + "%");
				sql.append(" and a.endIP like ?");
				params.add("%" + ipAddrQuery.trim() + "%");
			}			
		}
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), IpAddrSegInfoVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public boolean isExistId(int id) {
		List<String> idList = DbUtil.queryForObjectList("select ipID from ismsx_ipseginfo where ipID = ? ",
				String.class, id);
		if (idList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void insert(IsmsxIpSegInfo ismsxIpSegInfo) {
		ismsxIpSegInfo.insert();		
	}

	@Override
	public void update(IsmsxIpSegInfo ismsxIpSegInfo) {
		IsmsxIpSegInfo oldIpSegInfo = IsmsxIpSegInfo.getByKey(ismsxIpSegInfo.getIpid(),ismsxIpSegInfo.getServiceCode());
		try {
			PropertyUtils.copyProperties(oldIpSegInfo, ismsxIpSegInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldIpSegInfo.update();		
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for(String deleteId : deleteIdsArr) {
			DbUtil.update("delete from ismsx_ipseginfo where ipID = ? ", deleteId);
		}	
	}

	@Override
	public IsmsxIpSegInfo findDetailById(String id) {
		IsmsxIpSegInfo ipSegInfo = DbUtil.queryForObject("select * from ismsx_ipseginfo where ipID = ? ",IsmsxIpSegInfo.class, id);
		return ipSegInfo;
	}

	@Override
	public List<IsmsxIpSegInfo> findIpAddrSegByIdcId(String idcId) {
		String serviceCode = DbUtil.queryForObject("select service_code from tab_service_information where idcID = ? ",String.class, idcId);
		List<IsmsxIpSegInfo> ismsxIpSegInfo = DbUtil.queryForObjectList("select * from ismsx_ipseginfo where service_code = ? ",IsmsxIpSegInfo.class, serviceCode);		
		return ismsxIpSegInfo;
	}
	
}
