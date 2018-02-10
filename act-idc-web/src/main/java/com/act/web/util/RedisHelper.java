package com.act.web.util;


import com.act.util.redis.JedisPoolFactory;
import com.act.util.redis.JedisTemplate;

import redis.clients.jedis.JedisPool;

public class RedisHelper {
	private static RedisHelper instance = null;
	private JedisPool pool;
	private JedisTemplate jedisTemplate;

	private RedisHelper() {
		ConfigLoadUtil conf = SpringContextUtil.getBean("configLoadUtil");
		pool = JedisPoolFactory.createJedisPool(conf.getRedisIp(),
				conf.getRedisPort(), conf.getRedisTimeout(), 
				conf.getRedisMaxIdle(),conf.getRedisMaxActive(),conf.getRedisPass());
		jedisTemplate = new JedisTemplate(pool);
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new RedisHelper();

		}
	}

	public static RedisHelper getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	public JedisTemplate getJedisTemplate() {
		return jedisTemplate;
	}
}
