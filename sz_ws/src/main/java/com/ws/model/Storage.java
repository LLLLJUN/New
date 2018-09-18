package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月3日
 * 
 */

@Data
@ApiModel(value = "Storage",description = "库存参数实体bean")
public class Storage {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "商品标识码")
	private String sku;
	
	@ApiModelProperty(value = "商品颜色")
	private String color;
	
	@ApiModelProperty(value = "商品尺码")
	private String size;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "数量")
	private int num;
	
	
	
}
