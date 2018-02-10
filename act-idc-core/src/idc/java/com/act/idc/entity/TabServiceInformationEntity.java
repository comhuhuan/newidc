package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "tab_service_information")
public class TabServiceInformationEntity extends StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Length(max=14)
    @Column(name = "service_code")
    private String serviceCode;

    /**
     * IDC经营单位ID
     */
    @NotEmpty
    @Length(max=128)
    @Column(name = "idcID")
    @ColumnTitle("IDC经营单位ID")
    private String idcid;

    @NotEmpty
    @Length(max=8)
    @Column(name = "source_code")
    private String sourceCode;

    /**
     * 资源管理上传更新标识 0:已经上传1:新增2:修改 3:删除
     */
    @NotEmpty
    @Length(max=6)
    @ColumnTitle("资源管理上传更新标识")
    private String webstatus;

    @Length(max=128)
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 机房性质 1	租用 2	自建 999	其它
     */
    @NotEmpty
    @Length(max=3)
    @Column(name = "houseType")
    @ColumnTitle("机房性质")
    private String housetype;

    /**
     * 关联信息人员表,存入ID号(只有一个ID号),关联表ismsx_idcuserinfo.userId
     */
    @NotEmpty
    @Length(max=32)
    @Column(name = "houseOfficer")
    @ColumnTitle("关联信息人员表,存入ID号(只有一个ID号),关联表ismsx_idcuserinfo.userId")
    private String houseofficer;

    @NotEmpty
    @Length(max=6)
    @Column(name = "area_code")
    private String areaCode;

    @Length(max=20)
    @Column(name = "comm_code")
    private String commCode;

    @Length(max=20)
    @Column(name = "parent_comm_code")
    private String parentCommCode;

    @Length(max=128)
    private String address;

    @NotEmpty
    @Length(max=6)
    private String zip;

    @NotEmpty
    @Length(max=32)
    private String principal;

    @NotEmpty
    @Length(max=16)
    @Column(name = "principal_tel")
    private String principalTel;

    @NotEmpty
    @Length(max=2)
    @Column(name = "unit_nature_code")
    private String unitNatureCode;

    @NotEmpty
    @Length(max=32)
    private String safetyman;

    @NotEmpty
    @Length(max=16)
    @Column(name = "safetyman_tel")
    private String safetymanTel;

    @NotEmpty
    @Length(max=32)
    @Column(name = "safetyman_email")
    private String safetymanEmail;

    @NotEmpty
    @Length(max=6)
    @Column(name = "isp_code")
    private String ispCode;

    @NotEmpty
    @Column(name = "service_state")
    private Byte serviceState;

    @NotEmpty
    @Column(name = "terminal_number")
    private int terminalNumber;

    @NotEmpty
    @Column(name = "server_number")
    private int serverNumber;

    @NotEmpty
    @Length(max=2)
    @Column(name = "access_mode_code")
    private String accessModeCode;

    @NotEmpty
    @Column(name = "practitioner_number")
    private int practitionerNumber;

    @NotEmpty
    @Length(max=24)
    @Column(name = "net_monitor_department")
    private String netMonitorDepartment;

    @NotEmpty
    @Length(max=32)
    @Column(name = "net_monitor_man")
    private String netMonitorMan;

    @NotEmpty
    @Length(max=16)
    @Column(name = "net_monitor_man_tel")
    private String netMonitorManTel;

    @NotEmpty
    @Column(name = "punishment_resut")
    private int punishmentResut;

    @NotEmpty
    @Column(name = "service_kind")
    private Byte serviceKind;

    @NotEmpty
    @Column(name = "create_time")
    private Date createTime;

    @NotEmpty
    @Length(max=128)
    private String remark;

    @NotEmpty
    @Column(name = "send_flag")
    private Byte sendFlag;

    /**
     * 监测状态 0-关闭 1-开启
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("监测状态")
    private String monstatus;

    /**
     * 数据更新标识 0:已经上传1:新增2:修改 3:删除 
     */
    @NotEmpty
    @ColumnTitle("数据更新标识")
    private boolean ftpstatus;

    /**
     * 数据完整检查标识 0-未完整 1-已完整 
     */
    @NotEmpty
    @ColumnTitle("数据完整检查标识")
    private boolean checkdata;

    /**
     * 0-关闭未备案域名封堵功能, 1-开启未备案域名封堵功能
     */
    @NotEmpty
    @Column(name = "ba_status")
    @ColumnTitle("0-关闭未备案域名封堵功能,")
    private boolean baStatus;

    /**
     * 建筑面积-单位(平方米)
     */
    @NotEmpty
    @Column(name = "cons_area")
    @ColumnTitle("建筑面积-单位(平方米)")
    private int consArea;

    @NotEmpty
    @Length(max=40)
    @Column(name = "house_id")
    private String houseId;

    @NotEmpty
    @Length(max=255)
    @Column(name = "deploy_site_name")
    private String deploySiteName;

    /**
     * 执行状态 1-等待处理 2-正在处理 3-处理成功 4-处理失败
     */
    @Length(max=1)
    @ColumnTitle("执行状态")
    private String excstate;

    /**
     * 执行时间
     */
    @ColumnTitle("执行时间")
    private Date exctime;

    @NotEmpty
    @Length(max=65535)
    private String ip;

    /**
     * IP监控段
     */
    @NotEmpty
    @Length(max=2147483647)
    @Column(name = "ip_range")
    @ColumnTitle("IP监控段")
    private String ipRange;

    /**
     * 未上报原因
     */
    @Length(max=65535)
    @ColumnTitle("未上报原因")
    private String msg;

    public static final String Property_Excstate = "excstate";

    public static final String Property_CreateTime = "createTime";

    public static final String Property_SafetymanTel = "safetymanTel";

    public static final String Property_SourceCode = "sourceCode";

    public static final String Property_Remark = "remark";

    public static final String Property_ServerNumber = "serverNumber";

    public static final String Property_TerminalNumber = "terminalNumber";

    public static final String Property_ServiceName = "serviceName";

    public static final String Property_Checkdata = "checkdata";

    public static final String Property_AccessModeCode = "accessModeCode";

    public static final String Property_NetMonitorManTel = "netMonitorManTel";

    public static final String Property_UnitNatureCode = "unitNatureCode";

    public static final String Property_IspCode = "ispCode";

    public static final String Property_NetMonitorMan = "netMonitorMan";

    public static final String Property_Principal = "principal";

    public static final String Property_PunishmentResut = "punishmentResut";

    public static final String Property_Idcid = "idcid";

    public static final String Property_Monstatus = "monstatus";

    public static final String Property_BaStatus = "baStatus";

    public static final String Property_ServiceState = "serviceState";

    public static final String Property_PrincipalTel = "principalTel";

    public static final String Property_SendFlag = "sendFlag";

    public static final String Property_Houseofficer = "houseofficer";

    public static final String Property_Zip = "zip";

    public static final String Property_Exctime = "exctime";

    public static final String Property_AreaCode = "areaCode";

    public static final String Property_ServiceKind = "serviceKind";

    public static final String Property_Safetyman = "safetyman";

    public static final String Property_SafetymanEmail = "safetymanEmail";

    public static final String Property_IpRange = "ipRange";

    public static final String Property_Msg = "msg";

    public static final String Property_ParentCommCode = "parentCommCode";

    public static final String Property_Ip = "ip";

    public static final String Property_Ftpstatus = "ftpstatus";

    public static final String Property_Housetype = "housetype";

    public static final String Property_DeploySiteName = "deploySiteName";

    public static final String Property_ConsArea = "consArea";

    public static final String Property_Address = "address";

    public static final String Property_PractitionerNumber = "practitionerNumber";

    public static final String Property_CommCode = "commCode";

    public static final String Property_Webstatus = "webstatus";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_HouseId = "houseId";

    public static final String Property_NetMonitorDepartment = "netMonitorDepartment";

    /**
     * @return service_code
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * @param serviceCode
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * 获取IDC经营单位ID
     *
     * @return idcID - IDC经营单位ID
     */
    public String getIdcid() {
        return idcid;
    }

    /**
     * 设置IDC经营单位ID
     *
     * @param idcid IDC经营单位ID
     */
    public void setIdcid(String idcid) {
        addChangeField("idcid",this.idcid,idcid);
        this.idcid = idcid;
    }

    /**
     * @return source_code
     */
    public String getSourceCode() {
        return sourceCode;
    }

    /**
     * @param sourceCode
     */
    public void setSourceCode(String sourceCode) {
        addChangeField("sourceCode",this.sourceCode,sourceCode);
        this.sourceCode = sourceCode;
    }

    /**
     * 获取资源管理上传更新标识 0:已经上传1:新增2:修改 3:删除
     *
     * @return webstatus - 资源管理上传更新标识 0:已经上传1:新增2:修改 3:删除
     */
    public String getWebstatus() {
        return webstatus;
    }

    /**
     * 设置资源管理上传更新标识 0:已经上传1:新增2:修改 3:删除
     *
     * @param webstatus 资源管理上传更新标识 0:已经上传1:新增2:修改 3:删除
     */
    public void setWebstatus(String webstatus) {
        addChangeField("webstatus",this.webstatus,webstatus);
        this.webstatus = webstatus;
    }

    /**
     * @return service_name
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     */
    public void setServiceName(String serviceName) {
        addChangeField("serviceName",this.serviceName,serviceName);
        this.serviceName = serviceName;
    }

    /**
     * 获取机房性质 1	租用 2	自建 999	其它
     *
     * @return houseType - 机房性质 1	租用 2	自建 999	其它
     */
    public String getHousetype() {
        return housetype;
    }

    /**
     * 设置机房性质 1	租用 2	自建 999	其它
     *
     * @param housetype 机房性质 1	租用 2	自建 999	其它
     */
    public void setHousetype(String housetype) {
        addChangeField("housetype",this.housetype,housetype);
        this.housetype = housetype;
    }

    /**
     * 获取关联信息人员表,存入ID号(只有一个ID号),关联表ismsx_idcuserinfo.userId
     *
     * @return houseOfficer - 关联信息人员表,存入ID号(只有一个ID号),关联表ismsx_idcuserinfo.userId
     */
    public String getHouseofficer() {
        return houseofficer;
    }

    /**
     * 设置关联信息人员表,存入ID号(只有一个ID号),关联表ismsx_idcuserinfo.userId
     *
     * @param houseofficer 关联信息人员表,存入ID号(只有一个ID号),关联表ismsx_idcuserinfo.userId
     */
    public void setHouseofficer(String houseofficer) {
        addChangeField("houseofficer",this.houseofficer,houseofficer);
        this.houseofficer = houseofficer;
    }

    /**
     * @return area_code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        addChangeField("areaCode",this.areaCode,areaCode);
        this.areaCode = areaCode;
    }

    /**
     * @return comm_code
     */
    public String getCommCode() {
        return commCode;
    }

    /**
     * @param commCode
     */
    public void setCommCode(String commCode) {
        addChangeField("commCode",this.commCode,commCode);
        this.commCode = commCode;
    }

    /**
     * @return parent_comm_code
     */
    public String getParentCommCode() {
        return parentCommCode;
    }

    /**
     * @param parentCommCode
     */
    public void setParentCommCode(String parentCommCode) {
        addChangeField("parentCommCode",this.parentCommCode,parentCommCode);
        this.parentCommCode = parentCommCode;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        addChangeField("address",this.address,address);
        this.address = address;
    }

    /**
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip
     */
    public void setZip(String zip) {
        addChangeField("zip",this.zip,zip);
        this.zip = zip;
    }

    /**
     * @return principal
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * @param principal
     */
    public void setPrincipal(String principal) {
        addChangeField("principal",this.principal,principal);
        this.principal = principal;
    }

    /**
     * @return principal_tel
     */
    public String getPrincipalTel() {
        return principalTel;
    }

    /**
     * @param principalTel
     */
    public void setPrincipalTel(String principalTel) {
        addChangeField("principalTel",this.principalTel,principalTel);
        this.principalTel = principalTel;
    }

    /**
     * @return unit_nature_code
     */
    public String getUnitNatureCode() {
        return unitNatureCode;
    }

    /**
     * @param unitNatureCode
     */
    public void setUnitNatureCode(String unitNatureCode) {
        addChangeField("unitNatureCode",this.unitNatureCode,unitNatureCode);
        this.unitNatureCode = unitNatureCode;
    }

    /**
     * @return safetyman
     */
    public String getSafetyman() {
        return safetyman;
    }

    /**
     * @param safetyman
     */
    public void setSafetyman(String safetyman) {
        addChangeField("safetyman",this.safetyman,safetyman);
        this.safetyman = safetyman;
    }

    /**
     * @return safetyman_tel
     */
    public String getSafetymanTel() {
        return safetymanTel;
    }

    /**
     * @param safetymanTel
     */
    public void setSafetymanTel(String safetymanTel) {
        addChangeField("safetymanTel",this.safetymanTel,safetymanTel);
        this.safetymanTel = safetymanTel;
    }

    /**
     * @return safetyman_email
     */
    public String getSafetymanEmail() {
        return safetymanEmail;
    }

    /**
     * @param safetymanEmail
     */
    public void setSafetymanEmail(String safetymanEmail) {
        addChangeField("safetymanEmail",this.safetymanEmail,safetymanEmail);
        this.safetymanEmail = safetymanEmail;
    }

    /**
     * @return isp_code
     */
    public String getIspCode() {
        return ispCode;
    }

    /**
     * @param ispCode
     */
    public void setIspCode(String ispCode) {
        addChangeField("ispCode",this.ispCode,ispCode);
        this.ispCode = ispCode;
    }

    /**
     * @return service_state
     */
    public Byte getServiceState() {
        return serviceState;
    }

    /**
     * @param serviceState
     */
    public void setServiceState(Byte serviceState) {
        addChangeField("serviceState",this.serviceState,serviceState);
        this.serviceState = serviceState;
    }

    /**
     * @return terminal_number
     */
    public int getTerminalNumber() {
        return terminalNumber;
    }

    /**
     * @param terminalNumber
     */
    public void setTerminalNumber(int terminalNumber) {
        addChangeField("terminalNumber",this.terminalNumber,terminalNumber);
        this.terminalNumber = terminalNumber;
    }

    /**
     * @return server_number
     */
    public int getServerNumber() {
        return serverNumber;
    }

    /**
     * @param serverNumber
     */
    public void setServerNumber(int serverNumber) {
        addChangeField("serverNumber",this.serverNumber,serverNumber);
        this.serverNumber = serverNumber;
    }

    /**
     * @return access_mode_code
     */
    public String getAccessModeCode() {
        return accessModeCode;
    }

    /**
     * @param accessModeCode
     */
    public void setAccessModeCode(String accessModeCode) {
        addChangeField("accessModeCode",this.accessModeCode,accessModeCode);
        this.accessModeCode = accessModeCode;
    }

    /**
     * @return practitioner_number
     */
    public int getPractitionerNumber() {
        return practitionerNumber;
    }

    /**
     * @param practitionerNumber
     */
    public void setPractitionerNumber(int practitionerNumber) {
        addChangeField("practitionerNumber",this.practitionerNumber,practitionerNumber);
        this.practitionerNumber = practitionerNumber;
    }

    /**
     * @return net_monitor_department
     */
    public String getNetMonitorDepartment() {
        return netMonitorDepartment;
    }

    /**
     * @param netMonitorDepartment
     */
    public void setNetMonitorDepartment(String netMonitorDepartment) {
        addChangeField("netMonitorDepartment",this.netMonitorDepartment,netMonitorDepartment);
        this.netMonitorDepartment = netMonitorDepartment;
    }

    /**
     * @return net_monitor_man
     */
    public String getNetMonitorMan() {
        return netMonitorMan;
    }

    /**
     * @param netMonitorMan
     */
    public void setNetMonitorMan(String netMonitorMan) {
        addChangeField("netMonitorMan",this.netMonitorMan,netMonitorMan);
        this.netMonitorMan = netMonitorMan;
    }

    /**
     * @return net_monitor_man_tel
     */
    public String getNetMonitorManTel() {
        return netMonitorManTel;
    }

    /**
     * @param netMonitorManTel
     */
    public void setNetMonitorManTel(String netMonitorManTel) {
        addChangeField("netMonitorManTel",this.netMonitorManTel,netMonitorManTel);
        this.netMonitorManTel = netMonitorManTel;
    }

    /**
     * @return punishment_resut
     */
    public int getPunishmentResut() {
        return punishmentResut;
    }

    /**
     * @param punishmentResut
     */
    public void setPunishmentResut(int punishmentResut) {
        addChangeField("punishmentResut",this.punishmentResut,punishmentResut);
        this.punishmentResut = punishmentResut;
    }

    /**
     * @return service_kind
     */
    public Byte getServiceKind() {
        return serviceKind;
    }

    /**
     * @param serviceKind
     */
    public void setServiceKind(Byte serviceKind) {
        addChangeField("serviceKind",this.serviceKind,serviceKind);
        this.serviceKind = serviceKind;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        addChangeField("createTime",this.createTime,createTime);
        this.createTime = createTime;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        addChangeField("remark",this.remark,remark);
        this.remark = remark;
    }

    /**
     * @return send_flag
     */
    public Byte getSendFlag() {
        return sendFlag;
    }

    /**
     * @param sendFlag
     */
    public void setSendFlag(Byte sendFlag) {
        addChangeField("sendFlag",this.sendFlag,sendFlag);
        this.sendFlag = sendFlag;
    }

    /**
     * 获取监测状态 0-关闭 1-开启
     *
     * @return monstatus - 监测状态 0-关闭 1-开启
     */
    public String getMonstatus() {
        return monstatus;
    }

    /**
     * 设置监测状态 0-关闭 1-开启
     *
     * @param monstatus 监测状态 0-关闭 1-开启
     */
    public void setMonstatus(String monstatus) {
        addChangeField("monstatus",this.monstatus,monstatus);
        this.monstatus = monstatus;
    }

    /**
     * 获取数据更新标识 0:已经上传1:新增2:修改 3:删除 
     *
     * @return ftpstatus - 数据更新标识 0:已经上传1:新增2:修改 3:删除 
     */
    public boolean getFtpstatus() {
        return ftpstatus;
    }

    /**
     * 设置数据更新标识 0:已经上传1:新增2:修改 3:删除 
     *
     * @param ftpstatus 数据更新标识 0:已经上传1:新增2:修改 3:删除 
     */
    public void setFtpstatus(boolean ftpstatus) {
        addChangeField("ftpstatus",this.ftpstatus,ftpstatus);
        this.ftpstatus = ftpstatus;
    }

    /**
     * 获取数据完整检查标识 0-未完整 1-已完整 
     *
     * @return checkdata - 数据完整检查标识 0-未完整 1-已完整 
     */
    public boolean getCheckdata() {
        return checkdata;
    }

    /**
     * 设置数据完整检查标识 0-未完整 1-已完整 
     *
     * @param checkdata 数据完整检查标识 0-未完整 1-已完整 
     */
    public void setCheckdata(boolean checkdata) {
        addChangeField("checkdata",this.checkdata,checkdata);
        this.checkdata = checkdata;
    }

    /**
     * 获取0-关闭未备案域名封堵功能, 1-开启未备案域名封堵功能
     *
     * @return ba_status - 0-关闭未备案域名封堵功能, 1-开启未备案域名封堵功能
     */
    public boolean getBaStatus() {
        return baStatus;
    }

    /**
     * 设置0-关闭未备案域名封堵功能, 1-开启未备案域名封堵功能
     *
     * @param baStatus 0-关闭未备案域名封堵功能, 1-开启未备案域名封堵功能
     */
    public void setBaStatus(boolean baStatus) {
        addChangeField("baStatus",this.baStatus,baStatus);
        this.baStatus = baStatus;
    }

    /**
     * 获取建筑面积-单位(平方米)
     *
     * @return cons_area - 建筑面积-单位(平方米)
     */
    public int getConsArea() {
        return consArea;
    }

    /**
     * 设置建筑面积-单位(平方米)
     *
     * @param consArea 建筑面积-单位(平方米)
     */
    public void setConsArea(int consArea) {
        addChangeField("consArea",this.consArea,consArea);
        this.consArea = consArea;
    }

    /**
     * @return house_id
     */
    public String getHouseId() {
        return houseId;
    }

    /**
     * @param houseId
     */
    public void setHouseId(String houseId) {
        addChangeField("houseId",this.houseId,houseId);
        this.houseId = houseId;
    }

    /**
     * @return deploy_site_name
     */
    public String getDeploySiteName() {
        return deploySiteName;
    }

    /**
     * @param deploySiteName
     */
    public void setDeploySiteName(String deploySiteName) {
        addChangeField("deploySiteName",this.deploySiteName,deploySiteName);
        this.deploySiteName = deploySiteName;
    }

    /**
     * 获取执行状态 1-等待处理 2-正在处理 3-处理成功 4-处理失败
     *
     * @return excstate - 执行状态 1-等待处理 2-正在处理 3-处理成功 4-处理失败
     */
    public String getExcstate() {
        return excstate;
    }

    /**
     * 设置执行状态 1-等待处理 2-正在处理 3-处理成功 4-处理失败
     *
     * @param excstate 执行状态 1-等待处理 2-正在处理 3-处理成功 4-处理失败
     */
    public void setExcstate(String excstate) {
        addChangeField("excstate",this.excstate,excstate);
        this.excstate = excstate;
    }

    /**
     * 获取执行时间
     *
     * @return exctime - 执行时间
     */
    public Date getExctime() {
        return exctime;
    }

    /**
     * 设置执行时间
     *
     * @param exctime 执行时间
     */
    public void setExctime(Date exctime) {
        addChangeField("exctime",this.exctime,exctime);
        this.exctime = exctime;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        addChangeField("ip",this.ip,ip);
        this.ip = ip;
    }

    /**
     * 获取IP监控段
     *
     * @return ip_range - IP监控段
     */
    public String getIpRange() {
        return ipRange;
    }

    /**
     * 设置IP监控段
     *
     * @param ipRange IP监控段
     */
    public void setIpRange(String ipRange) {
        addChangeField("ipRange",this.ipRange,ipRange);
        this.ipRange = ipRange;
    }

    /**
     * 获取未上报原因
     *
     * @return msg - 未上报原因
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置未上报原因
     *
     * @param msg 未上报原因
     */
    public void setMsg(String msg) {
        addChangeField("msg",this.msg,msg);
        this.msg = msg;
    }
}