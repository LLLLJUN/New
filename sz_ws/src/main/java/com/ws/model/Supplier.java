package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月2日
 * 供应商实体类
 */

@Data
@ApiModel(value = "Supplier",description = "供应商参数实体bean")
public class Supplier {
	
	@ApiModelProperty(value = "供应商编码")
	private int id;
	
	@ApiModelProperty(value = "供应商代码")
	private String supplierCode;
	
	@ApiModelProperty(value = "供应商名字")
	private String supplierName;
	
	@ApiModelProperty(value = "供应商联系人")
	private String supplierMan;
	
	@ApiModelProperty(value = "供应商电话")
	private String supplierTel;
	
	@ApiModelProperty(value = "供应商email")
	private String supplierMail;
	
	@ApiModelProperty(value = "供应商地址")
	private String supplierAddress;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
}
