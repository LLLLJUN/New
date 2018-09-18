package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月3日
 */
public interface InStoreService {
	/**
	 *
	 *增加入库单
	 *@param jsonObject 
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> insertInStore(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *获得待入库单列表
	 *@param storeCode，pageRow
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectNoInStoreList(@Param("storeCode")String storeCode,@Param("pageRow")Integer pageRow);
	
	/**
	 *
	 *获得已入库单列表
	 *@param storeCode,pageRow
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectYesInStoreList(@Param("storeCode")String storeCode,@Param("pageRow")Integer pageRow);
	
	/**
	 *
	 *获得对应的入库单详细信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCodeYesInStore(@Param("inStoreCode")String inStoreCode);
	
	/**
	 *
	 *获得对应采购单待入库商品信息
	 *@param purchaseCode
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCodeStorage(@Param("purchaseCode")String purchaseCode);
	
}
