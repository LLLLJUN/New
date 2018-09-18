package com.ws.model;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月9日
 */
@Data
@ApiModel(value="OutStoreDetail",description="出库商品详情参数实体bean ")
public class OutStoreDetail {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "关联出库单号")
	private String outStoreCode;
	
	@ApiModelProperty(value = "商品标识码")
	private String sku;
	
	@ApiModelProperty(value = "商品颜色")
	private String color;
	
	@ApiModelProperty(value = "商品尺码")
	private String size;
	
	@ApiModelProperty(value = "采购价")
	private String purchasePrice;
	
	@ApiModelProperty(value = "出库数量")
	private int outStoreNum;
	
	
	
}
