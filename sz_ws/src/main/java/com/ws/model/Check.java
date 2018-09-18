package com.ws.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "Check",description = "商品盘点参数实体bean")
public class Check {
	
	@ApiModelProperty(value =  "主键ID")
	private int id;
	
	@ApiModelProperty(value =  "盘点单编号")
	private String checkBillCode;
	
	@ApiModelProperty(value =  "盘点单创建时间")
	private String createTime;
	
	@ApiModelProperty(value =  "盘点模式")
	private int checkMode;
	
	@ApiModelProperty(value =  "盘点状态")
	private int checkState;
	
	@ApiModelProperty(value =  "与盘点总数")
	private int planAllNum;
	
	@ApiModelProperty(value =  "实盘点总数")
	private int realAllNum;
	
	@ApiModelProperty(value =  "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value =  "盘点单制单人")
	private String checkMakeMan;
	
	@ApiModelProperty(value =  "盘点人姓名")
	private String checkMan;
	
	@ApiModelProperty(value =  "盘点完成时间")
	private String checkTime;
	
	@ApiModelProperty(value =  "备注信息")
	private String remark;
	
	//子查询字段
	private List<CheckDetail> checkDetailList;
	
	
}
