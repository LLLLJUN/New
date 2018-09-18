package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月2日
 */
public interface PurchaseService {
	
	/**
	 *
	 *增加采购单
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> insertPurchase(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *删除采购单
	 *@param purchaseCode
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> deletePurchase(@Param("purchaseCode")String purchaseCode);
	
	/**
	 *
	 *获得对应采购单信息
	 *@param purchaseCode
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCode(@Param("purchaseCode")String purchaseCode);
	
	/**
	 *
	 *采购单列表
	 *@param pageRow,storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectByPurchaseList(@Param("pageRow")Integer pageRow,@Param("storeCode")String storeCode);
	
	
	

}
