package com.ws.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月3日
 * 入库信息实体类
 */

@Data
@ApiModel(value = "InStore",description = "入库参数实体bean")
public class InStore {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "入库单编号")
	private String inStoreCode;
	
	@ApiModelProperty(value = "关联采购单编号")
	private String purchaseCode;
	
	@ApiModelProperty(value = "入库人")
	private String userName;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "备注信息")
	private String remark;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "实际入库仓库")
	private String warehouse;
	
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;
	
	@ApiModelProperty(value = "入库商品总价")
	private String goodsTotalPrices;
	
	@ApiModelProperty(value = "入库商品总数")
	private int GoodsAllNum;
	
	//子查询字段
	private int inStoreState;
	private List<InStoreDetail> inStoreDetailList;
	
	
	
	
}
