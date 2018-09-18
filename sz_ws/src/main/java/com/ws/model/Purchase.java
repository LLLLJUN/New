package com.ws.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月2日
 * 
 */

@Data
@ApiModel(value = "Purchase",description = "供应商参数实体bean")
public class Purchase {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;
	
	@ApiModelProperty(value = "采购总价")
	private String goodsTotalPrices;
	
	@ApiModelProperty(value = "采购总数")
	private int goodsAllNum;
	
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;
	
	@ApiModelProperty(value = "预计入库仓库")
	private String warehouse;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "采购人")
	private String userName;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "入库状态")
	private int inStoreState;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	//关联字段
	private List<PurchaseDetail> purchaseDetailList;
	private Supplier supplier;
	
	
	
	
	
}
