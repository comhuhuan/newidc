package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "res_cabinets")
public class ResCabinetsEntity extends StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabid;

    /**
     * 机房编号
     */
    @NotEmpty
    @Length(max=18)
    @Column(name = "service_code")
    @ColumnTitle("机房编号")
    private String serviceCode;

    @NotEmpty
    @Length(max=125)
    private String cabcode;

    @NotEmpty
    @Length(max=125)
    private String cabname;

    @NotEmpty
    @Length(max=255)
    private String cabremark;

    /**
     * 机柜在机房内的物理位置
     */
    @NotEmpty
    @Length(max=128)
    @Column(name = "cabLocation")
    @ColumnTitle("机柜在机房内的物理位置")
    private String cablocation;

    @NotEmpty
    private int roomid;

    /**
     * 机柜容量
     */
    @NotEmpty
    @ColumnTitle("机柜容量")
    private int units;

    /**
     * 机柜所属客户
     */
    @NotEmpty
    @ColumnTitle("机柜所属客户")
    private int custid;

    /**
     * 机架柜型号
     */
    @NotEmpty
    @Length(max=50)
    @ColumnTitle("机架柜型号")
    private String model;

    /**
     * 分配状态 0-未分配 1-已分配
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "assign_status")
    @ColumnTitle("分配状态")
    private String assignStatus;

    /**
     * 使用类型 1-自用2-出租
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("使用类型")
    private String usetype;

    /**
     * 机架位数
     */
    @NotEmpty
    @Column(name = "position_num")
    @ColumnTitle("机架位数")
    private Byte positionNum;

    /**
     * 0:空;1:预留;2:占用
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("0:空;1:预留;2:占用")
    private String status;

    @Length(max=20)
    private String orderid;

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

    public static final String Property_Model = "model";

    public static final String Property_Status = "status";

    public static final String Property_Usetype = "usetype";

    public static final String Property_Cabname = "cabname";

    public static final String Property_Cabremark = "cabremark";

    public static final String Property_Units = "units";

    public static final String Property_Ftpstatus = "ftpstatus";

    public static final String Property_Roomid = "roomid";

    public static final String Property_PositionNum = "positionNum";

    public static final String Property_Cabid = "cabid";

    public static final String Property_Cabcode = "cabcode";

    public static final String Property_Cablocation = "cablocation";

    public static final String Property_AssignStatus = "assignStatus";

    public static final String Property_Ismstip = "ismstip";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Orderid = "orderid";

    public static final String Property_Custid = "custid";

    /**
     * @return cabid
     */
    public int getCabid() {
        return cabid;
    }

    /**
     * @param cabid
     */
    public void setCabid(int cabid) {
        addChangeField("cabid",this.cabid,cabid);
        this.cabid = cabid;
    }

    /**
     * 获取机房编号
     *
     * @return service_code - 机房编号
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置机房编号
     *
     * @param serviceCode 机房编号
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * @return cabcode
     */
    public String getCabcode() {
        return cabcode;
    }

    /**
     * @param cabcode
     */
    public void setCabcode(String cabcode) {
        addChangeField("cabcode",this.cabcode,cabcode);
        this.cabcode = cabcode;
    }

    /**
     * @return cabname
     */
    public String getCabname() {
        return cabname;
    }

    /**
     * @param cabname
     */
    public void setCabname(String cabname) {
        addChangeField("cabname",this.cabname,cabname);
        this.cabname = cabname;
    }

    /**
     * @return cabremark
     */
    public String getCabremark() {
        return cabremark;
    }

    /**
     * @param cabremark
     */
    public void setCabremark(String cabremark) {
        addChangeField("cabremark",this.cabremark,cabremark);
        this.cabremark = cabremark;
    }

    /**
     * 获取机柜在机房内的物理位置
     *
     * @return cabLocation - 机柜在机房内的物理位置
     */
    public String getCablocation() {
        return cablocation;
    }

    /**
     * 设置机柜在机房内的物理位置
     *
     * @param cablocation 机柜在机房内的物理位置
     */
    public void setCablocation(String cablocation) {
        addChangeField("cablocation",this.cablocation,cablocation);
        this.cablocation = cablocation;
    }

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
     * 获取机柜容量
     *
     * @return units - 机柜容量
     */
    public int getUnits() {
        return units;
    }

    /**
     * 设置机柜容量
     *
     * @param units 机柜容量
     */
    public void setUnits(int units) {
        addChangeField("units",this.units,units);
        this.units = units;
    }

    /**
     * 获取机柜所属客户
     *
     * @return custid - 机柜所属客户
     */
    public int getCustid() {
        return custid;
    }

    /**
     * 设置机柜所属客户
     *
     * @param custid 机柜所属客户
     */
    public void setCustid(int custid) {
        addChangeField("custid",this.custid,custid);
        this.custid = custid;
    }

    /**
     * 获取机架柜型号
     *
     * @return model - 机架柜型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置机架柜型号
     *
     * @param model 机架柜型号
     */
    public void setModel(String model) {
        addChangeField("model",this.model,model);
        this.model = model;
    }

    /**
     * 获取分配状态 0-未分配 1-已分配
     *
     * @return assign_status - 分配状态 0-未分配 1-已分配
     */
    public String getAssignStatus() {
        return assignStatus;
    }

    /**
     * 设置分配状态 0-未分配 1-已分配
     *
     * @param assignStatus 分配状态 0-未分配 1-已分配
     */
    public void setAssignStatus(String assignStatus) {
        addChangeField("assignStatus",this.assignStatus,assignStatus);
        this.assignStatus = assignStatus;
    }

    /**
     * 获取使用类型 1-自用2-出租
     *
     * @return usetype - 使用类型 1-自用2-出租
     */
    public String getUsetype() {
        return usetype;
    }

    /**
     * 设置使用类型 1-自用2-出租
     *
     * @param usetype 使用类型 1-自用2-出租
     */
    public void setUsetype(String usetype) {
        addChangeField("usetype",this.usetype,usetype);
        this.usetype = usetype;
    }

    /**
     * 获取机架位数
     *
     * @return position_num - 机架位数
     */
    public Byte getPositionNum() {
        return positionNum;
    }

    /**
     * 设置机架位数
     *
     * @param positionNum 机架位数
     */
    public void setPositionNum(Byte positionNum) {
        addChangeField("positionNum",this.positionNum,positionNum);
        this.positionNum = positionNum;
    }

    /**
     * 获取0:空;1:预留;2:占用
     *
     * @return status - 0:空;1:预留;2:占用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置0:空;1:预留;2:占用
     *
     * @param status 0:空;1:预留;2:占用
     */
    public void setStatus(String status) {
        addChangeField("status",this.status,status);
        this.status = status;
    }

    /**
     * @return orderid
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * @param orderid
     */
    public void setOrderid(String orderid) {
        addChangeField("orderid",this.orderid,orderid);
        this.orderid = orderid;
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