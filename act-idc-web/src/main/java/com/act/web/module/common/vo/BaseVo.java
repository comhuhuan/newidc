/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.common.vo;

/**
 * The <code>BaseVo</code>
 * 基础vo
 * @author  FMJ
 * @since   V1.0
 */
public class BaseVo {

	// 页面导出必备字段 add 2017-04-12 by fmj

    /**
     * 导出方式[查询数据:1,全部数据:-1]
     */
    private String exportType;

    /**
     * 文件名称 不需后缀名
     */
    private String fileName;

    /**
     * 导入信息
     */
	private String uploadInfo;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExportType() {
		return exportType;
	}

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}

	public String getUploadInfo() {
		return uploadInfo;
	}

	public void setUploadInfo(String uploadInfo) {
		this.uploadInfo = uploadInfo;
	}

}
