/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.CardType;
import com.act.idc.model.IdcuserInfo;
import com.act.mapper.entity.Example;
import com.act.web.module.basedata.service.ChargePersonService;
import com.act.web.module.basedata.vo.ChargePersonVo;

/**
 * The <code>ChargePersonServiceImpl</code> 责任人 service实现类
 *
 * @author xuliang
 * @since v1.0
 */
@Service
public class ChargePersonServiceImpl implements ChargePersonService {

	@Override
	public PageResult<ChargePersonVo> pagingList(PageResult<ChargePersonVo> page, ChargePersonVo chargePersonVo) {
		StringBuilder sql = new StringBuilder(
				" SELECT a.userId AS userId,a.service_code AS service_code,a.name AS name,a.IDtype AS IDtype,a.ID AS ID,");
		sql.append(
				" a.tel AS tel,a.mobile AS mobile,a.Email AS Email FROM ismsx_idcuserinfo a where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		page = DbUtil.queryPageForObjectPageResult(sql.toString(), ChargePersonVo.class, page.getPageIndex(),
				page.getPageSize(), param);
		return page;
	}

	@Override
	public void insert(IdcuserInfo idcuserInfo) {
		idcuserInfo.insert();
	}

	@Override
	public void update(IdcuserInfo idcuserInfo) {
		IdcuserInfo oldUserInfo = IdcuserInfo.getByKey(idcuserInfo.getUserid(),idcuserInfo.getServiceCode());
		idcuserInfo.setUserid(idcuserInfo.getUserid());
		idcuserInfo.setServiceCode(idcuserInfo.getServiceCode());
		idcuserInfo.setName(idcuserInfo.getName());
		idcuserInfo.setIdtype(idcuserInfo.getIdtype());
		idcuserInfo.setId(idcuserInfo.getId());
		idcuserInfo.setTel(idcuserInfo.getTel());
		idcuserInfo.setMobile(idcuserInfo.getMobile());
		idcuserInfo.setEmail(idcuserInfo.getEmail());
		oldUserInfo.update();
	}

	@Override
	public void remove(String deleteIds) {
		String[] deleteIdsArr = deleteIds.split(",");
		for (String deleteId : deleteIdsArr) {
			IdcuserInfo.getDao().deleteByPrimaryKey(Integer.valueOf(deleteId));
		}
	}

	@Override
	public List<CardType> findIdenType() {
		Example example = new Example(CardType.class);
        //sfyxmk=1表示证件有效
		example.createCriteria().andEqualTo("sfyxmk",1);
        List<CardType> cardTypeList = CardType.getDao().selectByExample(example);		
		return cardTypeList;
	}

}
