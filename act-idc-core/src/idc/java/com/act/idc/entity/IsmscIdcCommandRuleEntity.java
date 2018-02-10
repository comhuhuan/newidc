package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsc_idccommandrule")
public class IsmscIdcCommandRuleEntity extends StandardEntity {
    /**
     * 管理指令文件序号
     */
    @Id
    @NotEmpty
    @Column(name = "idcCommandID")
    @ColumnTitle("管理指令文件序号")
    private long idccommandid;

    /**
     * 管理指令ID
     */
    @Id
    @NotEmpty
    @Column(name = "commandID")
    @ColumnTitle("管理指令ID")
    private long commandid;

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
     * 管理指令的类型：1-监测指令2-过滤指令3-病毒指令
     */
    @Id
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("管理指令的类型：1-监测指令2-过滤指令3-病毒指令")
    private String ctype;

    /**
     * 监测规则、过滤规则类型，见10.8节
     */
    @Id
    @NotEmpty
    @Length(max=3)
    @ColumnTitle("监测规则、过滤规则类型，见10.8节")
    private String subtype;

    /**
     * 操作类型 0-新增;1-删除
     */
    @Id
    @NotEmpty
    @Length(max=1)
    @Column(name = "operationType")
    @ColumnTitle("操作类型")
    private String operationtype;

    /**
     * 规则内容的起始值
     */
    @Id
    @NotEmpty
    @Length(max=1024)
    @Column(name = "valueStart")
    @ColumnTitle("规则内容的起始值")
    private String valuestart;

    /**
     * 应用策略编号
     */
    @Id
    @NotEmpty
    @Column(name = "scheme_id")
    @ColumnTitle("应用策略编号")
    private long schemeId;

    /**
     * 规则内容的结束值
     */
    @Length(max=1024)
    @Column(name = "valueEnd")
    @ColumnTitle("规则内容的结束值")
    private String valueend;

    /**
     * 关键词规则的匹配范围：0-正文标题及正文本身；1-附件标题；2-附件正文 
     */
    @Length(max=6)
    @Column(name = "keywordRange")
    @ColumnTitle("关键词规则的匹配范围：0-正文标题及正文本身；1-附件标题；2-附件正文")
    private String keywordrange;

    /**
     * 下发执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("下发执行状态")
    private String excstate;

    /**
     * 下发执行时间
     */
    @NotEmpty
    @ColumnTitle("下发执行时间")
    private Date exctime;

    /**
     * 取消执行状态 1-等待取消 2-正在取消 3-取消成功 4-取消失败 
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("取消执行状态")
    private String unexcstate;

    /**
     * 取消执行时间
     */
    @NotEmpty
    @ColumnTitle("取消执行时间")
    private Date unexctime;

    /**
     * 0-内部接口模式、1-外部接口模式
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "deployMode")
    @ColumnTitle("0-内部接口模式、1-外部接口模式")
    private String deploymode;

    /**
     * 消息编号
     */
    @NotEmpty
    @Column(name = "message_no")
    @ColumnTitle("消息编号")
    private long messageNo;

    /**
     * 消息序列号
     */
    @NotEmpty
    @Column(name = "message_sequence_no")
    @ColumnTitle("消息序列号")
    private long messageSequenceNo;

    /**
     * 本类消息的序列号
     */
    @NotEmpty
    @Column(name = "message_serial_no")
    @ColumnTitle("本类消息的序列号")
    private long messageSerialNo;

    /**
     * 匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配
     */
    @Length(max=20)
    @Column(name = "matchModel")
    @ColumnTitle("匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配")
    private String matchmodel;

    public static final String Property_Excstate = "excstate";

    public static final String Property_Unexcstate = "unexcstate";

    public static final String Property_Operationtype = "operationtype";

    public static final String Property_SchemeId = "schemeId";

    public static final String Property_MessageNo = "messageNo";

    public static final String Property_Exctime = "exctime";

    public static final String Property_Deploymode = "deploymode";

    public static final String Property_Commandid = "commandid";

    public static final String Property_Ctype = "ctype";

    public static final String Property_MessageSequenceNo = "messageSequenceNo";

    public static final String Property_Idccommandid = "idccommandid";

    public static final String Property_Keywordrange = "keywordrange";

    public static final String Property_Valuestart = "valuestart";

    public static final String Property_Matchmodel = "matchmodel";

