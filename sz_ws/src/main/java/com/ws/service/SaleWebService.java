package com.ws.service;

import javax.jws.WebService;


@WebService
public interface SaleWebService {
	
	/**
	 *
	 *获得指定时间段的销售量
	 *@param time
	 *@return
	 */
	public String queryByTimeSalesVolume(String time);
	
	
	/**
	 *
	 *获取各门店时间段内各个款式的畅销款TOP10和滞销款Top10数据
	 *@param time,storeCode
	 *@return
	 */
	public String querySaleBaseAndSaleWorstData(String time,String storeCode);
	
	/**
	 *
	 *获取时间段内各款式销量最高与销量最低 门店的数据
	 *@param time
	 *@return
	 */
	public String querySaleBestWorstData(String time);
	
	
	/**
	 *
	 *获取各门店时间段内各个款式的销售量
	 *@param time,storeCode
	 *@return
	 */
	public String querySaleData(String time,String storeCode );
	
}
