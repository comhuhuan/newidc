package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismxb_gatewayinfo")
public class IsmxbGatewayInfoEntity extends StandardEntity {
    /**
     * 互联网出入口ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gatewayID")
    @ColumnTitle("互联网出入口ID")
    private int gatewayid;

    /**
     * 机房ID
     */
    @Id
    @NotEmpty
    @Length(max=32)
    @Column(name = "service_code")
    @ColumnTitle("机房ID")
    private String serviceCode;

    /**
     * 互联网出入口带宽
     */
    @NotEmpty
    @Length(max=10)
    @Column(name = "bandWidth")
    @ColumnTitle("互联网出入口带宽")
    private String bandwidth;

    /**
     * 链路类型 1-电信 2-联通 3-移动 4-铁通 9-其他 对应 ismsb_linktype表中的 linkType栏位
     */
    @NotEmpty
    @Column(name = "linkType")
    @ColumnTitle("链路类型")
    private Byte linktype;

    /**
     * 串链路接入单位名称 接入单位指为ISMS覆盖的业务链路的上联单位(为IDC/ISP经营者提供接入的接入单位)
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "accessUnit")
    @ColumnTitle("串链路接入单位名称")
    private String accessunit;

    /**
     * 互联网出入口网关IP地址
     */
    @NotEmpty
    @Length(max=64)
    @Column(name = "gatewayIP")
    @ColumnTitle("互联网出入口网关IP地址")
    private String gatewayip;

    /**
     * 数据更新标识 0:已经上传1:新增2:修改 3:删除
     */
    @NotEmpty
    @ColumnTitle("数据更新标识")
    private boolean ftpstatus;

    public static final String Property_Gatewayip = "gatewayip";

    public static final String Property_Gatewayid = "gatewayid";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Accessunit = "accessunit";

    public static final String Property_Ftpstatus = "ftpstatus";

    public static final String Property_Linktype = "linktype";

    public static final String Property_Bandwidth = "bandwidth";

    /**
     * 获取互联网出入口ID
     *
     * @return gatewayID - 互联网出入口ID
     */
    public int getGatewayid() {
        return gatewayid;
    }

    /**
     * 设置互联网出入口ID
     *
     * @param gatewayid 互联网出入口ID
     */
    public void setGatewayid(int gatewayid) {
        addChangeField("gatewayid",this.gatewayid,gatewayid);
        this.gatewayid = gatewayid;
    }

    /**
     * 获取机房ID
     *
     * @return service_code - 机房ID
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置机房ID
     *
     * @param serviceCode 机房ID
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * 获取互联网出入口带宽
     *
     * @return bandWidth - 互联网出入口带宽
     */
    public String getBandwidth() {
        return bandwidth;
    }

    /**
     * 设置互联网出入口带宽
     *
     * @param bandwidth 互联网出入口带宽
     */
    public void setBandwidth(String bandwidth) {
        addChangeField("bandwidth",this.bandwidth,bandwidth);
        this.bandwidth = bandwidth;
    }

    /**
     * 获取链路类型 1-电信 2-联通 3-移动 4-铁通 9-其他 对应 ismsb_linktype表中的 linkType栏位
     *
     * @return linkType - 链路类型 1-电信 2-联通 3-移动 4-铁通 9-其他 对应 ismsb_linktype表中的 linkType栏位
     */
    public Byte getLinktype() {
        return linktype;
    }

    /**
     * 设置链路类型 1-电信 2-联通 3-移动 4-铁通 9-其他 对应 ismsb_linktype表中的 linkType栏位
     *
     * @param linktype 链路类型 1-电信 2-联通 3-移动 4-铁通 9-其他 对应 ismsb_linktype表中的 linkType栏位
     */
    public void setLinktype(Byte linktype) {
        addChangeField("linktype",this.linktype,linktype);
        this.linktype = linktype;
    }

    /**
     * 获取串链路接入单位名称 接入单位指为ISMS覆盖的业务链路的上联单位(为IDC/ISP经营者提供接入的接入单位)
     *
     * @return accessUnit - 串链路接入单位名称 接入单位指为ISMS覆盖的业务链路的上联单位(为IDC/ISP经营者提供接入的接入单位)
     */
    public String getAccessunit() {
        return accessunit;
    }

    /**
     * 设置串链路接入单位名称 接入单位指为ISMS覆盖的业务链路的上联单位(为IDC/ISP经营者提供接入的接入单位)
     *
     * @param accessunit 串链路接入单位名称 接入单位指为ISMS覆盖的业务链路的上联单位(为IDC/ISP经营者提供接入的接入单位)
     */
    public void setAccessunit(String accessunit) {
        addChangeField("accessunit",this.accessunit,accessunit);
        this.accessunit = accessunit;
    }

    /**
     * 获取互联网出入口网关IP地址
     *
     * @return gatewayIP - 互联网出入口网关IP地址
     */
    public String getGatewayip() {
        return gatewayip;
    }

    /**
     * 设置互联网出入口网关IP地址
     *
     * @param gatewayip 互联网出入口网关IP地址
     */
    public void setGatewayip(String gatewayip) {
        addChangeField("gatewayip",this.gatewayip,gatewayip);
        this.gatewayip = gatewayip;
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
}