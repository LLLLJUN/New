package com.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.util.ResponseResult;

/**
 * @author lujun
 * @date 2018年6月21日
 */
public interface EpcStyleService {
	ResponseEntity<ResponseResult<Map<String, Object>>> insertByEpc(@Param("epc")String epc,@Param("storeCode") String storeCode);
	
	ResponseEntity<ResponseResult<Map<String, Object>>> insertByMatchStyle(@Param("matchStyle")String matchStyle,@Param("style")String style,@Param("storeCode")String storeCode);
}
