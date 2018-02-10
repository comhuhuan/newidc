/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.common.vo;

import java.io.Serializable;

/**
 *
 * <p>Title: SelectVo
 * <p>Description:select组件查询条件
 * @author FMJ
 * @date 2018/2/7 10:39
 */
public class SelectVo<T> implements Serializable{
    /**
     * 选择框值
     */
    private T value;
    /**
     * 选择框显示值
     */
    private String label;

    public SelectVo() {
    }

    public SelectVo(T value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
