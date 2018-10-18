package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.TryOnDataDao;
import com.google.gson.Gson;
import com.model.TryOnData;
import com.service.SaleDataService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;
import com.ws.service.SaleWebService;
import com.ws.service.SaleWebServiceProxy;

@Service
public class SaleDataServiceImpl implements SaleDataService {
	//添加作者
	@Autowired
	private TryOnDataDao tryOnDataDao;

	@Override
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalSaleData(String time) {
		try {
			if(!time.equals("") && time!=null){
				List<Map<String, Object>> json=new ArrayList<>();
				SaleWebService sws=new SaleWebServiceProxy();
				String saleData=sws.queryByTimeSalesVolume(time);
				if(saleData!=null){
					Gson gson=new Gson();
					return RespResultGenerator.genOK(gson.fromJson(saleData, json.getClass()), "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
		
		
	}

	@Override
	public ResponseEntity<ResponseResult<Map<String, Object>>> querySaleBaseAndSaleWorstData(String time,
			String storeCode) {
		try {
			if(!time.equals("")&&time!=null){
				Map<String, Object> json=new HashMap<>();
				SaleWebService sws=new SaleWebServiceProxy();
				String saleBaseAndSaleWorstData=sws.querySaleBaseAndSaleWorstData(time, storeCode);
				if(!("").equals(saleBaseAndSaleWorstData)&&saleBaseAndSaleWorstData!=null){
					Gson gson=new Gson();
					return RespResultGenerator.genOK(gson.fromJson(saleBaseAndSaleWorstData, json.getClass()), "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	@Override
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> querySaleBestWorstData(String time) {
		try {
			if(!time.equals("")&&time!=null){
				List<Map<String, Object>> json=new ArrayList<>();
				SaleWebService sws=new SaleWebServiceProxy();
				String saleBestWorstData=sws.querySaleBestWorstData(time);
				if(saleBestWorstData!=null){
					Gson gson=new Gson();
					gson.toJson(saleBestWorstData);
					return RespResultGenerator.genOK(gson.fromJson(saleBestWorstData, json.getClass()), "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	@Override
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> querySaleTryData(String time, String storeCode) {
		try {
			if(!time.equals("")&&time!=null){
				List<Map<String, Object>> json=new ArrayList<>();
				SaleWebService sws=new SaleWebServiceProxy();
				String saleTryData=sws.querySaleData(time, storeCode);
				if(!("").equals(saleTryData)&&saleTryData!=null){
					Gson gson=new Gson();
					List<Map<String, Object>> list=gson.fromJson(saleTryData, json.getClass());
					TryOnData tryOnData=new TryOnData();
					tryOnData.setCreateTime(time);
					tryOnData.setStoreCode(storeCode);
					for (Map<String, Object> map : list) {
						String style= map.get("style").toString();
						tryOnData.setStyle(style);
						map.putAll(tryOnDataDao.selectTryData(tryOnData));
					}
					return RespResultGenerator.genOK(list, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

}
