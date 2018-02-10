package com.act.web.module.command.vo;

import java.util.List;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: NoFilterWebCmdVo.java
 * <p>Description: 免过滤网站指令展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:21:41
 */ 
public class NoFilterWebCmdVo extends BaseVo {
    /**
     * 免过滤指令ID
     */
    private Long commandIdQuery;
    /**
     * 结束时间
     */
    private String endDateQuery;
    /**
     * 下发状态
     */
    private String excStateQuery;
    /**
     *  免过滤类型
     */
    private String noFilterTypeQuery;
    /**
     * 机房名称
     */
    private String serviceCodeQuery;
    /**
     *  开始时间
     */
    private String startDateQuery;
    /**
     *  免过滤指令ID
     */
    private Long commandId;
  
    /**
     *  生成时间
     */
    private String createTime;
    /**
     * 执行状态
     */
    private String excState;
    
    /**
     * 管理指令文件序号
     */
    private Long idcCommandId;
    /**
     * 免过滤名称
     */
    private String noFilterName;
    /**
     *  免过滤类型
     */
    private String noFilterType; 
    /**
     * 
     */
    private List<OperationButtonVo> operationButton;
    
    /**
     * 操作类型
     */
    private String operationType;
    
    /**
     * 过期时间
     */
    private String expiredTime;

    /**
     * @return the endDateQuery
     */
    public String getEndDateQuery() {
        return endDateQuery;
    }

    /**
     * @param endDateQuery the endDateQuery to set
     */
    public void setEndDateQuery(String endDateQuery) {
        this.endDateQuery = endDateQuery;
    }

    /**
     * @return the excStateQuery
     */
    public String getExcStateQuery() {
        return excStateQuery;
    }

    /**
     * @param excStateQuery the excStateQuery to set
     */
    public void setExcStateQuery(String excStateQuery) {
        this.excStateQuery = excStateQuery;
    }

    /**
     * @return the noFilterTypeQuery
     */
    public String getNoFilterTypeQuery() {
        return noFilterTypeQuery;
    }

    /**
     * @param noFilterTypeQuery the noFilterTypeQuery to set
     */
    public void setNoFilterTypeQuery(String noFilterTypeQuery) {
        this.noFilterTypeQuery = noFilterTypeQuery;
    }

    /**
     * @return the serviceCodeQuery
     */
    public String getServiceCodeQuery() {
        return serviceCodeQuery;
    }

    /**
     * @param serviceCodeQuery the serviceCodeQuery to set
     */
    public void setServiceCodeQuery(String serviceCodeQuery) {
        this.serviceCodeQuery = serviceCodeQuery;
    }

    /**
     * @return the startDateQuery
     */
    public String getStartDateQuery() {
        return startDateQuery;
    }

    /**
     * @param startDateQuery the startDateQuery to set
     */
    public void setStartDateQuery(String startDateQuery) {
        this.startDateQuery = startDateQuery;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the excState
     */
    public String getExcState() {
        return excState;
    }

    /**
     * @param excState the excState to set
     */
    public void setExcState(String excState) {
        this.excState = excState;
    }

    /**
     * @return the noFilterName
     */
    public String getNoFilterName() {
        return noFilterName;
    }

    /**
     * @param noFilterName the noFilterName to set
     */
    public void setNoFilterName(String noFilterName) {
        this.noFilterName = noFilterName;
    }

    /**
     * @return the noFilterType
     */
    public String getNoFilterType() {
        return noFilterType;
    }

    /**
     * @param noFilterType the noFilterType to set
     */
    public void setNoFilterType(String noFilterType) {
        this.noFilterType = noFilterType;
    }

    /**
     * @return the operationButton
     */
    public List<OperationButtonVo> getOperationButton() {
        return operationButton;
    }

    /**
     * @param operationButton the operationButton to set
     */
    public void setOperationButton(List<OperationButtonVo> operationButton) {
        this.operationButton = operationButton;
    }

    /**
     * @return the commandIdQuery
     */
    public Long getCommandIdQuery() {
        return commandIdQuery;
    }

    /**
     * @param commandIdQuery the commandIdQuery to set
     */
    public void setCommandIdQuery(Long commandIdQuery) {
        this.commandIdQuery = commandIdQuery;
    }

    /**
     * @return the commandId
     */
    public Long getCommandId() {
        return commandId;
    }

    /**
     * @param commandId the commandId to set
     */
    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    /**
     * @return the idcCommandId
     */
    public Long getIdcCommandId() {
        return idcCommandId;
    }

    /**
     * @param idcCommandId the idcCommandId to set
     */
    public void setIdcCommandId(Long idcCommandId) {
        this.idcCommandId = idcCommandId;
    }

    /**
     * @return the operationType
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * @param operationType the operationType to set
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * @return the expiredTime
     */
    public String getExpiredTime() {
        return expiredTime;
    }

    /**
     * @param expiredTime the expiredTime to set
     */
    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
    
}
