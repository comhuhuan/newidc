package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsx_isstopsign")
public class IsmsxIsstopsignEntity extends StandardEntity {
    /**
     * 上传自增ID号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnTitle("上传自增ID号")
    private int id;

    /**
     * 处置对应策略号
     */
    @NotEmpty
    @Column(name = "scheme_id")
    @ColumnTitle("处置对应策略号")
    private long schemeId;

    /**
     * 机房编号
     */
    @NotEmpty
    @Length(max=18)
    @Column(name = "service_code")
    @ColumnTitle("机房编号")
    private String serviceCode;

    /**
     * 操作用户ID号,如果是管局侧—smcs 系统内- sys 其他系统—具体定义
     */
    @NotEmpty
    @Length(max=32)
    @ColumnTitle("操作用户ID号,如果是管局侧—smcs")
    private String userid;

    /**
     * 操作类型  1-一级域名操作 2-二级域名操作 3-IP(ip段)操作 4-URL地址 5-协议 6-端口(段) 7ip+port 8domain+ip 9domain+port
     */
    @NotEmpty
    @ColumnTitle("操作类型")
    private boolean utype;

    /**
     * 操作的具体内容
     */
    @NotEmpty
    @Length(max=1024)
    @ColumnTitle("操作的具体内容")
    private String content;

    /**
     * 0.过滤->未过滤(取消封堵) 1.未过滤->过滤（封堵） 2.没有变化(用于处理不成功的操作) 
     */
    @NotEmpty
    @ColumnTitle("0.过滤->未过滤(取消封堵)")
    private boolean stopsign;

    /**
     * 操作用户的IP地址,系统内操作默认127.0.0.1
     */
    @NotEmpty
    @Length(max=255)
    @ColumnTitle("操作用户的IP地址,系统内操作默认127.0.0.1")
    private String userip;

    /**
     * 操作时间
     */
    @NotEmpty
    @Column(name = "cur_time")
    @ColumnTitle("操作时间")
    private Date curTime;

    /**
     * 0为未发送过，1为发送过了
     */
    @NotEmpty
    @Column(name = "send_flag")
    @ColumnTitle("0为未发送过，1为发送过了")
    private boolean sendFlag;

    /**
     * 发送的命令号
     */
    @Length(max=8)
    @ColumnTitle("发送的命令号")
    private String cmd;

    /**
     * 私网IP
     */
    @Length(max=64)
    @Column(name = "local_ip")
    @ColumnTitle("私网IP")
    private String localIp;

    /**
     * 私网MAC
     */
    @Length(max=64)
    @Column(name = "local_mac")
    @ColumnTitle("私网MAC")
    private String localMac;

    /**
     * 私网机器名
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "local_machine")
    @ColumnTitle("私网机器名")
    private String localMachine;

    public static final String Property_SendFlag = "sendFlag";

    public static final String Property_SchemeId = "schemeId";

    public static final String Property_Userid = "userid";

    public static final String Property_CurTime = "curTime";

    public static final String Property_LocalMac = "localMac";

    public static final String Property_Utype = "utype";

    public static final String Property_Id = "id";

    public static final String Property_Content = "content";

    public static final String Property_Cmd = "cmd";

    public static final String Property_LocalMachine = "localMachine";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Userip = "userip";

    public static final String Property_Stopsign = "stopsign";

    public static final String Property_LocalIp = "localIp";

    /**
     * 获取上传自增ID号
     *
     * @return id - 上传自增ID号
     */
    public int getId() {
        return id;
    }

    /**
     * 设置上传自增ID号
     *
     * @param id 上传自增ID号
     */
    public void setId(int id) {
        addChangeField("id",this.id,id);
        this.id = id;
    }

    /**
     * 获取处置对应策略号
     *
     * @return scheme_id - 处置对应策略号
     */
    public long getSchemeId() {
        return schemeId;
    }

