package com.model;

import java.io.Serializable;

/**
 * @author lujun
 * @date 2018年6月21日
 */
public class GoodsInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 125157358608183649L;
	private int id;
	private String style;
	private String name;
	private String listPrice;
	private String curPrice;
	private String colors;
	private String sizes;
	private String onlineUrl;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getListPrice() {
		return listPrice;
	}
	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}
	public String getCurPrice() {
		return curPrice;
	}
	public void setCurPrice(String curPrice) {
		this.curPrice = curPrice;
	}
	public String getOnlineUrl() {
		return onlineUrl;
	}
	public void setOnlineUrl(String onlineUrl) {
		this.onlineUrl = onlineUrl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "GoodsInfo [id=" + id + ", style=" + style + ", name=" + name + ", listPrice=" + listPrice
				+ ", curPrice=" + curPrice + ", colors=" + colors + ", sizes=" + sizes + ", onlineUrl=" + onlineUrl
				+ ", createTime=" + createTime + "]";
	}
	
	
	
	
}
