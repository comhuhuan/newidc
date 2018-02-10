package com.act.web.es.type;

import java.util.Date;
/**
 * 违法违规网站日志
 * @author adminstrator
 *
 */
public class BlackcmdLogModel {
	private int port;
	private Date firstfound;
	private String protocol;
	private String operationAccount;
	private String domain_one;
	private String block;
	private long visitscount;
	private Date lastfound;
	private String illegaltype;
	private String serviceContent;
	private String ip;
	private String idcid;
	private String domain;
	private String scheme_id;
	private String service_code;
	private long key;
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Date getFirstfound() {
		return firstfound;
	}
	public void setFirstfound(Date firstfound) {
		this.firstfound = firstfound;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getOperationAccount() {
		return operationAccount;
	}
	public void setOperationAccount(String operationAccount) {
		this.operationAccount = operationAccount;
	}
	public String getDomain_one() {
		return domain_one;
	}
	public void setDomain_one(String domain_one) {
		this.domain_one = domain_one;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public long getVisitscount() {
		return visitscount;
	}
	public void setVisitscount(long visitscount) {
		this.visitscount = visitscount;
	}
	public Date getLastfound() {
		return lastfound;
	}
	public void setLastfound(Date lastfound) {
		this.lastfound = lastfound;
	}
	public String getIllegaltype() {
		return illegaltype;
	}
	public void setIllegaltype(String illegaltype) {
		this.illegaltype = illegaltype;
	}
	public String getServiceContent() {
		return serviceContent;
	}
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIdcid() {
		return idcid;
	}
	public void setIdcid(String idcid) {
		this.idcid = idcid;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getScheme_id() {
		return scheme_id;
	}
	public void setScheme_id(String scheme_id) {
		this.scheme_id = scheme_id;
	}
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	
}
