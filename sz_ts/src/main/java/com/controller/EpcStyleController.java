package com.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.EpcStyleService;
import com.util.ResponseResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author lujun
 * @date 2018年6月21日
 */
@Controller
public class EpcStyleController {
	
	@Resource
	private EpcStyleService epcStyleService;
	
	@ApiOperation(value="获取试穿信息")
	@RequestMapping(value="selectByEpc" ,method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectByEpc(@RequestParam("epc")String epc,@RequestParam("storeCode") String storeCode){
		return epcStyleService.insertByEpc(epc,storeCode);
	}
	
	@ApiOperation(value="获取搭配款信息")
	@RequestMapping(value="selectByMatchStyle",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectByMatchStyle(@RequestParam("matchStyle")String matchStyle,@RequestParam("style")String style,@RequestParam("storeCode")String storeCode){
		return epcStyleService.insertByMatchStyle(matchStyle, style,storeCode);
	}
	
}
