package com.ws.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.AppVersionDao;
import com.ws.model.AppVersion;
import com.ws.model.ResponseResult;
import com.ws.service.AppVersionService;
import com.ws.util.RespResultGenerator;


@Service
public class AppVersionServiceImpl implements AppVersionService {
	@Resource
	private AppVersionDao appVersionDao;
	
	public ResponseEntity<ResponseResult<Map<String,Object>>> selectAppVersion(int appVersion,HttpServletRequest requ,HttpServletResponse resp) {
		Map<String, Object> map=new HashMap<String, Object>();
		AppVersion app_Version= appVersionDao.selectAppVersion();
		if(appVersion>=0 && app_Version!=null && !app_Version.equals("")){
			if(app_Version.getVersionCode()>appVersion){
				map.put("appUrl", app_Version.getAppUrl());
				map.put("versionCode", app_Version.getVersionCode());
				map.put("versionName", app_Version.getVersionName());
				map.put("appCreateDate", app_Version.getAppCreateDate());
				map.put("messages", app_Version.getMessages());
				return  RespResultGenerator.genOK(map, "获取成功");
			}else{
				return  RespResultGenerator.genError(null, "获取成功");
			}
		}else{
			return RespResultGenerator.genError(null, "appVersion有误");
		}
	}	

}
