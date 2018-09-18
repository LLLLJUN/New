package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.SaleDao;
import com.ws.dao.SaleDetailDao;
import com.ws.model.Condition;
import com.ws.model.ResponseResult;
import com.ws.model.Sale;
import com.ws.model.SaleDetail;
import com.ws.service.SaleService;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.BatchSaleDetailJsonUtil;
import com.ws.util.jsonbeanutil.BatchSaleJsonUtil;
import com.ws.util.jsonbeanutil.SaleDetailJsonUtil;
import com.ws.util.jsonbeanutil.SaleJsonUtil;

import net.sf.json.JSONObject;
@Service
public class SaleServiceImpl implements SaleService {
	
	@Resource
	private SaleDao saleDao;
	@Resource
	private SaleDetailDao saleDetailDao;
		
	@Override
	public ResponseEntity<ResponseResult<Map<String, Object>>> queryGoodsPriceInfo(String sku) {
		try {
			if(!sku.equals("") && sku!=null){
				Map<String, Object> priceInfo=saleDao.selectGoodsPriceInfo(sku);
				if(priceInfo!=null){
					return RespResultGenerator.genOK(priceInfo, "获取成功");
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
	public ResponseEntity<ResponseResult<Map<String, Object>>> increaseSaleInfo(JSONObject jsonObject) {
		try {
			if(!jsonObject.equals("") && jsonObject!=null){
				Sale sale= SaleJsonUtil.getSaleBean(jsonObject);
				int saleNum=saleDao.insertSale(sale);
				List<SaleDetail> saleDetailList=SaleDetailJsonUtil.getSaleDetailBean(jsonObject, sale);
				int saleDetailNum=saleDetailDao.insertSaleDetailList(saleDetailList);
				if(saleNum>0&& saleDetailNum>0){
					return RespResultGenerator.genOK(null, "销售成功");
				}
				return RespResultGenerator.genError(null, "销售失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}
	
	@Override
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryBySaleBillNoGetSaleGoodsInfo(
			String saleBillNo) {
		try {
			if(!saleBillNo.equals("") && saleBillNo!=null){
				List<Map<String, Object>> saleDetailList= saleDetailDao.selectBySaleBillNoGetSaleGoodsInfo(saleBillNo);
				if(saleDetailList.size()>0){
					return RespResultGenerator.genOK(saleDetailList, "获取成功");
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
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryByTimeSaleInfo(Condition condition) {
		try {
			if(condition!=null &&!condition.equals("")){
				List<Map<String, Object>> saleList=saleDao.selectByTimeSaleInfo(condition);
				if(saleList.size()>0){
					return RespResultGenerator.genOK(saleList, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<String>> increaseSaleList(JSONObject jsonObject) {
		try {
			if(!jsonObject.equals("")&& jsonObject!=null){
				List<Sale>saleList=BatchSaleJsonUtil.getSaleListBean(jsonObject);
				List<SaleDetail> saleDetailList=BatchSaleDetailJsonUtil.getSaleDetailListBean(jsonObject, saleList);
				if(!saleList.isEmpty()&&!saleDetailList.isEmpty()){
					int saleListNum=saleDao.insertSaleList(saleList);
					int saleDetailNum=saleDetailDao.insertSaleDetailList(saleDetailList);
				 	if(saleListNum>0&& saleDetailNum>0){
						return RespResultGenerator.genOK(null, "获取成功");
					}
					return RespResultGenerator.genError(null, "获取失败");
				}
				return RespResultGenerator.genError(null, "参数Json解析错误");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}
	
	

}
