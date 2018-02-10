package com.act.web.module.activelog.vo;

import java.util.Date;
/**
 * 
 * 
 * <p>Title: ActiveDoaminLogVo.java
 * <p>Description: 活跃域名
 * @author zhufj
 * @date 2018年2月5日 下午7:50:16
 */
public class ActiveDoaminLogVo {
	private String associationUserQuery;//关联用户
	private Date endTimeQuery;//结束时间
	private Date firstEndTimeQuery;//首次结束时间
	private Date firstStartTimeQuery;//首次采集时间开始
	private String hostQuery;//域名
	private String ipQuery;//网站IP
	private String isHasUserQuery;//是否有关联用户
	private Date lastEndTimeQuery;//最后活跃时间结束
	private Date lastStartTimeQuery;//最后活跃时间开始
	private int pageIndex;//当前页
	private int pageSize;//页大小
	private String serviceCodeQuery;//机房编号
	private String topDomainFlagQuery;//是否顶级域名
	private Date startTimeQuery;//开始时间
	
	private String associationUser;//关联用户
	private String domain;//域名
	private Date firstTime;//首次采集时间
	private String ip;//IP
	private Date lastTime;//最近一次采集时间
	private String serviceName;//机房名称
	private int visitCount;//访问量
	public String getAssociationUserQuery() {
		return associationUserQuery;
	}
	public void setAssociationUserQuery(String associationUserQuery) {
		this.associationUserQuery = associationUserQuery;
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
	public String getHostQuery() {
		return hostQuery;
	}
	public void setHostQuery(String hostQuery) {
		this.hostQuery = hostQuery;
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
	public Date getLastEndTimeQuery() {
		return lastEndTimeQuery;
	}
	public void setLastEndTimeQuery(Date lastEndTimeQuery) {
		this.lastEndTimeQuery = lastEndTimeQuery;
	}
	public Date getLastStartTimeQuery() {
		return lastStartTimeQuery;
	}
	public void setLastStartTimeQuery(Date lastStartTimeQuery) {
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
	public String getServiceCodeQuery() {
		return serviceCodeQuery;
	}
	public void setServiceCodeQuery(String serviceCodeQuery) {
		this.serviceCodeQuery = serviceCodeQuery;
	}
	public String getTopDomainFlagQuery() {
		return topDomainFlagQuery;
	}
	public void setTopDomainFlagQuery(String topDomainFlagQuery) {
		this.topDomainFlagQuery = topDomainFlagQuery;
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
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	
	
}
