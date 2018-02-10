package com.act.web.util.quartz;

import javax.servlet.http.HttpServlet;
import org.apache.log4j.Logger;



/**
 * 随tomcat启动而启动，开启时间监控线程，目的为了发现时间变化，则重启所有定时任务
 * 解决系统时间前调，定时任务不运行的问题
 * @author han
 *
 */
public class TimeMonitorServlet  extends HttpServlet {
	private Logger log = Logger.getLogger(TimeMonitorServlet.class);
	
	@Override
	public void init() {
		Thread thread=new Thread(new TimeMonitorJob());
		thread.start();
	}
	
	public static void main(String[] args) {
		TimeMonitorServlet monitorServlet=new TimeMonitorServlet();
		monitorServlet.init();
	}
	
}
