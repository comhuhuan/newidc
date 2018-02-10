package com.act.web.module.securitylog.vo;
/**
 * 
 * 
 * <p>Title: FilterLogVo.java
 * <p>Description:监控日志vo
 * @author zhufj
 * @date 2018年2月5日 下午2:06:35
 */
public class FilterLogVo {
	private String hostQuery;//域名
	private String encodedQuery;//编码
	private String tableNameQuery;//表名
	private String ruleIdentifierQuery;//策略id
	private String selectTimeQuery;//所选时间
	private String startTimeQuery;//开始时间
	private String endTimeQuery;//结束时间
	private String timerangeValQuery;
	private String urlQuery;//网址查询
	private String midQuery;
	private String outIpQuery;
	private String serviceCodeQuery;//机房编号
	private String keyWordQuery;//关键字
	private String ruleIdQuery;//
	private String isStopQuery;//封堵状态
	private String schemeIdQuery;//策略id
	private int pageIndex;//当前页
	private int pageSize;//页大小
	
	
	private boolean hasSelectTime;//是否已选时间
	private String accountId;
	private String ipv4ToIpv6Set;
	private String serviceName;
	private String userId;
	private String uType;
	private String content;
	private String stopSign;
	private String userIp;
	private String curTime;
	private String localIp;
	private String localMac;
	private String localMachine;
	
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStopSign() {
		return stopSign;
	}
	public void setStopSign(String stopSign) {
		this.stopSign = stopSign;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getCurTime() {
		return curTime;
	}
	public void setCurTime(String curTime) {
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
	public String getSchemeIdQuery() {
		return schemeIdQuery;
	}
	public void setSchemeIdQuery(String schemeIdQuery) {
		this.schemeIdQuery = schemeIdQuery;
	}
	public String getOutIpQuery() {
		return outIpQuery;
	}
	public void setOutIpQuery(String outIpQuery) {
		this.outIpQuery = outIpQuery;
	}
	public String getServiceCodeQuery() {
		return serviceCodeQuery;
	}
	public void setServiceCodeQuery(String serviceCodeQuery) {
		this.serviceCodeQuery = serviceCodeQuery;
	}
	public String getKeyWordQuery() {
		return keyWordQuery;
	}
	public void setKeyWordQuery(String keyWordQuery) {
		this.keyWordQuery = keyWordQuery;
	}
	public String getRuleIdQuery() {
		return ruleIdQuery;
	}
	public void setRuleIdQuery(String ruleIdQuery) {
		this.ruleIdQuery = ruleIdQuery;
	}
	public String getIsStopQuery() {
		return isStopQuery;
	}
	public void setIsStopQuery(String isStopQuery) {
		this.isStopQuery = isStopQuery;
	}
	public String getUrlQuery() {
		return urlQuery;
	}
	public void setUrlQuery(String urlQuery) {
		this.urlQuery = urlQuery;
	}
	public String getMidQuery() {
		return midQuery;
	}
	public void setMidQuery(String midQuery) {
		this.midQuery = midQuery;
	}
	public String getTimerangeValQuery() {
		return timerangeValQuery;
	}
	public void setTimerangeValQuery(String timerangeValQuery) {
		this.timerangeValQuery = timerangeValQuery;
	}
	public String getHostQuery() {
		return hostQuery;
	}
	public void setHostQuery(String hostQuery) {
		this.hostQuery = hostQuery;
	}
	public String getEncodedQuery() {
		return encodedQuery;
	}
	public void setEncodedQuery(String encodedQuery) {
		this.encodedQuery = encodedQuery;
	}
	public String getTableNameQuery() {
		return tableNameQuery;
	}
	public void setTableNameQuery(String tableNameQuery) {
		this.tableNameQuery = tableNameQuery;
	}
	public String getRuleIdentifierQuery() {
		return ruleIdentifierQuery;
	}
	public void setRuleIdentifierQuery(String ruleIdentifierQuery) {
		this.ruleIdentifierQuery = ruleIdentifierQuery;
	}
	public String getSelectTimeQuery() {
		return selectTimeQuery;
	}
	public void setSelectTimeQuery(String selectTimeQuery) {
		this.selectTimeQuery = selectTimeQuery;
	}
	public String getStartTimeQuery() {
		return startTimeQuery;
	}
	public void setStartTimeQuery(String startTimeQuery) {
		this.startTimeQuery = startTimeQuery;
	}
	public String getEndTimeQuery() {
		return endTimeQuery;
	}
	public void setEndTimeQuery(String endTimeQuery) {
		this.endTimeQuery = endTimeQuery;
	}
	public boolean getHasSelectTime() {
		return hasSelectTime;
	}
	public void setHasSelectTime(boolean hasSelectTime) {
		this.hasSelectTime = hasSelectTime;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getIpv4ToIpv6Set() {
		return ipv4ToIpv6Set;
	}
	public void setIpv4ToIpv6Set(String ipv4ToIpv6Set) {
		this.ipv4ToIpv6Set = ipv4ToIpv6Set;
	}

}
