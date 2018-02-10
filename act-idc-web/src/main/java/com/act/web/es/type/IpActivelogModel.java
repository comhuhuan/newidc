package com.act.web.es.type;

import java.util.Date;
/**
 * IP活跃域名
 * @author adminstrator
 *
 */
public class IpActivelogModel {
	private String speciallineip;
	private int port;
	private String protocol;
	private Date lasttime;
	private String block;
	private long visitscount;
	private String service_code;
	private String isinipseg;
	private long key;
	private String ip;
	private Date firsttime;
	public String getSpeciallineip() {
		return speciallineip;
	}
	public void setSpeciallineip(String speciallineip) {
		this.speciallineip = speciallineip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
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
	public String getIsinipseg() {
		return isinipseg;
	}
	public void setIsinipseg(String isinipseg) {
		this.isinipseg = isinipseg;
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
