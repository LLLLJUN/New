package com.model;

import java.io.Serializable;

/**
 * @author lujun
 * @date 2018年6月25日
 * 试穿数据实体类
 */
public class TryOnData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6398868927098974623L;
	private int id;
	private String equipment;
	private String style;
	private String storeCode;
	private String createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	

	
	
	
}
