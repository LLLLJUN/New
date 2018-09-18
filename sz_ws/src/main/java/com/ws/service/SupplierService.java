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
public interface SupplierService {
	/**
	 *
	 *增加供应商
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> insertSupplier(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *删除供应商
	 *@param supplierCode
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> deleteBySupplierCode(@Param("supplierCode")String supplierCode);
	
	/**
	 *
	 *更新供应商
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> updateBySupplier(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *获得对应的供应商信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> selectBySupplierCode(@Param("supplierCode")String supplierCode);
	
	/**
	 *
	 *获得供应商列表
	 *@param pageRow 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectAllSupplier(@Param("pageRow")Integer pageRow);
}
