package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model.MatchData;

/**
 * @author lujun
 * @date 2018年6月25日
 */
public interface MatchDataDao {
	
	/**
	 *
	 *增加搭配数据
	 *@param matchData
	 *@return
	 */
	int insertMatchData(MatchData matchData);
	
	/**
	 *
	 *获得指定时间段搭配数据
	 *@param matchData
	 *@return
	 */
	List<Map<String, Object>> selectMatchData(MatchData matchData);
	
	/**
	 *
	 *获取各个门店所有搭配数据
	 *@param matchData
	 *@return
	 */
	List<Map<String, Object>> selectTotalStoreMatchData(MatchData matchData);
	
	/**
	 *
	 *获取指定时间段，门店，各个搭配款式数据
	 *@param matchData
	 *@return
	 */
	List<Map<String, Object>> selectByStoreCodeTotalMatchData(MatchData matchData);
	
	/**
	 *
	 *批量增加搭配数据
	 *@param matchDataList
	 *@return
	 */
	int batchInsertMatchData(@Param("matchDataList")List<MatchData> matchDataList);
	

}
