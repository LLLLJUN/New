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
import com.ws.service.OutStoreService;

import net.sf.json.JSONObject;


/**
 * @author lujun
 * @date 2018年7月10日
 */
@Api(value="出库接口")
@Controller
public class OutStoreController {
	@Resource
	private OutStoreService outStoreService;
	
	@RequestMapping(value="addOutStore",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="出库完成商品信息上传接口")
	@ApiImplicitParam(name="jsonObject",value="商品信息json",dataType="JSONObject")
	public ResponseEntity<ResponseResult<String>> addOutStore( @RequestBody JSONObject jsonObject){
		return outStoreService.addOutStore(jsonObject);
	}
	
	@RequestMapping(value="queryByTransferCode",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="待出库单详细信息查询")
	@ApiImplicitParam(name="transferCode",value="转货单号",dataType="string")
	public ResponseEntity<ResponseResult<Map<String, Object>>> queryByTransferCode(@RequestParam("transferCode")String transferCode){
		return outStoreService.queryByTransferCode(transferCode);
	}
	
	@RequestMapping(value="queryNoTransferList",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="待出库单列表")
	@ApiImplicitParams({
		@ApiImplicitParam(value="当前页码",name="pageRow",dataType="Integer"),
		@ApiImplicitParam(value="门店编码",name="storeCode",dataType="String")
	})
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryNoTransferList(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return outStoreService.queryNoTransferList(pageRow, storeCode);
	}
	
	@RequestMapping(value="queryYesTransferList",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="已出库单列表")
	@ApiImplicitParams({
		@ApiImplicitParam(value="当前页码",name="pageRow",dataType="Integer"),
		@ApiImplicitParam(value="门店编码",name="storeCode",dataType="String")
	})
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryYesTransferList(@RequestParam("pageRow")Integer pageRow,@RequestParam("storeCode")String storeCode){
		return outStoreService.queryYesTransferList(pageRow, storeCode);
	}
	
	@RequestMapping(value="queryYesOutStoreCode",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="已出库单详细信息查询")
	@ApiImplicitParam(name="outStoreCode",value="出库单编号",dataType="String")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryYesOutStoreCode(@RequestParam("outStoreCode")String outStoreCode){
		return outStoreService.queryYesOutStoreCode(outStoreCode);
	}
	
}
