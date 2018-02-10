package com.act.web.module.command.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: BaseDataCmdVo.java
 * <p>Description: 基础数据下发指令展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:20:16
 */ 
public class BaseDataCmdVo extends BaseVo{
    
    /**
     * 指令类型:1=打开监测,2=关闭监测,3=查询监测数据,0=查询基础数据
     */
    private String cmdTypeQuery;
    
    /**
     * 生成终止时间
     */
    private String endDateQuery;
    
    /**
     * 执行状态
     */
    private String excStateQuery;
    
    /**
     * 机房编号
     */
    private String serviceCodeQuery;
    
    /**
     * 生成起始时间
     */
    private String startDateQuery;
    
    /**
     * 查询指令ID
     */
    private String commandId;
    
    /**
     * 生成时间
     */
    private String createTime;;
    
    /**
     * 执行时间
     */
    private String excTime;
    
    /**
     * 执行状态:1=等待处理,2=正在处理,3=处理成功,4=处理失败
     */
    private String excState;
    
    /**
     * 经营者名称
     */
    private String idcName;
    
    /**
     * 查询终止时间
     */
    private String queryEndTime;
    
    /**
     * 查询起始时间
     */
    private String queryStartDate;
    
    /**
     * 机房名称
     */
    private String serviceName;
    
    /**
     * 指令类型 :1=打开监测,2=关闭监测,3=查询监测数据,0=查询基础数据
     */
    private String type;

    public String getCmdTypeQuery() {
        return cmdTypeQuery;
    }

    public void setCmdTypeQuery(String cmdTypeQuery) {
        this.cmdTypeQuery = cmdTypeQuery;
    }

    public String getEndDateQuery() {
        return endDateQuery;
    }

    public void setEndDateQuery(String endDateQuery) {
        this.endDateQuery = endDateQuery;
    }

    public String getExcStateQuery() {
        return excStateQuery;
    }

    public void setExcStateQuery(String excStateQuery) {
        this.excStateQuery = excStateQuery;
    }

    public String getServiceCodeQuery() {
        return serviceCodeQuery;
    }

    public void setServiceCodeQuery(String serviceCodeQuery) {
        this.serviceCodeQuery = serviceCodeQuery;
    }

    public String getStartDateQuery() {
        return startDateQuery;
    }

    public void setStartDateQuery(String startDateQuery) {
        this.startDateQuery = startDateQuery;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExcTime() {
        return excTime;
    }

    public void setExcTime(String excTime) {
        this.excTime = excTime;
    }

    public String getExcState() {
        return excState;
    }

    public void setExcState(String excState) {
        this.excState = excState;
    }

    public String getIdcName() {
        return idcName;
    }

    public void setIdcName(String idcName) {
        this.idcName = idcName;
    }

    public String getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public String getQueryStartDate() {
        return queryStartDate;
    }

    public void setQueryStartDate(String queryStartDate) {
        this.queryStartDate = queryStartDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
