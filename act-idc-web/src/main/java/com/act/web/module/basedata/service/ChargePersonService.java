/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import java.util.List;

import com.act.framework.util.PageResult;
import com.act.idc.model.CardType;
import com.act.idc.model.IdcuserInfo;
import com.act.web.module.basedata.vo.ChargePersonVo;

/**
 * The <code>ChargePersonServiceImpl</code>
 * 责任人 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface ChargePersonService {
	/**
     *
     * @param page 分页结果集
     * @param chargePersonVo 查询条件
     * @return {@code PageResult<ChargePersonVo>}
     */
    PageResult<ChargePersonVo> pagingList(PageResult<ChargePersonVo> page,
    		ChargePersonVo chargePersonVo);     
    /**
     * 新增
     * @param IdcuserInfo 实体类
     */
    public void insert(IdcuserInfo idcuserInfo); 
    /**
     * 修改
     * @param IdcuserInfo 实体类
     */
    public void update(IdcuserInfo idcuserInfo);   
    /**
     * 删除
     * @param deleteIds 
     */
    public void remove(String deleteIds);
    
    /**
     * 获取证件类型
     */
    public List<CardType> findIdenType();

}
