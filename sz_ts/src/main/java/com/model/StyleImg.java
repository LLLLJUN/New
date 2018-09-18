package com.model;

import java.io.Serializable;

/**
 * 款式对应图片表
 * @author lujun
 *
 */
public class StyleImg implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9145699904321799891L;
	private int id;
	private String style;
	private String url;
	private String createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "StyleImg [id=" + id + ", style=" + style + ", url=" + url + ", createTime=" + createTime + "]";
	}

	

	
}
