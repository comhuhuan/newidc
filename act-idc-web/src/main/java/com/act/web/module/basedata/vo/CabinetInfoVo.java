/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>CabinetInfoVo</code> 机柜vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class CabinetInfoVo extends BaseVo {
	private int cabid;
	private String serviceCode;
	private String cabcode;
	private String cabname;
	private String cabremark;
	private String cablocation;
	private int roomid;
	private int units;
	private int custid;
	private String model;
	private String assignStatus;
	private String usetype;
	private Byte positionNum;
	private String status;
	private String orderid;
	private Byte sendFlag;
	private boolean ftpstatus;
	private boolean ismstip;
	public int getCabid() {
		return cabid;
	}
	public void setCabid(int cabid) {
		this.cabid = cabid;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getCabcode() {
		return cabcode;
	}
	public void setCabcode(String cabcode) {
		this.cabcode = cabcode;
	}
	public String getCabname() {
		return cabname;
	}
	public void setCabname(String cabname) {
		this.cabname = cabname;
	}
	public String getCabremark() {
		return cabremark;
	}
	public void setCabremark(String cabremark) {
		this.cabremark = cabremark;
	}
	public String getCablocation() {
		return cablocation;
	}
	public void setCablocation(String cablocation) {
		this.cablocation = cablocation;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getAssignStatus() {
		return assignStatus;
	}
	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}
	public String getUsetype() {
		return usetype;
	}
	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}
	public Byte getPositionNum() {
		return positionNum;
	}
	public void setPositionNum(Byte positionNum) {
		this.positionNum = positionNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public boolean isIsmstip() {
		return ismstip;
	}
	public void setIsmstip(boolean ismstip) {
		this.ismstip = ismstip;
	}
		
}
