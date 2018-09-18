package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.Sale;
import com.ws.model.SaleDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BatchSaleDetailJsonUtil {
	public static List<SaleDetail> getSaleDetailListBean(JSONObject jsonObject,List<Sale> saleList){
		JSONObject json= JSONObject.fromObject(jsonObject);
		JSONArray dataArr=json.getJSONArray("data");
		List<SaleDetail> saleDetailList=new ArrayList<>();
		for (int i = 0; i < dataArr.size(); i++) {
			String dataInfo=dataArr.getString(i);
			JSONObject dataInfoJson=JSONObject.fromObject(dataInfo);
			JSONArray salesDtl=dataInfoJson.getJSONArray("salesdtl");
			for (int j = 0; j < salesDtl.size(); j++) {
				SaleDetail saleDetail=new SaleDetail();
				String saleGoodsInfo=salesDtl.getString(j);
				JSONObject object=JSONObject.fromObject(saleGoodsInfo);
				saleDetail.setColor(object.getString("color"));
				saleDetail.setCurPrice(object.getString("curPrice"));
				saleDetail.setListPrice(object.getString("listPrice"));
				saleDetail.setName(object.getString("name"));
				saleDetail.setSaleBillNo(saleList.get(i).getSaleBillNo());
				saleDetail.setSize(object.getString("size"));
				saleDetail.setAllPrice(object.getString("allPrice"));
				saleDetail.setSku(object.getString("sku"));
				saleDetail.setStyle(object.getString("style"));
				saleDetail.setSaleNum(object.getInt("saleNum"));
				saleDetailList.add(saleDetail);
			}
		}
		return saleDetailList;
	}
}
