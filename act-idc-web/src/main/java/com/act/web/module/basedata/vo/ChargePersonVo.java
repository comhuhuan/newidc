/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.basedata.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * The <code>ChargePersonVo</code> 责任人vo
 * 
 * @author xuliang
 * @since V2.0
 */
public class ChargePersonVo extends BaseVo {
	private String idtypeQuery;
	private String idQuery;
	private String nameQuery;	
	private int userid;
	private String serviceCode;
	private String name;
	private String idtype;
	private String id;
	private String tel;
	private String mobile;
	private String email;
	public String getIdtypeQuery() {
		return idtypeQuery;
	}
	public void setIdtypeQuery(String idtypeQuery) {
		this.idtypeQuery = idtypeQuery;
	}
	public String getIdQuery() {
		return idQuery;
	}
	public void setIdQuery(String idQuery) {
		this.idQuery = idQuery;
	}
	public String getNameQuery() {
		return nameQuery;
	}
	public void setNameQuery(String nameQuery) {
		this.nameQuery = nameQuery;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
