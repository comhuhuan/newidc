/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.enums;

/**
 * <p>
 * Title:MatchModelEnum
 * <p>
 * Description:匹配模式
 *
 * @author FMJ
 * @date 2018/2/7 15:38
 */
public enum MatchModelEnum {

	/**
	 * 匹配模式关系
	 */
	APPROX_MODEL("approx", "模糊匹配"), EXACT_MODEL("exact", "精确匹配"), PREFIX_MODEL("prefix", "前缀匹配"), SUFFIX_MODEL("suffix",
			"后缀匹配");
	/**
	 * 选择框值
	 */
	private String value;
	/**
	 * 选择框显示值
	 */
	private String label;

	MatchModelEnum(String value, String label) {
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
