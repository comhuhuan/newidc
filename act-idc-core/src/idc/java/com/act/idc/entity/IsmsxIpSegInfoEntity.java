package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsx_ipseginfo")
public class IsmsxIpSegInfoEntity extends StandardEntity {
    /**
     * IP地址段资源的编号，由ISMS定义，当前机房中唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ipID")
    @ColumnTitle("IP地址段资源的编号，由ISMS定义，当前机房中唯一")
    private int ipid;

    @Id
    @NotEmpty
    @Length(max=18)
    @Column(name = "service_code")
    private String serviceCode;

    /**
     * 该地址段的起始IP地址
     */
    @NotEmpty
    @Length(max=64)
    @Column(name = "startIP")
    @ColumnTitle("该地址段的起始IP地址")
    private String startip;

    /**
     * 该地址段的终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     */
    @NotEmpty
    @Length(max=64)
    @Column(name = "endIP")
    @ColumnTitle("该地址段的终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址")
    private String endip;

    /**
     * 对应的私网起始IP地址
     */
    @Length(max=64)
    @Column(name = "pstartIP")
    @ColumnTitle("对应的私网起始IP地址")
    private String pstartip;

    /**
     * 对应的私网终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     */
    @Length(max=64)
    @Column(name = "pendIP")
    @ColumnTitle("对应的私网终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址")
    private String pendip;

    /**
     * IP地址使用方式，包括；0-静态；1-动态；2-保留。
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("IP地址使用方式，包括；0-静态；1-动态；2-保留。")
    private String type;

    /**
     * 使用该IP段的单位名称，如果是个人需要填写姓名
     */
    @Length(max=128)
    @ColumnTitle("使用该IP段的单位名称，如果是个人需要填写姓名")
    private String user;

    /**
     * 使用人的证件类型
     */
    @Length(max=3)
    @Column(name = "IDtype")
    @ColumnTitle("使用人的证件类型")
    private String idtype;

    /**
     * 对应的使用人的证件号码
     */
    @Length(max=32)
    @Column(name = "IDnumber")
    @ColumnTitle("对应的使用人的证件号码")
    private String idnumber;

    /**
     * 来源单位 特定单个IP/IP段的来源，自有的填写自己的单位名称，用户携带的填写用户单位名称
     */
    @NotEmpty
    @Length(max=128)
    @Column(name = "sourceUnit")
    @ColumnTitle("来源单位")
    private String sourceunit;

    /**
     * 分配单位 IDC/ISP IDC/ISP经营者所持有IP的上级 的上级 分配单位:集团 /省公司 /市公司 市公司 市公司 分配的写集团 /省/市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 自己申请的写 ICANN ICANNICANNICANN、APNICAPNICAPNIC 或其他地址分配单位的名称
     */
    @NotEmpty
    @Length(max=128)
    @Column(name = "allocationU")
    @ColumnTitle("分配单位")
    private String allocationu;

    /**
     * 该IP段分配给使用人的时间或使用方式转变的时间，采用yyyy-MM-dd格式
     */
    @Column(name = "useTime")
    @ColumnTitle("该IP段分配给使用人的时间或使用方式转变的时间，采用yyyy-MM-dd格式")
    private Date usetime;

    /**
     * 目前有多个地方使用这个表，做一个使用地方的定义 1-机房对应IP段 2-服务器对应IP段
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("目前有多个地方使用这个表，做一个使用地方的定义")
    private String usertype;

    /**
     * 数据更新标识 0:已经上传1:新增2:修改 3:删除
     */
    @NotEmpty
    @ColumnTitle("数据更新标识")
    private boolean ftpstatus;

    /**
     * 所属占用机房
     */
    @ColumnTitle("所属占用机房")
    private Integer serverid;

    public static final String Property_Idtype = "idtype";

    public static final String Property_Startip = "startip";

    public static final String Property_Pendip = "pendip";

    public static final String Property_Usertype = "usertype";

    public static final String Property_Idnumber = "idnumber";

    public static final String Property_Type = "type";

    public static final String Property_Ftpstatus = "ftpstatus";

    public static final String Property_Endip = "endip";

    public static final String Property_Pstartip = "pstartip";

