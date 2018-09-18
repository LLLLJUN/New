package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月6日
 */
public interface GoodsTransferService {
	/**
	 *
	 *新增转货出库单
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> insertGoodsTransfer(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *删除转货出库单
	 *@param transferCode
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> deleteGoodsTransfer(@Param("transferCode")String transferCode);
	
	/**
	 *
	 *获得对应的转货出库单信息
	 *@param transferCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectByTransferCode(@Param("transferCode")String transferCode);
	
	/**
	 *
	 *获得转货出库单列表
	 *@param pageRow,storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectGoodsTransferList(@Param("pageRow")Integer pageRow,@Param("storeCode")String storeCode);
}
