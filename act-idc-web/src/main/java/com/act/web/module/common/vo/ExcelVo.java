/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.common.vo;

/**
 * <p>Title: ExcelVo
 * <p>Description: excel操作样例vo
 * @author FMJ
 * @date 2018/2/7 8:36
 */
public class ExcelVo {
    /**
     * 域名id
     */
    private Integer domainId;
    /**
     * 机房编号
     */
    private String serviceCode;
    /**
     * 域名
     */
    private String domain;
    /**
     * 服务内容
     */
    private String serviceContent;

    public ExcelVo() {
    }

    public ExcelVo(String serviceCode, String domain, String serviceContent) {
        this.serviceCode = serviceCode;
        this.domain = domain;
        this.serviceContent = serviceContent;
    }

    @Override
    public String toString() {
        return serviceCode + "|" + domain + "|" + serviceContent;

    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }
}
