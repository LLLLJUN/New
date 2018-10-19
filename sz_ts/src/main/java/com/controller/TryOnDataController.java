package com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.TryOnDataService;
import com.util.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月26日
 */
@Api(value="试穿数据接口")
@Controller
public class TryOnDataController {
	//试穿数据接口
	@Resource
	private TryOnDataService tryOnDataService;
	
	@ApiOperation(value="获取试穿数据")
	@RequestMapping(value="queryTryOnData",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTryOnData(@RequestParam("storeCode")String storeCode,
			@RequestParam("time")String time){
		return tryOnDataService.queryTryOnData(storeCode, time);
		
	}
	
	
	@ApiOperation(value="获取各个门店的试穿数据和搭配数据总数")
	@RequestMapping(value="queryTotalStoreData",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> queryTotalStoreData(@RequestParam("time") String time,HttpServletRequest requ,HttpServletResponse resp){
		return tryOnDataService.queryToTalStoreTryOnData(time,requ,resp);
	}
	
	@ApiOperation(value="获取指定门店，时间段各个款式的试穿数据和搭配数据总数")
	@RequestMapping(value="queryTotalByStoreCodeData",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> queryTotalByStoreCodeData(@RequestParam("time") String time,@RequestParam("storeCode")String storeCode,HttpServletRequest requ){
		return tryOnDataService.queryByStoreCodeAndTimeTryOnDataAndMatchData(time, storeCode, requ);
	}
	
	
	@ApiOperation(value="批量增加试穿数据")
	@RequestMapping(value="batchInsertTryOnData",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseResult<String>> batchInsertTryOnData(@RequestBody JSONObject jsonObject,HttpServletRequest requ){
		return tryOnDataService.batchInsertTryOnData(jsonObject, requ);
		
	}
	
	@ApiOperation(value="获取单个门店试穿数据")
	@RequestMapping(value="queryByStoreCodeAndTimeGetData",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> queryByStoreCodeAndTimeGetData(@RequestParam("storeCode")String storeCode,
			@RequestParam("time")String time,HttpServletRequest requ){
		return tryOnDataService.queryByStoreCodeAndTimeGetData(time, storeCode, requ);
		
	}
	
	@ApiOperation(value="获取所有门店试穿数据")
	@RequestMapping(value="querytByTimeGetTotalStoreTryOnData",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> querytByTimeGetTotalStoreTryOnData(@RequestParam("time")String time,HttpServletRequest requ){
		return tryOnDataService.queryByTimeGetTotalStoreTryOnData(time, requ);
		
	}
}
