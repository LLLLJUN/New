package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;


/**
 * @author lujun
 * @date 2018年7月3日
 */
public interface StorageService {
	
	/**
	 *
	 *获得对应门店的库存
	 *@param storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectAllStorage(@Param("storeCode")String storeCode);

}
