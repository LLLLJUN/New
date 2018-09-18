package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.Sale;
import com.ws.model.SaleDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SaleDetailJsonUtil {
	public static List<SaleDetail> getSaleDetailBean(JSONObject jsonObject,Sale sale){
		JSONObject json= JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		JSONArray salesDtl=data.getJSONArray("salesdtl");
		List<SaleDetail> saleDetailList=new ArrayList<>();
		for (int i = 0; i < salesDtl.size(); i++) {
			SaleDetail saleDetail=new SaleDetail();
			String saleGoodsInfo=salesDtl.getString(i);
			JSONObject object=JSONObject.fromObject(saleGoodsInfo);
			saleDetail.setColor(object.getString("color"));
			saleDetail.setCurPrice(object.getString("curPrice"));
			saleDetail.setListPrice(object.getString("listPrice"));
			saleDetail.setName(object.getString("name"));
			saleDetail.setSaleBillNo(sale.getSaleBillNo());
			saleDetail.setSize(object.getString("size"));
			saleDetail.setAllPrice(object.getString("allPrice"));
			saleDetail.setSku(object.getString("sku"));
			saleDetail.setStyle(object.getString("style"));
			saleDetail.setSaleNum(object.getInt("saleNum"));
			saleDetailList.add(saleDetail);
		}
		
		return saleDetailList;
	} 
}
