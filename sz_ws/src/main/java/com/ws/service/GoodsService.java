package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;
import com.ws.util.resp.ResponsePageResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年6月29日
 */
public interface GoodsService {
	/**
	 *
	 *新增商品
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> insertGoods(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *删除商品
	 *@param sku
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> deleteGoodsBySku(@Param("sku")String sku);
	
	/**
	 *
	 *修改商品
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> updateGoods(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *获得商品列表
	 *@param pageRow
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> pageGoods(@Param("pageRow")Integer pageRow);
	
	ResponseEntity<ResponsePageResult<Map<String, Object>>> pageGoods1(@Param("pageRow")Integer pageRow);
	/**
	 *
	 *获得商品详细信息
	 *@param sku
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> selectGoodsBySku(@Param("sku")String sku);
		
	/**
	 *
	 *获得所有商品
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryAllGoods();
}
