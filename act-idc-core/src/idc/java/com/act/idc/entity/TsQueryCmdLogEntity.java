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
     * ��ѯָ������
     */
    @Length(max=50)
    @Column(name = "cmd_type")
    @ColumnTitle("��ѯָ������")
    private String cmdType;

    /**
     * ��ѯָ������
     */
    @Length(max=255)
    @Column(name = "cmd_content")
    @ColumnTitle("��ѯָ������")
    private String cmdContent;

    /**
     * ��ѯ�����0���ɹ���1��ʧ�ܣ�
     */
    @Column(name = "result_code")
    @ColumnTitle("��ѯ�����0���ɹ���1��ʧ�ܣ�")
    private Integer resultCode;

    @Column(name = "query_time")
    private Date queryTime;

    /**
     * ��ѯ����Ա����
     */
    @Length(max=20)
    @Column(name = "user_name")
    @ColumnTitle("��ѯ����Ա����")
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
     * ��ȡ��ѯָ������
     *
     * @return cmd_type - ��ѯָ������
     */
    public String getCmdType() {
        return cmdType;
    }

    /**
     * ���ò�ѯָ������
     *
     * @param cmdType ��ѯָ������
     */
    public void setCmdType(String cmdType) {
        addChangeField("cmdType",this.cmdType,cmdType);
        this.cmdType = cmdType;
    }

    /**
     * ��ȡ��ѯָ������
     *
     * @return cmd_content - ��ѯָ������
     */
    public String getCmdContent() {
        return cmdContent;
    }

    /**
     * ���ò�ѯָ������
     *
     * @param cmdContent ��ѯָ������
     */
    public void setCmdContent(String cmdContent) {
        addChangeField("cmdContent",this.cmdContent,cmdContent);
        this.cmdContent = cmdContent;
    }

    /**
     * ��ȡ��ѯ�����0���ɹ���1��ʧ�ܣ�
     *
     * @return result_code - ��ѯ�����0���ɹ���1��ʧ�ܣ�
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * ���ò�ѯ�����0���ɹ���1��ʧ�ܣ�
     *
     * @param resultCode ��ѯ�����0���ɹ���1��ʧ�ܣ�
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
     * ��ȡ��ѯ����Ա����
     *
     * @return user_name - ��ѯ����Ա����
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ���ò�ѯ����Ա����
     *
     * @param userName ��ѯ����Ա����
     */
    public void setUserName(String userName) {
        addChangeField("userName",this.userName,userName);
        this.userName = userName;
    }
}