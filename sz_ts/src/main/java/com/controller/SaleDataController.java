package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.SaleDataService;
import com.util.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="销售数据接口")
public class SaleDataController {
	
	
	@Autowired
	private SaleDataService saleDataService;
	
	@RequestMapping(value="queryTotalSaleData",method=RequestMethod.GET)
	@ApiOperation(value="获取时间段内各门店销售额和销售量")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalSaleData(@RequestParam("time")String time){
		return saleDataService.queryTotalSaleData(time);
	} 
	
	@RequestMapping(value="querySaleBaseAndSaleWorstData",method=RequestMethod.GET)
	@ApiOperation(value="获取各门店时间段内各个款式的畅销款TOP10和滞销款Top10")
	public ResponseEntity<ResponseResult<Map<String, Object>>> querySaleBaseAndSaleWorstData(@RequestParam("time")String time,@RequestParam("storeCode")String storeCode){
		return saleDataService.querySaleBaseAndSaleWorstData(time, storeCode);
	} 
	
	@RequestMapping(value="querySaleBestWorstData",method=RequestMethod.GET)
	@ApiOperation(value="获取时间段内各款式销量最高与销量最低 门店的数据 ")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> querySaleBestWorstData(@RequestParam("time")String time){
		return saleDataService.querySaleBestWorstData(time);
	} 
	
	@RequestMapping(value="querySaleTryData",method=RequestMethod.GET)
	@ApiOperation(value="：获取各门店时间段内各个款式的销售量和试穿量数据")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> querySaleTryData(@RequestParam("time")String time,@RequestParam("storeCode")String storeCode){
		return saleDataService.querySaleTryData(time, storeCode);
	} 
	
}
