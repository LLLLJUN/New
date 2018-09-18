package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.AppVersionDao;
import com.model.AppVersion;
import com.service.AppVersionService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;
@Service
public class AppVersionServiceImp implements AppVersionService {
	
	@Resource
	private AppVersionDao appVersionDao;
	
	public ResponseEntity<ResponseResult<Map<String,Object>>> selectAppVersion(int appVersion) {
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			AppVersion app_Version= appVersionDao.selectAppVersion();
			if(appVersion>0){
				if(app_Version.getVersionCode()>appVersion){
					map.put("appUrl", app_Version.getAppUrl());
					map.put("versionCode", app_Version.getVersionCode());
					map.put("versionName", app_Version.getVersionName());
					map.put("messages", app_Version.getMessages());
					map.put("appCreateDate", app_Version.getAppCreateDate());
					return  RespResultGenerator.genOK(map, "获取成功");
				}else{
					return  RespResultGenerator.genError(null, "获取成功");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null,"操作失败"+e.toString());
			
		}
		
		
		
		return null;
	}

	

}
