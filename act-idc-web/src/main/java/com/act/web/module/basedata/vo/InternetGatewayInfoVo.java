/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>InternetGatewayInfoVo</code> 互联网出入口信息vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class InternetGatewayInfoVo extends BaseVo {

	private int gatewayid;
	private String serviceCode;
	private String bandwidth;
	private Byte linktype;
	private String accessunit;
	private String gatewayip;
	private boolean ftpstatus;
	
	private String gatewayipQuery;
	public int getGatewayid() {
		return gatewayid;
	}
	public void setGatewayid(int gatewayid) {
		this.gatewayid = gatewayid;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}
	public Byte getLinktype() {
		return linktype;
	}
	public void setLinktype(Byte linktype) {
		this.linktype = linktype;
	}
	public String getAccessunit() {
		return accessunit;
	}
	public void setAccessunit(String accessunit) {
		this.accessunit = accessunit;
	}
	public String getGatewayip() {
		return gatewayip;
	}
	public void setGatewayip(String gatewayip) {
		this.gatewayip = gatewayip;
	}
	public boolean isFtpstatus() {
		return ftpstatus;
	}
	public void setFtpstatus(boolean ftpstatus) {
		this.ftpstatus = ftpstatus;
	}
	public String getGatewayipQuery() {
		return gatewayipQuery;
	}
	public void setGatewayipQuery(String gatewayipQuery) {
		this.gatewayipQuery = gatewayipQuery;
	}
		
}
