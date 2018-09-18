package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月4日
 * 
 */

@Data
@ApiModel(value = "InStoreDetali",description = "入库商品详情参数实体bean")
public class InStoreDetail {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "关联入库单编号")
	private String inStoreCode;
	
	@ApiModelProperty(value = "商品标识码")
	private String sku;
	
	@ApiModelProperty(value = "商品颜色")
	private String color;
	
	@ApiModelProperty(value = "商品尺码")
	private String size;
	
	@ApiModelProperty(value = "采购价")
	private String purchasePrice;
	
	@ApiModelProperty(value = "入库数量")
	private int inStoreNum;
	
	
}
