package com.ws.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.ws.model.ResponseResult;
import com.ws.service.StoresService;

import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="门店接口")
public class StoresController {
	@Resource
	private StoresService storesService;
	
	
	@ApiOperation(value="获取所有门店信息",httpMethod="GET")
	@RequestMapping(value="queryTotalStore",method=RequestMethod.GET)
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalStore(){
		return storesService.queryTotalStore();
	}
	
}
