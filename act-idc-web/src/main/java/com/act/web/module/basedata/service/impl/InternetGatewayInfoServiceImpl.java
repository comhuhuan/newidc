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
import com.act.idc.model.IsmxbGatewayInfo;
import com.act.web.module.basedata.service.InternetGatewayInfoService;
import com.act.web.module.basedata.vo.InternetGatewayInfoVo;

/**
 * The <code>InternetGatewayInfoServiceImpl</code> 互联网出入口信息管理 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class InternetGatewayInfoServiceImpl implements InternetGatewayInfoService {

	@Override
	public PageResult<InternetGatewayInfoVo> pagingList(PageResult<InternetGatewayInfoVo> page,
			InternetGatewayInfoVo internetGatewayInfoVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.gatewayID AS gatewayID,a.service_code AS service_code,a.bandWidth AS bandWidth,a.linkType AS linkType,a.accessUnit AS accessUnit,");
		sql.append(" a.gatewayIP AS gatewayIP,a.ftpstatus AS ftpstatus FROM ismxb_gatewayinfo a where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		if (internetGatewayInfoVo != null) {
			// 出入口网关ip
			String gatewayipQuery = internetGatewayInfoVo.getGatewayipQuery();
			if (StringUtils.isNotEmpty(gatewayipQuery)) {
				sql.append(" and a.gatewayIP like ?");
				params.add("%" + gatewayipQuery.trim() + "%");
			}
		}
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), InternetGatewayInfoVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public boolean isExistId(int id) {
		List<String> idList = DbUtil.queryForObjectList("select gatewayID from ismxb_gatewayinfo where gatewayID = ? ",
				String.class, id);
		if (idList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void insert(IsmxbGatewayInfo ismxbGatewayInfo) {
		ismxbGatewayInfo.insert();		
	}

	@Override
	public void update(IsmxbGatewayInfo ismxbGatewayInfo) {
		IsmxbGatewayInfo oldGatewayInfo = IsmxbGatewayInfo.getByKey(ismxbGatewayInfo.getGatewayid(),ismxbGatewayInfo.getServiceCode());
		try {
			PropertyUtils.copyProperties(oldGatewayInfo, ismxbGatewayInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldGatewayInfo.update();			
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for(String deleteId : deleteIdsArr) {
			DbUtil.update("delete from ismxb_gatewayinfo where gatewayID = ? ", deleteId);
		}		
	}

	@Override
	public List<IsmxbGatewayInfo> findGatewayInfoByIdcId(String idcId) {
		String serviceCode = DbUtil.queryForObject("select service_code from tab_service_information where idcID = ? ",String.class, idcId);
		List<IsmxbGatewayInfo> gatewayInfo = DbUtil.queryForObjectList("select * from ismxb_gatewayinfo where service_code = ? ",IsmxbGatewayInfo.class, serviceCode);		
		return gatewayInfo;
	}

	

}
