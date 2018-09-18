package com.ws.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.Condition;
import com.ws.model.ResponseResult;
import com.ws.model.Users;


/**
 * @author lujun
 * @date 2018年6月29日
 */
public interface UsersService {
	
	/**
	 *
	 *登录
	 *@param userCode,userPsw
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String,Object>>> selectLogin(@Param("userName")String userCode,@Param("userPsw")String userPsw,
			HttpServletResponse resp,HttpServletRequest requ,HttpSession session);
	
	/**
	 *
	 *增加权限
	 *@param userCode
	 *@return
	 */
	Users queryByUserCode(String userCode);
	
	/**
	 *
	 *增加用户
	 *@param users
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> addOrUpdateUsers(@Param("users")Users users);
	
	/**
	 *
	 *删除用户
	 *@param userCode
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> delUsers(@Param("userCode")String [] userCode);
	
	/**
	 *
	 *获得用户详细信息
	 *@param userCode
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryUserCodeInfo(@Param("userCode")String userCode);
	
	/**
	 *
	 *用户列表
	 *@param condition
	 *@return
	 */
	ResponseEntity<ResponseResult<Map<String, Object>>> queryUserList(@Param("condition") Condition condition,@Param("pageRow") Integer pageRow,HttpSession session);
}
