package com.act.web.enums;

/**
 * 
 * <p>Title: CmdVerifyEnum.java
 * <p>Description: 指令验证枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:08:45
 */ 
public enum CmdVerifyEnum {

    /**
     * 0=正确；
     */
    VERIFY_RIGHT("0", "正确"),
    /**
     * 1=出错;
     */
    VERIFY_ERROR("1", "出错");

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private CmdVerifyEnum(String type, String explain) {
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
