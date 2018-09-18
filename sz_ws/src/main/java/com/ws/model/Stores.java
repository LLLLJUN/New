package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年6月29日
 * 
 */

@Data
@ApiModel(value = "Stores",description = "门店参数实体bean")
public class Stores {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "门店名字")
	private String storeName;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "门店所属区域")
	private String storeArea;
	
	@ApiModelProperty(value = "门店地址")
	private String storeAddress;
	
	@ApiModelProperty(value = "门店电话")
	private String storeTel;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
		
}
