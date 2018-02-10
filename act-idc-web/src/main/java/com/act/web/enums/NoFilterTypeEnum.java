package com.act.web.enums;

/**
 * 
 * <p>Title: NoFilterTypeEnum.java
 * <p>Description: 免过滤类型枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:09:33
 */ 
public enum NoFilterTypeEnum {
    
    /**
     * 1=域名
     */
    DOMAIN("1","域名"),
    /**
     * 2=IP
     */
    IP("2","IP");
    
    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private NoFilterTypeEnum(String type, String explain) {
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
