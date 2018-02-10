package com.act.web.enums;

/**
 * 
 * <p>Title: CmdTypeEnum.java
 * <p>Description: 指令类型枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:08:30
 */ 
public enum CmdTypeEnum {

    /**
     * 0=基础数据管理指令
     */
    BASIC_DATA_MANAGE("0", "基础数据管理指令"), ACCESS_LOG_QUERY("1", "访问日志查询指令"), INFO_SECURITY_MANAGE("2",
            "信息安全管理指令"), MANAGE_QUERY("3", "管理指令查询指令"), CODE_LIST_ISSUSE("4", "代码表发布指令"), BASIC_DATA_QUERY("5",
                    "基础数据查询指令"), INFO_SECURITY_QUERY("6", "信息安全查询指令"), AREA_CONTROL("51",
                            "区域管控指令"), CMD_EXC_PROCEDURE("52", "指令执行过程查询指令"), WORK_ORDER("53", "工单接口指令");

    /**
     * 值
     */
    private String type;
    /**
     * 标签
     */
    private String explain;

    private CmdTypeEnum(String type, String explain) {
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
