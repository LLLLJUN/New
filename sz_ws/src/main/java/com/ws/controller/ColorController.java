package com.ws.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.ws.model.ResponseResult;
import com.ws.service.ColorService;

import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="商品颜色接口")
public class ColorController {
	
	@Resource
	private ColorService colorService;
	
	@ApiOperation(value="increaseColor",httpMethod="GET")
	@ApiImplicitParam(name="colorName",value="颜色名字",paramType="String")
	@RequestMapping(value="increaseColor",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ResponseResult<Map<String, Object>>> increaseColor(@RequestParam("colorName")String colorName, HttpServletRequest requ){
		return colorService.increaseColor(colorName,requ);
	}
	
	@ApiOperation(value="queryTotalColorInfo",httpMethod="GET")
	@RequestMapping(value="queryTotalColorInfo",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalColorInfo(){
		return colorService.queryTotalColorInfo();
	}
}
