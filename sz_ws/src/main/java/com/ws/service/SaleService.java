package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.Condition;
import com.ws.model.ResponseResult;

import net.sf.json.JSONObject;



public interface SaleService {
	
	/**
	 *
	 *获取商品价格信息
	 *@param sku
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryGoodsPriceInfo(@Param("sku")String sku);
	
	
	/**
	 *
	 *新增 销售单信息
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> increaseSaleInfo(@Param("jsonObject")JSONObject jsonObject);
	
	
	/**
	 *
	 *获取对应销售单商品信息
	 *@param saleBillNo
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryBySaleBillNoGetSaleGoodsInfo(@Param("saleBillNo")String saleBillNo);

	/**
	 *
	 *获取时间段内商品销售数据
	 *@param condition
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryByTimeSaleInfo(@Param("condition") Condition condition);
	
	/**
	 *
	 *批量新增销售数据
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> increaseSaleList(@Param("jsonObject")JSONObject jsonObject);
}
