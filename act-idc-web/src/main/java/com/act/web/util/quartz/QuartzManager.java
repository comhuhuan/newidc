package com.act.web.util.quartz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.act.web.job.TestJob;
import com.act.web.util.SpringContextUtil;


public class QuartzManager {
	private static Logger log = Logger.getLogger(QuartzManager.class);
	private static Scheduler scheduler;
	
	private static List<QuartzVo> vos=new ArrayList<QuartzVo>();
	
	public static void getInfo(Scheduler sched) throws SchedulerException{
		 log.info("### 获取所有job ###");
		 vos.clear();
		 QuartzVo vo=new QuartzVo();
		 Set<JobKey> keys=sched.getJobKeys(GroupMatcher.anyJobGroup());
		 for (JobKey jobKey : keys) {
			 vo.setJobDetail(sched.getJobDetail(jobKey));
			 CronTrigger trigger=(CronTrigger)sched.getTriggersOfJob(jobKey).get(0);
			 vo.setTriggerName(trigger.getKey().getName());
			 vo.setCron(trigger.getCronExpression());
			 log.info("添加任务："+jobKey.getName());
			 vos.add(vo);
		}
	}
    /**
     * @Description:启动所有定时任务
     * @param sched调度器
     * @Title: QuartzManager.java
     */
    public static void reStartJobs() {
        try {
        	log.info("重启所有定时任务");
        	Scheduler localQuartzScheduler=SpringContextUtil.getBean("localQuartzScheduler");
        	if(localQuartzScheduler!=null&&!localQuartzScheduler.isShutdown()){ //spring初始配置的调用任务
        		//先关闭之前的调度任务，再创建新的调用任务
        		getInfo(localQuartzScheduler);
        		localQuartzScheduler.shutdown(true);
        		localQuartzScheduler=null;
        		StdSchedulerFactory sf = new StdSchedulerFactory();
            	scheduler = sf.getScheduler();
        	}else{ //自己创建的调度任务
        		//先关闭之前的调度任务，再创建新的调用任务
        		getInfo(scheduler);
        		scheduler.shutdown(true);
        		StdSchedulerFactory sf = new StdSchedulerFactory();
            	scheduler = sf.getScheduler();
        	}
        	for (QuartzVo vo : vos) {
    	         CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(vo.getCron());
    	         // 按cronExpression表达式构建trigger
    	         CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(vo.getTriggerName(), "DEFAULT")
    	                 .withSchedule(scheduleBuilder).build();
    	         scheduler.scheduleJob(vo.getJobDetail(), trigger);
			}
	        scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
