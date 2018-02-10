package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "tab_sys_operate_log")
public class TabSysOperateLogEntity extends StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int opId;

    @NotEmpty
    @Length(max=32)
    private String operater;

    @NotEmpty
    @Column(name = "op_time")
    private Date opTime;

    @NotEmpty
    @Length(max=2)
    @Column(name = "op_type")
    private String opType;

    @NotEmpty
    @Column(name = "op_result")
    private boolean opResult;

    @NotEmpty
    @Length(max=39)
    @Column(name = "op_ip")
    private String opIp;

    @NotEmpty
    @Length(max=200)
    @Column(name = "op_object")
    private String opObject;

    @NotEmpty
    @Length(max=512)
    @Column(name = "op_params")
    private String opParams;

    @NotEmpty
    @Length(max=65535)
    @Column(name = "op_desc")
    private String opDesc;

    public static final String Property_OpIp = "opIp";

    public static final String Property_OpTime = "opTime";

    public static final String Property_OpResult = "opResult";

    public static final String Property_Operater = "operater";

    public static final String Property_OpId = "opId";

    public static final String Property_OpType = "opType";

    public static final String Property_OpDesc = "opDesc";

    public static final String Property_OpParams = "opParams";

    public static final String Property_OpObject = "opObject";

    /**
     * @return op_id
     */
    public int getOpId() {
        return opId;
    }

    /**
     * @param opId
     */
    public void setOpId(int opId) {
        addChangeField("opId",this.opId,opId);
        this.opId = opId;
    }

    /**
     * @return operater
     */
    public String getOperater() {
        return operater;
    }

    /**
     * @param operater
     */
    public void setOperater(String operater) {
        addChangeField("operater",this.operater,operater);
        this.operater = operater;
    }

    /**
     * @return op_time
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     * @param opTime
     */
    public void setOpTime(Date opTime) {
        addChangeField("opTime",this.opTime,opTime);
        this.opTime = opTime;
    }

    /**
     * @return op_type
     */
    public String getOpType() {
        return opType;
    }

    /**
     * @param opType
     */
    public void setOpType(String opType) {
        addChangeField("opType",this.opType,opType);
        this.opType = opType;
    }

    /**
     * @return op_result
     */
    public boolean getOpResult() {
        return opResult;
    }

    /**
     * @param opResult
     */
    public void setOpResult(boolean opResult) {
        addChangeField("opResult",this.opResult,opResult);
        this.opResult = opResult;
    }

    /**
     * @return op_ip
     */
    public String getOpIp() {
        return opIp;
    }

    /**
     * @param opIp
     */
    public void setOpIp(String opIp) {
        addChangeField("opIp",this.opIp,opIp);
        this.opIp = opIp;
    }

    /**
     * @return op_object
     */
    public String getOpObject() {
        return opObject;
    }

    /**
     * @param opObject
     */
    public void setOpObject(String opObject) {
        addChangeField("opObject",this.opObject,opObject);
        this.opObject = opObject;
    }

    /**
     * @return op_params
     */
    public String getOpParams() {
        return opParams;
    }

    /**
     * @param opParams
     */
    public void setOpParams(String opParams) {
        addChangeField("opParams",this.opParams,opParams);
        this.opParams = opParams;
    }

    /**
     * @return op_desc
     */
    public String getOpDesc() {
        return opDesc;
    }

    /**
     * @param opDesc
     */
    public void setOpDesc(String opDesc) {
        addChangeField("opDesc",this.opDesc,opDesc);
        this.opDesc = opDesc;
    }
}