package com.ws.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.ws.model.ResponseResult;
import com.ws.service.SizeService;

import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="商品尺码接口")
public class SizeController {
	
	@Resource
	private SizeService sizeService;
	
	@ApiOperation(value="increaseSize",httpMethod="GET")
	@ApiImplicitParam(name="sizeName",value="尺码名字",paramType="String")
	@RequestMapping(value="increaseSize",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ResponseResult<Map<String, Object>>> increaseSize(@RequestParam("sizeName")String sizeName){
		return sizeService.increaseSize(sizeName);
	}
	
	@ApiOperation(value="queryTotalSizeInfo",httpMethod="GET")
	@RequestMapping(value="queryTotalSizeInfo",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalSizeInfo(){
		return sizeService.queryTotalSizeInfo();
	}
}
