package com.ws.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月6日
 */

@Data
@ApiModel(value="GoodsTransfer",description="转货详情参数实体bean")
public class GoodsTransfer {

	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "转货单编号")
	private String transferCode;
	
	@ApiModelProperty(value = "转货商品总数")
	private int goodsAllNum;
	
	@ApiModelProperty(value = "转货商品总价")
	private String goodsTotalPrices;
	
	@ApiModelProperty(value = "转货出库状态")
	private int outStoreState;
	
	@ApiModelProperty(value = "转货入库状态")
	private int inStoreState;
	
	@ApiModelProperty(value = "出货门店代码")
	private String sendStoreCode;
	
	@ApiModelProperty(value = "出货门店名字")
	private String sendStoreName;
	
	@ApiModelProperty(value = "预计出货仓库")
	private String warehouse;
	
	@ApiModelProperty(value = "收货门店代码")
	private String receiveStoreCode;
	
	@ApiModelProperty(value = "收货门店名字")
	private String receiveStoreName;
	
	@ApiModelProperty(value = "转货单创建人")
	private String userName;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	//子查询字段
	private List<GoodsTransferDetail> goodsTransferDetailList;
	
	
}
