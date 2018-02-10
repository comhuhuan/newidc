package com.act.web.enums;

/**
 * 
 * <p>Title: ReturnReasonEnum.java
 * <p>Description: 回退原因分类枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:10:30
 */ 
public enum ReturnReasonEnum {

    /**
     * 0=上报记录通过核验
     */
    PASS("0", "上报记录通过核验"), CONFLICT("1", "上报数据与既有数据记录冲突"), INCOMPLETE("2", "上报数据内容不完整,"), MISTAKE("3", "上报数据内容错误");

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private ReturnReasonEnum(String type, String explain) {
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
