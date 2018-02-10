package com.act.web.es.type;

import java.util.Date;
/**
 * 活跃域名
 * @author adminstrator
 *
 */
public class DomainActivelogModel {
	private String topdomainflag;
	private Date lasttime;
	private String domain_one;
	private String domain;
	private String block;
	private long visitscount;
	private String service_code;
	private long key;
	private String ip;
	private Date firsttime;
	public String getTopdomainflag() {
		return topdomainflag;
	}
	public void setTopdomainflag(String topdomainflag) {
		this.topdomainflag = topdomainflag;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	public String getDomain_one() {
		return domain_one;
	}
	public void setDomain_one(String domain_one) {
		this.domain_one = domain_one;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getFirsttime() {
		return firsttime;
	}
	public void setFirsttime(Date firsttime) {
		this.firsttime = firsttime;
	}
	
}
