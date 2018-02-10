package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ismsc_idccommand")
public class IsmscIdcCommandEntity extends StandardEntity {
    /**
     * 管理指令文件序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 管理指令的类型：1-监测指令2-过滤指令3-病毒指令
     */
    @Id
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("管理指令的类型：1-监测指令2-过滤指令3-病毒指令")
    private String ctype;

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
     * 管理指令名称
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "commandIDname")
    @ColumnTitle("管理指令名称")
    private String commandidname;

    /**
     * 生效范围-IDC经营单位ID
     */
    @Length(max=128)
    @Column(name = "idcID")
    @ColumnTitle("生效范围-IDC经营单位ID")
    private String idcid;

    /**
     * 监测规则、过滤规则类型 如果是单类指令则同子表相同，如是组合则根据相应数据换算
     */
    @NotEmpty
    @Length(max=50)
    @ColumnTitle("监测规则、过滤规则类型")
    private String subtype;

    /**
     * 是否组合 0-非组合 1-组合 
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("是否组合")
    private String grouptype;

    /**
     * 是否阻断 0-不阻断; 1- 阻断. 没有该选项，则不进行处理-默认 0 
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("是否阻断")
    private String block;

    /**
     * 阻断原因
     */
    @Length(max=128)
    @ColumnTitle("阻断原因")
    private String reason;

    /**
     * 日志记录 0-不记录；1-记录
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("日志记录")
    private String clog;

    /**
     * 日志上传 0-不上传; 1-上传
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("日志上传")
    private String report;

    /**
     * 生效时间 yyyy-MM-dd HH:mm:ss格式
     */
    @NotEmpty
    @Column(name = "effectTime")
    @ColumnTitle("生效时间")
    private Date effecttime;

    /**
     * 过期时间 yyyy-MM-dd HH:mm:ss格式
     */
    @NotEmpty
    @Column(name = "expiredTime")
    @ColumnTitle("过期时间")
    private Date expiredtime;

    /**
     * 指令属主
     */
    @NotEmpty
    @Length(max=32)
    @ColumnTitle("指令属主")
    private String owner;

    /**
     * 查看指令权限 0-无可读权限 ;1-有可读权限
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("查看指令权限")
    private String visible;

    /**
     * 生成时间
     */
    @NotEmpty
    @Column(name = "timeStamp")
    @ColumnTitle("生成时间")
    private Date timestamp;

    /**
     * 下发执行状态 1-等待下发 2-下发 3-取消
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("下发执行状态")
    private String status;

    /**
     * 最后操作时间
     */
    @NotEmpty
    @ColumnTitle("最后操作时间")
    private Date statustime;

    /**
     * 0-SMMS,1-CU,2-EUM
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "cmdFlag")
    @ColumnTitle("0-SMMS,1-CU,2-EUM")
    private String cmdflag;

    /**
     * 标准版本号
     */
    @NotEmpty
    @Length(max=4)
    @Column(name = "commandVersion")
    @ColumnTitle("标准版本号")
    private String commandversion;

    /**
     * 指令优先级
     */
    @NotEmpty
    @ColumnTitle("指令优先级")
    private int level;

    /**
     * 100:严重,50:中等,10:一般
     */
    @Column(name = "alarmLevel")
    @ColumnTitle("100:严重,50:中等,10:一般")
    private Integer alarmlevel;

    /**
     * 备注信息
     */
    @Length(max=65535)
    @ColumnTitle("备注信息")
    private String memo;

    public static final String Property_Expiredtime = "expiredtime";

    public static final String Property_Operationtype = "operationtype";

    public static final String Property_Memo = "memo";

    public static final String Property_Visible = "visible";

    public static final String Property_Commandidname = "commandidname";

    public static final String Property_Status = "status";

    public static final String Property_Commandid = "commandid";

    public static final String Property_Reason = "reason";

    public static final String Property_Ctype = "ctype";

    public static final String Property_Block = "block";

    public static final String Property_Cmdflag = "cmdflag";

    public static final String Property_Idccommandid = "idccommandid";

    public static final String Property_Clog = "clog";

    public static final String Property_Alarmlevel = "alarmlevel";

    public static final String Property_Timestamp = "timestamp";

    public static final String Property_Grouptype = "grouptype";

    public static final String Property_Level = "level";

    public static final String Property_Statustime = "statustime";

    public static final String Property_Commandversion = "commandversion";

    public static final String Property_Idcid = "idcid";

    public static final String Property_Subtype = "subtype";

    public static final String Property_Owner = "owner";

    public static final String Property_Report = "report";

    public static final String Property_Effecttime = "effecttime";

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
     * 获取管理指令名称
     *
     * @return commandIDname - 管理指令名称
     */
    public String getCommandidname() {
        return commandidname;
    }

    /**
     * 设置管理指令名称
     *
     * @param commandidname 管理指令名称
     */
    public void setCommandidname(String commandidname) {
        addChangeField("commandidname",this.commandidname,commandidname);
        this.commandidname = commandidname;
    }

    /**
     * 获取生效范围-IDC经营单位ID
     *
     * @return idcID - 生效范围-IDC经营单位ID
     */
    public String getIdcid() {
        return idcid;
    }

    /**
     * 设置生效范围-IDC经营单位ID
     *
     * @param idcid 生效范围-IDC经营单位ID
     */
    public void setIdcid(String idcid) {
        addChangeField("idcid",this.idcid,idcid);
        this.idcid = idcid;
    }

    /**
     * 获取监测规则、过滤规则类型 如果是单类指令则同子表相同，如是组合则根据相应数据换算
     *
     * @return subtype - 监测规则、过滤规则类型 如果是单类指令则同子表相同，如是组合则根据相应数据换算
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * 设置监测规则、过滤规则类型 如果是单类指令则同子表相同，如是组合则根据相应数据换算
     *
     * @param subtype 监测规则、过滤规则类型 如果是单类指令则同子表相同，如是组合则根据相应数据换算
     */
    public void setSubtype(String subtype) {
        addChangeField("subtype",this.subtype,subtype);
        this.subtype = subtype;
    }

    /**
     * 获取是否组合 0-非组合 1-组合 
     *
     * @return grouptype - 是否组合 0-非组合 1-组合 
     */
    public String getGrouptype() {
        return grouptype;
    }

    /**
     * 设置是否组合 0-非组合 1-组合 
     *
     * @param grouptype 是否组合 0-非组合 1-组合 
     */
    public void setGrouptype(String grouptype) {
        addChangeField("grouptype",this.grouptype,grouptype);
        this.grouptype = grouptype;
    }

    /**
     * 获取是否阻断 0-不阻断; 1- 阻断. 没有该选项，则不进行处理-默认 0 
     *
     * @return block - 是否阻断 0-不阻断; 1- 阻断. 没有该选项，则不进行处理-默认 0 
     */
    public String getBlock() {
        return block;
    }

    /**
     * 设置是否阻断 0-不阻断; 1- 阻断. 没有该选项，则不进行处理-默认 0 
     *
     * @param block 是否阻断 0-不阻断; 1- 阻断. 没有该选项，则不进行处理-默认 0 
     */
    public void setBlock(String block) {
        addChangeField("block",this.block,block);
        this.block = block;
    }

    /**
     * 获取阻断原因
     *
     * @return reason - 阻断原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置阻断原因
     *
     * @param reason 阻断原因
     */
    public void setReason(String reason) {
        addChangeField("reason",this.reason,reason);
        this.reason = reason;
    }

    /**
     * 获取日志记录 0-不记录；1-记录
     *
     * @return clog - 日志记录 0-不记录；1-记录
     */
    public String getClog() {
        return clog;
    }

    /**
     * 设置日志记录 0-不记录；1-记录
     *
     * @param clog 日志记录 0-不记录；1-记录
     */
    public void setClog(String clog) {
        addChangeField("clog",this.clog,clog);
        this.clog = clog;
    }

    /**
     * 获取日志上传 0-不上传; 1-上传
     *
     * @return report - 日志上传 0-不上传; 1-上传
     */
    public String getReport() {
        return report;
    }

    /**
     * 设置日志上传 0-不上传; 1-上传
     *
     * @param report 日志上传 0-不上传; 1-上传
     */
    public void setReport(String report) {
        addChangeField("report",this.report,report);
        this.report = report;
    }

    /**
     * 获取生效时间 yyyy-MM-dd HH:mm:ss格式
     *
     * @return effectTime - 生效时间 yyyy-MM-dd HH:mm:ss格式
     */
    public Date getEffecttime() {
        return effecttime;
    }

    /**
     * 设置生效时间 yyyy-MM-dd HH:mm:ss格式
     *
     * @param effecttime 生效时间 yyyy-MM-dd HH:mm:ss格式
     */
    public void setEffecttime(Date effecttime) {
        addChangeField("effecttime",this.effecttime,effecttime);
        this.effecttime = effecttime;
    }

    /**
     * 获取过期时间 yyyy-MM-dd HH:mm:ss格式
     *
     * @return expiredTime - 过期时间 yyyy-MM-dd HH:mm:ss格式
     */
    public Date getExpiredtime() {
        return expiredtime;
    }

    /**
     * 设置过期时间 yyyy-MM-dd HH:mm:ss格式
     *
     * @param expiredtime 过期时间 yyyy-MM-dd HH:mm:ss格式
     */
    public void setExpiredtime(Date expiredtime) {
        addChangeField("expiredtime",this.expiredtime,expiredtime);
        this.expiredtime = expiredtime;
    }

    /**
     * 获取指令属主
     *
     * @return owner - 指令属主
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置指令属主
     *
     * @param owner 指令属主
     */
    public void setOwner(String owner) {
        addChangeField("owner",this.owner,owner);
        this.owner = owner;
    }

    /**
     * 获取查看指令权限 0-无可读权限 ;1-有可读权限
     *
     * @return visible - 查看指令权限 0-无可读权限 ;1-有可读权限
     */
    public String getVisible() {
        return visible;
    }

    /**
     * 设置查看指令权限 0-无可读权限 ;1-有可读权限
     *
     * @param visible 查看指令权限 0-无可读权限 ;1-有可读权限
     */
    public void setVisible(String visible) {
        addChangeField("visible",this.visible,visible);
        this.visible = visible;
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
     * 获取下发执行状态 1-等待下发 2-下发 3-取消
     *
     * @return status - 下发执行状态 1-等待下发 2-下发 3-取消
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置下发执行状态 1-等待下发 2-下发 3-取消
     *
     * @param status 下发执行状态 1-等待下发 2-下发 3-取消
     */
    public void setStatus(String status) {
        addChangeField("status",this.status,status);
        this.status = status;
    }

    /**
     * 获取最后操作时间
     *
     * @return statustime - 最后操作时间
     */
    public Date getStatustime() {
        return statustime;
    }

    /**
     * 设置最后操作时间
     *
     * @param statustime 最后操作时间
     */
    public void setStatustime(Date statustime) {
        addChangeField("statustime",this.statustime,statustime);
        this.statustime = statustime;
    }

    /**
     * 获取0-SMMS,1-CU,2-EUM
     *
     * @return cmdFlag - 0-SMMS,1-CU,2-EUM
     */
    public String getCmdflag() {
        return cmdflag;
    }

    /**
     * 设置0-SMMS,1-CU,2-EUM
     *
     * @param cmdflag 0-SMMS,1-CU,2-EUM
     */
    public void setCmdflag(String cmdflag) {
        addChangeField("cmdflag",this.cmdflag,cmdflag);
        this.cmdflag = cmdflag;
    }

    /**
     * 获取标准版本号
     *
     * @return commandVersion - 标准版本号
     */
    public String getCommandversion() {
        return commandversion;
    }

    /**
     * 设置标准版本号
     *
     * @param commandversion 标准版本号
     */
    public void setCommandversion(String commandversion) {
        addChangeField("commandversion",this.commandversion,commandversion);
        this.commandversion = commandversion;
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
     * 获取100:严重,50:中等,10:一般
     *
     * @return alarmLevel - 100:严重,50:中等,10:一般
     */
    public Integer getAlarmlevel() {
        return alarmlevel;
    }

    /**
     * 设置100:严重,50:中等,10:一般
     *
     * @param alarmlevel 100:严重,50:中等,10:一般
     */
    public void setAlarmlevel(Integer alarmlevel) {
        addChangeField("alarmlevel",this.alarmlevel,alarmlevel);
        this.alarmlevel = alarmlevel;
    }

    /**
     * 获取备注信息
     *
     * @return memo - 备注信息
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注信息
     *
     * @param memo 备注信息
     */
    public void setMemo(String memo) {
        addChangeField("memo",this.memo,memo);
        this.memo = memo;
    }
}