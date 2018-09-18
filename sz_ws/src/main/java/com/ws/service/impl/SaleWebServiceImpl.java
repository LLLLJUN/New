package com.ws.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.ws.dao.SaleDao;
import com.ws.dao.SaleDetailDao;
import com.ws.model.Condition;
import com.ws.model.Sale;
import com.ws.service.SaleWebService;

@WebService(endpointInterface="com.ws.service.SaleWebService")
public class SaleWebServiceImpl implements SaleWebService {
	
	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private SaleDetailDao saleDetailDao;

	@Override
	public String queryByTimeSalesVolume(String time) {
		try {
			if(!time.equals("")&&time!=null){
				Sale sale=new Sale();
				sale.setSaleTime(time);
				List<Map<String, Object>> saleDataList=saleDao.selectByTimeGetSalesVolume(sale);
				if(saleDataList!=null){
					return JSON.toJSONString(saleDataList);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String querySaleBaseAndSaleWorstData(String time, String storeCode) {
		try {
			if(!time.equals("")&&time!=null){
				Sale sale=new Sale();
				sale.setSaleTime(time);
				if(storeCode!=null){
					sale.setStoreCode(storeCode);
				}
				Map<String, Object> map=new HashMap<>();
				List<Map<String, Object>>saleBaseDataList=saleDetailDao.getSaleBaseData(sale);
				List<Map<String, Object>>saleWorstDataList=saleDetailDao.getSaleWorstData(sale);
				if(!saleBaseDataList.isEmpty()&&!saleWorstDataList.isEmpty()){
					map.put("saleBestData",saleBaseDataList);
					map.put("saleWorstData",saleWorstDataList);
					return JSON.toJSONString(map);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String querySaleBestWorstData(String time) {
		try {
			if(!time.equals("")&&time!=null){
				Sale sale=new Sale();
				sale.setSaleTime(time);
				List<String>styleList=saleDetailDao.getTotalSaleStyle(sale);
				List<Map<String, Object>> list=new ArrayList<>();
				for (String style : styleList) {
					Map<String, Object> map=new HashMap<>();
					Condition condition=new Condition();
					condition.setSaleTime(time);
					condition.setStyle(style);
					map.put("style", style);
					List<Map<String, Object>>bestWorsList=saleDetailDao.getSaleBestWorstData(condition);
					map.put("bestSaleNum", bestWorsList.get(0).get("count"));
					map.put("bestStoreName", bestWorsList.get(0).get("storeName"));
					map.put("worstSaleNum", bestWorsList.get(1).get("count"));
					map.put("worstStoreName", bestWorsList.get(1).get("storeName"));
					list.add(map);
				}
				String s=list.toString();
				if(!list.isEmpty()){
					return s;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String querySaleData(String time, String storeCode) {
		try {
			if(!time.equals("")&&time!=null){
				Sale sale=new Sale();
				sale.setSaleTime(time);
				if(storeCode!=null){
					sale.setStoreCode(storeCode);
				}
				List<Map<String, Object>> saleDataList=saleDetailDao.getSaleData(sale);
				if(!saleDataList.isEmpty()){
					return JSON.toJSONString(saleDataList);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
