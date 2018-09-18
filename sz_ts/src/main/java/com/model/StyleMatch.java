package com.model;

import java.io.Serializable;

/**
 * @author lujun
 * @date 2018年6月21日
 */
public class StyleMatch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3202777469192182028L;
	private int id;
	private String style;
	private String matchStyle;
	private String matchUrl;
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
	public String getMatchStyle() {
		return matchStyle;
	}
	public void setMatchStyle(String matchStyle) {
		this.matchStyle = matchStyle;
	}
	public String getMatchUrl() {
		return matchUrl;
	}
	public void setMatchUrl(String matchUrl) {
		this.matchUrl = matchUrl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "StyleMatch [id=" + id + ", style=" + style + ", matchStyle=" + matchStyle + ", matchUrl=" + matchUrl
				+ ", createTime=" + createTime + "]";
	}
	

	
	
	
	
}
