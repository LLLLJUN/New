package com.ws.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;
import com.ws.model.ResponseResult;
import com.ws.service.AppVersionService;


@Api(value="AppVersionController是app更新控制层")
@Controller
public class AppVersionController {
	@Resource
	private AppVersionService appVersionService;
	
	@ApiOperation(value="app更新",httpMethod="GET")
	@RequestMapping(value="selectAppVersion", method= RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="appVersion",value="app版本号",dataType="Integer",required=true)
	public ResponseEntity<ResponseResult<Map<String,Object>>> selectAppVersion(@RequestParam("appVersion")Integer appVersion,
			HttpServletRequest requ,HttpServletResponse resp){
		return appVersionService.selectAppVersion(appVersion,requ,resp);
	};

}
