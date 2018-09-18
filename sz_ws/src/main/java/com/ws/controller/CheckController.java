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
import com.ws.service.CheckService;
import com.ws.util.resp.ResponsePageResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月5日
 */
@Controller
@Api(value="盘点单接口")
public class CheckController {
	
	@Resource
	private CheckService checkService;
	
	@RequestMapping(value="insertCheck",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增盘点单",httpMethod="POST")
	@ApiImplicitParam(name="jsonObject",value="新增盘点单信息json",dataType="JSONObject")
	public ResponseEntity<ResponseResult<String>> insertCheck(@RequestBody JSONObject jsonObject,HttpServletRequest requ){
		return checkService.insertCheck(jsonObject);
	}
	
	@RequestMapping(value="selectCheckByCheckBillCode",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据盘点单号查询盘点商品信息",httpMethod="GET")
	@ApiImplicitParam(name="checkBillCode",value="盘点单号",required=true,dataType="String")
	public ResponseEntity<ResponsePageResult<Map<String, Object>>> selectCheckByCheckBillCode(@RequestParam("checkBillCode")String checkBillCode,HttpServletRequest requ){
		return checkService.selectCheckByCheckBillCode(checkBillCode);
	}
	@RequestMapping(value="selectCheckList",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="待盘点单列表查询",httpMethod="GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRow",value="当前页",required=false,dataType="Integer"),
		@ApiImplicitParam(name="storeCode",value="门店编码",required=true,dataType="String")
	})
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectCheckList(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return checkService.selectCheckList(pageRow, storeCode);
	} 
	
	@RequestMapping(value="selectYesCheckList",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="以盘点单列表查询",httpMethod="GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRow",value="当前页",required=false,dataType="Integer"),
		@ApiImplicitParam(name="storeCode",value="门店编码",required=true,dataType="String")
	})
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectYesCheckList(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return checkService.selectYesCheckList(pageRow, storeCode);
	}
	
	@RequestMapping(value="updateCheck",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="盘点单信息上传",httpMethod="POST")
	@ApiImplicitParam(name="jsonObject",value="盘点单信息json",dataType="JSONObject",required=true)
	public ResponseEntity<ResponseResult<String>> updateCheck(@RequestBody JSONObject jsonObject,HttpServletRequest requ){
		return checkService.updateCheck(jsonObject);
	}
}
