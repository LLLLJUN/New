package com.ws.model;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年6月29日
 * app更新实体类
 */
@Data
@ApiModel(value="AppVersion",description="app版本信息实体bean")
public class AppVersion {
	
	@ApiModelProperty(value = "主键ID" )
	private int id;
	
	@ApiModelProperty(value = "版本编号" )
	private int versionCode;
	
	@ApiModelProperty(value = "版本名字" )
	private String versionName;
	
	@ApiModelProperty(value = "描述信息" )
	private String messages;
	
	@ApiModelProperty(value = "app下载路径" )
	private String appUrl;
	
	@ApiModelProperty(value = "app创建时间" )
	private String appCreateDate;
	
	
	
}
