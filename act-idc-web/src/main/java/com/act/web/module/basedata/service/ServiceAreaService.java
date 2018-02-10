/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import java.util.List;

import com.act.framework.util.PageResult;
import com.act.idc.model.ResRooms;
import com.act.web.module.basedata.vo.ServiceAreaVo;

/**
 * The <code>IServiceAreaServiceImpl</code>
 * 机房区域 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface ServiceAreaService {
	/**
     *
     * @param page 分页结果集
     * @param serviceAreaVo 查询条件
     * @return {@code PageResult<ServiceAreaVo>}
     */
    PageResult<ServiceAreaVo> pagingList(PageResult<ServiceAreaVo> page,
    		ServiceAreaVo serviceAreaVo);     
    /**
     * 判断id是否存在
     * @param id 
     */
    public boolean isExistId(int id);
    /**
     * 新增
     * @param resRooms 实体类
     */
    public void insert(ResRooms resRooms); 
    /**
     * 修改
     * @param resRooms 实体类
     */
    public void update(ResRooms resRooms);   
    /**
     * 删除
     * @param deleteIds 
     */
    public void remove(String deleteIds);
    /**
     * 根据机房id查找机房区域信息 
     */
    public List<ResRooms> findResRoomsByIdcId(String idcId);

}