    public static final String Property_Serverid = "serverid";

    public static final String Property_Ipid = "ipid";

    public static final String Property_Allocationu = "allocationu";

    public static final String Property_Usetime = "usetime";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_User = "user";

    public static final String Property_Sourceunit = "sourceunit";

    /**
     * 获取IP地址段资源的编号，由ISMS定义，当前机房中唯一
     *
     * @return ipID - IP地址段资源的编号，由ISMS定义，当前机房中唯一
     */
    public int getIpid() {
        return ipid;
    }

    /**
     * 设置IP地址段资源的编号，由ISMS定义，当前机房中唯一
     *
     * @param ipid IP地址段资源的编号，由ISMS定义，当前机房中唯一
     */
    public void setIpid(int ipid) {
        addChangeField("ipid",this.ipid,ipid);
        this.ipid = ipid;
    }

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
     * 获取该地址段的起始IP地址
     *
     * @return startIP - 该地址段的起始IP地址
     */
    public String getStartip() {
        return startip;
    }

    /**
     * 设置该地址段的起始IP地址
     *
     * @param startip 该地址段的起始IP地址
     */
    public void setStartip(String startip) {
        addChangeField("startip",this.startip,startip);
        this.startip = startip;
    }

    /**
     * 获取该地址段的终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     *
     * @return endIP - 该地址段的终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     */
    public String getEndip() {
        return endip;
    }

    /**
     * 设置该地址段的终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     *
     * @param endip 该地址段的终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     */
    public void setEndip(String endip) {
        addChangeField("endip",this.endip,endip);
        this.endip = endip;
    }

    /**
     * 获取对应的私网起始IP地址
     *
     * @return pstartIP - 对应的私网起始IP地址
     */
    public String getPstartip() {
        return pstartip;
    }

    /**
     * 设置对应的私网起始IP地址
     *
     * @param pstartip 对应的私网起始IP地址
     */
    public void setPstartip(String pstartip) {
        addChangeField("pstartip",this.pstartip,pstartip);
        this.pstartip = pstartip;
    }

    /**
     * 获取对应的私网终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     *
     * @return pendIP - 对应的私网终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     */
    public String getPendip() {
        return pendip;
    }

    /**
     * 设置对应的私网终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     *
     * @param pendip 对应的私网终止IP地址，当起始IP地址与终止IP地址相同时，表示该地址段只有一个地址
     */
    public void setPendip(String pendip) {
        addChangeField("pendip",this.pendip,pendip);
        this.pendip = pendip;
    }

    /**
     * 获取IP地址使用方式，包括；0-静态；1-动态；2-保留。
     *
     * @return type - IP地址使用方式，包括；0-静态；1-动态；2-保留。
     */
    public String getType() {
        return type;
    }

    /**
     * 设置IP地址使用方式，包括；0-静态；1-动态；2-保留。
     *
     * @param type IP地址使用方式，包括；0-静态；1-动态；2-保留。
     */
    public void setType(String type) {
        addChangeField("type",this.type,type);
        this.type = type;
    }

    /**
     * 获取使用该IP段的单位名称，如果是个人需要填写姓名
     *
     * @return user - 使用该IP段的单位名称，如果是个人需要填写姓名
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置使用该IP段的单位名称，如果是个人需要填写姓名
     *
     * @param user 使用该IP段的单位名称，如果是个人需要填写姓名
     */
    public void setUser(String user) {
        addChangeField("user",this.user,user);
        this.user = user;
    }

    /**
     * 获取使用人的证件类型
     *
     * @return IDtype - 使用人的证件类型
     */
    public String getIdtype() {
        return idtype;
    }

    /**
     * 设置使用人的证件类型
     *
     * @param idtype 使用人的证件类型
     */
    public void setIdtype(String idtype) {
        addChangeField("idtype",this.idtype,idtype);
        this.idtype = idtype;
    }

    /**
     * 获取对应的使用人的证件号码
     *
     * @return IDnumber - 对应的使用人的证件号码
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * 设置对应的使用人的证件号码
     *
     * @param idnumber 对应的使用人的证件号码
     */
    public void setIdnumber(String idnumber) {
        addChangeField("idnumber",this.idnumber,idnumber);
        this.idnumber = idnumber;
    }

