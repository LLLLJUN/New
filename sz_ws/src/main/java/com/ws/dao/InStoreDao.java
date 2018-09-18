package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Condition;
import com.ws.model.InStore;
import com.ws.model.Page;

/**
 * @author lujun
 * @date 2018年7月3日
 */
public interface InStoreDao {
	
	/**
	 *
	 *增加入库信息
	 *@param inStore
	 *@return
	 */
	int insertInStore(InStore inStore);
	
	/**
	 *
	 *获得待入库商品列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectNoInStoreList(Page page);
	
	/**
	 *获得待入库商品总数
	 *
	 *@param condition
	 *@return
	 */
	int selectAllCount(Condition condition);
	
	/**
	 *
	 *获得已入库商品总数
	 *@param conditions
	 *@return
	 */
	int selectAllYesCount(Condition conditions);
	
	/**
	 *
	 *获得已入库商品列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectYesInStoreList(Page page);
	
	/**
	 *
	 *获得对应已入库采购单信息
	 *@param inStoreCode
	 *@return
	 */
	Map<String, Object> selectByPurchaseCodeYesInStore(String inStoreCode);
	
	/**
	 *
	 *获得对应采购单待入库商品信息
	 *@param purchaseCode
	 *@return
	 */
	List<Map<String,Object>> selectByPurchaseCodeStorage(String purchaseCode);
	
	int selectInSotoreGoodsAllNum(String purchaseCode);
	
}
