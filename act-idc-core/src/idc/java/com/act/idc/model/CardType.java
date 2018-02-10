package com.act.idc.model;

import com.act.framework.entity.BaseEntity;
import com.act.idc.dao.CardTypeDao;
import com.act.idc.entity.CardTypeEntity;

public class CardType extends CardTypeEntity {

    public static CardType getByKey(String cardTypeCode) {
        return (CardType)BaseEntity.getByKey(CardType.class, cardTypeCode);
    }

    public static CardTypeDao getDao() {
        return (CardTypeDao)BaseEntity.getDao(CardType.class);
    }
}