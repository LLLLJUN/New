package com.ws.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;


public interface AppVersionService {
	
	/**
	 *
	 *获得app版本信息
	 *@param appVersion
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String,Object>>> selectAppVersion(@Param("appVersion")int appVersion,HttpServletRequest requ,HttpServletResponse resp);
	
}
