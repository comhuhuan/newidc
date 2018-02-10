/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.enums;

/**
 * <p>
 * Title:IllegalTypeEnum
 * <p>
 * Description:违法违规情况
 * <p>
 * Modified History:
 *
 * @author FMJ
 * @date 2018/2/8 9:17
 */
public enum IllegalTypeEnum {

	/**
	 * 违法违规关系
	 */
	ICP_ILLEGAL("1", "未备案"), WEB_ILLEGAL("2", "违法网站"), OTHER_ILLEGAL("999", "其他");
	/**
	 * 选择框值
	 */
	private String value;
	/**
	 * 选择框显示值
	 */
	private String label;

	IllegalTypeEnum(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}