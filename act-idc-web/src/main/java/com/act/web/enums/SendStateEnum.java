package com.act.web.enums;

/**
 * 
 * <p>Title: SendStateEnum.java
 * <p>Description: 下发状态枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:10:40
 */ 
public enum SendStateEnum {
    
    /**
     * 1=下发成功
     */
    SEND_SUCCESS("1","下发成功"),
    /**
     * 2=取消成功
     */
    CANCEL_SUCCESS("2","取消成功"),
    /**
     * 3=失败
     */
    SEND_FAIL("3","失败");
    
    /**
     * 类型
     */
    private String type;
    /**
     * 名称
     */
    private String explain;
    
    private SendStateEnum(String type, String explain) {
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
     * @param type the type to set
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
     * @param explain the explain to set
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }
}
