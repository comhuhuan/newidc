package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsx_idcuserinfo")
public class IdcuserInfoEntity extends StandardEntity {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    @ColumnTitle("用户ID")
    private int userid;

    /**
     * 机房ID
     */
    @Id
    @NotEmpty
    @Length(max=128)
    @Column(name = "service_code")
    @ColumnTitle("机房ID")
    private String serviceCode;

    /**
     * 姓名
     */
    @NotEmpty
    @Length(max=32)
    @ColumnTitle("姓名")
    private String name;

    /**
     * 证件类型
     */
    @NotEmpty
    @Length(max=3)
    @Column(name = "IDtype")
    @ColumnTitle("证件类型")
    private String idtype;

    /**
     * 证件号码
     */
    @NotEmpty
    @Length(max=32)
    @Column(name = "ID")
    @ColumnTitle("证件号码")
    private String id;

    /**
     * 固定电话
     */
    @NotEmpty
    @Length(max=32)
    @ColumnTitle("固定电话")
    private String tel;

    /**
     * 移动电话
     */
    @NotEmpty
    @Length(max=32)
    @ColumnTitle("移动电话")
    private String mobile;

    /**
     * Email地址
     */
    @NotEmpty
    @Length(max=64)
    @Column(name = "Email")
    @ColumnTitle("Email地址")
    private String email;

    public static final String Property_Id = "id";

    public static final String Property_Email = "email";

    public static final String Property_Idtype = "idtype";

    public static final String Property_Tel = "tel";

    public static final String Property_Name = "name";

    public static final String Property_Userid = "userid";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Mobile = "mobile";

    /**
     * 获取用户ID
     *
     * @return userId - 用户ID
     */
    public int getUserid() {
        return userid;
    }

    /**
     * 设置用户ID
     *
     * @param userid 用户ID
     */
    public void setUserid(int userid) {
        addChangeField("userid",this.userid,userid);
        this.userid = userid;
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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        addChangeField("name",this.name,name);
        this.name = name;
    }

    /**
     * 获取证件类型
     *
     * @return IDtype - 证件类型
     */
    public String getIdtype() {
        return idtype;
    }

    /**
     * 设置证件类型
     *
     * @param idtype 证件类型
     */
    public void setIdtype(String idtype) {
        addChangeField("idtype",this.idtype,idtype);
        this.idtype = idtype;
    }

    /**
     * 获取证件号码
     *
     * @return ID - 证件号码
     */
    public String getId() {
        return id;
    }

    /**
     * 设置证件号码
     *
     * @param id 证件号码
     */
    public void setId(String id) {
        addChangeField("id",this.id,id);
        this.id = id;
    }

    /**
     * 获取固定电话
     *
     * @return tel - 固定电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置固定电话
     *
     * @param tel 固定电话
     */
    public void setTel(String tel) {
        addChangeField("tel",this.tel,tel);
        this.tel = tel;
    }

    /**
     * 获取移动电话
     *
     * @return mobile - 移动电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置移动电话
     *
     * @param mobile 移动电话
     */
    public void setMobile(String mobile) {
        addChangeField("mobile",this.mobile,mobile);
        this.mobile = mobile;
    }

    /**
     * 获取Email地址
     *
     * @return Email - Email地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置Email地址
     *
     * @param email Email地址
     */
    public void setEmail(String email) {
        addChangeField("email",this.email,email);
        this.email = email;
    }
}