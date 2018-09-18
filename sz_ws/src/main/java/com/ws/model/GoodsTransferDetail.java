package com.ws.model;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月6日
 */
@Data
@ApiModel(value="GoodsTransferDetaill",description="转货商品详情参数实体bean")
public class GoodsTransferDetail {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "关联转货单号")
	private String transferCode;
	
	@ApiModelProperty(value = "商品标识码")
	private String sku;
	
	@ApiModelProperty(value = "商品颜色")
	private String color;
	
	@ApiModelProperty(value = "商品尺码")
	private String size;
	
	@ApiModelProperty(value = "商品采购价")
	private String purchasePrice;
	
	@ApiModelProperty(value = "转货数量")
	private int transferNum;
	
	
}
