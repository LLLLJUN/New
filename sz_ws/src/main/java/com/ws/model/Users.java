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
@ApiModel(value = "Users",description = "用户参数实体bean")
public class Users {
	
	@ApiModelProperty(value = "主键ID")
	private int id;
	
	@ApiModelProperty(value = "用户名字")
	private String userName;
	
	@ApiModelProperty(value = "用户编码")
	private String userCode;
	
	@ApiModelProperty(value = "用户密码")
	private String userPsw;
	
	@ApiModelProperty(value = "用户角色")
	private int userRole;
	
	@ApiModelProperty(value = "用户Email")
	private String userMail;
	
	@ApiModelProperty(value = "用户电话")
	private String userTel;
	
	@ApiModelProperty(value = "门店代码")
	private String storeCode;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	
	
	
	
	

}
