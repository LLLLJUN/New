package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Color",description="颜色参数实体bean")
public class Color {
	
	@ApiModelProperty(value = "主键id")
	private int id;
	
	@ApiModelProperty(value = "颜色编码")
	private String color;
	
	@ApiModelProperty(value = "颜色名字")
	private String colorName;
}
