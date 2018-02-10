package com.act.web.module.command.vo;

import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: ReceiveCmdVerifyVo.java
 * <p>Description: 接收指令验证展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:22:25
 */ 
public class ReceiveCmdVerifyVo extends BaseVo {

    /**
     * 指令验证查询
     */
    private String cmdCheckQuery;

    /**
     * 指令ID号查询
     */
    private String commandIdQuery;

    /**
     *  指令类型查询
     */
    private String commandTypeQuery;

    /**
     * 终止接收时间查询
     */
    private String endDateQuery;

    /**
     *  起始接收时间查询
     */
    private String startDateQuery;

    /**
     * 指令ID号
     */
    private String commandId;
    
    /**
     * 下发指令编号
     */
    private String commandSequence;
    
    /**
     * 指令类型
     */
    private String commandType;
    
    /**
     *  版本号
     */
    private String commandVersion;
    
    /**
     *  接收时间
     */
    private String curTime;
    
    /**
     *  IDC/ISP许可证号
     */
    private String idcId;
    
    /**
     * 返回信息
     */
    private String resultMsg;
    
    /**
     * 指令内容
     */
    private String command;
    
    private String compressionFormat;
    
    private String encryptAlgorithm;
    
    private String hashAlgorithm;
    
   private String resultCode;
    
    public String getCmdCheckQuery() {
        return cmdCheckQuery;
    }

    public void setCmdCheckQuery(String cmdCheckQuery) {
        this.cmdCheckQuery = cmdCheckQuery;
    }

    public String getCommandIdQuery() {
        return commandIdQuery;
    }

    public void setCommandIdQuery(String commandIdQuery) {
        this.commandIdQuery = commandIdQuery;
    }

    public String getCommandTypeQuery() {
        return commandTypeQuery;
    }

    public void setCommandTypeQuery(String commandTypeQuery) {
        this.commandTypeQuery = commandTypeQuery;
    }

    public String getEndDateQuery() {
        return endDateQuery;
    }

    public void setEndDateQuery(String endDateQuery) {
        this.endDateQuery = endDateQuery;
    }

    public String getStartDateQuery() {
        return startDateQuery;
    }

    public void setStartDateQuery(String startDateQuery) {
        this.startDateQuery = startDateQuery;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCommandSequence() {
        return commandSequence;
    }

    public void setCommandSequence(String commandSequence) {
        this.commandSequence = commandSequence;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandVersion() {
        return commandVersion;
    }

    public void setCommandVersion(String commandVersion) {
        this.commandVersion = commandVersion;
    }

    public String getCurTime() {
        return curTime;
    }

    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return the compressionFormat
     */
    public String getCompressionFormat() {
        return compressionFormat;
    }

    /**
     * @param compressionFormat the compressionFormat to set
     */
    public void setCompressionFormat(String compressionFormat) {
        this.compressionFormat = compressionFormat;
    }

    /**
     * @return the encryptAlgorithm
     */
    public String getEncryptAlgorithm() {
        return encryptAlgorithm;
    }

    /**
     * @param encryptAlgorithm the encryptAlgorithm to set
     */
    public void setEncryptAlgorithm(String encryptAlgorithm) {
        this.encryptAlgorithm = encryptAlgorithm;
    }

    /**
     * @return the hashAlgorithm
     */
    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * @param hashAlgorithm the hashAlgorithm to set
     */
    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    /**
     * @return the resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode the resultCode to set
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    
}
