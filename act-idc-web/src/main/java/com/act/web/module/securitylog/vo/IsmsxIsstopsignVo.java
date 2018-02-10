package com.act.web.module.securitylog.vo;

import java.util.Date;
/**
 * 
 * @Description 封堵操作信息记录Vo
 * @author zhufj
 * @date 2018年1月30日 上午9:53:45
 *
 */
public class IsmsxIsstopsignVo {
	//作查询用
	private String domainQuery;//域名
	private String subType;//操作类型【 1-一级域名操作； 2-二级域名操作； 3-IP(ip段)操作； 4-URL地址； 5-协议； 6-端口(段)； 7ip+port； 8-domain+ip； 9-domain+port】
	private int pageIndex;//当前页
	private int pageSize;//页大小
	private int serviceCodeQuery;//服务代码
	
	private String content;//操作的具体内容
	private Date curTime;//操作时间
	private String localIp;//私网IP
	private String localMac;//私网MAC
	private String localMachine;//私网机器名
	private String serviceName;//机房名称
	private String stopSign;//封堵
	private String uType;//操作类型
	private String userId;//操作用户ID号
	private String userIp;//操作用户的IP地址
	
	public String getDomainQuery() {
		return domainQuery;
	}
	public void setDomainQuery(String domainQuery) {
		this.domainQuery = domainQuery;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
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
	public int getServiceCodeQuery() {
		return serviceCodeQuery;
	}
	public void setServiceCodeQuery(int serviceCodeQuery) {
		this.serviceCodeQuery = serviceCodeQuery;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCurTime() {
		return curTime;
	}
	public void setCurTime(Date curTime) {
		this.curTime = curTime;
	}
	public String getLocalIp() {
		return localIp;
	}
	public void setLocalIp(String localIp) {
		this.localIp = localIp;
	}
	public String getLocalMac() {
		return localMac;
	}
	public void setLocalMac(String localMac) {
		this.localMac = localMac;
	}
	public String getLocalMachine() {
		return localMachine;
	}
	public void setLocalMachine(String localMachine) {
		this.localMachine = localMachine;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getStopSign() {
		return stopSign;
	}
	public void setStopSign(String stopSign) {
		this.stopSign = stopSign;
	}
	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
}
