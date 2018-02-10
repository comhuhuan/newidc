/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.ResCabinets;
import com.act.web.module.basedata.service.CabinetInfoService;
import com.act.web.module.basedata.vo.CabinetInfoVo;

/**
 * The <code>CabinetInfoServiceImpl</code> 机柜管理 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class CabinetInfoServiceImpl implements CabinetInfoService {

	@Override
	public PageResult<CabinetInfoVo> pagingList(PageResult<CabinetInfoVo> page, CabinetInfoVo cabinetInfoVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.cabid AS cabid,a.service_code AS service_code,a.cabcode AS cabcode,a.cabname AS cabname,a.cabremark AS cabremark,");
		sql.append(
				" a.cabLocation AS cabLocation,a.roomid AS roomid,a.units AS units,a.custid AS custid,a.model AS model,a.assign_status AS assign_status,a.usetype AS usetype,a.position_num AS position_num,a.status AS status,a.orderid AS orderid,a.send_flag AS send_flag,a.ftpstatus AS ftpstatus,ismstip AS ismstip FROM res_cabinets a where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), CabinetInfoVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public boolean isExistId(int id) {
		List<String> idList = DbUtil.queryForObjectList("select cabid from res_cabinets where cabid = ? ", String.class,
				id);
		if (idList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void insert(ResCabinets resCabinets) {
		resCabinets.insert();
	}

	@Override
	public void update(ResCabinets resCabinets) {
		ResCabinets oldResCabinets = ResCabinets.getByKey(resCabinets.getCabid());
		try {
			PropertyUtils.copyProperties(oldResCabinets, resCabinets);
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldResCabinets.update();
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for (String deleteId : deleteIdsArr) {
			DbUtil.update("delete from res_cabinets where cabid = ? ", deleteId);
		}
	}

}
