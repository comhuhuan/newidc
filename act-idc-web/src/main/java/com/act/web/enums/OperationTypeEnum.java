package com.act.web.enums;

/**
 * 
 * <p>Title: OperationTypeEnum.java
 * <p>Description: 操作类型枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:09:49
 */ 
public enum OperationTypeEnum {
    /**
     * 0=新增；
     */
    INSERT("0", "新增"),
    /**
     * 1=删除
     */
    DELETE("1", "删除");

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private OperationTypeEnum(String type, String explain) {
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
