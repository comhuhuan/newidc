package com.act.web.module.command.vo;

import java.util.List;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: InfoSecurityCmdVo.java
 * <p>Description: 信息安全管理指令展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:21:22
 */ 
public class InfoSecurityCmdVo extends BaseVo {
    
    /**
     *  指令类型
     */
    private String commandTypeQuery;
    /**
     * 生成时间
     */
    private String createDateQuery;
    /**
     *  下发状态
     */
    private String excStateQuery;
    /**
     *  机房名称
     */
    private String serviceCodeQuery;
    /**
     * 管理指令文件序号
     */
    private Long idcCommandId;
    /**
     * 管理指令ID
     */
    private Long commandId;
    /**
     * 管理指令类型
     */
    private String commandType;
    /**
     *  生成时间
     */
    private Long createTime;
    /**
     *  执行状态
     */
    private String excState;
    /**
     * 执行时间
     */
    private String excTime;
    /**
     * 按钮状态
     */
    private List<OperationButtonVo> operationButton;
    /**
     * 执行状态
     */
    private String operationType;
    /**
     * 下发用户[可读权限]
     */
    private String owner;
    /**
     * 下发用户[可读权限]
     */
    private String visible;
    /**
     * 下发场所
     */
    private String serviceName;
    
    /**
     * 规则类型
     */
    private String subType;
    
    /**
     * 规则内容
     */
    private String valueEnd;
    
    /**
     * 规则内容
     */
    private String valueStart;
    
    /**
     * 过期时间
     */
    private Long expiredTime;

    /**
     * @return the commandTypeQuery
     */
    public String getCommandTypeQuery() {
        return commandTypeQuery;
    }

    /**
     * @param commandTypeQuery the commandTypeQuery to set
     */
    public void setCommandTypeQuery(String commandTypeQuery) {
        this.commandTypeQuery = commandTypeQuery;
    }

    /**
     * @return the createDateQuery
     */
    public String getCreateDateQuery() {
        return createDateQuery;
    }

    /**
     * @param createDateQuery the createDateQuery to set
     */
    public void setCreateDateQuery(String createDateQuery) {
        this.createDateQuery = createDateQuery;
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
     * @return the commandType
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * @param commandType the commandType to set
     */
    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    /**
     * @return the createTime
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Long createTime) {
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
     * @return the excTime
     */
    public String getExcTime() {
        return excTime;
    }

    /**
     * @param excTime the excTime to set
     */
    public void setExcTime(String excTime) {
        this.excTime = excTime;
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
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the visible
     */
    public String getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(String visible) {
        this.visible = visible;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the subType
     */
    public String getSubType() {
        return subType;
    }

    /**
     * @param subType the subType to set
     */
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     * @return the valueEnd
     */
    public String getValueEnd() {
        return valueEnd;
    }

    /**
     * @param valueEnd the valueEnd to set
     */
    public void setValueEnd(String valueEnd) {
        this.valueEnd = valueEnd;
    }

    /**
     * @return the valueStart
     */
    public String getValueStart() {
        return valueStart;
    }

    /**
     * @param valueStart the valueStart to set
     */
    public void setValueStart(String valueStart) {
        this.valueStart = valueStart;
    }

    /**
     * @return the expiredTime
     */
    public Long getExpiredTime() {
        return expiredTime;
    }

    /**
     * @param expiredTime the expiredTime to set
     */
    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }
    
}
