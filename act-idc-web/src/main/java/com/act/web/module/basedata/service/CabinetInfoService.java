/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import com.act.framework.util.PageResult;
import com.act.idc.model.ResCabinets;
import com.act.web.module.basedata.vo.CabinetInfoVo;

/**
 * The <code>CabinetInfoServiceImpl</code>
 * 机房区域 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface CabinetInfoService {
	/**
     *
     * @param page 分页结果集
     * @param cabinetInfoVo 查询条件
     * @return {@code PageResult<CabinetInfoVo>}
     */
    PageResult<CabinetInfoVo> pagingList(PageResult<CabinetInfoVo> page,
    		CabinetInfoVo cabinetInfoVo);     
    /**
     * 判断id是否存在
     * @param id 
     */
    public boolean isExistId(int id);
    /**
     * 新增
     * @param resCabinetsEntity 实体类
     */
    public void insert(ResCabinets resCabinets); 
    /**
     * 修改
     * @param resCabinetsEntity 实体类
     */
    public void update(ResCabinets resCabinets);   
    /**
     * 删除
     * @param deleteIds 
     */
    public void remove(String deleteIds);

}
