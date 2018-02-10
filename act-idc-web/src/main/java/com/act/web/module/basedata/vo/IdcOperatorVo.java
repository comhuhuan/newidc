/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import java.util.Date;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>IdcOperatorVo</code> Idc经营者管理vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class IdcOperatorVo extends BaseVo {
	//TODO
	private String idcidQuery;
	private String idcnameQuery;
	private String corpQuery;
	private String ftpstatusQuery;
	private String idcid;
	private String idcname;
	private String idcadd;
	private String idczip;
	private String corp;
	private String idcofficer;
	private String emergencycontact;
	private Date timestamp;
	private Byte sendFlag;
	private boolean ftpstatus;
	
	public String getIdcid() {
		return idcid;
	}

	public void setIdcid(String idcid) {
		this.idcid = idcid;
	}

	public String getIdcname() {
		return idcname;
	}

	public void setIdcname(String idcname) {
		this.idcname = idcname;
	}

	public String getIdcadd() {
		return idcadd;
	}

	public void setIdcadd(String idcadd) {
		this.idcadd = idcadd;
	}

	public String getIdczip() {
		return idczip;
	}

	public void setIdczip(String idczip) {
		this.idczip = idczip;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public String getIdcofficer() {
		return idcofficer;
	}

	public void setIdcofficer(String idcofficer) {
		this.idcofficer = idcofficer;
	}

	public String getEmergencycontact() {
		return emergencycontact;
	}

	public void setEmergencycontact(String emergencycontact) {
		this.emergencycontact = emergencycontact;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Byte getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(Byte sendFlag) {
		this.sendFlag = sendFlag;
	}

	public boolean isFtpstatus() {
		return ftpstatus;
	}

	public void setFtpstatus(boolean ftpstatus) {
		this.ftpstatus = ftpstatus;
	}

	public String getIdcidQuery() {
		return idcidQuery;
	}

	public void setIdcidQuery(String idcidQuery) {
		this.idcidQuery = idcidQuery;
	}

	public String getIdcnameQuery() {
		return idcnameQuery;
	}

	public void setIdcnameQuery(String idcnameQuery) {
		this.idcnameQuery = idcnameQuery;
	}

	public String getCorpQuery() {
		return corpQuery;
	}

	public void setCorpQuery(String corpQuery) {
		this.corpQuery = corpQuery;
	}

	public String getFtpstatusQuery() {
		return ftpstatusQuery;
	}

	public void setFtpstatusQuery(String ftpstatusQuery) {
		this.ftpstatusQuery = ftpstatusQuery;
	}

}
