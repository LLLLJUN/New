package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.Sale;
import com.ws.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BatchSaleJsonUtil {
	public static List<Sale> getSaleListBean(JSONObject jsonObject){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONArray arr=json.getJSONArray("data");
		List<Sale> saleList=new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			String data=arr.getString(i);
			JSONObject batchSale=JSONObject.fromObject(data);
			Sale sale=new Sale();
			sale.setRemark(batchSale.getString("remark"));
			sale.setSaleBillNo(DateUtil.createCode("saleBillNo"));
			sale.setStoreCode(batchSale.getString("storeCode"));
			sale.setTotalNum(batchSale.getInt("totalNum"));
			sale.setTotalPrice(batchSale.getString("totalPrice"));
			sale.setUserCode(batchSale.getString("userCode"));
			sale.setUserName(batchSale.getString("userName"));
			sale.setSaleTime(batchSale.getString("saleTime"));
			saleList.add(sale);
		}
		
		return saleList;
	}
}
