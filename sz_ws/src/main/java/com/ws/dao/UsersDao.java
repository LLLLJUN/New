package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Condition;
import com.ws.model.Page;
import com.ws.model.Users;


/**
 * @author lujun
 * @date 2018年6月29日
 */
public interface UsersDao {
	 
	/**
	 *
	 *登录
	 *@param users
	 *@return
	 */
	Map<String,Object> selectLogin(Users users);
	 
	/**
	 *
	 *shiro认证，获得对应的用户信息
	 *@param userCode
	 *@return
	 */
	Users selectByUsersCode(String userCode);
	 
	/**
	 *
	 *增加用户
	 *@param users
	 *@return
	 */
	int insertUser(Users users);
	 
	/**
	 *
	 *修改用户信息
	 *@param users
	 *@return
	 */
	int updateUsers(Users users);
	 
	/**
	 *
	 *删除用户
	 *@param userCode
	 *@return
	 */
	int deleteUsers(String userCode);
	 
	/**
	 *
	 *获得用户列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectUserList(Page page);
	 
	/**
	 *
	 *获得指定条件下的用户总数
	 *@param condition
	 *@return
	 */
	int selectCount(Condition condition);
	
	/**
	 *
	 *获得对应的用户详细信息
	 *@param userCode
	 *@return
	 */
	Map<String, Object> selectByUsersCodeInfo(String userCode);
}
