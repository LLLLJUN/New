package com.ws.service;

import java.util.List;

import com.ws.model.Duty;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public interface DutyService {
	/**
	 *
	 *获得所有权限
	 *@param 
	 *@return
	 */
	List<String> queryAllPermission();
	
	/**
	 *
	 *增加权限
	 *@param permissions
	 *@return
	 */
	int addPermission(Duty permissions);
	
	/**
	 *
	 *获得对应用户的权限
	 *@param userCode
	 *@return
	 */
	List<String> selectByUserCodePermission(String userCode);
}
