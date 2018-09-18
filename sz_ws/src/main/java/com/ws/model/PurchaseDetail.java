package com.ws.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月2日
 * 
 */
@Data
@ApiModel(value = "PurchaseDetail",description = "采购商品详情参数实体bean")
public class PurchaseDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -653517491890656407L;
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "关联采购单号")
	private String purchaseCode;
	
	@ApiModelProperty(value = "商品标识码")
	private String sku;
	
	@ApiModelProperty(value = "商品颜色")
	private String color;
	
	@ApiModelProperty(value = "商品尺码")
	private String size;
	
	@ApiModelProperty(value = "采购数量")
	private int purchaseNum;
	
	@ApiModelProperty(value = "采购价格")
	private String purchasePrice;
	
	
}
