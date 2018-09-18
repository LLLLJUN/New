package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lujun
 * @date 2018年7月12日
 */

@Data
@ApiModel(value = "Role",description = "角色参数实体bean")
public class Role {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "角色描述")
	private String userRoleName;
	
	@ApiModelProperty(value = "角色")
	private String role;
	

	
	
	
}
