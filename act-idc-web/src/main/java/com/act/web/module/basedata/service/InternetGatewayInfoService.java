/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import java.util.List;

import com.act.framework.util.PageResult;
import com.act.idc.model.IsmxbGatewayInfo;
import com.act.web.module.basedata.vo.InternetGatewayInfoVo;

/**
 * The <code>InternetGatewayInfoImpl</code>
 * 互联网出入口信息 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface InternetGatewayInfoService {
	/**
     *
     * @param page 分页结果集
     * @param internetGatewayInfoVo 查询条件
     * @return {@code PageResult<InternetGatewayInfoVo>}
     */
    PageResult<InternetGatewayInfoVo> pagingList(PageResult<InternetGatewayInfoVo> page,
    		InternetGatewayInfoVo internetGatewayInfoVo);     
    /**
     * 判断id是否存在
     * @param id 
     */
    public boolean isExistId(int id);
    /**
     * 新增
     * @param ismxbGatewayInfo 实体类
     */
    public void insert(IsmxbGatewayInfo ismxbGatewayInfo); 
    /**
     * 修改
     * @param ismxbGatewayInfo 实体类
     */
    public void update(IsmxbGatewayInfo ismxbGatewayInfo);   
    /**
     * 删除
     * @param deleteIds 
     */
    public void remove(String deleteIds);
    
    /**
     * 根据机房id查找互联网信息 
     * 
     */
    public List<IsmxbGatewayInfo> findGatewayInfoByIdcId(String idcId);

}
