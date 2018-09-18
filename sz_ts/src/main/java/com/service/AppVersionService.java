package com.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.util.ResponseResult;

public interface AppVersionService {
	ResponseEntity<ResponseResult<Map<String,Object>>> selectAppVersion(int appVersion);
}
