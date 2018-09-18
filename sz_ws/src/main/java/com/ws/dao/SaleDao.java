package com.ws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ws.model.Condition;
import com.ws.model.Sale;

public interface SaleDao {
	
	
  	/**
  	 *
  	 *获取对应sku商品信息
  	 *@param sku
  	 *@return
  	 */
  	Map<String, Object> selectGoodsPriceInfo(String sku);
  	
  	/**
  	 *
  	 *新增销售单据
  	 *@param sale
  	 *@return
  	 */
  	int insertSale(Sale sale);
  	
  	/**
  	 *
  	 *模拟销售数据，批量插入
  	 *@param saleList
  	 *@return
  	 */
  	int insertSaleList(@Param("saleList") List<Sale> saleList);
  	
  	/**
  	 *
  	 *获得指定门店，时间段内销售数据
  	 *@param condition
  	 *@return
  	 */
  	List<Map<String, Object>> selectByTimeSaleInfo(Condition condition);
  	
  	
  	/**
  	 *
  	 *获得指定时间段的销售量
  	 *@param sale
  	 *@return
  	 */
  	List<Map<String, Object>> selectByTimeGetSalesVolume(Sale sale); 
  	
  	
}
