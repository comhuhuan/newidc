/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import java.util.List;

import com.act.framework.util.PageResult;
import com.act.idc.model.IsmsxIpSegInfo;
import com.act.web.module.basedata.vo.IpAddrSegInfoVo;

/**
 * The <code>IpAddrSegInfoServiceImpl</code>
 * ip地址段信息 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface IpAddrSegInfoService {
	/**
     * 分页查询ismsx_ipseginfo
     *
     * @param page 分页结果集
     * @param ipAddrSegInfoVo 查询条件
     * @return {@code PageResult<IpAddrSegInfoVo>}
     */
    PageResult<IpAddrSegInfoVo> pagingList(PageResult<IpAddrSegInfoVo> page,
    		IpAddrSegInfoVo ipAddrSegInfoVo);     
    /**
     * 判断ip地址信息中id是否存在
     * @param id ip地址信息id
     */
    public boolean isExistId(int id);
    /**
     * 新增
     * @param ismsxIpSegInfo 实体类
     */
    public void insert(IsmsxIpSegInfo ismsxIpSegInfo); 
    /**
     * 修改
     * @param ismsxIpSegInfo 实体类
     */
    public void update(IsmsxIpSegInfo ismsxIpSegInfo);   
    /**
     * 删除ip地址信息
     * @param deleteIds ip地址信息id
     */
    public void remove(String deleteIds);
    /**
     * 通过id查找ip信息
     * 
     */
    public IsmsxIpSegInfo findDetailById(String id);
    /**
     * 通过机房id查找ip地址信息
     * 
     */
    public List<IsmsxIpSegInfo> findIpAddrSegByIdcId(String idcId);
}