    /**
     * 获取来源单位 特定单个IP/IP段的来源，自有的填写自己的单位名称，用户携带的填写用户单位名称
     *
     * @return sourceUnit - 来源单位 特定单个IP/IP段的来源，自有的填写自己的单位名称，用户携带的填写用户单位名称
     */
    public String getSourceunit() {
        return sourceunit;
    }

    /**
     * 设置来源单位 特定单个IP/IP段的来源，自有的填写自己的单位名称，用户携带的填写用户单位名称
     *
     * @param sourceunit 来源单位 特定单个IP/IP段的来源，自有的填写自己的单位名称，用户携带的填写用户单位名称
     */
    public void setSourceunit(String sourceunit) {
        addChangeField("sourceunit",this.sourceunit,sourceunit);
        this.sourceunit = sourceunit;
    }

    /**
     * 获取分配单位 IDC/ISP IDC/ISP经营者所持有IP的上级 的上级 分配单位:集团 /省公司 /市公司 市公司 市公司 分配的写集团 /省/市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 自己申请的写 ICANN ICANNICANNICANN、APNICAPNICAPNIC 或其他地址分配单位的名称
     *
     * @return allocationU - 分配单位 IDC/ISP IDC/ISP经营者所持有IP的上级 的上级 分配单位:集团 /省公司 /市公司 市公司 市公司 分配的写集团 /省/市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 自己申请的写 ICANN ICANNICANNICANN、APNICAPNICAPNIC 或其他地址分配单位的名称
     */
    public String getAllocationu() {
        return allocationu;
    }

    /**
     * 设置分配单位 IDC/ISP IDC/ISP经营者所持有IP的上级 的上级 分配单位:集团 /省公司 /市公司 市公司 市公司 分配的写集团 /省/市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 自己申请的写 ICANN ICANNICANNICANN、APNICAPNICAPNIC 或其他地址分配单位的名称
     *
     * @param allocationu 分配单位 IDC/ISP IDC/ISP经营者所持有IP的上级 的上级 分配单位:集团 /省公司 /市公司 市公司 市公司 分配的写集团 /省/市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 市公司名称， 自己申请的写 ICANN ICANNICANNICANN、APNICAPNICAPNIC 或其他地址分配单位的名称
     */
    public void setAllocationu(String allocationu) {
        addChangeField("allocationu",this.allocationu,allocationu);
        this.allocationu = allocationu;
    }

    /**
     * 获取该IP段分配给使用人的时间或使用方式转变的时间，采用yyyy-MM-dd格式
     *
     * @return useTime - 该IP段分配给使用人的时间或使用方式转变的时间，采用yyyy-MM-dd格式
     */
    public Date getUsetime() {
        return usetime;
    }

    /**
     * 设置该IP段分配给使用人的时间或使用方式转变的时间，采用yyyy-MM-dd格式
     *
     * @param usetime 该IP段分配给使用人的时间或使用方式转变的时间，采用yyyy-MM-dd格式
     */
    public void setUsetime(Date usetime) {
        addChangeField("usetime",this.usetime,usetime);
        this.usetime = usetime;
    }

    /**
     * 获取目前有多个地方使用这个表，做一个使用地方的定义 1-机房对应IP段 2-服务器对应IP段
     *
     * @return usertype - 目前有多个地方使用这个表，做一个使用地方的定义 1-机房对应IP段 2-服务器对应IP段
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * 设置目前有多个地方使用这个表，做一个使用地方的定义 1-机房对应IP段 2-服务器对应IP段
     *
     * @param usertype 目前有多个地方使用这个表，做一个使用地方的定义 1-机房对应IP段 2-服务器对应IP段
     */
    public void setUsertype(String usertype) {
        addChangeField("usertype",this.usertype,usertype);
        this.usertype = usertype;
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
     * 获取所属占用机房
     *
     * @return serverid - 所属占用机房
     */
    public Integer getServerid() {
        return serverid;
    }

    /**
     * 设置所属占用机房
     *
     * @param serverid 所属占用机房
     */
    public void setServerid(Integer serverid) {
        addChangeField("serverid",this.serverid,serverid);
        this.serverid = serverid;
    }
}