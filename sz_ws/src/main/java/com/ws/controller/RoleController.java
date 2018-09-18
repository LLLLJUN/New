package com.ws.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.ws.model.ResponseResult;
import com.ws.service.RoleService;

import io.swagger.annotations.ApiOperation;

/**
 * @author lujun
 * @date 2018年7月24日
 */
@Controller
@Api(value= "角色接口")
public class RoleController {
	@Resource
	private RoleService roleService;
	
	@RequestMapping(value="queryAllRoleInfo")
	@ResponseBody
	@ApiOperation(value="获取所有角色信息")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryAllRoleInfo(){
		return roleService.seleceAllRoleInfo();
	}
}
