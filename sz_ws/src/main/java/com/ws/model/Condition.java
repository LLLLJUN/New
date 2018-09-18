package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月3日
 */
@Data
@ApiModel(value = "Condition", description = "条件参数实体bean")
public class Condition {
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "用户角色")
	private int userRole;
	
	@ApiModelProperty(value = "用户编码")
	private String userCode;
	
	@ApiModelProperty(value = "开始时间")
	private String startDate;
	
	@ApiModelProperty(value = "结束时间")
	private String endDate;
	
	@ApiModelProperty(value = "销售开单时间")
	private String saleTime;
	
	@ApiModelProperty(value = "款式")
	private String style;

}
