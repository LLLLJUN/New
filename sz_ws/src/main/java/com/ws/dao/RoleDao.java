package com.ws.dao;

import java.util.List;
import java.util.Map;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public interface RoleDao {
	  
    /**
     *
     *获得全部角色
     *@param 
     *@return
     */
    List<String> selectAllRole();
     
    /**
     *
     *查询对应角色信息
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
	List<Map<String, Object>> selectAllRoleInfo();
}
