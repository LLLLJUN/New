
package com.model;

import java.io.Serializable;

/**
 * @author lujun
 * @date 2018年6月21日
 */
public class StyleInfo implements Serializable {
	
	private static final long serialVersionUID = 6429943300872636770L;
	/**
	 * 
	 */

	private int id;
	private String style;
	private String info;
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
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "StyleInfo [id=" + id + ", style=" + style + ", info=" + info + ", createTime=" + createTime + "]";
	}
	
	
	
	
}
