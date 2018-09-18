package com.ws.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.ws.model.ResponseResult;
import com.ws.service.InStoreService;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月4日
 */
@Api(value="入库Controller")
@Controller
public class InStoreController {
	
	@Resource
	private InStoreService inStoreService;
	
	@ApiOperation(value="插入入库信息",httpMethod="POST")
	@RequestMapping(value="insertInStore",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="jsonObject",value="入库信息json",required=true,dataType="JSONObject")
	ResponseEntity<ResponseResult<String>> insertInStore(@RequestBody JSONObject jsonObject){
		return inStoreService.insertInStore(jsonObject);
	}
	
	@ApiOperation(value="查询待入库列表信息",httpMethod="GET")
	@RequestMapping(value="selectNoInStore",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRow",value="当前页",required=false,dataType="Integer"),
		@ApiImplicitParam(name="storeCode",value="门店编码",required=true,dataType="String")
	})	
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectNoInStore(@RequestParam(value="pageRow",defaultValue="1")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return inStoreService.selectNoInStoreList(storeCode, pageRow);
	}
	
	@ApiOperation(value="根据采购单号查询对应的待入库商品信息",httpMethod="GET")
	@RequestMapping(value="selectPurchaseCodeStorage",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="purchaseCode",value="采购单号",required=true,dataType="String")
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectPurchaseCodeStorage(@RequestParam("purchaseCode")String purchaseCode){
		return inStoreService.selectByPurchaseCodeStorage(purchaseCode);
	}
	
	@ApiOperation(value="查询已入库列表信息",httpMethod="GET")
	@RequestMapping(value="selectYesInStore",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRow",value="当前页",required=false,dataType="Integer"),
		@ApiImplicitParam(name="storeCode",value="门店编码",required=true,dataType="String")
	})
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectYesInStore(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return inStoreService.selectYesInStoreList(storeCode, pageRow);
	}
	
	@ApiOperation(value="根据入库单号查询对应的已入库商品信息",httpMethod="GET")
	@RequestMapping(value="selectByPurchaseCodeYesInStore",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="inStoreCode",value="入库单号",required=true,dataType="String")
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCodeYesInStore(@RequestParam("inStoreCode")String inStoreCode){
		return inStoreService.selectByPurchaseCodeYesInStore(inStoreCode);
	}
	
	
	
}
