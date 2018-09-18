package com.ws.model;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月9日
 */
@Data
@ApiModel(value="Duty",description="用户权限参数实体bean")
public class Duty {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "用户权限")
	private String userPermission;
	
	@ApiModelProperty(value = "权限描述")
	private String userDuty;
	

	
	
}
