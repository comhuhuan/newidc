package com.act.web.enums;

/**
 * 
 * <p>Title: ExcStateEnum.java
 * <p>Description: 执行状态枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:08:58
 */ 
public enum ExcStateEnum {

    /**
     * 1=待处理
     */
    WAIT_HANDLE("1", "待处理"),
    /**
     * 2=正在处理
     */
    IS_HANDLING("2", "正在处理"),
    /**
     * 3=处理成功
     */
    HANDLE_SUCCESS("3", "处理成功"),
    /**
     * 4=处理失败
     */
    HANDLE_FAIL("4", "处理失败");
    

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private ExcStateEnum(String type, String explain) {
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
