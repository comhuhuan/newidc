/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.service;

import java.util.HashMap;

import com.act.framework.util.PageResult;
import com.act.idc.model.IsmsxIdcBasicInfo;
import com.act.web.module.basedata.vo.IdcOperatorVo;

/**
 * The <code>IdcOperatorServiceImpl</code>
 * idc经营者管理 service
 *
 * @author xuliang
 * @since v1.0
 */
public interface IdcOperatorService {

    /**
     * 分页查询ismsx_idcbasicinfo
     *
     * @param page 分页结果集
     * @param idcOperatorVo 查询条件
     * @return {@code PageResult<IdcOperatorVo>}
     */
    PageResult<IdcOperatorVo> pagingList(PageResult<IdcOperatorVo> page,
    		IdcOperatorVo idcOperatorVo);   
    /**
     * 新增
     * @param ismsxIdcBasicInfo 实体类
     */
    public void insert(IsmsxIdcBasicInfo ismsxIdcBasicInfo); 
    /**
     * 修改
     * @param ismsxIdcBasicInfo 实体类
     */
    public void update(IsmsxIdcBasicInfo ismsxIdcBasicInfo); 
    /**
     * 删除经营者
     * @param deleteIds 经营者id
     */
    public void remove(String deleteIds);
    
    /**
     * 经营者详情
     * @param idcId 经营者id
     */
    public HashMap<String,Object> findDetailById(String idcId);

}
