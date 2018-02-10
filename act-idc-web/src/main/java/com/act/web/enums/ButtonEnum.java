package com.act.web.enums;

/**
 * 
 * <p>Title: ButtonEnum.java
 * <p>Description: 按钮枚举类
 * <p>Modified History:
 * @author chenxin
 * @date 2018年2月2日 下午2:07:59
 */ 
public enum ButtonEnum {
    
    /**
     * 1=点击查看EU接收情况
     */
    CHECK_EU("点击查看EU接收情况",1),
    /**
     * 2=点击进行下发
     */
    SEND("点击进行下发",2),
    /**
     * 3=点击取消下发
     */
    CANCEL_SEND("点击取消下发",3),
    /**
     * 4=正在下发或已下发成功
     */
    SENDING("正在下发或已下发成功",4),
    /**
     * 5=已过期
     */
    EXPIRED("已过期",5),
    /**
     * 6=已取消成功,不需取消下发
     */
    CANCEL_SUCCESS("正在下发或已取消成功不需再次取消",6);
    
    private ButtonEnum(String title, Integer type) {
        this.title = title;
        this.type = type;
    }
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 按钮类型
     */
    private Integer type;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
}
