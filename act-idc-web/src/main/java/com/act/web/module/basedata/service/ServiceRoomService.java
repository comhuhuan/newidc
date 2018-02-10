/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.idc.model.TabServiceInformation;
import com.act.web.module.basedata.vo.ServiceRoomVo;

/**
 * The <code>ServiceRoomServiceImpl</code>
 * 机房 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface ServiceRoomService {
	/**
     *
     * @param page 分页结果集
     * @param serviceRoomVo 查询条件
     * @return {@code PageResult<ServiceRoomVo>}
     */
    PageResult<ServiceRoomVo> pagingList(PageResult<ServiceRoomVo> page,
    		ServiceRoomVo serviceRoomVo);     
    /**
     * 判断id是否存在
     * @param id 
     */
    public boolean isExistId(int id);
    /**
     * 新增
     * @param tabServiceInformation 实体类
     */
    public void insert(TabServiceInformation tabServiceInformation); 
    /**
     * 修改
     * @param tabServiceInformation 实体类
     */
    public void update(TabServiceInformation tabServiceInformation);   
    /**
     * 删除
     * @param deleteIds 
     */
    public void remove(String deleteIds);
    /**
     * 构造机房树
     * 
     */
    public Map<String,Object> getHouseTree();
    /**
     * 通过id查找机房信息
     * 
     */
    public TabServiceInformation findDetailById(String id);

}
