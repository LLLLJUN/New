package com.ws.dao;

import java.util.List;

import com.ws.model.Duty;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public interface DutyDao {
	
	/**
	 *
	 *获取全部权限信息
	 *@param 
	 *@return
	 */
	List<String> selectAllUserPermission();
	
	/**
	 *
	 *增加新权限
	 *@param duty
	 *@return
	 */
	int insertPermission(Duty duty);
	
    /**
     *
     *获取对应用户的权限
     *@param userCode
     *@return
     */
    List<String> selectByUserCodePermission(String userCode);
}
