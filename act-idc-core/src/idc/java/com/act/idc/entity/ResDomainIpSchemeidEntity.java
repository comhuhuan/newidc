package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "res_domainip_schemeid")
public class ResDomainIpSchemeidEntity extends StandardEntity {
    /**
     * ��������
     */
    @Id
    @NotEmpty
    @ColumnTitle("��������")
    private byte[] content;

    /**
     * ����ID
     */
    @Id
    @NotEmpty
    @Length(max=18)
    @Column(name = "service_code")
    @ColumnTitle("����ID")
    private String serviceCode;

    /**
     * ������Ӧ����
     */
    @NotEmpty
    @Length(max=20)
    @Column(name = "isstop_scheme_id")
    @ColumnTitle("������Ӧ����")
    private String isstopSchemeId;

    /**
     * 1-���� 2-ԭIP��ַ
     */
    @NotEmpty
    @Column(name = "scheme_type")
    @ColumnTitle("1-����")
    private int schemeType;

    /**
     * url���״̬��0-�ȴ���� 1-ȡ����� 2-���ڷ�� 3-����ȡ��
     */
    @NotEmpty
    @ColumnTitle("url���״̬��0-�ȴ����")
    private Byte isstop;

    public static final String Property_Content = "content";

    public static final String Property_SchemeType = "schemeType";

    public static final String Property_IsstopSchemeId = "isstopSchemeId";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_Isstop = "isstop";

    /**
     * ��ȡ��������
     *
     * @return content - ��������
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * ���ù�������
     *
     * @param content ��������
     */
    public void setContent(byte[] content) {
        addChangeField("content",this.content,content);
        this.content = content;
    }

    /**
     * ��ȡ����ID
     *
     * @return service_code - ����ID
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * ���û���ID
     *
     * @param serviceCode ����ID
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * ��ȡ������Ӧ����
     *
     * @return isstop_scheme_id - ������Ӧ����
     */
    public String getIsstopSchemeId() {
        return isstopSchemeId;
    }

    /**
     * ����������Ӧ����
     *
     * @param isstopSchemeId ������Ӧ����
     */
    public void setIsstopSchemeId(String isstopSchemeId) {
        addChangeField("isstopSchemeId",this.isstopSchemeId,isstopSchemeId);
        this.isstopSchemeId = isstopSchemeId;
    }

    /**
     * ��ȡ1-���� 2-ԭIP��ַ
     *
     * @return scheme_type - 1-���� 2-ԭIP��ַ
     */
    public int getSchemeType() {
        return schemeType;
    }

    /**
     * ����1-���� 2-ԭIP��ַ
     *
     * @param schemeType 1-���� 2-ԭIP��ַ
     */
    public void setSchemeType(int schemeType) {
        addChangeField("schemeType",this.schemeType,schemeType);
        this.schemeType = schemeType;
    }

    /**
     * ��ȡurl���״̬��0-�ȴ���� 1-ȡ����� 2-���ڷ�� 3-����ȡ��
     *
     * @return isstop - url���״̬��0-�ȴ���� 1-ȡ����� 2-���ڷ�� 3-����ȡ��
     */
    public Byte getIsstop() {
        return isstop;
    }

    /**
     * ����url���״̬��0-�ȴ���� 1-ȡ����� 2-���ڷ�� 3-����ȡ��
     *
     * @param isstop url���״̬��0-�ȴ���� 1-ȡ����� 2-���ڷ�� 3-����ȡ��
     */
    public void setIsstop(Byte isstop) {
        addChangeField("isstop",this.isstop,isstop);
        this.isstop = isstop;
    }
}