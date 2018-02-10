package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "res_rooms")
public class ResRoomsEntity extends StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomid;

    /**
     * 机房ID号
     */
    @NotEmpty
    @Length(max=32)
    @Column(name = "service_code")
    @ColumnTitle("机房ID号")
    private String serviceCode;

    /**
     * 机房片区编号
     */
    @NotEmpty
    @Length(max=128)
    @ColumnTitle("机房片区编号")
    private String roomcode;

    /**
     * 机房片区名称
     */
    @NotEmpty
    @Length(max=128)
    @ColumnTitle("机房片区名称")
    private String roomname;

    /**
     * 所在区域
     */
    @NotEmpty
    @Length(max=6)
    @Column(name = "area_code")
    @ColumnTitle("所在区域")
    private String areaCode;

    /**
     * 联系人
     */
    @NotEmpty
    @Length(max=20)
    @ColumnTitle("联系人")
    private String contact;

    /**
     * 联系电话
     */
    @NotEmpty
    @Length(max=30)
    @ColumnTitle("联系电话")
    private String tel;

    /**
     * 手机号
     */
    @NotEmpty
    @Length(max=30)
    @ColumnTitle("手机号")
    private String mobile;

    /**
     * 及时通
     */
    @NotEmpty
    @Length(max=255)
    @ColumnTitle("及时通")
    private String qqmsn;

    /**
     * 出件地址
     */
    @NotEmpty
    @Length(max=100)
    @ColumnTitle("出件地址")
    private String email;

    /**
     * 建筑面积-单位(平方米)
     */
    @NotEmpty
    @Column(name = "cons_area")
    @ColumnTitle("建筑面积-单位(平方米)")
    private int consArea;

    /**
     * 楼层ID
     */
    @NotEmpty
    @Length(max=5)
    @Column(name = "floorId")
    @ColumnTitle("楼层ID")
    private String floorid;

    /**
     * 机柜总行数
     */
    @NotEmpty
    @Length(max=10)
    @Column(name = "frameX")
    @ColumnTitle("机柜总行数")
    private String framex;

    /**
     * 机柜总列数
     */
    @NotEmpty
    @Length(max=10)
    @Column(name = "frameY")
    @ColumnTitle("机柜总列数")
    private String framey;

    @NotEmpty
    @Length(max=255)
    private String remark;

    /**
     * 0为未发送过，1为发送过了
     */
    @NotEmpty
    @Column(name = "send_flag")
    @ColumnTitle("0为未发送过，1为发送过了")
    private Byte sendFlag;

    /**
     * 数据更新标识 0:已经上传1:新增2:修改 3:删除
     */
    @NotEmpty
    @ColumnTitle("数据更新标识")
    private boolean ftpstatus;

    /**
     * 0-不符合上传要求 1-符合上传要求
     */
    @NotEmpty
    @ColumnTitle("0-不符合上传要求")
    private boolean ismstip;

    public static final String Property_SendFlag = "sendFlag";

    public static final String Property_Qqmsn = "qqmsn";

    public static final String Property_Remark = "remark";

    public static final String Property_AreaCode = "areaCode";

    public static final String Property_Tel = "tel";

    public static final String Property_Contact = "contact";

    public static final String Property_Ftpstatus = "ftpstatus";

    public static final String Property_Roomid = "roomid";

    public static final String Property_Roomname = "roomname";

    public static final String Property_ConsArea = "consArea";

    public static final String Property_Email = "email";

    public static final String Property_Framex = "framex";

    public static final String Property_Ismstip = "ismstip";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Floorid = "floorid";

    public static final String Property_Roomcode = "roomcode";

    public static final String Property_Framey = "framey";

    public static final String Property_Mobile = "mobile";

    /**
     * @return roomid
     */
    public int getRoomid() {
        return roomid;
    }

    /**
     * @param roomid
     */
    public void setRoomid(int roomid) {
        addChangeField("roomid",this.roomid,roomid);
        this.roomid = roomid;
    }

    /**
     * 获取机房ID号
     *
     * @return service_code - 机房ID号
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置机房ID号
     *
     * @param serviceCode 机房ID号
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * 获取机房片区编号
     *
     * @return roomcode - 机房片区编号
     */
    public String getRoomcode() {
        return roomcode;
    }

    /**
     * 设置机房片区编号
     *
     * @param roomcode 机房片区编号
     */
    public void setRoomcode(String roomcode) {
        addChangeField("roomcode",this.roomcode,roomcode);
        this.roomcode = roomcode;
    }

    /**
     * 获取机房片区名称
     *
     * @return roomname - 机房片区名称
     */
    public String getRoomname() {
        return roomname;
    }

    /**
     * 设置机房片区名称
     *
     * @param roomname 机房片区名称
     */
    public void setRoomname(String roomname) {
        addChangeField("roomname",this.roomname,roomname);
        this.roomname = roomname;
    }

    /**
     * 获取所在区域
     *
     * @return area_code - 所在区域
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置所在区域
     *
     * @param areaCode 所在区域
     */
    public void setAreaCode(String areaCode) {
        addChangeField("areaCode",this.areaCode,areaCode);
        this.areaCode = areaCode;
    }

    /**
     * 获取联系人
     *
     * @return contact - 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact) {
        addChangeField("contact",this.contact,contact);
        this.contact = contact;
    }

    /**
     * 获取联系电话
     *
     * @return tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        addChangeField("tel",this.tel,tel);
        this.tel = tel;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        addChangeField("mobile",this.mobile,mobile);
        this.mobile = mobile;
    }

    /**
     * 获取及时通
     *
     * @return qqmsn - 及时通
     */
    public String getQqmsn() {
        return qqmsn;
    }

    /**
     * 设置及时通
     *
     * @param qqmsn 及时通
     */
    public void setQqmsn(String qqmsn) {
        addChangeField("qqmsn",this.qqmsn,qqmsn);
        this.qqmsn = qqmsn;
    }

    /**
     * 获取出件地址
     *
     * @return email - 出件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置出件地址
     *
     * @param email 出件地址
     */
    public void setEmail(String email) {
        addChangeField("email",this.email,email);
        this.email = email;
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
     * 获取楼层ID
     *
     * @return floorId - 楼层ID
     */
    public String getFloorid() {
        return floorid;
    }

    /**
     * 设置楼层ID
     *
     * @param floorid 楼层ID
     */
    public void setFloorid(String floorid) {
        addChangeField("floorid",this.floorid,floorid);
        this.floorid = floorid;
    }

    /**
     * 获取机柜总行数
     *
     * @return frameX - 机柜总行数
     */
    public String getFramex() {
        return framex;
    }

    /**
     * 设置机柜总行数
     *
     * @param framex 机柜总行数
     */
    public void setFramex(String framex) {
        addChangeField("framex",this.framex,framex);
        this.framex = framex;
    }

    /**
     * 获取机柜总列数
     *
     * @return frameY - 机柜总列数
     */
    public String getFramey() {
        return framey;
    }

    /**
     * 设置机柜总列数
     *
     * @param framey 机柜总列数
     */
    public void setFramey(String framey) {
        addChangeField("framey",this.framey,framey);
        this.framey = framey;
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
     * 获取0为未发送过，1为发送过了
     *
     * @return send_flag - 0为未发送过，1为发送过了
     */
    public Byte getSendFlag() {
        return sendFlag;
    }

    /**
     * 设置0为未发送过，1为发送过了
     *
     * @param sendFlag 0为未发送过，1为发送过了
     */
    public void setSendFlag(Byte sendFlag) {
        addChangeField("sendFlag",this.sendFlag,sendFlag);
        this.sendFlag = sendFlag;
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
     * 获取0-不符合上传要求 1-符合上传要求
     *
     * @return ismstip - 0-不符合上传要求 1-符合上传要求
     */
    public boolean getIsmstip() {
        return ismstip;
    }

    /**
     * 设置0-不符合上传要求 1-符合上传要求
     *
     * @param ismstip 0-不符合上传要求 1-符合上传要求
     */
    public void setIsmstip(boolean ismstip) {
        addChangeField("ismstip",this.ismstip,ismstip);
        this.ismstip = ismstip;
    }
}