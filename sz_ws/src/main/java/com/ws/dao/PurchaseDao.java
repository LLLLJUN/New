package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Condition;
import com.ws.model.Page;
import com.ws.model.Purchase;

/**
 * @author lujun
 * @date 2018年7月2日
 */
public interface PurchaseDao {
	 
	/**
	 *
	 *增加采购单
	 *@param purchase
	 *@return
	 */
	int insertPurchase(Purchase purchase);
	 
	/**
	 *
	 *删除采购单
	 *@param purchaseCode
	 *@return
	 */
	int deletePurchase(String purchaseCode);
	 
	/**
	 *
	 *获得对应的采购单信息
	 *@param purchaseCode
	 *@return
	 */
	Map<String, Object> selectByPurchaseCode(String purchaseCode);
	 
	/**
	 *
	 *获得采购单列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectBystoreCodeAllPurchase(Page page);
	 
	/**
	 *
	 *获得对应门店采购单总数
	 *@param condition
	 *@return
	 */
	int selectAllCount(Condition condition);
	
	/**
	 *
	 *获得对应的采购单信息
	 *@param purchaseCode
	 *@return
	 */
	Map<String, Object> selectByPurchaseCodeNoInStore(String purchaseCode);
	 
	List<Map<String, Object>> selectPurchaseDetail(String purchaseCode);
	
	/**
	 *
	 *获得对应采购单采购商品总数
	 *@param 
	 *@return
	 */
	int selectGoodsAllNum(String purchaseCode);
	
	/**
	 *
	 *修改采购单是否入库
	 *@param 
	 *@return
	 */
	int updateInStoreState(Purchase purchase);
	
}
