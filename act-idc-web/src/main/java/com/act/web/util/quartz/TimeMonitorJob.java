package com.act.web.util.quartz;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import com.act.web.util.SpringContextUtil;

public class TimeMonitorJob implements Runnable{
	private Logger log = Logger.getLogger(TimeMonitorJob.class);
	@Override
	public void run() {
		try{
			Long lastSecond=0L;
			while(true){
				Long currentSeconds = System.currentTimeMillis()/1000;
				if(Math.abs(currentSeconds-lastSecond)>12 && lastSecond!=0){
					log.info("时间被修改...");
					QuartzManager.reStartJobs();
				}
				lastSecond=currentSeconds;
				Thread.sleep(10*1000);
			}
		}catch (Exception e) {
			log.error("时间监控异常", e);
		}
	}

}
