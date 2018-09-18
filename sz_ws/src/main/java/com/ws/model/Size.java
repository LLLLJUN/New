package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Size",description="尺码参数实体bean")
public class Size {
	
	@ApiModelProperty(value = "主键id")
	private int id;
	
	@ApiModelProperty(value = "尺码编码")
	private String size;
	
	@ApiModelProperty(value = "尺码名字")
	private String sizeName;
}
