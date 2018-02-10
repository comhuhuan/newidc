package com.act.web.enums;

/**
 * 
 * <p>Title: BaseDataCmdTypeEnum.java
 * <p>Description: 基础数据查询指令---指令类型
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:07:43
 */ 
public enum BaseDataCmdTypeEnum {
    /**
     * 0=查询基础数据；
     */
    QUERY_BASIC_DATA("0", "查询基础数据"), 
    /**
     * 1=打开监测
     */
    OPEN_MONITOR("1", "打开监测"), 
    /**
     * 2=关闭监测
     */
    CLOSE_MONITOR("2", "关闭监测"), 
    /**
     * 3=查询监测数据
     */
    QUERY_MONITOR_DATA("3", "查询监测数据");
    
    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private BaseDataCmdTypeEnum(String type, String explain) {
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
