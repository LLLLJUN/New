package com.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="Condition",description="条件参数实体bean")
@Data
public class Condition {
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "门店归属地")
	private String storeArea;
}
