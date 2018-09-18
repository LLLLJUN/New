package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.util.ResponseResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月26日
 */
public interface MatchDataService {
	
	/**
	 *
	 *获得对应 时间段，门店搭配数据
	 *@param storeDode ,time
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryMatchData(@Param("storeCode")String storeCode,
			@Param("time")String time);
	
	
	ResponseEntity<ResponseResult<String>> batchInsertMatchData(HttpServletRequest requ, @Param("jsonObject")JSONObject jsonObject);
	
}
