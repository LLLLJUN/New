package com.ws.controller;

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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;
import com.ws.model.ResponseResult;
import com.ws.service.SupplierService;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月2日
 */
@Api(value="供应商接口")
@Controller
public class SupplierController {
	
	@Resource
	private SupplierService supplierService;
	
	@ApiOperation(value="新增供应商",httpMethod="POST")
	@RequestMapping(value="insertSupplier",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(value="供应商信息json",name="jsonObject",required=true,dataType="JSONObject")
	public ResponseEntity<ResponseResult<Map<String,Object>>> insertSupperlier(@RequestBody JSONObject jsonObject,HttpServletRequest requ,
			HttpServletResponse resp){
		return supplierService.insertSupplier(jsonObject);
	}
	
	@ApiOperation(value="删除供应商",httpMethod="GET")
	@RequestMapping(value="deleteBySupplierCode",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(value="供应商编码",name="supplierCode",required=true,dataType="String")
	public ResponseEntity<ResponseResult<String>> deleteBySupplierCode(@RequestParam("supplierCode")String supplierCode,HttpServletRequest requ,
			HttpServletResponse resp){
		return supplierService.deleteBySupplierCode(supplierCode);
	}
	
	@ApiOperation(value="更新供应商信息",httpMethod="POST")
	@RequestMapping(value="updateBySupplier",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="jsonObject",value="供应商信息json",required=true,dataType="JSONObject")
	public ResponseEntity<ResponseResult<String>> updateBySupplier(@RequestBody JSONObject jsonObject,HttpServletRequest requ,
			HttpServletResponse resp){
		return supplierService.updateBySupplier(jsonObject);
	}
	
	@ApiOperation(value="供应商详情",httpMethod="GET")
	@RequestMapping(value="selectBySupplierCode",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(value="供应商编码",name="supplierCode",required=true,dataType="String")
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectBySupplierCode(@RequestParam("supplierCode")String  supplierCode,HttpServletRequest requ,
			HttpServletResponse resp){
		return supplierService.selectBySupplierCode(supplierCode);
	}
	
	@ApiOperation(value="供应商列表",httpMethod="GET")
	@RequestMapping(value="selectAllSupplier",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(value="当前页",name="pageRow",required=true,dataType="Integer")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectAllSupplier(@RequestParam("pageRow")int pageRow,HttpServletRequest requ,
			HttpServletResponse resp){
		return supplierService.selectAllSupplier(pageRow);
		
	}

}
