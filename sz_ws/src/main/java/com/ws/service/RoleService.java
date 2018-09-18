package com.ws.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public interface RoleService {
	
	/**
	 *
	 *获得所有权限
	 *@param 
	 *@return
	 */
	List<String> selectAllRole();

    /**
     *
     *获得对应用户的权限
     *@param userCode
     *@return
     */
    List<String> selectByUserCodeRole(String userCode);
    
    /**
     *
     *获得全部角色信息
     *@param 
     *@return
     */
    ResponseEntity<ResponseResult<List<Map<String, Object>>>> seleceAllRoleInfo();
}
