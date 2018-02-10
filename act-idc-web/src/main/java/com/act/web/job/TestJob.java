/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.job;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * The <code>TestJob</code>
 * 定时任务样例演示
 *
 * @author FMJ
 * @since v2.0
 */
public class TestJob extends QuartzJobBean {

    private final Logger log = LoggerFactory.getLogger(TestJob.class);

    /**
     * 定时任务样例演示
     *
     * @param context
     */
    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("定时任务样例日志打印...");
    }
}
