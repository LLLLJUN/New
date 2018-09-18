package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.util.ResponseResult;

public interface SaleDataService {
	
	/**
	 *
	 *：获取时间段内各门店销售额和销售量
	 *@param time
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalSaleData(@Param("time")String time);
	
	/**
	 *
	 *获取各门店时间段内各个款式的畅销款TOP10和滞销款Top10数据
	 *@param 
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> querySaleBaseAndSaleWorstData(@Param("time")String time,@Param("storeCode") String storeCode);
	
	/**
	 *
	 *：获取时间段内各款式销量最高与销量最低 门店的数据
	 *@param time
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> querySaleBestWorstData(@Param("time")String time);
	
	
	/**
	 *
	 *：获取各门店时间段内各个款式的销售量和试穿量数据 
	 *@param time
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> querySaleTryData(@Param("time")String time,@Param("storeCode") String storeCode);
	
}
