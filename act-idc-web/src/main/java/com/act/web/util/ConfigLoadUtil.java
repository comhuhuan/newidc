/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The <code>ConfigLoadUtil</code>
 * 加载config.properties
 *
 * @author FMJ
 * @since V2.0
 */
@Component
public class ConfigLoadUtil {


    @Value("${isInterceptor}")
    private String isInterceptor;

    @Value("${exportMaxRow}")
    private Integer exportMaxRow;
    
    @Value("${redis.ip}")
    private String redisIp;
    
    @Value("${redis.port}")
    private Integer redisPort;
    
    @Value("${redis.pass}")
    private String redisPass;
    
    @Value("${redis.maxActive}")
    private Integer redisMaxActive;
    
    @Value("${redis.maxIdle}")
    private Integer redisMaxIdle;
    
    @Value("${redis.timeout}")
    private Integer redisTimeout;
    

    public String getIsInterceptor() {
        return isInterceptor;
    }

    public void setIsInterceptor(String isInterceptor) {
        this.isInterceptor = isInterceptor;
    }

    public Integer getExportMaxRow() {
        return exportMaxRow;
    }

    public void setExportMaxRow(Integer exportMaxRow) {
        this.exportMaxRow = exportMaxRow;
    }

	public String getRedisIp() {
		return redisIp;
	}

	public void setRedisIp(String redisIp) {
		this.redisIp = redisIp;
	}

	public Integer getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(Integer redisPort) {
		this.redisPort = redisPort;
	}

	public String getRedisPass() {
		return redisPass;
	}

	public void setRedisPass(String redisPass) {
		this.redisPass = redisPass;
	}

	public Integer getRedisMaxActive() {
		return redisMaxActive;
	}

	public void setRedisMaxActive(Integer redisMaxActive) {
		this.redisMaxActive = redisMaxActive;
	}

	public Integer getRedisMaxIdle() {
		return redisMaxIdle;
	}

	public void setRedisMaxIdle(Integer redisMaxIdle) {
		this.redisMaxIdle = redisMaxIdle;
	}

	public Integer getRedisTimeout() {
		return redisTimeout;
	}

	public void setRedisTimeout(Integer redisTimeout) {
		this.redisTimeout = redisTimeout;
	}
}
