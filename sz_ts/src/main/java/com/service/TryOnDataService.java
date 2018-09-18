package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.util.ResponseResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月26日
 */
public interface TryOnDataService {
	/**
	 *
	 *获得指定时间段对应门店试穿数据
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTryOnData(@Param("storeCode")String storeCode,@Param("time")String time);
	
	/**
	 *
	 *获得所有门店指定时间段的试穿，搭配数据
	 *@param time(时间段)
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryToTalStoreTryOnData(@Param("time")String time,HttpServletRequest requ,HttpServletResponse resp);
	
	
	/**
	 *
	 *获得指定门店，时间段各个款式搭配和试穿数据
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryByStoreCodeAndTimeTryOnDataAndMatchData(@Param("time")String time,@Param("storeCode")String storeCode,
			HttpServletRequest requ);
	
	/**
	 *
	 *批量新增试穿数据
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>>  batchInsertTryOnData(@Param("jsonObject")JSONObject jsonObject,HttpServletRequest requ); 
	
	
	/**
	 *
	 *获得指定时间段，门店的搭配和试穿数据
	 *@param time storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryByStoreCodeAndTimeGetData(@Param("time")String time,@Param("storeCode")String storeCode,HttpServletRequest requ);
	
	
	
	/**
	 *
	 *根据指定时间段获取所有门店的试穿数据
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryByTimeGetTotalStoreTryOnData(@Param("time")String time,HttpServletRequest requ);
}