    /**
     * 设置处置对应策略号
     *
     * @param schemeId 处置对应策略号
     */
    public void setSchemeId(long schemeId) {
        addChangeField("schemeId",this.schemeId,schemeId);
        this.schemeId = schemeId;
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
     * 获取操作用户ID号,如果是管局侧—smcs 系统内- sys 其他系统—具体定义
     *
     * @return userid - 操作用户ID号,如果是管局侧—smcs 系统内- sys 其他系统—具体定义
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置操作用户ID号,如果是管局侧—smcs 系统内- sys 其他系统—具体定义
     *
     * @param userid 操作用户ID号,如果是管局侧—smcs 系统内- sys 其他系统—具体定义
     */
    public void setUserid(String userid) {
        addChangeField("userid",this.userid,userid);
        this.userid = userid;
    }

    /**
     * 获取操作类型  1-一级域名操作 2-二级域名操作 3-IP(ip段)操作 4-URL地址 5-协议 6-端口(段) 7ip+port 8domain+ip 9domain+port
     *
     * @return utype - 操作类型  1-一级域名操作 2-二级域名操作 3-IP(ip段)操作 4-URL地址 5-协议 6-端口(段) 7ip+port 8domain+ip 9domain+port
     */
    public boolean getUtype() {
        return utype;
    }

    /**
     * 设置操作类型  1-一级域名操作 2-二级域名操作 3-IP(ip段)操作 4-URL地址 5-协议 6-端口(段) 7ip+port 8domain+ip 9domain+port
     *
     * @param utype 操作类型  1-一级域名操作 2-二级域名操作 3-IP(ip段)操作 4-URL地址 5-协议 6-端口(段) 7ip+port 8domain+ip 9domain+port
     */
    public void setUtype(boolean utype) {
        addChangeField("utype",this.utype,utype);
        this.utype = utype;
    }

    /**
     * 获取操作的具体内容
     *
     * @return content - 操作的具体内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置操作的具体内容
     *
     * @param content 操作的具体内容
     */
    public void setContent(String content) {
        addChangeField("content",this.content,content);
        this.content = content;
    }

    /**
     * 获取0.过滤->未过滤(取消封堵) 1.未过滤->过滤（封堵） 2.没有变化(用于处理不成功的操作) 
     *
     * @return stopsign - 0.过滤->未过滤(取消封堵) 1.未过滤->过滤（封堵） 2.没有变化(用于处理不成功的操作) 
     */
    public boolean getStopsign() {
        return stopsign;
    }

    /**
     * 设置0.过滤->未过滤(取消封堵) 1.未过滤->过滤（封堵） 2.没有变化(用于处理不成功的操作) 
     *
     * @param stopsign 0.过滤->未过滤(取消封堵) 1.未过滤->过滤（封堵） 2.没有变化(用于处理不成功的操作) 
     */
    public void setStopsign(boolean stopsign) {
        addChangeField("stopsign",this.stopsign,stopsign);
        this.stopsign = stopsign;
    }

    /**
     * 获取操作用户的IP地址,系统内操作默认127.0.0.1
     *
     * @return userip - 操作用户的IP地址,系统内操作默认127.0.0.1
     */
    public String getUserip() {
        return userip;
    }

    /**
     * 设置操作用户的IP地址,系统内操作默认127.0.0.1
     *
     * @param userip 操作用户的IP地址,系统内操作默认127.0.0.1
     */
    public void setUserip(String userip) {
        addChangeField("userip",this.userip,userip);
        this.userip = userip;
    }

    /**
     * 获取操作时间
     *
     * @return cur_time - 操作时间
     */
    public Date getCurTime() {
        return curTime;
    }

    /**
     * 设置操作时间
     *
     * @param curTime 操作时间
     */
    public void setCurTime(Date curTime) {
        addChangeField("curTime",this.curTime,curTime);
        this.curTime = curTime;
    }

    /**
     * 获取0为未发送过，1为发送过了
     *
     * @return send_flag - 0为未发送过，1为发送过了
     */
    public boolean getSendFlag() {
        return sendFlag;
    }

    /**
     * 设置0为未发送过，1为发送过了
     *
     * @param sendFlag 0为未发送过，1为发送过了
     */
    public void setSendFlag(boolean sendFlag) {
        addChangeField("sendFlag",this.sendFlag,sendFlag);
        this.sendFlag = sendFlag;
    }

    /**
     * 获取发送的命令号
     *
     * @return cmd - 发送的命令号
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * 设置发送的命令号
     *
     * @param cmd 发送的命令号
     */
    public void setCmd(String cmd) {
        addChangeField("cmd",this.cmd,cmd);
        this.cmd = cmd;
    }

    /**
     * 获取私网IP
     *
     * @return local_ip - 私网IP
     */
    public String getLocalIp() {
        return localIp;
    }

    /**
     * 设置私网IP
     *
     * @param localIp 私网IP
     */
    public void setLocalIp(String localIp) {
        addChangeField("localIp",this.localIp,localIp);
        this.localIp = localIp;
    }

    /**
     * 获取私网MAC
     *
     * @return local_mac - 私网MAC
     */
    public String getLocalMac() {
        return localMac;
    }

    /**
     * 设置私网MAC
     *
     * @param localMac 私网MAC
     */
    public void setLocalMac(String localMac) {
        addChangeField("localMac",this.localMac,localMac);
        this.localMac = localMac;
    }

    /**
     * 获取私网机器名
     *
     * @return local_machine - 私网机器名
     */
    public String getLocalMachine() {
        return localMachine;
    }

    /**
     * 设置私网机器名
     *
     * @param localMachine 私网机器名
     */
    public void setLocalMachine(String localMachine) {
        addChangeField("localMachine",this.localMachine,localMachine);
        this.localMachine = localMachine;
    }
}