    public static final String Property_Unexctime = "unexctime";

    public static final String Property_Subtype = "subtype";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Valueend = "valueend";

    public static final String Property_MessageSerialNo = "messageSerialNo";

    /**
     * 获取管理指令文件序号
     *
     * @return idcCommandID - 管理指令文件序号
     */
    public long getIdccommandid() {
        return idccommandid;
    }

    /**
     * 设置管理指令文件序号
     *
     * @param idccommandid 管理指令文件序号
     */
    public void setIdccommandid(long idccommandid) {
        addChangeField("idccommandid",this.idccommandid,idccommandid);
        this.idccommandid = idccommandid;
    }

    /**
     * 获取管理指令ID
     *
     * @return commandID - 管理指令ID
     */
    public long getCommandid() {
        return commandid;
    }

    /**
     * 设置管理指令ID
     *
     * @param commandid 管理指令ID
     */
    public void setCommandid(long commandid) {
        addChangeField("commandid",this.commandid,commandid);
        this.commandid = commandid;
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
     * 获取管理指令的类型：1-监测指令2-过滤指令3-病毒指令
     *
     * @return ctype - 管理指令的类型：1-监测指令2-过滤指令3-病毒指令
     */
    public String getCtype() {
        return ctype;
    }

    /**
     * 设置管理指令的类型：1-监测指令2-过滤指令3-病毒指令
     *
     * @param ctype 管理指令的类型：1-监测指令2-过滤指令3-病毒指令
     */
    public void setCtype(String ctype) {
        addChangeField("ctype",this.ctype,ctype);
        this.ctype = ctype;
    }

    /**
     * 获取监测规则、过滤规则类型，见10.8节
     *
     * @return subtype - 监测规则、过滤规则类型，见10.8节
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * 设置监测规则、过滤规则类型，见10.8节
     *
     * @param subtype 监测规则、过滤规则类型，见10.8节
     */
    public void setSubtype(String subtype) {
        addChangeField("subtype",this.subtype,subtype);
        this.subtype = subtype;
    }

    /**
     * 获取操作类型 0-新增;1-删除
     *
     * @return operationType - 操作类型 0-新增;1-删除
     */
    public String getOperationtype() {
        return operationtype;
    }

    /**
     * 设置操作类型 0-新增;1-删除
     *
     * @param operationtype 操作类型 0-新增;1-删除
     */
    public void setOperationtype(String operationtype) {
        addChangeField("operationtype",this.operationtype,operationtype);
        this.operationtype = operationtype;
    }

    /**
     * 获取规则内容的起始值
     *
     * @return valueStart - 规则内容的起始值
     */
    public String getValuestart() {
        return valuestart;
    }

    /**
     * 设置规则内容的起始值
     *
     * @param valuestart 规则内容的起始值
     */
    public void setValuestart(String valuestart) {
        addChangeField("valuestart",this.valuestart,valuestart);
        this.valuestart = valuestart;
    }

    /**
     * 获取应用策略编号
     *
     * @return scheme_id - 应用策略编号
     */
    public long getSchemeId() {
        return schemeId;
    }

    /**
     * 设置应用策略编号
     *
     * @param schemeId 应用策略编号
     */
    public void setSchemeId(long schemeId) {
        addChangeField("schemeId",this.schemeId,schemeId);
        this.schemeId = schemeId;
    }

    /**
     * 获取规则内容的结束值
     *
     * @return valueEnd - 规则内容的结束值
     */
    public String getValueend() {
        return valueend;
    }

    /**
     * 设置规则内容的结束值
     *
     * @param valueend 规则内容的结束值
     */
    public void setValueend(String valueend) {
        addChangeField("valueend",this.valueend,valueend);
        this.valueend = valueend;
    }

    /**
     * 获取关键词规则的匹配范围：0-正文标题及正文本身；1-附件标题；2-附件正文 
     *
     * @return keywordRange - 关键词规则的匹配范围：0-正文标题及正文本身；1-附件标题；2-附件正文 
     */
    public String getKeywordrange() {
        return keywordrange;
    }

    /**
     * 设置关键词规则的匹配范围：0-正文标题及正文本身；1-附件标题；2-附件正文 
     *
     * @param keywordrange 关键词规则的匹配范围：0-正文标题及正文本身；1-附件标题；2-附件正文 
     */
    public void setKeywordrange(String keywordrange) {
        addChangeField("keywordrange",this.keywordrange,keywordrange);
        this.keywordrange = keywordrange;
    }

    /**
     * 获取下发执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败
     *
     * @return excstate - 下发执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败
     */
    public String getExcstate() {
        return excstate;
    }

    /**
     * 设置下发执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败
     *
     * @param excstate 下发执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败
     */
    public void setExcstate(String excstate) {
        addChangeField("excstate",this.excstate,excstate);
        this.excstate = excstate;
    }

    /**
     * 获取下发执行时间
     *
     * @return exctime - 下发执行时间
     */
    public Date getExctime() {
        return exctime;
    }

    /**
     * 设置下发执行时间
     *
     * @param exctime 下发执行时间
     */
    public void setExctime(Date exctime) {
        addChangeField("exctime",this.exctime,exctime);
        this.exctime = exctime;
    }

    /**
     * 获取取消执行状态 1-等待取消 2-正在取消 3-取消成功 4-取消失败 
     *
     * @return unexcstate - 取消执行状态 1-等待取消 2-正在取消 3-取消成功 4-取消失败 
     */
    public String getUnexcstate() {
        return unexcstate;
    }

    /**
     * 设置取消执行状态 1-等待取消 2-正在取消 3-取消成功 4-取消失败 
     *
     * @param unexcstate 取消执行状态 1-等待取消 2-正在取消 3-取消成功 4-取消失败 
     */
    public void setUnexcstate(String unexcstate) {
        addChangeField("unexcstate",this.unexcstate,unexcstate);
        this.unexcstate = unexcstate;
    }

    /**
     * 获取取消执行时间
     *
     * @return unexctime - 取消执行时间
     */
    public Date getUnexctime() {
        return unexctime;
    }

    /**
     * 设置取消执行时间
     *
     * @param unexctime 取消执行时间
     */
    public void setUnexctime(Date unexctime) {
        addChangeField("unexctime",this.unexctime,unexctime);
        this.unexctime = unexctime;
    }

    /**
     * 获取0-内部接口模式、1-外部接口模式
     *
     * @return deployMode - 0-内部接口模式、1-外部接口模式
     */
    public String getDeploymode() {
        return deploymode;
    }

    /**
     * 设置0-内部接口模式、1-外部接口模式
     *
     * @param deploymode 0-内部接口模式、1-外部接口模式
     */
    public void setDeploymode(String deploymode) {
        addChangeField("deploymode",this.deploymode,deploymode);
        this.deploymode = deploymode;
    }

    /**
     * 获取消息编号
     *
     * @return message_no - 消息编号
     */
    public long getMessageNo() {
        return messageNo;
    }

    /**
     * 设置消息编号
     *
     * @param messageNo 消息编号
     */
    public void setMessageNo(long messageNo) {
        addChangeField("messageNo",this.messageNo,messageNo);
        this.messageNo = messageNo;
    }

    /**
     * 获取消息序列号
     *
     * @return message_sequence_no - 消息序列号
     */
    public long getMessageSequenceNo() {
        return messageSequenceNo;
    }

    /**
     * 设置消息序列号
     *
     * @param messageSequenceNo 消息序列号
     */
    public void setMessageSequenceNo(long messageSequenceNo) {
        addChangeField("messageSequenceNo",this.messageSequenceNo,messageSequenceNo);
        this.messageSequenceNo = messageSequenceNo;
    }

    /**
     * 获取本类消息的序列号
     *
     * @return message_serial_no - 本类消息的序列号
     */
    public long getMessageSerialNo() {
        return messageSerialNo;
    }

    /**
     * 设置本类消息的序列号
     *
     * @param messageSerialNo 本类消息的序列号
     */
    public void setMessageSerialNo(long messageSerialNo) {
        addChangeField("messageSerialNo",this.messageSerialNo,messageSerialNo);
        this.messageSerialNo = messageSerialNo;
    }

    /**
     * 获取匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配
     *
     * @return matchModel - 匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配
     */
    public String getMatchmodel() {
        return matchmodel;
    }

    /**
     * 设置匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配
     *
     * @param matchmodel 匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配
     */
    public void setMatchmodel(String matchmodel) {
        addChangeField("matchmodel",this.matchmodel,matchmodel);
        this.matchmodel = matchmodel;
    }
}