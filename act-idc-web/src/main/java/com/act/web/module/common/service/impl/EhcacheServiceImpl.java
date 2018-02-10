/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.common.service.impl;

import com.act.framework.util.DbUtil;
import com.act.idc.model.TabSysConfig;
import com.act.web.module.common.service.EhcacheService;
import com.act.web.module.common.vo.SelectVo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:EhcacheServiceImpl
 * <p>Description:缓存service
 * <p>Modified History:
 *
 * @author FMJ
 * @date 2018/2/7 11:38
 */
@Service
public class EhcacheServiceImpl implements EhcacheService{

    /**
     * <p>Title: loadServiceCodeList
     * <p>Description: 加载机房列表,根据用户id
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param userId 用户id
     * @return 机房列表
     */
    @Override
    @Cacheable(value = "myCache", key = "#root.methodName + #root.args[0] + #root.args[1]")
    public  List<SelectVo> loadServiceCodeList(String userId,boolean isAdmin) {
        if(isAdmin){
            return DbUtil.queryForObjectList(
                    " SELECT DISTINCT a.service_code as value,a.service_name as label FROM tab_service_information a ",SelectVo.class);
        }else{
            return DbUtil.queryForObjectList(
                    " SELECT DISTINCT a.service_code as value,a.service_name as label FROM tab_service_information a "
                            + " LEFT JOIN tab_servicepurview b ON a.service_code = b.servicecode where b.user_id = ? ",
                    SelectVo.class, userId);
        }
    }

    /**
     * <p>Title: loadConfig
     * <p>Description: 加载tab_sysconfig Configid为键/Configval值
     * TODO 刷新缓存值逻辑未写,配置维护逻辑应该加入
     * @author FMJ
     * @date 2018/2/7 13:52
     * @return tab_sysconfig数据列表,加入缓存
     */
    @Override
    @Cacheable(value = "myCache", key = "#root.methodName")
    public Map<String, String> loadConfig() {
        Map<String, String> result = new HashMap<>(16);
        List<TabSysConfig> sysList = TabSysConfig.getDao().selectAll();
        for (TabSysConfig sys : sysList) {
            result.put(sys.getConfigid(), sys.getConfigval());
        }
        return result;
    }


    /**
     * TODO 仅为样例,后期会删除
     * <p>Title: load
     * <p>Description: 加载缓存样例
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param userId 用户id
     * @return 缓存数据
     */
    @Override
    @Cacheable(value = "myCache", key = "#root.methodName + #root.args[0]")
    public  List<SelectVo> load(String userId) {
        return DbUtil.queryForObjectList(
                " SELECT DISTINCT a.service_code as value,a.service_name as label FROM tab_service_information a "
                        + " LEFT JOIN tab_servicepurview b ON a.service_code = b.servicecode where b.user_id = ? ",
                SelectVo.class, userId);
    }

    /**
     * TODO 仅为样例,后期会删除
     * <p>Title: load
     * <p>Description: 清除缓存样例
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param userId 用户id
     * @return 清除结果
     */
    @Override
    @CacheEvict(value = "myCache", key = "#root.args[0] + #root.args[1]")
    public void evict(String methodName,String userId) {
    }



}