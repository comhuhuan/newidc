/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import java.util.Date;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>ServiceRoomVo</code> 机房vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class ServiceRoomVo extends BaseVo {
	private String serviceCode;
	private String idcid;
	private String sourceCode;
	private String webstatus;
	private String serviceName;
	private String housetype;
	private String houseofficer;
	private String areaCode;
	private String commCode;
	private String parentCommCode;
	private String address;
	private String zip;
	private String principal;
	private String principalTel;
	private String unitNatureCode;
	private String safetyman;
	private String safetymanTel;
	private String safetymanEmail;
	private String ispCode;
	private Byte serviceState;
	private int terminalNumber;
	private int serverNumber;
	private String accessModeCode;
	private int practitionerNumber;
	private String netMonitorDepartment;
	private String netMonitorMan;
	private String netMonitorManTel;
	private int punishmentResut;
	private Byte serviceKind;
	private Date createTime;
	private String remark;
	private Byte sendFlag;
	private String monstatus;
	private boolean ftpstatus;
	private boolean checkdata;
	private boolean baStatus;
	private int consArea;
	private String houseId;
	private String deploySiteName;
	private String excstate;
	private Date exctime;
	private String ip;
	private String ipRange;
	private String msg;
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getIdcid() {
		return idcid;
	}
	public void setIdcid(String idcid) {
		this.idcid = idcid;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getWebstatus() {
		return webstatus;
	}
	public void setWebstatus(String webstatus) {
		this.webstatus = webstatus;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	public String getHouseofficer() {
		return houseofficer;
	}
	public void setHouseofficer(String houseofficer) {
		this.houseofficer = houseofficer;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getCommCode() {
		return commCode;
	}
	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}
	public String getParentCommCode() {
		return parentCommCode;
	}
	public void setParentCommCode(String parentCommCode) {
		this.parentCommCode = parentCommCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getPrincipalTel() {
		return principalTel;
	}
	public void setPrincipalTel(String principalTel) {
		this.principalTel = principalTel;
	}
	public String getUnitNatureCode() {
		return unitNatureCode;
	}
	public void setUnitNatureCode(String unitNatureCode) {
		this.unitNatureCode = unitNatureCode;
	}
	public String getSafetyman() {
		return safetyman;
	}
	public void setSafetyman(String safetyman) {
		this.safetyman = safetyman;
	}
	public String getSafetymanTel() {
		return safetymanTel;
	}
	public void setSafetymanTel(String safetymanTel) {
		this.safetymanTel = safetymanTel;
	}
	public String getSafetymanEmail() {
		return safetymanEmail;
	}
	public void setSafetymanEmail(String safetymanEmail) {
		this.safetymanEmail = safetymanEmail;
	}
	public String getIspCode() {
		return ispCode;
	}
	public void setIspCode(String ispCode) {
		this.ispCode = ispCode;
	}
	public Byte getServiceState() {
		return serviceState;
	}
	public void setServiceState(Byte serviceState) {
		this.serviceState = serviceState;
	}
	public int getTerminalNumber() {
		return terminalNumber;
	}
	public void setTerminalNumber(int terminalNumber) {
		this.terminalNumber = terminalNumber;
	}
	public int getServerNumber() {
		return serverNumber;
	}
	public void setServerNumber(int serverNumber) {
		this.serverNumber = serverNumber;
	}
	public String getAccessModeCode() {
		return accessModeCode;
	}
	public void setAccessModeCode(String accessModeCode) {
		this.accessModeCode = accessModeCode;
	}
	public int getPractitionerNumber() {
		return practitionerNumber;
	}
	public void setPractitionerNumber(int practitionerNumber) {
		this.practitionerNumber = practitionerNumber;
	}
	public String getNetMonitorDepartment() {
		return netMonitorDepartment;
	}
	public void setNetMonitorDepartment(String netMonitorDepartment) {
		this.netMonitorDepartment = netMonitorDepartment;
	}
	public String getNetMonitorMan() {
		return netMonitorMan;
	}
	public void setNetMonitorMan(String netMonitorMan) {
		this.netMonitorMan = netMonitorMan;
	}
	public String getNetMonitorManTel() {
		return netMonitorManTel;
	}
	public void setNetMonitorManTel(String netMonitorManTel) {
		this.netMonitorManTel = netMonitorManTel;
	}
	public int getPunishmentResut() {
		return punishmentResut;
	}
	public void setPunishmentResut(int punishmentResut) {
		this.punishmentResut = punishmentResut;
	}
	public Byte getServiceKind() {
		return serviceKind;
	}
	public void setServiceKind(Byte serviceKind) {
		this.serviceKind = serviceKind;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Byte getSendFlag() {
		return sendFlag;
	}
	public void setSendFlag(Byte sendFlag) {
		this.sendFlag = sendFlag;
	}
	public String getMonstatus() {
		return monstatus;
	}
	public void setMonstatus(String monstatus) {
		this.monstatus = monstatus;
	}
	public boolean isFtpstatus() {
		return ftpstatus;
	}
	public void setFtpstatus(boolean ftpstatus) {
		this.ftpstatus = ftpstatus;
	}
	public boolean isCheckdata() {
		return checkdata;
	}
	public void setCheckdata(boolean checkdata) {
		this.checkdata = checkdata;
	}
	public boolean isBaStatus() {
		return baStatus;
	}
	public void setBaStatus(boolean baStatus) {
		this.baStatus = baStatus;
	}
	public int getConsArea() {
		return consArea;
	}
	public void setConsArea(int consArea) {
		this.consArea = consArea;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getDeploySiteName() {
		return deploySiteName;
	}
	public void setDeploySiteName(String deploySiteName) {
		this.deploySiteName = deploySiteName;
	}
	public String getExcstate() {
		return excstate;
	}
	public void setExcstate(String excstate) {
		this.excstate = excstate;
	}
	public Date getExctime() {
		return exctime;
	}
	public void setExctime(Date exctime) {
		this.exctime = exctime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIpRange() {
		return ipRange;
	}
	public void setIpRange(String ipRange) {
		this.ipRange = ipRange;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
