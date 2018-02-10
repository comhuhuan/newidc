package com.act.web.enums;

/**
 * 
 * <p>Title: ReturnDataTypeEnum.java
 * <p>Description: 退回数据类型
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:10:03
 */ 
public enum ReturnDataTypeEnum {
    
    /**
     * 0=经营者
     */
    IDC_DATA("0","经营者"),SERVICE_DATA("1", "机房数据"), USER_DATA("2", "用户数据");

    private String type;
    private String explain;

    private ReturnDataTypeEnum(String type, String explain) {
        this.type = type;
        this.explain = explain;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the explain
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param explain
     *            the explain to set
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

}
