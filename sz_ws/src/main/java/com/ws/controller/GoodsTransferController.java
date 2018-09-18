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
import com.ws.service.GoodsTransferService;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月6日
 */
@Controller
@Api(value="转货单接口")
public class GoodsTransferController {
	@Resource
	private GoodsTransferService goodsTransferService;
	
	@ApiOperation(value="插入转货单信息",httpMethod="POST")
	@RequestMapping(value="insertGoodsTransfer",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="jsonObject",value="插入转货单json",required=true,dataType="JSONObject")
	public ResponseEntity<ResponseResult<String>> insertGoodsTransfer(@RequestBody JSONObject jsonObject){
		return goodsTransferService.insertGoodsTransfer(jsonObject);
	}
	
	@ApiOperation(value="删除转货单信息",httpMethod="GET")
	@RequestMapping(value="insertGoodsTransfer",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="transferCode",value="转货单号",required=true,dataType="String")
	public ResponseEntity<ResponseResult<String>> deleteGoodsTransfer(@RequestParam("transferCode")String transferCode){
		return goodsTransferService.deleteGoodsTransfer(transferCode);
	}
	
	@ApiOperation(value="查询转货单信息",httpMethod="GET")
	@RequestMapping(value="selectByTransfer",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="transferCode",value="转货单号",required=true,dataType="String")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectByTransfer(@RequestParam("transferCode")String transferCode){
		return goodsTransferService.selectByTransferCode(transferCode);
	}
	
	@ApiOperation(value="查询转货单列表信息",httpMethod="GET")
	@RequestMapping(value="selectGoodsTransfer",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageRow",value="当前页",required=false,dataType="Integer"),
		@ApiImplicitParam(name="storeCode",value="门店编码",required=true,dataType="String")
	})
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectGoodsTransfer(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return goodsTransferService.selectGoodsTransferList(pageRow, storeCode);
	}
 
}
