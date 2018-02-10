package com.act.web.module.securitylog.vo;

import java.util.Date;

/**
 * 基础数据异常监测Vo
 * @author adminstrator
 *
 */
public class BaseDataMonitorVo {
	//作查询用
	private String currentStateQuery;//当前状态【1-已封堵，0-未封堵】
	private String domainQuery;//域名
	private String errorQuery;//登记异常【0-正常，1-IP登记保留，实际为启用，2-IP登记域名有误，3-IP未登记】
	private String ipQuery;//IP
	private String notPutOnRecordsQuery;//备案异常【0-正常,1-未备案】
	private int pageIndex;//当前页
	private int pageSize;//页大小
	private int serviceCodeQuery;//服务代码
	private Date firstFindTimeQuery;//首次发现时间
	private int portQuery;//端口
	private String statusQuery;//状态
	
	//作返回实体用
	private String  domain; //实际域名
	private String error;//登记异常
	private Date firstfindTime;//首次发现时间 "YYYY-MM-dd HH:mm:ss"
	private String icperror;//备案异常
	private String  ip;//网站ip
	private Date  lastfindTime;//最近一次发现时间  "YYYY-MM-dd HH:mm:ss"
	private long port;//端口 【不展示】
	private String  realUseType;//实际使用方式
	private String regDomain;//登记域名
	private String  serviceCode;//机房编号 【不展示】
	private String  serviceName;//机房名称
	private String state;//状态 【1-已封堵，0-未封堵】
	private String useType;//登记使用方式

	
	public Date getFirstFindTimeQuery() {
		return firstFindTimeQuery;
	}
	public void setFirstFindTimeQuery(Date firstFindTimeQuery) {
		this.firstFindTimeQuery = firstFindTimeQuery;
	}
	public int getPortQuery() {
		return portQuery;
	}
	public void setPortQuery(int portQuery) {
		this.portQuery = portQuery;
	}
	public String getStatusQuery() {
		return statusQuery;
	}
	public void setStatusQuery(String statusQuery) {
		this.statusQuery = statusQuery;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Date getFirstfindTime() {
		return firstfindTime;
	}
	public void setFirstfindTime(Date firstfindTime) {
		this.firstfindTime = firstfindTime;
	}
	public String getIcperror() {
		return icperror;
	}
	public void setIcperror(String icperror) {
		this.icperror = icperror;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLastfindTime() {
		return lastfindTime;
	}
	public void setLastfindTime(Date lastfindTime) {
		this.lastfindTime = lastfindTime;
	}
	public long getPort() {
		return port;
	}
	public void setPort(long port) {
		this.port = port;
	}
	public String getRealUseType() {
		return realUseType;
	}
	public void setRealUseType(String realUseType) {
		this.realUseType = realUseType;
	}
	public String getRegDomain() {
		return regDomain;
	}
	public void setRegDomain(String regDomain) {
		this.regDomain = regDomain;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getCurrentStateQuery() {
		return currentStateQuery;
	}
	public void setCurrentStateQuery(String currentStateQuery) {
		this.currentStateQuery = currentStateQuery;
	}
	public String getDomainQuery() {
		return domainQuery;
	}
	public void setDomainQuery(String domainQuery) {
		this.domainQuery = domainQuery;
	}
	public String getErrorQuery() {
		return errorQuery;
	}
	public void setErrorQuery(String errorQuery) {
		this.errorQuery = errorQuery;
	}
	public String getIpQuery() {
		return ipQuery;
	}
	public void setIpQuery(String ipQuery) {
		this.ipQuery = ipQuery;
	}
	public String getNotPutOnRecordsQuery() {
		return notPutOnRecordsQuery;
	}
	public void setNotPutOnRecordsQuery(String notPutOnRecordsQuery) {
		this.notPutOnRecordsQuery = notPutOnRecordsQuery;
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
}
