/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.util;

import java.util.List;
import java.util.Map;

import com.act.web.module.common.service.EhcacheService;
import com.act.web.module.common.vo.SelectVo;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

/**
 * <p>
 * Title: EhcacheUtil
 * <p>
 * Description: 缓存相关工具类
 * 
 * @author FMJ
 * @date 2018/2/7 10:44
 */
public class EhcacheUtil {

	private static EhcacheService ehcacheService = SpringContextUtil.getBean("ehcacheServiceImpl");

	/**
	 * <p>
	 * Title:getEhcacheKey
	 * <p>
	 * Description:得到myCache下 所有key值
	 * 
	 * @author FMJ
	 * @date 2018/2/7 18:04
	 * @return 得到key列表
	 */
	public static List getEhcacheKey() {
		CacheManager cacheManager = CacheManager.getCacheManager("ehCache");
		Ehcache ehcache = cacheManager.getEhcache("myCache");
		return ehcache.getKeys();
	}

	/**
	 * <p>
	 * Title: getConfigByConfigId
	 * <p>
	 * Description: 根据tab_sysconfig.configid 得到 tab_sysconfig.configval
	 * 
	 * @author FMJ
	 * @date 2018/2/7 18:04
	 * @param configId
	 *            tab_sysconfig.configid
	 * @return tab_sysconfig.configval
	 */
	public static String getConfigByConfigId(String configId) {
		// 缓存处理
		Map<String, String> resultMap = ehcacheService.loadConfig();
		return resultMap.get(configId);
	}

	/**
	 * <p>
	 * Title: getServiceCodeList
	 * <p>
	 * Description: 根据用户ID得到有权限的机房列表
	 * 
	 * @author FMJ
	 * @date 2018/2/7 18:04
	 * @param userId
	 *            用户ID
	 * @return 机房列表
	 */
	public static List<SelectVo> getServiceCodeList(String userId, boolean isAdmin) {
		// 缓存处理
		return ehcacheService.loadServiceCodeList(userId, isAdmin);
	}

}
