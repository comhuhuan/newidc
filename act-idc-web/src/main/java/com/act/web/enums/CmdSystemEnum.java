package com.act.web.enums;

/**
 * 
 * <p>Title: CmdSystemEnum.java
 * <p>Description: 指令来源枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:08:10
 */ 
public enum CmdSystemEnum {

    /**
     * 0=SMMS（上级）;
     */
    SMMS("0", "SMMS"),
    /**
     * 1=cu（本级）
     */
    CU("1", "CU"), 
    /**
     * 2=eu
     */
    EU_ACK("2", "EU_ACK"),
    /**
     *3=du
     */
    DU("3","DU");

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private CmdSystemEnum(String type, String explain) {
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
