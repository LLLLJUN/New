package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="Sale",description = "销售参数实体bean")
public class Sale {
	
	@ApiModelProperty(value = "主键id")
	private int id;
	
	@ApiModelProperty(value = "销售单据编号")
	private String saleBillNo;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "销售人员代码")
	private String userCode;
	
	@ApiModelProperty(value = "销售人员名称")
	private String userName;
	
	@ApiModelProperty(value = "销售总数")
	private int totalNum;
	
	@ApiModelProperty(value = "销售总价")
	private String totalPrice;
	
	@ApiModelProperty(value = "销售时间")
	private String saleTime;
	
	@ApiModelProperty(value = "销售备注")
	private String remark;
}
