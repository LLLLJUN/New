package com.controller;

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

import com.service.MatchDataService;
import com.util.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月26日
 */
@Api(value="搭配款式接口")
@Controller
public class MatchDataController {
	@Resource
	private MatchDataService matchDataService;
	
	@ApiOperation(value="获取搭配款式关注数据")
	@RequestMapping(value="queryMatchData",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryMatchData(@RequestParam("storeCode")String storeCode,
			@RequestParam("time")String time){
		return matchDataService.queryMatchData(storeCode, time);
		
	}
	
	@ApiOperation(value="批量增加搭配数据")
	@RequestMapping(value="batchInsertMatchData",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseResult<String>> batchInsertMatchData(HttpServletRequest requ,  @RequestBody JSONObject  jsonObject){
		return matchDataService.batchInsertMatchData(requ, jsonObject);
	}
}
