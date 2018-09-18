package com.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "AppVersion",description="app更新参数实体bean")
@Data
public class AppVersion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 872503745346710400L;
	
	@ApiModelProperty(value = "主键id")
	private int id;
	
	@ApiModelProperty(value = "app版本号")
	private int versionCode;
	
	@ApiModelProperty(value = "app版本名字")
	private String versionName;
	
	@ApiModelProperty(value = "app更新信息")
	private String messages;
	
	@ApiModelProperty(value = "appurl")
	private String appUrl;
	
	@ApiModelProperty(value = "app创建时间")
	private String appCreateDate;
	
	
	
	
}
