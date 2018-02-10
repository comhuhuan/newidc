package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsc_nofilterblackrule")
public class NofilterBlackRuleEntity extends StandardEntity {
    /**
     * 自增序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcCommandID")
    @ColumnTitle("自增序列号")
    private long idccommandid;

    /**
     * 指令ID
     */
    @Id
    @NotEmpty
    @Column(name = "commandId")
    @ColumnTitle("指令ID")
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
     * 数据类型 1- 免过滤 2-违法网站
     */
    @Id
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("数据类型")
    private String datatype;

    /**
     * 指令分类1-域名 2-IP
     */
    @Id
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("指令分类1-域名")
    private String type;

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
     * 内容的起始值,当类型是域名时则只记录在该栏位.
     */
    @Id
    @NotEmpty
    @Length(max=128)
    @Column(name = "valueStart")
    @ColumnTitle("内容的起始值,当类型是域名时则只记录在该栏位.")
    private String valuestart;

    /**
     * 应用策略ID
     */
    @NotEmpty
    @Column(name = "scheme_id")
    @ColumnTitle("应用策略ID")
    private long schemeId;

    /**
     * 内容的结束值,仅在则类型为IP时有效，目前模式下起始IP记录相同，当扩展为IP段时则为IP结束段
     */
    @Length(max=128)
    @Column(name = "valueEnd")
    @ColumnTitle("内容的结束值,仅在则类型为IP时有效，目前模式下起始IP记录相同，当扩展为IP段时则为IP结束段")
    private String valueend;

    /**
     * 执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败 
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("执行状态")
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
     * 0-默认模式socket、1-接口模式WS
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "deployMode")
    @ColumnTitle("0-默认模式socket、1-接口模式WS")
    private String deploymode;

    /**
     * 指令优先级
     */
    @NotEmpty
    @ColumnTitle("指令优先级")
    private int level;

    /**
     * '匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配'
     */
    @Length(max=20)
    @Column(name = "matchModel")
    @ColumnTitle("'匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配'")
    private String matchmodel;

    public static final String Property_Excstate = "excstate";

    public static final String Property_Unexcstate = "unexcstate";

    public static final String Property_Operationtype = "operationtype";

    public static final String Property_SchemeId = "schemeId";

    public static final String Property_Exctime = "exctime";

    public static final String Property_Deploymode = "deploymode";

    public static final String Property_Commandid = "commandid";

    public static final String Property_Idccommandid = "idccommandid";

    public static final String Property_Type = "type";

    public static final String Property_Valuestart = "valuestart";

    public static final String Property_Matchmodel = "matchmodel";

    public static final String Property_Level = "level";

    public static final String Property_Unexctime = "unexctime";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Datatype = "datatype";

    public static final String Property_Valueend = "valueend";

    /**
     * 获取自增序列号
     *
     * @return idcCommandID - 自增序列号
     */
    public long getIdccommandid() {
        return idccommandid;
    }

    /**
     * 设置自增序列号
     *
     * @param idccommandid 自增序列号
     */
    public void setIdccommandid(long idccommandid) {
        addChangeField("idccommandid",this.idccommandid,idccommandid);
        this.idccommandid = idccommandid;
    }

    /**
     * 获取指令ID
     *
     * @return commandId - 指令ID
     */
    public long getCommandid() {
        return commandid;
    }

    /**
     * 设置指令ID
     *
     * @param commandid 指令ID
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
     * 获取数据类型 1- 免过滤 2-违法网站
     *
     * @return datatype - 数据类型 1- 免过滤 2-违法网站
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * 设置数据类型 1- 免过滤 2-违法网站
     *
     * @param datatype 数据类型 1- 免过滤 2-违法网站
     */
    public void setDatatype(String datatype) {
        addChangeField("datatype",this.datatype,datatype);
        this.datatype = datatype;
    }

    /**
     * 获取指令分类1-域名 2-IP
     *
     * @return type - 指令分类1-域名 2-IP
     */
    public String getType() {
        return type;
    }

    /**
     * 设置指令分类1-域名 2-IP
     *
     * @param type 指令分类1-域名 2-IP
     */
    public void setType(String type) {
        addChangeField("type",this.type,type);
        this.type = type;
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
     * 获取内容的起始值,当类型是域名时则只记录在该栏位.
     *
     * @return valueStart - 内容的起始值,当类型是域名时则只记录在该栏位.
     */
    public String getValuestart() {
        return valuestart;
    }

    /**
     * 设置内容的起始值,当类型是域名时则只记录在该栏位.
     *
     * @param valuestart 内容的起始值,当类型是域名时则只记录在该栏位.
     */
    public void setValuestart(String valuestart) {
        addChangeField("valuestart",this.valuestart,valuestart);
        this.valuestart = valuestart;
    }

    /**
     * 获取应用策略ID
     *
     * @return scheme_id - 应用策略ID
     */
    public long getSchemeId() {
        return schemeId;
    }

    /**
     * 设置应用策略ID
     *
     * @param schemeId 应用策略ID
     */
    public void setSchemeId(long schemeId) {
        addChangeField("schemeId",this.schemeId,schemeId);
        this.schemeId = schemeId;
    }

    /**
     * 获取内容的结束值,仅在则类型为IP时有效，目前模式下起始IP记录相同，当扩展为IP段时则为IP结束段
     *
     * @return valueEnd - 内容的结束值,仅在则类型为IP时有效，目前模式下起始IP记录相同，当扩展为IP段时则为IP结束段
     */
    public String getValueend() {
        return valueend;
    }

    /**
     * 设置内容的结束值,仅在则类型为IP时有效，目前模式下起始IP记录相同，当扩展为IP段时则为IP结束段
     *
     * @param valueend 内容的结束值,仅在则类型为IP时有效，目前模式下起始IP记录相同，当扩展为IP段时则为IP结束段
     */
    public void setValueend(String valueend) {
        addChangeField("valueend",this.valueend,valueend);
        this.valueend = valueend;
    }

    /**
     * 获取执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败 
     *
     * @return excstate - 执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败 
     */
    public String getExcstate() {
        return excstate;
    }

    /**
     * 设置执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败 
     *
     * @param excstate 执行状态 1-等待下发 2-正在下发 3-下发成功 4-下发失败 
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
     * 获取0-默认模式socket、1-接口模式WS
     *
     * @return deployMode - 0-默认模式socket、1-接口模式WS
     */
    public String getDeploymode() {
        return deploymode;
    }

    /**
     * 设置0-默认模式socket、1-接口模式WS
     *
     * @param deploymode 0-默认模式socket、1-接口模式WS
     */
    public void setDeploymode(String deploymode) {
        addChangeField("deploymode",this.deploymode,deploymode);
        this.deploymode = deploymode;
    }

    /**
     * 获取指令优先级
     *
     * @return level - 指令优先级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 设置指令优先级
     *
     * @param level 指令优先级
     */
    public void setLevel(int level) {
        addChangeField("level",this.level,level);
        this.level = level;
    }

    /**
     * 获取'匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配'
     *
     * @return matchModel - '匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配'
     */
    public String getMatchmodel() {
        return matchmodel;
    }

    /**
     * 设置'匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配'
     *
     * @param matchmodel '匹配模式：approx-模糊匹配;exact-精确匹配;prefix-前缀匹配;suffix-后缀匹配'
     */
    public void setMatchmodel(String matchmodel) {
        addChangeField("matchmodel",this.matchmodel,matchmodel);
        this.matchmodel = matchmodel;
    }
}