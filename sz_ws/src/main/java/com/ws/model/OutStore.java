package com.ws.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月9日
 */

@Data
@ApiModel(value = "OutStore",description="出库详情参数实体bean")
public class OutStore {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "出库单编号")
	private String outStoreCode;
	
	@ApiModelProperty(value = "出库总数")
	private int goodsAllNum;
	
	@ApiModelProperty(value = "出库总价")
	private String goodsTotalPrices;
	
	@ApiModelProperty(value = "出库方式")
	private int outStoreMode;
	
	@ApiModelProperty(value = "关联转货单号")
	private String relevanceCode;
	
	@ApiModelProperty(value = "实际出库仓库")
	private String warehouse;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "出库人")
	private String userName;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "出库完成时间")
	private String outStoreTime;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	//关联字段
	private int outStoreState;
	private List<OutStoreDetail> outStoreDetailList;
	
}
