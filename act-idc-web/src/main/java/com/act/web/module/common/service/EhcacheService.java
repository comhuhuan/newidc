/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.common.service;

import java.util.List;
import java.util.Map;

import com.act.web.module.common.vo.SelectVo;

/**
 * <p>
 * Title:EhcacheService
 * <p>
 * Description:缓存样例service
 * TODO 因各功能维模块未开发完毕,获取暂时放置此类中
 * 
 * @author FMJ
 * @date 2018/2/7 11:38
 */
public interface EhcacheService {

    /**
     * <p>Title: loadServiceCodeList
     * <p>Description: 加载机房列表,根据用户id
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param userId 用户ID
     * @return 机房列表,加入缓存
     */
    List<SelectVo> loadServiceCodeList(String userId,boolean isAdmin);

    /**
     * TODO 刷新缓存值逻辑未写,配置维护逻辑应该加入
     * <p>Title: loadConfig
     * <p>Description: 加载tab_sysconfig属性
     * @author FMJ
     * @date 2018/2/7 13:52
     * @return tab_sysconfig数据列表,加入缓存
     */
    Map<String, String> loadConfig();

    /**
     * TODO 仅为样例,后期会删除
     * <p>Title: load
     * <p>Description: 加载缓存
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param userId 用户id
     * @return 缓存数据
     */
	List<SelectVo> load(String userId);


    /**
     * TODO 仅为样例,后期会删除
     * <p>Title: load
     * <p>Description: 清除缓存
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param methodName 方法名称
     * @param userId 用户id
     * @return 清除结果
     */
    void evict(String methodName,String userId);
}