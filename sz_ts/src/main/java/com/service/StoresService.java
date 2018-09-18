package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.model.Stores;
import com.util.ResponseResult;

/**
 * @author lujun
 * @date 2018年7月26日
 */

public interface StoresService {
	/**
	 *
	 *获得所有门店信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryStores(@Param("storeCode")String storeCode);
	
	/**
	 *
	 *增加或修改门店
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> increaseStore(@Param("store")Stores store);
	
	/**
	 *
	 *分页获取门店信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> pageQueryStore(@Param("storeCode")String storeCode,@Param("storeArea") String storeArea,@Param("pageRow")Integer pageRow
			);

	/**
	 *
	 *删除对应门店
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> deleteStore(@Param("storeCode")String storeCode);

	
	/**
	 *
	 *修改对应门店信息
	 *@param stores
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> updateStore(@Param("storeCode")Stores stores);
	
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryStoreCodeAndStoreName();
	
	String says();
}
