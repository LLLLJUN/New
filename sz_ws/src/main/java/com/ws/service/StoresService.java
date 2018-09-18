package com.ws.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

public interface StoresService {
	
	/**
	 *
	 *获取所有门店信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalStore();
}
