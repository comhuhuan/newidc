package com.act.web.util.quartz;

import org.quartz.JobDetail;
import org.quartz.Trigger;

public class QuartzVo {
	private JobDetail jobDetail;
	private String triggerName;
	private String cron;
	public JobDetail getJobDetail() {
		return jobDetail;
	}
	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
}
