package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

public interface SizeService {
	/**
	 *
	 *新增尺码
	 *@param color
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> increaseSize(@Param("sizeName")String sizeName);
	
	/**
	 *
	 *获得所有尺码信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalSizeInfo();
}
