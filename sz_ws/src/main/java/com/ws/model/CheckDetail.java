package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月5日
 * 
 */

@Data
@ApiModel(value = "CheckDetail",description = "盘点单商品详情参数实体bean")
public class CheckDetail {
	
	@ApiModelProperty(value="主键ID")
	private int id;
	
	@ApiModelProperty(value="关联盘点单号")
	private String checkBillCode;
	
	@ApiModelProperty(value="商品标识码")
	private String sku;
	
	@ApiModelProperty(value="商品颜色")
	private String color;
	
	@ApiModelProperty(value="商品尺码")
	private String size;
	
	@ApiModelProperty(value="预盘数量")
	private int planNum;
	
	@ApiModelProperty(value="实盘数量")
	private int realNum;
	
	
}
