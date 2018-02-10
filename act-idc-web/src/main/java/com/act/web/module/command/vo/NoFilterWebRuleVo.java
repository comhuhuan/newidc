package com.act.web.module.command.vo;

/**
 * 
 * <p>Title: NoFilterWebRuleVo.java
 * <p>Description: 免过滤网站子策略展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:21:54
 */ 
public class NoFilterWebRuleVo {
    
    /**
     * 免过滤的主键
     */
    private Long idcCommandId;
    
    /**
     *  应用策略Id
     */
    private Long schemeId;
    
    /**
     *  机房id
     */
    private String serviceCode;
    
    /**
     *  免过滤指令ID
     */
    private Long commandId;
    
    /**
     *  免过滤内容
     */
    private String content;
    
    /**
     *  执行时间
     */
    private String excTime;
    
    /**
     *  执行状态
     */
    private String excState;
    
    /**
     * 下发范围
     */
    private String serviceName;
    
    /**
     * 免过滤类型
     */
    private String type;
    
    /**
     * 操作类型
     */
    private String operationType;

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
     * @return the schemeId
     */
    public Long getSchemeId() {
        return schemeId;
    }

    /**
     * @param schemeId the schemeId to set
     */
    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    /**
     * @return the serviceCode
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * @param serviceCode the serviceCode to set
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
    
    
}
