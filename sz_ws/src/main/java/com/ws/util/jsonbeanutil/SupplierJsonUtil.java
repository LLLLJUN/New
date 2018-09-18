package com.ws.util.jsonbeanutil;

import com.ws.model.Supplier;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class SupplierJsonUtil {
	public static Supplier getSupplierBean(JSONObject jsonObject){
		Supplier supplier=new Supplier();
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONArray array=json.getJSONArray("data");
		for (int i = 0; i < array.size(); i++) {
			String supp=array.getString(i);
			JSONObject data=JSONObject.fromObject(supp);
			supplier.setSupplierAddress(data.getString("supplierAddress"));
			supplier.setSupplierMail(data.getString("supplierMail"));
			supplier.setSupplierMan(data.getString("supplierMan"));
			supplier.setSupplierName(data.getString("supplierName"));
			supplier.setSupplierTel(data.getString("supplierTel"));
			if(data.get("supplierCode")!=null && !data.get("supplierCode").equals("")){
				supplier.setSupplierCode(data.getString("supplierCode"));
			}
		}
		return supplier;
	}
}
