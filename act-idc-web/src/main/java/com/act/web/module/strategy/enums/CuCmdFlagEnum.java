/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.enums;

/**
 * <p>
 * Title:CuCmdFlagEnum
 * <p>
 * Description:cu指令来源
 *
 * @author FMJ
 * @date 2018/2/7 15:38 {0=上级指令,1=本地指令}
 */
public enum CuCmdFlagEnum {
    /**
     * 指令来源关系
     */
	SMMS_FLAG(0, "上级指令"), LOCAL_FLAG(1, "本地指令");
	/**
	 * 选择框值
	 */
	private Integer value;
	/**
	 * 选择框显示值
	 */
	private String label;

	CuCmdFlagEnum(Integer value, String label) {
		this.value = value;
		this.label = label;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}