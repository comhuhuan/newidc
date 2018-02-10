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
     * �ϴ�����ID��
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnTitle("�ϴ�����ID��")
    private int id;

    /**
     * ���ö�Ӧ���Ժ�
     */
    @NotEmpty
    @Column(name = "scheme_id")
    @ColumnTitle("���ö�Ӧ���Ժ�")
    private long schemeId;

    /**
     * �������
     */
    @NotEmpty
    @Length(max=18)
    @Column(name = "service_code")
    @ColumnTitle("�������")
    private String serviceCode;

    /**
     * �����û�ID��,����ǹֲܾࡪsmcs ϵͳ��- sys ����ϵͳ�����嶨��
     */
    @NotEmpty
    @Length(max=32)
    @ColumnTitle("�����û�ID��,����ǹֲܾࡪsmcs")
    private String userid;

    /**
     * ��������  1-һ���������� 2-������������ 3-IP(ip��)���� 4-URL��ַ 5-Э�� 6-�˿�(��) 7ip+port 8domain+ip 9domain+port
     */
    @NotEmpty
    @ColumnTitle("��������")
    private boolean utype;

    /**
     * �����ľ�������
     */
    @NotEmpty
    @Length(max=1024)
    @ColumnTitle("�����ľ�������")
    private String content;

    /**
     * 0.����->δ����(ȡ�����) 1.δ����->���ˣ���£� 2.û�б仯(���ڴ����ɹ��Ĳ���) 
     */
    @NotEmpty
    @ColumnTitle("0.����->δ����(ȡ�����)")
    private boolean stopsign;

    /**
     * �����û���IP��ַ,ϵͳ�ڲ���Ĭ��127.0.0.1
     */
    @NotEmpty
    @Length(max=255)
    @ColumnTitle("�����û���IP��ַ,ϵͳ�ڲ���Ĭ��127.0.0.1")
    private String userip;

    /**
     * ����ʱ��
     */
    @NotEmpty
    @Column(name = "cur_time")
    @ColumnTitle("����ʱ��")
    private Date curTime;

    /**
     * 0Ϊδ���͹���1Ϊ���͹���
     */
    @NotEmpty
    @Column(name = "send_flag")
    @ColumnTitle("0Ϊδ���͹���1Ϊ���͹���")
    private boolean sendFlag;

    /**
     * ���͵������
     */
    @Length(max=8)
    @ColumnTitle("���͵������")
    private String cmd;

    /**
     * ˽��IP
     */
    @Length(max=64)
    @Column(name = "local_ip")
    @ColumnTitle("˽��IP")
    private String localIp;

    /**
     * ˽��MAC
     */
    @Length(max=64)
    @Column(name = "local_mac")
    @ColumnTitle("˽��MAC")
    private String localMac;

    /**
     * ˽��������
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "local_machine")
    @ColumnTitle("˽��������")
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
     * ��ȡ�ϴ�����ID��
     *
     * @return id - �ϴ�����ID��
     */
    public int getId() {
        return id;
    }

    /**
     * �����ϴ�����ID��
     *
     * @param id �ϴ�����ID��
     */
    public void setId(int id) {
        addChangeField("id",this.id,id);
        this.id = id;
    }

    /**
     * ��ȡ���ö�Ӧ���Ժ�
     *
     * @return scheme_id - ���ö�Ӧ���Ժ�
     */
    public long getSchemeId() {
        return schemeId;
    }

    /**
     * ���ô��ö�Ӧ���Ժ�
     *
     * @param schemeId ���ö�Ӧ���Ժ�
     */
    public void setSchemeId(long schemeId) {
        addChangeField("schemeId",this.schemeId,schemeId);
        this.schemeId = schemeId;
    }

    /**
     * ��ȡ�������
     *
     * @return service_code - �������
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * ���û������
     *
     * @param serviceCode �������
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * ��ȡ�����û�ID��,����ǹֲܾࡪsmcs ϵͳ��- sys ����ϵͳ�����嶨��
     *
     * @return userid - �����û�ID��,����ǹֲܾࡪsmcs ϵͳ��- sys ����ϵͳ�����嶨��
     */
    public String getUserid() {
        return userid;
    }

    /**
     * ���ò����û�ID��,����ǹֲܾࡪsmcs ϵͳ��- sys ����ϵͳ�����嶨��
     *
     * @param userid �����û�ID��,����ǹֲܾࡪsmcs ϵͳ��- sys ����ϵͳ�����嶨��
     */
    public void setUserid(String userid) {
        addChangeField("userid",this.userid,userid);
        this.userid = userid;
    }

    /**
     * ��ȡ��������  1-һ���������� 2-������������ 3-IP(ip��)���� 4-URL��ַ 5-Э�� 6-�˿�(��) 7ip+port 8domain+ip 9domain+port
     *
     * @return utype - ��������  1-һ���������� 2-������������ 3-IP(ip��)���� 4-URL��ַ 5-Э�� 6-�˿�(��) 7ip+port 8domain+ip 9domain+port
     */
    public boolean getUtype() {
        return utype;
    }

    /**
     * ���ò�������  1-һ���������� 2-������������ 3-IP(ip��)���� 4-URL��ַ 5-Э�� 6-�˿�(��) 7ip+port 8domain+ip 9domain+port
     *
     * @param utype ��������  1-һ���������� 2-������������ 3-IP(ip��)���� 4-URL��ַ 5-Э�� 6-�˿�(��) 7ip+port 8domain+ip 9domain+port
     */
    public void setUtype(boolean utype) {
        addChangeField("utype",this.utype,utype);
        this.utype = utype;
    }

    /**
     * ��ȡ�����ľ�������
     *
     * @return content - �����ľ�������
     */
    public String getContent() {
        return content;
    }

    /**
     * ���ò����ľ�������
     *
     * @param content �����ľ�������
     */
    public void setContent(String content) {
        addChangeField("content",this.content,content);
        this.content = content;
    }

    /**
     * ��ȡ0.����->δ����(ȡ�����) 1.δ����->���ˣ���£� 2.û�б仯(���ڴ����ɹ��Ĳ���) 
     *
     * @return stopsign - 0.����->δ����(ȡ�����) 1.δ����->���ˣ���£� 2.û�б仯(���ڴ����ɹ��Ĳ���) 
     */
    public boolean getStopsign() {
        return stopsign;
    }

    /**
     * ����0.����->δ����(ȡ�����) 1.δ����->���ˣ���£� 2.û�б仯(���ڴ����ɹ��Ĳ���) 
     *
     * @param stopsign 0.����->δ����(ȡ�����) 1.δ����->���ˣ���£� 2.û�б仯(���ڴ����ɹ��Ĳ���) 
     */
    public void setStopsign(boolean stopsign) {
        addChangeField("stopsign",this.stopsign,stopsign);
        this.stopsign = stopsign;
    }

    /**
     * ��ȡ�����û���IP��ַ,ϵͳ�ڲ���Ĭ��127.0.0.1
     *
     * @return userip - �����û���IP��ַ,ϵͳ�ڲ���Ĭ��127.0.0.1
     */
    public String getUserip() {
        return userip;
    }

    /**
     * ���ò����û���IP��ַ,ϵͳ�ڲ���Ĭ��127.0.0.1
     *
     * @param userip �����û���IP��ַ,ϵͳ�ڲ���Ĭ��127.0.0.1
     */
    public void setUserip(String userip) {
        addChangeField("userip",this.userip,userip);
        this.userip = userip;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return cur_time - ����ʱ��
     */
    public Date getCurTime() {
        return curTime;
    }

    /**
     * ���ò���ʱ��
     *
     * @param curTime ����ʱ��
     */
    public void setCurTime(Date curTime) {
        addChangeField("curTime",this.curTime,curTime);
        this.curTime = curTime;
    }

    /**
     * ��ȡ0Ϊδ���͹���1Ϊ���͹���
     *
     * @return send_flag - 0Ϊδ���͹���1Ϊ���͹���
     */
    public boolean getSendFlag() {
        return sendFlag;
    }

    /**
     * ����0Ϊδ���͹���1Ϊ���͹���
     *
     * @param sendFlag 0Ϊδ���͹���1Ϊ���͹���
     */
    public void setSendFlag(boolean sendFlag) {
        addChangeField("sendFlag",this.sendFlag,sendFlag);
        this.sendFlag = sendFlag;
    }

    /**
     * ��ȡ���͵������
     *
     * @return cmd - ���͵������
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * ���÷��͵������
     *
     * @param cmd ���͵������
     */
    public void setCmd(String cmd) {
        addChangeField("cmd",this.cmd,cmd);
        this.cmd = cmd;
    }

    /**
     * ��ȡ˽��IP
     *
     * @return local_ip - ˽��IP
     */
    public String getLocalIp() {
        return localIp;
    }

    /**
     * ����˽��IP
     *
     * @param localIp ˽��IP
     */
    public void setLocalIp(String localIp) {
        addChangeField("localIp",this.localIp,localIp);
        this.localIp = localIp;
    }

    /**
     * ��ȡ˽��MAC
     *
     * @return local_mac - ˽��MAC
     */
    public String getLocalMac() {
        return localMac;
    }

    /**
     * ����˽��MAC
     *
     * @param localMac ˽��MAC
     */
    public void setLocalMac(String localMac) {
        addChangeField("localMac",this.localMac,localMac);
        this.localMac = localMac;
    }

    /**
     * ��ȡ˽��������
     *
     * @return local_machine - ˽��������
     */
    public String getLocalMachine() {
        return localMachine;
    }

    /**
     * ����˽��������
     *
     * @param localMachine ˽��������
     */
    public void setLocalMachine(String localMachine) {
        addChangeField("localMachine",this.localMachine,localMachine);
        this.localMachine = localMachine;
    }
}