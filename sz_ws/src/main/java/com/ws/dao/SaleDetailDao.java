package com.ws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ws.model.Condition;
import com.ws.model.Sale;
import com.ws.model.SaleDetail;

public interface SaleDetailDao {
	
	/**
	 *
	 *新增销售商品信息
	 *@param saleDetailList
	 *@return
	 */
	int insertSaleDetailList(@Param("saleDetailList") List<SaleDetail>  saleDetailList);
	
	/**
	 *
	 *获得对应销售单号商品信息
	 *@param saleBillNo
	 *@return
	 */
	List<Map<String, Object>> selectBySaleBillNoGetSaleGoodsInfo(String saleBillNo);
 	
 	/**
 	 *
 	 *获取各门店时间段内各个款式的畅销款TOP10数据
 	 *@param Sale
 	 *@return
 	 */
 	List<Map<String, Object>> getSaleBaseData(Sale sale);
 	
 	/**
	 *
	 *获取各门店时间段内各个款式的滞销款Top10数据
	 *@param Sale
	 *@return
	 */
	List<Map<String, Object>> getSaleWorstData(Sale sale);
	
	/**
	 *
	 *获得指定时间段所有款式
	 *@param sale
	 *@return
	 */
	List<String> getTotalSaleStyle(Sale sale);
	
	
	/**
	 *
	 *获取时间段内各款式销量最高与销量最低 门店的数据
	 *@param sale
	 *@return
	 */
	List<Map<String, Object>> getSaleBestWorstData(Condition condition);
	
	
	/**
	 *
	 *：获取各门店时间段内各个款式的销售量
	 *@param sale
	 *@return
	 */
	List<Map<String, Object>> getSaleData(Sale sale);
}
