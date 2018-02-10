package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ts_query_cmd_log")
public class TsQueryCmdLogEntity extends StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 查询指令类型
     */
    @Length(max=50)
    @Column(name = "cmd_type")
    @ColumnTitle("查询指令类型")
    private String cmdType;

    /**
     * 查询指令内容
     */
    @Length(max=255)
    @Column(name = "cmd_content")
    @ColumnTitle("查询指令内容")
    private String cmdContent;

    /**
     * 查询结果（0：成功，1：失败）
     */
    @Column(name = "result_code")
    @ColumnTitle("查询结果（0：成功，1：失败）")
    private Integer resultCode;

    @Column(name = "query_time")
    private Date queryTime;

    /**
     * 查询管理员名称
     */
    @Length(max=20)
    @Column(name = "user_name")
    @ColumnTitle("查询管理员名称")
    private String userName;

    public static final String Property_Id = "id";

    public static final String Property_ResultCode = "resultCode";

    public static final String Property_CmdContent = "cmdContent";

    public static final String Property_UserName = "userName";

    public static final String Property_CmdType = "cmdType";

    public static final String Property_QueryTime = "queryTime";

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        addChangeField("id",this.id,id);
        this.id = id;
    }

    /**
     * 获取查询指令类型
     *
     * @return cmd_type - 查询指令类型
     */
    public String getCmdType() {
        return cmdType;
    }

    /**
     * 设置查询指令类型
     *
     * @param cmdType 查询指令类型
     */
    public void setCmdType(String cmdType) {
        addChangeField("cmdType",this.cmdType,cmdType);
        this.cmdType = cmdType;
    }

    /**
     * 获取查询指令内容
     *
     * @return cmd_content - 查询指令内容
     */
    public String getCmdContent() {
        return cmdContent;
    }

    /**
     * 设置查询指令内容
     *
     * @param cmdContent 查询指令内容
     */
    public void setCmdContent(String cmdContent) {
        addChangeField("cmdContent",this.cmdContent,cmdContent);
        this.cmdContent = cmdContent;
    }

    /**
     * 获取查询结果（0：成功，1：失败）
     *
     * @return result_code - 查询结果（0：成功，1：失败）
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * 设置查询结果（0：成功，1：失败）
     *
     * @param resultCode 查询结果（0：成功，1：失败）
     */
    public void setResultCode(Integer resultCode) {
        addChangeField("resultCode",this.resultCode,resultCode);
        this.resultCode = resultCode;
    }

    /**
     * @return query_time
     */
    public Date getQueryTime() {
        return queryTime;
    }

    /**
     * @param queryTime
     */
    public void setQueryTime(Date queryTime) {
        addChangeField("queryTime",this.queryTime,queryTime);
        this.queryTime = queryTime;
    }

    /**
     * 获取查询管理员名称
     *
     * @return user_name - 查询管理员名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置查询管理员名称
     *
     * @param userName 查询管理员名称
     */
    public void setUserName(String userName) {
        addChangeField("userName",this.userName,userName);
        this.userName = userName;
    }
}