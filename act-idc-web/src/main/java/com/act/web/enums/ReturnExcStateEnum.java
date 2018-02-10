package com.act.web.enums;

/**
 * 
 * <p>Title: ReturnExcStateEnum.java
 * <p>Description: 回退数据执行状态枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:10:15
 */ 
public enum ReturnExcStateEnum {

    /**
     * 1=等待处理
     */
    WAIT_HANDLE("1", "等待处理"),
    /**
     * 2=处理完成
     */
    IS_HANDLING("2", "处理完成"),
    /**
     * 3=重新上报成功
     */
    HANDLE_SUCCESS("3", "重新上报成功"), 
    /**
     * 4=重新上报失败
     */
    HANDLE_FAIL("4", "重新上报失败");

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private ReturnExcStateEnum(String type, String explain) {
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
