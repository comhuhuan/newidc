package com.act.web.module.command.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: ViewEuVo.java
 * <p>Description: 查看EU展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:22:53
 */ 
public class ViewEuVo extends BaseVo {
    /**
     *  EU名称查询
     */
    private String euNameQuery;
    
    /**
     *  状态
     */
    private String resultCodeQuery;
    
    /**
     * 机房名称
     */
    private String serviceCodeQuery;
    
    /**
     *  时间
     */
    private String curTime;
    
    /**
     * EU名称
     */
    private String euName;
    
    /**
     *  描述
     */
    private String msgInfo;
    
    /**
     *  状态
     */
    private String resultCode;
    
    /**
     * 机房名称
     */
    private String serviceName;
    
    /**
     * 管理指令id
     */
    private Long commandId;
    
    /**
     * 管理指令文件id
     */
    private Long idcCommandId;

    /**
     * @return the euNameQuery
     */
    public String getEuNameQuery() {
        return euNameQuery;
    }

    /**
     * @param euNameQuery the euNameQuery to set
     */
    public void setEuNameQuery(String euNameQuery) {
        this.euNameQuery = euNameQuery;
    }

    /**
     * @return the resultCodeQuery
     */
    public String getResultCodeQuery() {
        return resultCodeQuery;
    }

    /**
     * @param resultCodeQuery the resultCodeQuery to set
     */
    public void setResultCodeQuery(String resultCodeQuery) {
        this.resultCodeQuery = resultCodeQuery;
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
     * @return the curTime
     */
    public String getCurTime() {
        return curTime;
    }

    /**
     * @param curTime the curTime to set
     */
    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }

    /**
     * @return the euName
     */
    public String getEuName() {
        return euName;
    }

    /**
     * @param euName the euName to set
     */
    public void setEuName(String euName) {
        this.euName = euName;
    }

    /**
     * @return the msgInfo
     */
    public String getMsgInfo() {
        return msgInfo;
    }

    /**
     * @param msgInfo the msgInfo to set
     */
    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    /**
     * @return the resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode the resultCode to set
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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

}
