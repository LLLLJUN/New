package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SaleDetail",description = "销售详情参数实体bean")
public class SaleDetail {
	
	@ApiModelProperty(value = "主键id")
	private int id;
	
	@ApiModelProperty(value = "销售单据编号")
	private String saleBillNo;
	
	@ApiModelProperty(value = "商品sku")
	private String sku;
	
	@ApiModelProperty(value = "商品颜色")
	private String color;
	
	@ApiModelProperty(value = "商品尺码")
	private String size;
	
	@ApiModelProperty(value = "商品名字")
	private String name;
	
	@ApiModelProperty(value = "商品款式")
	private String style;
	
	@ApiModelProperty(value = "牌价")
	private String listPrice;
	
	@ApiModelProperty(value = "现价")
	private String curPrice;
	
	@ApiModelProperty(value = "销售数量")
	private int saleNum;
	
	@ApiModelProperty(value = "销售总价")
	private String allPrice;
}
