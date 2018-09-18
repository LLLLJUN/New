package com.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 2018/6/14
 * 广告实体类
 */
@ApiModel(value="Advertising",description="广告参数实体bean")
public class Advertising implements Serializable {
	
	private static final long serialVersionUID = -7176180073833093396L;
	/**
	 * 
	 */
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "广告图片版本编号")
	private int adVersion;
	
	@Length(min=2,max=10,message="不能小于2，大于10")
	@ApiModelProperty(value = "广告图片Url")
	private String adUrl; 
	
	@ApiModelProperty(value = "广告图片创建时间")
	private String adCreateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdVersion() {
		return adVersion;
	}
	public void setAdVersion(int adVersion) {
		this.adVersion = adVersion;
	}
	public String getAdUrl() {
		return adUrl;
	}
	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}
	public String getAdCreateDate() {
		return adCreateDate;
	}
	public void setAdCreateDate(String adCreateDate) {
		this.adCreateDate = adCreateDate;
	}
	@Override
	public String toString() {
		return "Advertising [id=" + id + ", adVersion=" + adVersion + ", adUrl=" + adUrl + ", adCreateDate="
				+ adCreateDate + "]";
	}
	
	
	
	
	 
}
