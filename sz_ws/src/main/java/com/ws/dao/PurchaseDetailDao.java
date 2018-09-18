package com.ws.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ws.model.PurchaseDetail;

/**
 * @author lujun
 * @date 2018年7月2日
 */
public interface PurchaseDetailDao {
	
	/**
	 *
	 *增加采购商品信息
	 *@param purchaseDetailList
	 *@return
	 */
	int inserPurchaseDetailList(@Param("purchaseDetailList")List<PurchaseDetail> purchaseDetailList);
	 
	/**
	 *
	 *删除对应采购单商品
	 *@param purchaseCode
	 *@return
	 */
	int deletePurchaseDetail(String purchaseCode);
}
