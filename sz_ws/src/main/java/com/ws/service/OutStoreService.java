package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月9日
 */
public interface OutStoreService {
	
	/**
	 *
	 *增加出库单
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> addOutStore(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *获得对应转货信息
	 *@param transferCode
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryByTransferCode(@Param("transferCode")String transferCode);
	
	/**
	 *
	 *获得待出库列表
	 *@param pageRow,storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryNoTransferList(@Param("pageRow")Integer pageRow,@Param("storeCode")String storeCode);
	
	/**
	 *
	 *获得已出库列表
	 *@param pageRow,storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryYesTransferList(@Param("pageRow")Integer pageRow,@Param("storeCode")String storeCode);

	/**
	 *
	 *获得已出库单详细信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryYesOutStoreCode(String outStoreCode);
}
