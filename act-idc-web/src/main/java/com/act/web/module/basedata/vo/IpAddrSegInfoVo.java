/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import java.util.Date;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>IpAddrSegInfoVo</code> ip地址段信息vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class IpAddrSegInfoVo extends BaseVo {
	private int ipid;
	private String serviceCode;
	private String startip;
	private String endip;
	private String pstartip;
	private String pendip;
	private String type;
	private String user;
	private String idtype;
	private String idnumber;
	private String sourceunit;
	private String allocationu;
	private Date usetime;
	private String usertype;
	private boolean ftpstatus;
	private Integer serverid;

	private String ipAddrQuery;

	public int getIpid() {
		return ipid;
	}

	public void setIpid(int ipid) {
		this.ipid = ipid;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getStartip() {
		return startip;
	}

	public void setStartip(String startip) {
		this.startip = startip;
	}

	public String getEndip() {
		return endip;
	}

	public void setEndip(String endip) {
		this.endip = endip;
	}

	public String getPstartip() {
		return pstartip;
	}

	public void setPstartip(String pstartip) {
		this.pstartip = pstartip;
	}

	public String getPendip() {
		return pendip;
	}

	public void setPendip(String pendip) {
		this.pendip = pendip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getSourceunit() {
		return sourceunit;
	}

	public void setSourceunit(String sourceunit) {
		this.sourceunit = sourceunit;
	}

	public String getAllocationu() {
		return allocationu;
	}

	public void setAllocationu(String allocationu) {
		this.allocationu = allocationu;
	}

	public Date getUsetime() {
		return usetime;
	}

	public void setUsetime(Date usetime) {
		this.usetime = usetime;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public boolean isFtpstatus() {
		return ftpstatus;
	}

	public void setFtpstatus(boolean ftpstatus) {
		this.ftpstatus = ftpstatus;
	}

	public Integer getServerid() {
		return serverid;
	}

	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}

	public String getIpAddrQuery() {
		return ipAddrQuery;
	}

	public void setIpAddrQuery(String ipAddrQuery) {
		this.ipAddrQuery = ipAddrQuery;
	}

}
