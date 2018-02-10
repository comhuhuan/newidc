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
import com.act.idc.model.ResRooms;
import com.act.web.module.basedata.service.ServiceAreaService;
import com.act.web.module.basedata.vo.ServiceAreaVo;

/**
 * The <code>ServiceAreaServiceImpl</code> 机房区域信息管理 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class ServiceAreaServiceImpl implements ServiceAreaService {

	@Override
	public PageResult<ServiceAreaVo> pagingList(PageResult<ServiceAreaVo> page, ServiceAreaVo serviceAreaVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.roomid AS roomid,a.service_code AS service_code,a.roomcode AS roomcode,a.area_code AS area_code,a.contact AS contact,");
		sql.append(
				" a.tel AS tel,a.mobile AS mobile,a.qqmsn AS qqmsn,a.email AS email,a.cons_area AS cons_area,a.floorId AS floorId,a.frameX AS frameX,a.frameY AS frameY,a.remark AS remark,a.send_flag AS send_flag,a.ftpstatus AS ftpstatus,a.ismstip AS ismstip FROM res_rooms a where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		if (serviceAreaVo != null) {
			// 机房片区名称
			String roomnameQuery = serviceAreaVo.getRoomnameQuery();
			if (StringUtils.isNotEmpty(roomnameQuery)) {
				sql.append(" and a.roomname like ?");
				params.add("%" + roomnameQuery.trim() + "%");
			}
			// 机房片区编号
			String roomcodeQuery = serviceAreaVo.getRoomcodeQuery();
			if (StringUtils.isNotEmpty(roomcodeQuery)) {
				sql.append(" and a.roomcode like ?");
				params.add("%" + roomcodeQuery.trim() + "%");
			}
		}
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), ServiceAreaVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public boolean isExistId(int id) {
		List<String> idList = DbUtil.queryForObjectList("select roomid from res_rooms where roomid = ? ", String.class,
				id);
		if (idList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void insert(ResRooms resRooms) {
		resRooms.insert();
	}

	@Override
	public void update(ResRooms resRooms) {
		ResRooms oldResRooms = ResRooms.getByKey(resRooms.getRoomid());
		try {
			PropertyUtils.copyProperties(oldResRooms, resRooms);
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldResRooms.update();
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for (String deleteId : deleteIdsArr) {
			DbUtil.update("delete from res_rooms where roomid = ? ", deleteId);
		}
	}

	@Override
	public List<ResRooms> findResRoomsByIdcId(String idcId) {
		String serviceCode = DbUtil.queryForObject("select service_code from tab_service_information where idcID = ? ",String.class, idcId);
		List<ResRooms> resRooms = DbUtil.queryForObjectList("select * from res_rooms where service_code = ? ",ResRooms.class, serviceCode);		
		return resRooms;
	}

}
