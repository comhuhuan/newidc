/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.IdcuserInfo;
import com.act.idc.model.IsmsxIdcBasicInfo;
import com.act.mapper.util.StringUtil;
import com.act.web.module.basedata.service.IdcOperatorService;
import com.act.web.module.basedata.vo.IdcOperatorVo;

/**
 * The <code>IdcOperatorServiceImpl</code> idc经营者管理 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class IdcOperatorServiceImpl implements IdcOperatorService {

	@Override
	public PageResult<IdcOperatorVo> pagingList(PageResult<IdcOperatorVo> page, IdcOperatorVo idcOperatorVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.idcID AS idcID,a.idcName AS idcName,a.idcAdd AS idcAdd,a.idcZip AS idcZip,a.corp AS corp,");
		sql.append(
				" a.idcOfficer AS idcOfficer,a.emergencyContact AS emergencyContact,a.timeStamp AS timeStamp,a.send_flag AS sendFlag, ");
		sql.append(" a.ftpstatus AS ftpStatus,a.msg AS msg FROM ismsx_idcbasicinfo a where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		if (idcOperatorVo != null) {
			// 用户企业法人查询
			String corpQuery = idcOperatorVo.getCorpQuery();
			if (StringUtil.isNotEmpty(corpQuery)) {
				sql.append(" and a.corp like ?");
				params.add("%" + corpQuery.trim() + "%");
			}
			// IDC/ISP许可证号
			String idcidQuery = idcOperatorVo.getIdcidQuery();
			if (StringUtil.isNotEmpty(idcidQuery)) {
				sql.append(" and a.idcId like ?");
				params.add("%" + idcidQuery.trim() + "%");
			}
			// 经营者名称
			String idcnameQuery = idcOperatorVo.getIdcnameQuery();
			if (StringUtil.isNotEmpty(idcnameQuery)) {
				sql.append(" and a.idcName like ?");
				params.add("%" + idcnameQuery.trim() + "%");
			}
			// 是否上报
			String ftpstatusQuery = idcOperatorVo.getFtpstatusQuery();
			if (StringUtil.isNotEmpty(ftpstatusQuery)) {
				sql.append(" and a.ftpstatus like ?");
				params.add("%" + ftpstatusQuery.trim() + "%");
			}
		}
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), IdcOperatorVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public void insert(IsmsxIdcBasicInfo ismsxIdcBasicInfo) {
		ismsxIdcBasicInfo.insert();
	}

	@Override
	public void update(IsmsxIdcBasicInfo ismsxIdcBasicInfo) {
		IsmsxIdcBasicInfo oldBasicInfo = IsmsxIdcBasicInfo.getByKey(ismsxIdcBasicInfo.getIdcid());
		oldBasicInfo.setIdcid(ismsxIdcBasicInfo.getIdcid());
		oldBasicInfo.setIdcname(ismsxIdcBasicInfo.getIdcname());
		oldBasicInfo.setIdcadd(ismsxIdcBasicInfo.getIdcadd());
		oldBasicInfo.setIdczip(ismsxIdcBasicInfo.getIdczip());
		oldBasicInfo.setCorp(ismsxIdcBasicInfo.getCorp());
		oldBasicInfo.setIdcofficer(ismsxIdcBasicInfo.getIdcofficer());
		oldBasicInfo.setEmergencycontact(ismsxIdcBasicInfo.getEmergencycontact());
		oldBasicInfo.setTimestamp(ismsxIdcBasicInfo.getTimestamp());
		oldBasicInfo.setSendFlag(ismsxIdcBasicInfo.getSendFlag());
		oldBasicInfo.setFtpstatus(ismsxIdcBasicInfo.getFtpstatus());
		oldBasicInfo.setMsg(ismsxIdcBasicInfo.getMsg());
		oldBasicInfo.update();
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for (String deleteId : deleteIdsArr) {
			IsmsxIdcBasicInfo.getDao().deleteByPrimaryKey(Integer.valueOf(deleteId));
		}
	}

	@Override
	public HashMap<String, Object> findDetailById(String idcId) {
		HashMap<String, Object> detailMap = new HashMap<String, Object>();
		// 根据id获取经营者信息
		IsmsxIdcBasicInfo basicInfo = IsmsxIdcBasicInfo.getByKey(idcId);
		// 应急联系人信息
		List<IdcuserInfo> emergencycontact = null;
		if (StringUtil.isNotEmpty(basicInfo.getEmergencycontact())) {
			emergencycontact = IdcuserInfo.getDao().selectAll();
		}
		// 网络信息安全责任人信息
		List<IdcuserInfo> idcofficer = null;
		if (StringUtil.isNotEmpty(basicInfo.getIdcofficer())) {
			idcofficer = IdcuserInfo.getDao().selectAll();
		}
		detailMap.put("emergencycontact", emergencycontact);
		detailMap.put("idcofficer", idcofficer);
		detailMap.put("basicInfo", basicInfo);
		return detailMap;
	}

}
