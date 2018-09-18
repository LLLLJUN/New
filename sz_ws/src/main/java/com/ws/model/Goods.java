package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年6月29日
 */

@Data
@ApiModel(value = "Goods", description = "商品详情参数实体bean")
public class Goods  {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "商品标识码")
	private String sku;
	
	@ApiModelProperty(value = "商品名字")
	private String name;
	
	@ApiModelProperty(value = "商品款式")
	private String style;
	
	@ApiModelProperty(value = "商品颜色")
	private String colors;
	
	@ApiModelProperty(value = "商品尺码")
	private String sizes;
	
	@ApiModelProperty(value = "单位")
	private String unit;
	
	@ApiModelProperty(value = "采购价")
	private String purchasePrice;
	
	@ApiModelProperty(value = "牌价")
	private String listPrice;
	
	@ApiModelProperty(value = "现价")
	private String curPrice;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "预警上线")
	private int upperLimitNum;
	
	@ApiModelProperty(value = "预警下线")
	private int lowerLimitNum;
	
	
	

}
