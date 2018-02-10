/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.vo;

import com.act.web.module.common.vo.SelectVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title:IllegalWebVo
 * <p>
 * Description:违法网站vo
 * ismsc_nofilterblack.datatype = 2/ismsc_nofilterblackrule
 *
 * @author FMJ
 * @date 2018/2/7 14:54
 */
public class IllegalWebVo {

	// 初始化start
	/**
	 * 指令来源
	 */
	private List<SelectVo> cmdFlagList;
	/**
	 * 违法违规情况
	 */
	private List<SelectVo> illegalTypeList;
	/**
	 * 匹配模式列表
	 */
	private List<SelectVo> matchModelList;
	/**
	 * 机房列表
	 */
	private List<SelectVo> serviceCodeList;
	// 初始化end

	// 查询条件start
    /**
     * 违法网站名称
     */
    private String nameQuery;
    /**
     * 违法网站指令ID
     */
    private Long commandIdQuery;
    /**
     * 下发类型 1=待下发,2=下发,3=取消
     */
    private String statusQuery;
    /**
     * 违法网站类型 1=域名,2=IP
     */
    private Integer typeQuery;
    /**
     * 机房名称
     */
    private String serviceCodeQuery;
    /**
     * 策略内容
     */
    private String contentQuery;
    /**
     * 开始时间 yyyy-MM-dd
     */
    private String dateStartQuery;
    /**
     * 结束时间 yyyy-MM-dd
     */
    private String dateEndQuery;
	/**
	 * 指令来源
	 */
	private Integer cmdFlagQuery;

	// 查询条件end

	// 列表展示start
    /**
     * 违法网站主键
     */
    private Long idcCommandId;
    /**
     * 违法网站名称
     */
    private String name;
    /**
     * 违法网站指令ID
     */
    private Long commandId;
    /**
     * 违法网站类型 【1=域名,2=IP】
     */
    private Integer type;
    /**
     * 违法违规情况
     */
    private String illegalType;
    /**
     * 操作人员
     */
    private String owner;
    /**
     * 创建时间
     */
    private Date timeStamp;
    /**
     * 期限标识
     */
    private Integer isWu;
    /**
     * 过期时间 isWu==30 显示无期限,否则显示expiredTime 当expiredTime < 当前时间时字体显示红色且无法点击勾选框
     */
    private Date expiredTime;
    /**
     * 指令来源：0-SMMS,1-CU
     */
    private Integer cmdFlag;
    /**
     * 监测状态
     */
    private String status;
    /**
     * 处置状态:0-未处置,1-已处置
     */
    private Integer isStop;
    /**
     * 监测状态 cmdFlag/status
     */
    private String statusLable;
    /**
     * 封堵状态
     */
    private String excstateLable;
    /**
     * 操作
     */
    private List<ButtonVo> operationButton;
	/**
	 * 处置
	 */
	private List<ButtonVo> disposeButton;
	/**
	 * 操作类型 不展示用于初始化修改页面
	 */
	private String operationType;
	// 列表展示end

	public IllegalWebVo() {
	}

	/**
	 * <p>
	 * Title: IllegalWebVo
	 * <p>
	 * Description:违法网站页面初始化
	 * 
	 * @author FMJ
	 * @date 2018/2/8 8:14
	 * @param cmdFlagList
	 *            指令来源
	 * @param illegalTypeList
	 *            违法违规情况
	 * @param matchModelList
	 *            匹配模式列表
	 * @param serviceCodeList
	 *            机房列表
	 */
	public IllegalWebVo(List<SelectVo> cmdFlagList, List<SelectVo> illegalTypeList, List<SelectVo> matchModelList,
			List<SelectVo> serviceCodeList) {
		this.cmdFlagList = cmdFlagList;
		this.illegalTypeList = illegalTypeList;
		this.matchModelList = matchModelList;
		this.serviceCodeList = serviceCodeList;
	}

    public List<SelectVo> getCmdFlagList() {
        return cmdFlagList;
    }

    public void setCmdFlagList(List<SelectVo> cmdFlagList) {
        this.cmdFlagList = cmdFlagList;
    }

    public List<SelectVo> getIllegalTypeList() {
        return illegalTypeList;
    }

    public void setIllegalTypeList(List<SelectVo> illegalTypeList) {
        this.illegalTypeList = illegalTypeList;
    }

    public List<SelectVo> getMatchModelList() {
        return matchModelList;
    }

    public void setMatchModelList(List<SelectVo> matchModelList) {
        this.matchModelList = matchModelList;
    }

    public List<SelectVo> getServiceCodeList() {
        return serviceCodeList;
    }

    public void setServiceCodeList(List<SelectVo> serviceCodeList) {
        this.serviceCodeList = serviceCodeList;
    }

    public String getNameQuery() {
        return nameQuery;
    }

    public void setNameQuery(String nameQuery) {
        this.nameQuery = nameQuery;
    }

    public Long getCommandIdQuery() {
        return commandIdQuery;
    }

    public void setCommandIdQuery(Long commandIdQuery) {
        this.commandIdQuery = commandIdQuery;
    }

    public String getStatusQuery() {
        return statusQuery;
    }

    public void setStatusQuery(String statusQuery) {
        this.statusQuery = statusQuery;
    }

    public Integer getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(Integer typeQuery) {
        this.typeQuery = typeQuery;
    }

    public String getServiceCodeQuery() {
        return serviceCodeQuery;
    }

    public void setServiceCodeQuery(String serviceCodeQuery) {
        this.serviceCodeQuery = serviceCodeQuery;
    }

    public String getContentQuery() {
        return contentQuery;
    }

    public void setContentQuery(String contentQuery) {
        this.contentQuery = contentQuery;
    }

    public String getDateStartQuery() {
        return dateStartQuery;
    }

    public void setDateStartQuery(String dateStartQuery) {
        this.dateStartQuery = dateStartQuery;
    }

    public String getDateEndQuery() {
        return dateEndQuery;
    }

    public void setDateEndQuery(String dateEndQuery) {
        this.dateEndQuery = dateEndQuery;
    }

    public Integer getCmdFlagQuery() {
        return cmdFlagQuery;
    }

    public void setCmdFlagQuery(Integer cmdFlagQuery) {
        this.cmdFlagQuery = cmdFlagQuery;
    }

    public Long getIdcCommandId() {
        return idcCommandId;
    }

    public void setIdcCommandId(Long idcCommandId) {
        this.idcCommandId = idcCommandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIllegalType() {
        return illegalType;
    }

    public void setIllegalType(String illegalType) {
        this.illegalType = illegalType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getIsWu() {
        return isWu;
    }

    public void setIsWu(Integer isWu) {
        this.isWu = isWu;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getCmdFlag() {
        return cmdFlag;
    }

    public void setCmdFlag(Integer cmdFlag) {
        this.cmdFlag = cmdFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsStop() {
        return isStop;
    }

    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }

    public String getStatusLable() {
        return statusLable;
    }

    public void setStatusLable(String statusLable) {
        this.statusLable = statusLable;
    }

    public String getExcstateLable() {
        return excstateLable;
    }

    public void setExcstateLable(String excstateLable) {
        this.excstateLable = excstateLable;
    }

    public List<ButtonVo> getOperationButton() {
        return operationButton;
    }

    public void setOperationButton(List<ButtonVo> operationButton) {
        this.operationButton = operationButton;
    }

    public List<ButtonVo> getDisposeButton() {
        return disposeButton;
    }

    public void setDisposeButton(List<ButtonVo> disposeButton) {
        this.disposeButton = disposeButton;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}