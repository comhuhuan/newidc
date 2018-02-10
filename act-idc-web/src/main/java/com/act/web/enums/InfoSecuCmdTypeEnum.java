package com.act.web.enums;

/**
 * 
 * <p>Title: InfoSecuCmdTypeEnum.java
 * <p>Description: 信息安全管理指令的指令枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午11:17:57
 */ 
public enum InfoSecuCmdTypeEnum {
    /** 
     * @Fields MONITOR_CMD : 1=监测指令；
    */ 
    MONITOR_CMD("1", "监测指令"), 
    /** 
     * @Fields FILTER_CMD : 2=过滤指令
    */ 
    FILTER_CMD("2", "过滤指令");
    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private InfoSecuCmdTypeEnum(String type, String explain) {
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
