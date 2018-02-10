/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.sso.vo;

/**
 * <p>
 * Title:SessionVo
 * <p>
 * Description:用于存放session值
 *
 * @author fmj
 * @date 2018/1/31 9:51
 */
public class SessionVo {

	/**
	 * 当前用户id
	 */
	private String userId;
	/**
	 * 是否为管理员 true表示是
	 */
	private Boolean isAdmin;
	/**
	 * 当前ip
	 */
	private String localIp;
	/**
	 * 当前mac
	 */
	private String localMac;
	/**
	 * 当前machine
	 */
	private String localMachine;

	public SessionVo(String userId, Boolean isAdmin, String localIp, String localMac, String localMachine) {
		this.userId = userId;
        this.isAdmin = isAdmin;
		this.localIp = localIp;
		this.localMac = localMac;
		this.localMachine = localMachine;
	}

	public Boolean getAdmin() {
		return isAdmin;
	}

	public void setAdmin(Boolean admin) {
		isAdmin = admin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLocalIp() {
		return localIp;
	}

	public void setLocalIp(String localIp) {
		this.localIp = localIp;
	}

	public String getLocalMac() {
		return localMac;
	}

	public void setLocalMac(String localMac) {
		this.localMac = localMac;
	}

	public String getLocalMachine() {
		return localMachine;
	}

	public void setLocalMachine(String localMachine) {
		this.localMachine = localMachine;
	}
}