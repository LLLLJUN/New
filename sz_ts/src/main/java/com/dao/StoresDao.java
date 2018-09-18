package com.dao;

import java.util.List;
import java.util.Map;

import com.model.Condition;
import com.model.Page;
import com.model.Stores;

/**
 * @author lujun
 * @date 2018年7月26日
 */
public interface StoresDao {
	
	/**
	 *
	 *获得所有门店信息
	 *@param 
	 *@return
	 */
	List<Map<String, Object>> selectAllStore();
	
	/**
	 *
	 *获得对应的门店信息
	 *@param storeCode
	 *@return
	 */
	Map<String, Object> selectByStoreCode(String storeCode);
	
	/**
	 *
	 *增加门店
	 *@param store
	 *@return
	 */
	int increaseStore(Stores store);
	
	/**
	 *
	 *获得门店总数
	 *@param 
	 *@return
	 */
	int queryCount(Condition condition);
	
	/**
	 *
	 *获得门店列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> pageQueryStores(Page page);
	
	/**
	 *
	 *逻辑删除
	 *@param storeCode
	 *@return
	 */
	int deleteStore(String storeCode);
	
	/**
	 *
	 *修改门店信息
	 *@param stores
	 *@return
	 */
	int updateStore(Stores stores);
	
	List<Map<String, Object>> selectStoreNameAndStoreCode();
}
