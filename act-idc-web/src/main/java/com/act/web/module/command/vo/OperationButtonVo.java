package com.act.web.module.command.vo;

import com.act.web.enums.ButtonEnum;
import com.act.web.module.common.vo.BaseVo;

/**
 * 
 * <p>Title: OperationButtonVo.java
 * <p>Description: 按钮展示对象
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:22:11
 */ 
public class OperationButtonVo extends BaseVo {
    
    /**
     * 是否隐藏    boolean 【false-不隐藏 ，true-隐藏】
     */
    private Boolean isHidden;
    
    /**
     * 标题  string  鼠标悬停显示值
     */
    private String title;
    
    /**
     * 1、查看EU；2、下发；3、取消下发
     */
    private Integer type;
    
    public OperationButtonVo() {
    }
    
    public OperationButtonVo(boolean isHidden,ButtonEnum buttonEnum) {
        this.isHidden = isHidden;
        this.title = buttonEnum.getTitle();
        this.type = buttonEnum.getType();
    }

    /**
     * @return the isHidden
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * @param isHidden the isHidden to set
     */
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

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
