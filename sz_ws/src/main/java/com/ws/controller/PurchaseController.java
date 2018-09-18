 package com.ws.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.ws.service.PurchaseService;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月2日
 */
@Api(value="采购单接口")
@Controller
public class PurchaseController {
	
	@Resource
	private PurchaseService purchaseService;
	
	@ApiOperation(value="新增采购单",httpMethod="POST",notes="详细json")
	@RequestMapping(value="insertPurchase",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="jsonObject",value="采购单信息json",required=true,dataType="JSONObject")
	public ResponseEntity<ResponseResult<String>> insertPurchase(@RequestBody JSONObject jsonObject,HttpServletRequest requ){
		return purchaseService.insertPurchase(jsonObject);
	}
	
	@ApiOperation(value="删除采购单",httpMethod="GET")
	@RequestMapping(value="deletePurchase",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="purchaseCode",value="采购单号",required=true,dataType="String")
	public ResponseEntity<ResponseResult<String>> deletePurchase(@RequestParam("purchaseCode")String purchaseCode){
		return purchaseService.deletePurchase(purchaseCode);
	}
	
	@ApiOperation(value="采购单详情",httpMethod="GET")
	@RequestMapping(value="selectByPurchaseCode",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="purchaseCode",value="采购单号",required=true,dataType="String")
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCode(@RequestParam("purchaseCode")String purchaseCode){
		return purchaseService.selectByPurchaseCode(purchaseCode);
	}
	
	@ApiOperation(value="采购单列表",httpMethod="GET")
	@RequestMapping(value="selectPurchaseList",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRow",value="当前页",required=false,dataType="Integer"),
		@ApiImplicitParam(name="storeCode",value="门店编码",required=true,dataType="String")
	})
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectPurchaseList(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return purchaseService.selectByPurchaseList(pageRow, storeCode);
				
	}
	
	
	
}
