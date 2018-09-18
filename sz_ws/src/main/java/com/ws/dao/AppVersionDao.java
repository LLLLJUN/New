package com.ws.dao;

import com.ws.model.AppVersion;

public interface AppVersionDao {
	
	
	
	/**
	 *
	 *获取最新app信息
	 *@param 
	 *@return
	 */
	AppVersion selectAppVersion();

}
