/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>ServiceAreaVo</code> 机房区域vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class ServiceAreaVo extends BaseVo {

	private int roomid;
	private String serviceCode;
	private String roomcode;
	private String roomname;
	private String areaCode;
	private String contact;
	private String tel;
	private String mobile;
	private String qqmsn;
	private String email;
	private int consArea;
	private String floorid;
	private String framex;
	private String framey;
	private String remark;
	private Byte sendFlag;
	private boolean ftpstatus;
	private boolean ismstip;
	
	private String roomcodeQuery;
	private String roomnameQuery;
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQqmsn() {
		return qqmsn;
	}
	public void setQqmsn(String qqmsn) {
		this.qqmsn = qqmsn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getConsArea() {
		return consArea;
	}
	public void setConsArea(int consArea) {
		this.consArea = consArea;
	}
	public String getFloorid() {
		return floorid;
	}
	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}
	public String getFramex() {
		return framex;
	}
	public void setFramex(String framex) {
		this.framex = framex;
	}
	public String getFramey() {
		return framey;
	}
	public void setFramey(String framey) {
		this.framey = framey;
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
	public String getRoomcodeQuery() {
		return roomcodeQuery;
	}
	public void setRoomcodeQuery(String roomcodeQuery) {
		this.roomcodeQuery = roomcodeQuery;
	}
	public String getRoomnameQuery() {
		return roomnameQuery;
	}
	public void setRoomnameQuery(String roomnameQuery) {
		this.roomnameQuery = roomnameQuery;
	}	
		
}
