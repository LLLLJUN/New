package com.model;

import java.io.Serializable;

/**
 * @author lujun
 * @date 2018年6月25日
 * 搭配款关注数据实体类
 */
public class MatchData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1542878050248837437L;
	private int id;
	private String matchStyle;
	private String style;
	private String storeCode;
	private String equipment;
	private String createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatchStyle() {
		return matchStyle;
	}
	public void setMatchStyle(String matchStyle) {
		this.matchStyle = matchStyle;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	
	
	
	
}
