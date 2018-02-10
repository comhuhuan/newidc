package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsx_idcbasicinfo")
public class IsmsxIdcBasicInfoEntity extends StandardEntity {
    /**
     * 经营者ID号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Length(max=128)
    @Column(name = "idcID")
    @ColumnTitle("经营者ID号")
    private String idcid;

    /**
     * 经营者名称，与许可证上名称一致
     */
    @NotEmpty
    @Length(max=128)
    @Column(name = "idcName")
    @ColumnTitle("经营者名称，与许可证上名称一致")
    private String idcname;

    /**
     * 经营者通信地址
     */
    @NotEmpty
    @Length(max=128)
    @Column(name = "idcAdd")
    @ColumnTitle("经营者通信地址")
    private String idcadd;

    /**
     * 对应经营者通信地址的邮编
     */
    @NotEmpty
    @Length(max=6)
    @Column(name = "idcZip")
    @ColumnTitle("对应经营者通信地址的邮编")
    private String idczip;

    /**
     * 企业法人
     */
    @NotEmpty
    @Length(max=128)
    @ColumnTitle("企业法人")
    private String corp;

    /**
     * 网络信息安全责任人信息: 关联信息人员表,存入ID号,多个用|线分隔
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "idcOfficer")
    @ColumnTitle("网络信息安全责任人信息:")
    private String idcofficer;

    /**
     * 应急联系人信息: 关联信息人员表,存入ID号,多个用|线分隔
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "emergencyContact")
    @ColumnTitle("应急联系人信息:")
    private String emergencycontact;

    /**
     * 生成时间
     */
    @NotEmpty
    @Column(name = "timeStamp")
    @ColumnTitle("生成时间")
    private Date timestamp;

    /**
     * 0为未发送过,1为发送过了
     */
    @NotEmpty
    @Column(name = "send_flag")
    @ColumnTitle("0为未发送过,1为发送过了")
    private int sendFlag;

    /**
     * 数据更新标识 0:已经上传1:新增2:修改 3:删除
     */
    @NotEmpty
    @ColumnTitle("数据更新标识")
    private int ftpstatus;

    /**
     * 未上报原因
     */
    @Length(max=65535)
    @ColumnTitle("未上报原因")
    private String msg;

    public static final String Property_SendFlag = "sendFlag";

    public static final String Property_Timestamp = "timestamp";

    public static final String Property_Idcofficer = "idcofficer";

    public static final String Property_Idcname = "idcname";

    public static final String Property_Idcid = "idcid";

    public static final String Property_Idczip = "idczip";

    public static final String Property_Idcadd = "idcadd";

    public static final String Property_Corp = "corp";

    public static final String Property_Msg = "msg";

    public static final String Property_Emergencycontact = "emergencycontact";

    public static final String Property_Ftpstatus = "ftpstatus";

    /**
     * 获取经营者ID号
     *
     * @return idcID - 经营者ID号
     */
    public String getIdcid() {
        return idcid;
    }

    /**
     * 设置经营者ID号
     *
     * @param idcid 经营者ID号
     */
    public void setIdcid(String idcid) {
        addChangeField("idcid",this.idcid,idcid);
        this.idcid = idcid;
    }

    /**
     * 获取经营者名称，与许可证上名称一致
     *
     * @return idcName - 经营者名称，与许可证上名称一致
     */
    public String getIdcname() {
        return idcname;
    }

    /**
     * 设置经营者名称，与许可证上名称一致
     *
     * @param idcname 经营者名称，与许可证上名称一致
     */
    public void setIdcname(String idcname) {
        addChangeField("idcname",this.idcname,idcname);
        this.idcname = idcname;
    }

    /**
     * 获取经营者通信地址
     *
     * @return idcAdd - 经营者通信地址
     */
    public String getIdcadd() {
        return idcadd;
    }

    /**
     * 设置经营者通信地址
     *
     * @param idcadd 经营者通信地址
     */
    public void setIdcadd(String idcadd) {
        addChangeField("idcadd",this.idcadd,idcadd);
        this.idcadd = idcadd;
    }

    /**
     * 获取对应经营者通信地址的邮编
     *
     * @return idcZip - 对应经营者通信地址的邮编
     */
    public String getIdczip() {
        return idczip;
    }

    /**
     * 设置对应经营者通信地址的邮编
     *
     * @param idczip 对应经营者通信地址的邮编
     */
    public void setIdczip(String idczip) {
        addChangeField("idczip",this.idczip,idczip);
        this.idczip = idczip;
    }

    /**
     * 获取企业法人
     *
     * @return corp - 企业法人
     */
    public String getCorp() {
        return corp;
    }

    /**
     * 设置企业法人
     *
     * @param corp 企业法人
     */
    public void setCorp(String corp) {
        addChangeField("corp",this.corp,corp);
        this.corp = corp;
    }

    /**
     * 获取网络信息安全责任人信息: 关联信息人员表,存入ID号,多个用|线分隔
     *
     * @return idcOfficer - 网络信息安全责任人信息: 关联信息人员表,存入ID号,多个用|线分隔
     */
    public String getIdcofficer() {
        return idcofficer;
    }

    /**
     * 设置网络信息安全责任人信息: 关联信息人员表,存入ID号,多个用|线分隔
     *
     * @param idcofficer 网络信息安全责任人信息: 关联信息人员表,存入ID号,多个用|线分隔
     */
    public void setIdcofficer(String idcofficer) {
        addChangeField("idcofficer",this.idcofficer,idcofficer);
        this.idcofficer = idcofficer;
    }

    /**
     * 获取应急联系人信息: 关联信息人员表,存入ID号,多个用|线分隔
     *
     * @return emergencyContact - 应急联系人信息: 关联信息人员表,存入ID号,多个用|线分隔
     */
    public String getEmergencycontact() {
        return emergencycontact;
    }

    /**
     * 设置应急联系人信息: 关联信息人员表,存入ID号,多个用|线分隔
     *
     * @param emergencycontact 应急联系人信息: 关联信息人员表,存入ID号,多个用|线分隔
     */
    public void setEmergencycontact(String emergencycontact) {
        addChangeField("emergencycontact",this.emergencycontact,emergencycontact);
        this.emergencycontact = emergencycontact;
    }

    /**
     * 获取生成时间
     *
     * @return timeStamp - 生成时间
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * 设置生成时间
     *
     * @param timestamp 生成时间
     */
    public void setTimestamp(Date timestamp) {
        addChangeField("timestamp",this.timestamp,timestamp);
        this.timestamp = timestamp;
    }

    /**
     * 获取0为未发送过,1为发送过了
     *
     * @return send_flag - 0为未发送过,1为发送过了
     */
    public int getSendFlag() {
        return sendFlag;
    }

    /**
     * 设置0为未发送过,1为发送过了
     *
     * @param sendFlag 0为未发送过,1为发送过了
     */
    public void setSendFlag(int sendFlag) {
        addChangeField("sendFlag",this.sendFlag,sendFlag);
        this.sendFlag = sendFlag;
    }

    /**
     * 获取数据更新标识 0:已经上传1:新增2:修改 3:删除
     *
     * @return ftpstatus - 数据更新标识 0:已经上传1:新增2:修改 3:删除
     */
    public int getFtpstatus() {
        return ftpstatus;
    }

    /**
     * 设置数据更新标识 0:已经上传1:新增2:修改 3:删除
     *
     * @param ftpstatus 数据更新标识 0:已经上传1:新增2:修改 3:删除
     */
    public void setFtpstatus(int ftpstatus) {
        addChangeField("ftpstatus",this.ftpstatus,ftpstatus);
        this.ftpstatus = ftpstatus;
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