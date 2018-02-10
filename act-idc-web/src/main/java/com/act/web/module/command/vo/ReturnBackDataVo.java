package com.act.web.module.command.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: ReturnBackDataVo.java
 * <p>Description: 回退数据内容查询展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:22:38
 */ 
public class ReturnBackDataVo extends BaseVo {

    /**
     * 退回数据类型:0=经营者,1=机房数据,2=用户数据
     */
    private String dataTypeQuery;

    /**
     * 结束时间
     */
    private String endDateQuery;

    /**
     * 处理状态
     */
    private String excStateQuery;

    /**
     * 退回原因分类
     */
    private String returnCodeQuery;

    /**
     * 机房名称
     */
    private String serviceCodeQuery;

    /**
     * 开始时间
     */
    private String startDateQuery;

    /**
     * 生成时间
     */
    private String createTime;

    /**
     * 退回数据类别
     */
    private String dataType;

    /**
     * 处理状态
     */
    private String excState;

    /**
     * 处理时间
     */
    private String excTime;

    /**
     * 主键
     */
    private String id;

    /**
     * IDC经营者
     */
    private String idcName;

    /**
     * 退回原因分类
     */
    private String returnCode;

    /**
     * 退回原因说明
     */
    private String returnMsg;

    /**
     * 机房编号
     */
    private String serviceCode;

    /**
     * 机房名称
     */
    private String serviceName;
    
    /**
     * 应用服务名称
     */
    private String appServiceName;
    
    /**
     *  用户ID
     */
    private String custId;
    
    /**
     * 用户名称
     */
    private String custName;
    
    /**
     * 域名
     */
    private String domainName;
    
    /**
     * 机房机架名称
     */
    private String frameName;
    
    /**
     *  互联网出入口
     */
    private String gatewayName;
    
    /**
     * IP段
     */
    private String ipSegName;
    
    /**
     * 占用机房名称
     */
    private String occupyServiceName;
    
    /**
     * @return the dataTypeQuery
     */
    public String getDataTypeQuery() {
        return dataTypeQuery;
    }

    /**
     * @param dataTypeQuery
     *            the dataTypeQuery to set
     */
    public void setDataTypeQuery(String dataTypeQuery) {
        this.dataTypeQuery = dataTypeQuery;
    }

    /**
     * @return the endDateQuery
     */
    public String getEndDateQuery() {
        return endDateQuery;
    }

    /**
     * @param endDateQuery
     *            the endDateQuery to set
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
     * @param excStateQuery
     *            the excStateQuery to set
     */
    public void setExcStateQuery(String excStateQuery) {
        this.excStateQuery = excStateQuery;
    }

    /**
     * @return the returnCodeQuery
     */
    public String getReturnCodeQuery() {
        return returnCodeQuery;
    }

    /**
     * @param returnCodeQuery
     *            the returnCodeQuery to set
     */
    public void setReturnCodeQuery(String returnCodeQuery) {
        this.returnCodeQuery = returnCodeQuery;
    }

    /**
     * @return the serviceCodeQuery
     */
    public String getServiceCodeQuery() {
        return serviceCodeQuery;
    }

    /**
     * @param serviceCodeQuery
     *            the serviceCodeQuery to set
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
     * @param startDateQuery
     *            the startDateQuery to set
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
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType
     *            the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the excState
     */
    public String getExcState() {
        return excState;
    }

    /**
     * @param excState
     *            the excState to set
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
     * @param excTime
     *            the excTime to set
     */
    public void setExcTime(String excTime) {
        this.excTime = excTime;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the idcName
     */
    public String getIdcName() {
        return idcName;
    }

    /**
     * @param idcName
     *            the idcName to set
     */
    public void setIdcName(String idcName) {
        this.idcName = idcName;
    }

    /**
     * @return the returnCode
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * @param returnCode
     *            the returnCode to set
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * @return the returnMsg
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * @param returnMsg
     *            the returnMsg to set
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    /**
     * @return the serviceCode
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * @param serviceCode
     *            the serviceCode to set
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     *            the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the appServiceName
     */
    public String getAppServiceName() {
        return appServiceName;
    }

    /**
     * @param appServiceName the appServiceName to set
     */
    public void setAppServiceName(String appServiceName) {
        this.appServiceName = appServiceName;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the domainName
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * @param domainName the domainName to set
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * @return the frameName
     */
    public String getFrameName() {
        return frameName;
    }

    /**
     * @param frameName the frameName to set
     */
    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    /**
     * @return the gatewayName
     */
    public String getGatewayName() {
        return gatewayName;
    }

    /**
     * @param gatewayName the gatewayName to set
     */
    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    /**
     * @return the ipSegName
     */
    public String getIpSegName() {
        return ipSegName;
    }

    /**
     * @param ipSegName the ipSegName to set
     */
    public void setIpSegName(String ipSegName) {
        this.ipSegName = ipSegName;
    }

    /**
     * @return the occupyServiceName
     */
    public String getOccupyServiceName() {
        return occupyServiceName;
    }

    /**
     * @param occupyServiceName the occupyServiceName to set
     */
    public void setOccupyServiceName(String occupyServiceName) {
        this.occupyServiceName = occupyServiceName;
    }
}
