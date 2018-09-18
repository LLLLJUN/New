package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model.TryOnData;

/**
 * @author lujun
 * @date 2018年6月25日
 */
public interface TryOnDataDao {
	
	/**
	 *
	 *增加试穿数据
	 *@param tryOnData
	 *@return
	 */
	int insertTryOnData(TryOnData tryOnData);
	
	/**
	 *
	 *获得指定时间段试穿数据
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectData(TryOnData tryOnData);
	
	/**
	 *
	 *获得指定时间端各个门店的试穿数据总数
	 *@param time(时间段)
	 *@return
	 */
	List<Map<String, Object>> selectTryOnData(TryOnData tryOnData);
	
	/**
	 *
	 *获得指定时间段，门店，所有款式试穿数据
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectByStoreCodeTotalTruOnData(TryOnData tryOnData);
	
	
	
	/**
	 *
	 *批量新增试穿数据
	 *@param 
	 *@return
	 */
	int batchInsertTryOnDataList(@Param("tryOnDataList")List<TryOnData> tryOnDataList);
		
	/**
	 *
	 *获得一天数据
	 *@param tryOnData
	 *@return
	 */
	Map<String, Object> selectByStoreCodeAndTimeGetDataDay(TryOnData tryOnData);
	
	/**
	 *
	 *获得一周数据
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectByStoreCodeAndTimeGetDataWeek(TryOnData tryOnData);
	
	/**
	 *
	 *获得一季数据
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectByStoreCodeAndTimeGetDataQuarter(TryOnData tryOnData);
	
	/**
	 *
	 *获得一年数据
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectByStoreCodeAndTimeGetDataYear(TryOnData tryOnData);
	
	/**
	 *
	 *获取试穿最多款，和最少款
	 *@param 
	 *@return
	 */
	List<String> selectByTimeAndStoreCodeGettryOnMostStyleAndTryOnLeastStyleData(TryOnData tryOnData);
	
	/**
	 *
	 *获得一月数据
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectByTimeGetTotalStoreTryOnDataMonth(TryOnData tryOnData);
	
	/**
	 *
	 *获得一天所有数据 ，按门店分组
	 *@param 
	 *@return
	 */
	List<Map<String, Object>> selectByTimeGetTotalStoreTryOnDataGroupByStoreCodeDay();
	
	/**
	 *
	 *获得指定时间的门店代码
	 *@param tryOnData
	 *@return
	 */
	List<Map<String, Object>> selectByTimeTotalStoreCode(TryOnData tryOnData);
	
	
	/**
	 *
	 *获取指定款式，时间，门店试穿数据
	 *@param tryOnData
	 *@return
	 */
	Map<String, Object> selectTryData(TryOnData tryOnData);
  }
