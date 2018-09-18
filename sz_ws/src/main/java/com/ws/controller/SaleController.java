package com.ws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;
import com.ws.model.Condition;
import com.ws.model.ResponseResult;
import com.ws.service.SaleService;

import net.sf.json.JSONObject;

@Controller
@Api(value = "销售接口")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	
	@RequestMapping(value = "queryGoodsPriceInfo",method=RequestMethod.GET)
	@ApiOperation(value="获取销售商品价格信息",httpMethod="GET")
	@ApiImplicitParam(name="sku",value="商品sku",dataType="String")
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> queryGoodsPriceInfo(@RequestParam("sku")String sku){
		return saleService.queryGoodsPriceInfo(sku);
	}
	
	@RequestMapping(value = "increaseSaleInfo",method=RequestMethod.POST)
	@ApiOperation(value="上传销售商品信息",httpMethod="POST")
	@ApiImplicitParam(name="jsonObject",value="商品信息json",dataType="JSONObject")
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> increaseSaleInfo(@RequestBody JSONObject jsonObject){
		return saleService.increaseSaleInfo(jsonObject);
	}
	
	@RequestMapping(value = "increaseSaleInfoList",method=RequestMethod.POST)
	@ApiOperation(value="批量上传销售商品信息",httpMethod="POST")
	@ApiImplicitParam(name="jsonObject",value="商品信息json",dataType="JSONObject")
	@ResponseBody
	public ResponseEntity<ResponseResult<String>> increaseSaleInfoList(@RequestBody JSONObject jsonObject){
		return saleService.increaseSaleList(jsonObject);
	}
	
	@ApiOperation(value="获得销售商品信息",httpMethod="GET")
	@RequestMapping(value="queryBySaleBillNoGetSaleGoodsInfo",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryBySaleBillNoGetSaleGoodsInfo(@RequestParam("saleBillNo")String saleBillNo){
		return saleService.queryBySaleBillNoGetSaleGoodsInfo(saleBillNo);
	}
	
	@ApiOperation(value="获取时间段内商品销售数据",httpMethod="GET")
	@RequestMapping(value="queryByTimeSaleInfo",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryByTimeSaleInfo(Condition condition){
		return saleService.queryByTimeSaleInfo(condition);
	}
}
