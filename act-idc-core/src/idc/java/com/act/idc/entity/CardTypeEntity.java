package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "tab_card_type")
public class CardTypeEntity extends StandardEntity {
    /**
     * 代码号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Length(max=3)
    @Column(name = "card_type_code")
    @ColumnTitle("代码号")
    private String cardTypeCode;

    /**
     * 证件类型
     */
    @NotEmpty
    @Length(max=32)
    @Column(name = "card_type_name")
    @ColumnTitle("证件类型")
    private String cardTypeName;

    /**
     * 资源管理显示名称
     */
    @Length(max=32)
    @Column(name = "source_name")
    @ColumnTitle("资源管理显示名称")
    private String sourceName;

    /**
     * 是否有效0 - 无效 1 - 有效
     */
    @NotEmpty
    @Length(max=1)
    @ColumnTitle("是否有效0")
    private String sfyxmk;

    /**
     * 备注
     */
    @Length(max=255)
    @ColumnTitle("备注")
    private String remark;

    public static final String Property_Sfyxmk = "sfyxmk";

    public static final String Property_Remark = "remark";

    public static final String Property_SourceName = "sourceName";

    public static final String Property_CardTypeName = "cardTypeName";

    public static final String Property_CardTypeCode = "cardTypeCode";

    /**
     * 获取代码号
     *
     * @return card_type_code - 代码号
     */
    public String getCardTypeCode() {
        return cardTypeCode;
    }

    /**
     * 设置代码号
     *
     * @param cardTypeCode 代码号
     */
    public void setCardTypeCode(String cardTypeCode) {
        addChangeField("cardTypeCode",this.cardTypeCode,cardTypeCode);
        this.cardTypeCode = cardTypeCode;
    }

    /**
     * 获取证件类型
     *
     * @return card_type_name - 证件类型
     */
    public String getCardTypeName() {
        return cardTypeName;
    }

    /**
     * 设置证件类型
     *
     * @param cardTypeName 证件类型
     */
    public void setCardTypeName(String cardTypeName) {
        addChangeField("cardTypeName",this.cardTypeName,cardTypeName);
        this.cardTypeName = cardTypeName;
    }

    /**
     * 获取资源管理显示名称
     *
     * @return source_name - 资源管理显示名称
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置资源管理显示名称
     *
     * @param sourceName 资源管理显示名称
     */
    public void setSourceName(String sourceName) {
        addChangeField("sourceName",this.sourceName,sourceName);
        this.sourceName = sourceName;
    }

    /**
     * 获取是否有效0 - 无效 1 - 有效
     *
     * @return sfyxmk - 是否有效0 - 无效 1 - 有效
     */
    public String getSfyxmk() {
        return sfyxmk;
    }

    /**
     * 设置是否有效0 - 无效 1 - 有效
     *
     * @param sfyxmk 是否有效0 - 无效 1 - 有效
     */
    public void setSfyxmk(String sfyxmk) {
        addChangeField("sfyxmk",this.sfyxmk,sfyxmk);
        this.sfyxmk = sfyxmk;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        addChangeField("remark",this.remark,remark);
        this.remark = remark;
    }
}