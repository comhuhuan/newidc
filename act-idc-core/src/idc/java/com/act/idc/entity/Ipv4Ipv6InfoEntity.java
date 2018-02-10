package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ipv4_ipv6_info")
public class Ipv4Ipv6InfoEntity extends StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ipv4;

    @NotEmpty
    @Length(max=255)
    private String ipv6;

    /**
     * ����ʱ��
     */
    @NotEmpty
    @Column(name = "create_time")
    @ColumnTitle("����ʱ��")
    private Date createTime;

    /**
     * 0-δ����1-�Ѵ���
     */
    @NotEmpty
    @Column(name = "send_flag")
    @ColumnTitle("0-δ����1-�Ѵ���")
    private Byte sendFlag;

    public static final String Property_SendFlag = "sendFlag";

    public static final String Property_Ipv6 = "ipv6";

    public static final String Property_CreateTime = "createTime";

    public static final String Property_Ipv4 = "ipv4";

    /**
     * @return ipv4
     */
    public int getIpv4() {
        return ipv4;
    }

    /**
     * @param ipv4
     */
    public void setIpv4(int ipv4) {
        addChangeField("ipv4",this.ipv4,ipv4);
        this.ipv4 = ipv4;
    }

    /**
     * @return ipv6
     */
    public String getIpv6() {
        return ipv6;
    }

    /**
     * @param ipv6
     */
    public void setIpv6(String ipv6) {
        addChangeField("ipv6",this.ipv6,ipv6);
        this.ipv6 = ipv6;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return create_time - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���÷���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        addChangeField("createTime",this.createTime,createTime);
        this.createTime = createTime;
    }

    /**
     * ��ȡ0-δ����1-�Ѵ���
     *
     * @return send_flag - 0-δ����1-�Ѵ���
     */
    public Byte getSendFlag() {
        return sendFlag;
    }

    /**
     * ����0-δ����1-�Ѵ���
     *
     * @param sendFlag 0-δ����1-�Ѵ���
     */
    public void setSendFlag(Byte sendFlag) {
        addChangeField("sendFlag",this.sendFlag,sendFlag);
        this.sendFlag = sendFlag;
    }
}