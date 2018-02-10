package com.act.web.es.type;

import java.util.Date;
/**
 * 
 * @Description 基础数据监测实体
 * @author zhufj
 * @date 2018年1月27日 上午11:47:42
 *
 */
public class IsmsmHousemonitorModel {
	private int port;//端口 【不展示】
	private Date firstfind_time;//首次发现时间 "YYYY-MM-dd HH:mm:ss"
	private String protocol; //协议
	private String useType;//登记使用方式
	private String error;//登记异常
	private Date currenttime;//当前时间
	private String currentState;//当前状态
	private String realUseType;//实际用户类型
	private long visitscount;//访问量
	private int send_flag; 
	private String regDomain;//登记域名
	private String type; //类型
	private String serviceType;//服务类型
	private String ip;//网站ip
	private String illegalType;//违法类型
	private String domain;//实际域名
	private String icperror;//备案异常
	private Date lastfind_time;//最近一次发现时间  "YYYY-MM-dd HH:mm:ss"
	private String service_code;//机房编号 【不展示】
	private String user;//用户
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Date getFirstfind_time() {
		return firstfind_time;
	}
	public void setFirstfind_time(Date firstfind_time) {
		this.firstfind_time = firstfind_time;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Date getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(Date currenttime) {
		this.currenttime = currenttime;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getRealUseType() {
		return realUseType;
	}
	public void setRealUseType(String realUseType) {
		this.realUseType = realUseType;
	}
	public long getVisitscount() {
		return visitscount;
	}
	public void setVisitscount(long visitscount) {
		this.visitscount = visitscount;
	}
	public int getSend_flag() {
		return send_flag;
	}
	public void setSend_flag(int send_flag) {
		this.send_flag = send_flag;
	}
	public String getRegDomain() {
		return regDomain;
	}
	public void setRegDomain(String regDomain) {
		this.regDomain = regDomain;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIllegalType() {
		return illegalType;
	}
	public void setIllegalType(String illegalType) {
		this.illegalType = illegalType;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getIcperror() {
		return icperror;
	}
	public void setIcperror(String icperror) {
		this.icperror = icperror;
	}
	public Date getLastfind_time() {
		return lastfind_time;
	}
	public void setLastfind_time(Date lastfind_time) {
		this.lastfind_time = lastfind_time;
	}
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
