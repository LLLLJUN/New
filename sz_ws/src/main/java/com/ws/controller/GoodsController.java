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
import com.ws.service.GoodsService;
import com.ws.util.resp.ResponsePageResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年6月29日
 */
@Api(value="商品接口")
@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;
	
	@ApiOperation(value="新增商品",notes="详细字段")
	@RequestMapping(value="insertGoods",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="jsonObject",value="新增商品信息json",required=true,dataType="JSONObject")
/*	@RequiresPermissions("Goods:add")
	@PermissionNameUtil("新增商品")*/
	//@RequiresUser
	public ResponseEntity<ResponseResult<Map<String, Object>>> insertGoods(@RequestBody JSONObject jsonObject,HttpServletRequest requ
			){
		return goodsService.insertGoods(jsonObject);
				
	}
	
	@ApiOperation(value="删除商品",notes="根据Sku删除")
	@RequestMapping(value="deleteGoodsBySku",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="sku",value="商品编码sku",required=true,dataType="String")
/*	@RequiresPermissions("Goods:del")
	@PermissionNameUtil("删除商品")*/
	//@RequiresUser
	public ResponseEntity<ResponseResult<Map<String, Object>>> deleteGoodsBySku(@RequestParam("sku")String sku,
			HttpServletRequest requ,HttpServletResponse resp){
		return goodsService.deleteGoodsBySku(sku);
	}
	
	@ApiOperation(value="更新商品",notes="商品详细信息")
	@RequestMapping(value="updateGoods",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="jsonObject",value="更新商品信息json",required=true,dataType="JSONObject")
	/*@RequiresPermissions("Goods:edit")
	@PermissionNameUtil("更新商品")*/
	//@RequiresUser
	public ResponseEntity<ResponseResult<Map<String, Object>>> updateGoods(@RequestBody JSONObject jsonObject,HttpServletRequest requ,
			HttpServletResponse resp){
		return goodsService.updateGoods(jsonObject);
	}
	
	@ApiOperation(value="分页查看商品列表",notes="每页五条",httpMethod="GET")
	@RequestMapping(value="goodsPage",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="pageRow",value="当前页",dataType="Integer")
	/*@RequiresPermissions("Goods:list")
	@PermissionNameUtil("商品列表")*/
	//@RequiresUser
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> goodsPage(@RequestParam(value="pageRow",defaultValue="1",required=true)Integer pageRow,HttpServletRequest requ,
			HttpServletResponse response){
		return goodsService.pageGoods(pageRow);
	}
	@RequestMapping(value="goodsPage1",method=RequestMethod.GET)
	public ResponseEntity<ResponsePageResult<Map<String, Object>>> goodsPage1(@RequestParam(value="pageRow",defaultValue="1",required=true)Integer pageRow,HttpServletRequest requ,
			HttpServletResponse response){
		return goodsService.pageGoods1(pageRow);
	}
	
	@ApiOperation(value="商品详情",notes="根据sku查询")
	@RequestMapping(value="selectGoodsBySku",method=RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParam(name="sku",value="商品编码sku",required=true,dataType="String")
/*	@RequiresPermissions("Goods:goods")
	@PermissionNameUtil("商品信息")*/
	//@RequiresUser
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectGoodsBySku(@RequestParam("sku")String sku,HttpServletRequest requ,
			HttpServletResponse resp){
		return goodsService.selectGoodsBySku(sku);
	}
	
	@ApiOperation(value="查询所有商品详细信息",notes="所有",httpMethod="GET")
	@RequestMapping(value="queryAllGoodsInfo",method=RequestMethod.GET)
	@ResponseBody
	/*@RequiresPermissions("Goods:Allgoods")
	@PermissionNameUtil("所有商品")*/
	//@RequiresUser
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryAllGoodsInfo(HttpServletRequest requ,HttpServletResponse resp){
		return goodsService.queryAllGoods();
	}
	
	
	
}
