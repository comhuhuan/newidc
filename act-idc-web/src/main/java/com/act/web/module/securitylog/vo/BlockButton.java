package com.act.web.module.securitylog.vo;
/**
 * 
 * 
 * <p>Title: Block.java
 * <p>Description: 封堵按钮对象
 * @author zhufj
 * @date 2018年2月2日 下午2:40:35
 */
public class BlockButton {
	private boolean hidden;//是否隐藏
	private String title;//标题
	private String type;//按钮类型
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
