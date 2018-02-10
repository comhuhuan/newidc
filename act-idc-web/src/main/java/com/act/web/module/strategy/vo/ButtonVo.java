/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.vo;

/**
 * <p>
 * Title:buttonVo
 * <p>
 * Description:按钮状态vo
 *
 * @author FMJ
 * @date 2018/2/8 12:44
 */
public class ButtonVo {
	/**
	 * false-不隐藏 true-隐藏
	 */
	private boolean hidden;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 类型
	 */
	private Integer type;

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}