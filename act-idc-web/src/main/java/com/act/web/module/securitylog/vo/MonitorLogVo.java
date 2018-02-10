package com.act.web.module.securitylog.vo;

import java.util.Date;
/**
 * 
 * <p>Title: MonitorLogVo.java
 * <p>Description:监控日志vo
 * @author zhufj
 * @date 2018年2月2日 下午2:31:12
 */
public class MonitorLogVo {
	//查询所用
	private String hostQuery;//域名
	private String isStopQuery;//封堵状态[1-封堵，2-未封堵]
	private String keyWordQuery;//报警信息
	private String midQuery;//目的IP
	private String outIpQuery;//outIpQuery
	private int pageIndex;//当前页
	private int pageSize;//页大小
	private String ruleIdQuery;//策略ID
	private String selectTimeQuery;//所选时间
	private String serviceCodeQuery;//机房名称
	private String startTimeQuery;//开始时间
	private String endTimeQuery;//结束时间
	private String urlQuery;//	网址
	private String timerangeValQuery;//
	private String encodedQuery;//编码查询
	private String tableNameQuery;//表名参数
	private String ruleIdentifierQuery;//策略id
	
	private boolean hasSelectTime;//是否已经选择时间段了
	private String attUrl;//网址属性
	private BlockButton block;//封堵按钮
	private String blockReason;//报警信息
	private Date curTime;//报警时间
	private String inIp;//目的ip
	private String host;//域名
	private String inPort;//目的端口
	private Byte isstop;//url封堵状态【0-等待封堵 1-取消封堵 2-正在封堵 3-正在取消】
	private String md5Url;//加密的url
	private String outIp;//源ip
	private String ruleIdentifier;//策略ID
	private String serviceCode;//机房编号
	private String serviceName;//机房名称
	private String tableName;//报警原因
	private String url;//网址
	private String accountId;// 登录的账号
	private String ipv4ToIpv6Set;//ipv4转ipv6
	private String encoded;//编码
	
	public String getRuleIdentifierQuery() {
		return ruleIdentifierQuery;
	}
	public void setRuleIdentifierQuery(String ruleIdentifierQuery) {
		this.ruleIdentifierQuery = ruleIdentifierQuery;
	}
	public String getTableNameQuery() {
		return tableNameQuery;
	}
	public void setTableNameQuery(String tableNameQuery) {
		this.tableNameQuery = tableNameQuery;
	}
	public String getEncodedQuery() {
		return encodedQuery;
	}
	public void setEncodedQuery(String encodedQuery) {
		this.encodedQuery = encodedQuery;
	}
	public String getEncoded() {
		return encoded;
	}
	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}
	public boolean getHasSelectTime() {
		return hasSelectTime;
	}
	public void setHasSelectTime(boolean hasSelectTime) {
		this.hasSelectTime = hasSelectTime;
	}
	public String getTimerangeValQuery() {
		return timerangeValQuery;
	}
	public void setTimerangeValQuery(String timerangeValQuery) {
		this.timerangeValQuery = timerangeValQuery;
	}
	public String getIpv4ToIpv6Set() {
		return ipv4ToIpv6Set;
	}
	public void setIpv4ToIpv6Set(String ipv4ToIpv6Set) {
		this.ipv4ToIpv6Set = ipv4ToIpv6Set;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAttUrl() {
		return attUrl;
	}
	public void setAttUrl(String attUrl) {
		this.attUrl = attUrl;
	}
	public BlockButton getBlock() {
		return block;
	}
	public void setBlock(BlockButton block) {
		this.block = block;
	}
	public String getBlockReason() {
		return blockReason;
	}
	public void setBlockReason(String blockReason) {
		this.blockReason = blockReason;
	}
	public Date getCurTime() {
		return curTime;
	}
	public void setCurTime(Date curTime) {
		this.curTime = curTime;
	}
	public String getInIp() {
		return inIp;
	}
	public void setInIp(String inIp) {
		this.inIp = inIp;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getInPort() {
		return inPort;
	}
	public void setInPort(String inPort) {
		this.inPort = inPort;
	}
	public Byte getIsstop() {
		return isstop;
	}
	public void setIsstop(Byte isstop) {
		this.isstop = isstop;
	}
	public String getMd5Url() {
		return md5Url;
	}
	public void setMd5Url(String md5Url) {
		this.md5Url = md5Url;
	}
	public String getOutIp() {
		return outIp;
	}
	public void setOutIp(String outIp) {
		this.outIp = outIp;
	}
	public String getRuleIdentifier() {
		return ruleIdentifier;
	}
	public void setRuleIdentifier(String ruleIdentifier) {
		this.ruleIdentifier = ruleIdentifier;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHostQuery() {
		return hostQuery;
	}
	public void setHostQuery(String hostQuery) {
		this.hostQuery = hostQuery;
	}
	public String getIsStopQuery() {
		return isStopQuery;
	}
	public void setIsStopQuery(String isStopQuery) {
		this.isStopQuery = isStopQuery;
	}
	public String getKeyWordQuery() {
		return keyWordQuery;
	}
	public void setKeyWordQuery(String keyWordQuery) {
		this.keyWordQuery = keyWordQuery;
	}
	public String getMidQuery() {
		return midQuery;
	}
	public void setMidQuery(String midQuery) {
		this.midQuery = midQuery;
	}
	public String getOutIpQuery() {
		return outIpQuery;
	}
	public void setOutIpQuery(String outIpQuery) {
		this.outIpQuery = outIpQuery;
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
	public String getRuleIdQuery() {
		return ruleIdQuery;
	}
	public void setRuleIdQuery(String ruleIdQuery) {
		this.ruleIdQuery = ruleIdQuery;
	}
	public String getSelectTimeQuery() {
		return selectTimeQuery;
	}
	public void setSelectTimeQuery(String selectTimeQuery) {
		this.selectTimeQuery = selectTimeQuery;
	}
	public String getServiceCodeQuery() {
		return serviceCodeQuery;
	}
	public void setServiceCodeQuery(String serviceCodeQuery) {
		this.serviceCodeQuery = serviceCodeQuery;
	}
	public String getStartTimeQuery() {
		return startTimeQuery;
	}
	public String getEndTimeQuery() {
		return endTimeQuery;
	}
	public void setEndTimeQuery(String endTimeQuery) {
		this.endTimeQuery = endTimeQuery;
	}
	public void setStartTimeQuery(String startTimeQuery) {
		this.startTimeQuery = startTimeQuery;
	}
	public String getUrlQuery() {
		return urlQuery;
	}
	public void setUrlQuery(String urlQuery) {
		this.urlQuery = urlQuery;
	}
}
