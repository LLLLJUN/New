package com.ws.controller;

import java.util.List;
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
import com.ws.service.StorageService;

/**
 * @author lujun
 * @date 2018年7月3日
 */
@Api(value="门店库存接口")
@Controller
public class StorageController {
	@Resource
	private StorageService storageService;
	
	@ApiOperation(value="门店库存查询",httpMethod="GET")
	@RequestMapping(value="selectAllStorage",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="storeCode",value="门店代码",required=true,dataType="String")
	public ResponseEntity<ResponseResult<List<Map<String,Object>>>> selectAllStorage(@RequestParam("storeCode")String storeCode,HttpServletRequest requ,HttpServletResponse resp){
		return storageService.selectAllStorage(storeCode);
	}
	

}
