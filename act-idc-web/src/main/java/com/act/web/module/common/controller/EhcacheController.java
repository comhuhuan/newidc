/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.common.controller;

import com.act.web.module.common.service.EhcacheService;
import com.act.web.module.common.vo.SelectVo;
import com.act.web.util.EhcacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.web.util.ConfigLoadUtil;
import com.act.web.util.SpringContextUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Title:EhcacheController
 * <p>
 * Description:缓存控制器
 *
 * @author FMJ
 * @date 2018/2/7 10:48
 */
@Controller
@RequestMapping("/common/ehcache")
public class EhcacheController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(EhcacheController.class);

	@Resource
	private EhcacheService ehcacheService;

    /**
     * TODO 仅为样例,后期会删除
     * <p>Title: load
     * <p>Description: 加载缓存样例
     * @author FMJ
     * @date 2018/2/7 13:52
     * @param userId 用户id
     * @return 缓存数据
     */
	@ResponseBody
	@RequestMapping(value = "/load.do")
	public Object load(String userId) {
		try {
			List<SelectVo> result = ehcacheService.load(userId);
			List keys = EhcacheUtil.getEhcacheKey();
			log.info("缓存key:" + Arrays.toString(keys.toArray()));
			return ajax(Status.success, result);
		} catch (Exception e) {
			log.error("加载缓存失败", e);
			return ajax(Status.error, "加载缓存失败");
		}
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
	@ResponseBody
	@RequestMapping(value = "/evict.do")
	public Object evict(String userId) {
		try {
			ehcacheService.evict("load", userId);
			List keys = EhcacheUtil.getEhcacheKey();
			log.info("缓存key:" + Arrays.toString(keys.toArray()));
			return ajax(Status.success, "清除缓存成功");
		} catch (Exception e) {
			log.error("清除缓存失败", e);
			return ajax(Status.error, "清除缓存失败");
		}
	}
}