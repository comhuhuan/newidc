package com.act.web.module.command.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: CodeListIssuseCmdVo.java
 * <p>Description: 代码表发布指令展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:20:33
 */ 
public class CodeListIssuseCmdVo extends BaseVo{
    
    /**
     * 生成时间
     */
    private String createDateQuery;
    
    /**
     * 执行状态
     */
    private String excStateQuery;
    
    /**
     * 查询指令ID
     */
    private String commandId;
    
    /**
     * 生成时间
     */
    private String createTime;
    
    /**
     * 执行时间
     */
    private String excTime;
    
    /**
     * 执行状态
     */
    private String excState;

    public String getCreateDateQuery() {
        return createDateQuery;
    }

    public void setCreateDateQuery(String createDateQuery) {
        this.createDateQuery = createDateQuery;
    }

    public String getExcStateQuery() {
        return excStateQuery;
    }

    public void setExcStateQuery(String excStateQuery) {
        this.excStateQuery = excStateQuery;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExcTime() {
        return excTime;
    }

    public void setExcTime(String excTime) {
        this.excTime = excTime;
    }

    public String getExcState() {
        return excState;
    }

    public void setExcState(String excState) {
        this.excState = excState;
    }
}
