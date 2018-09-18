package com.ws.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

public interface ColorService {
	
	/**
	 *
	 *新增颜色
	 *@param color
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> increaseColor(@Param("colorName")String colorName, HttpServletRequest requ);
	
	/**
	 *
	 *获得所有颜色信息
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalColorInfo();
}
