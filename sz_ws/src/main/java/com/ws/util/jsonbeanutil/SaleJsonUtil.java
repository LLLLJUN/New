package com.ws.util.jsonbeanutil;

import com.ws.model.Sale;
import com.ws.util.DateUtil;

import net.sf.json.JSONObject;

public class SaleJsonUtil {
	public static Sale getSaleBean(JSONObject jsonObject){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		Sale sale=new Sale();
		sale.setRemark(data.getString("remark"));
		sale.setSaleBillNo(DateUtil.createCode("saleBillNo"));
		sale.setSaleBillNo(DateUtil.createCode("saleBillNo"));
		sale.setStoreCode(data.getString("storeCode"));
		sale.setTotalNum(data.getInt("totalNum"));
		sale.setTotalPrice(data.getString("totalPrice"));
		sale.setUserCode(data.getString("userCode"));
		sale.setUserName(data.getString("userName"));
		return sale;
	} 
}
