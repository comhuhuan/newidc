package com.act.web.module.activelog.vo;

import java.util.Date;

public class ActiveIpLogVo {
	private String associationUserQuery;//	关联用户
	private String clickDateQuery; //所选时间
	private Date endTimeQuery;//结束时间
	private Date firstEndTimeQuery;//首次采集时间结束
	private Date firstStartTimeQuery;//首次采集时间开始
	private String ipQuery;//网站ip
	private String isHasUserQuery;//是否有关联用户【0-无关联用户，1-有关联用户】
	private String lastEndTimeQuery;//最后活跃时间结束
	private String lastStartTimeQuery;//最后活跃时间开始
	private int pageIndex;//当前页
	private int pageSize;//页大小
	private String portQuery;//应用端口
	private String protocolQuery;//传输层协议类型【1-TCP，2-UDP】
	private String serviceCodeQuery;//机房名称
	private Date startTimeQuery;//开始时间
	private String hostQuery;//域名
	private String topdomainflag;//是否是顶级域名
	
	private String associationUser;
	private String firstTime;
	private String ip;
	private String lastTime;
	private String port;
	private String protocol;
	private String serviceCode;
	private long visitCount;

	public String getTopdomainflag() {
		return topdomainflag;
	}
	public void setTopdomainflag(String topdomainflag) {
		this.topdomainflag = topdomainflag;
	}
	public String getHostQuery() {
		return hostQuery;
	}
	public void setHostQuery(String hostQuery) {
		this.hostQuery = hostQuery;
	}
	public String getAssociationUserQuery() {
		return associationUserQuery;
	}
	public void setAssociationUserQuery(String associationUserQuery) {
		this.associationUserQuery = associationUserQuery;
	}
	public String getClickDateQuery() {
		return clickDateQuery;
	}
	public void setClickDateQuery(String clickDateQuery) {
		this.clickDateQuery = clickDateQuery;
	}
	public Date getEndTimeQuery() {
		return endTimeQuery;
	}
	public void setEndTimeQuery(Date endTimeQuery) {
		this.endTimeQuery = endTimeQuery;
	}
	public Date getFirstEndTimeQuery() {
		return firstEndTimeQuery;
	}
	public void setFirstEndTimeQuery(Date firstEndTimeQuery) {
		this.firstEndTimeQuery = firstEndTimeQuery;
	}
	public Date getFirstStartTimeQuery() {
		return firstStartTimeQuery;
	}
	public void setFirstStartTimeQuery(Date firstStartTimeQuery) {
		this.firstStartTimeQuery = firstStartTimeQuery;
	}
	public String getIpQuery() {
		return ipQuery;
	}
	public void setIpQuery(String ipQuery) {
		this.ipQuery = ipQuery;
	}
	public String getIsHasUserQuery() {
		return isHasUserQuery;
	}
	public void setIsHasUserQuery(String isHasUserQuery) {
		this.isHasUserQuery = isHasUserQuery;
	}
	public String getLastEndTimeQuery() {
		return lastEndTimeQuery;
	}
	public void setLastEndTimeQuery(String lastEndTimeQuery) {
		this.lastEndTimeQuery = lastEndTimeQuery;
	}
	public String getLastStartTimeQuery() {
		return lastStartTimeQuery;
	}
	public void setLastStartTimeQuery(String lastStartTimeQuery) {
		this.lastStartTimeQuery = lastStartTimeQuery;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPortQuery() {
		return portQuery;
	}
	public void setPortQuery(String portQuery) {
		this.portQuery = portQuery;
	}
	public String getProtocolQuery() {
		return protocolQuery;
	}
	public void setProtocolQuery(String protocolQuery) {
		this.protocolQuery = protocolQuery;
	}
	public String getServiceCodeQuery() {
		return serviceCodeQuery;
	}
	public void setServiceCodeQuery(String serviceCodeQuery) {
		this.serviceCodeQuery = serviceCodeQuery;
	}
	public Date getStartTimeQuery() {
		return startTimeQuery;
	}
	public void setStartTimeQuery(Date startTimeQuery) {
		this.startTimeQuery = startTimeQuery;
	}
	public String getAssociationUser() {
		return associationUser;
	}
	public void setAssociationUser(String associationUser) {
		this.associationUser = associationUser;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public long getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(long visitCount) {
		this.visitCount = visitCount;
	}
	
}
