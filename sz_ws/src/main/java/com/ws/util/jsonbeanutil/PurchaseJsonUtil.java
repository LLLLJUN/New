package com.ws.util.jsonbeanutil;

import com.ws.model.Purchase;
import com.ws.util.DateUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class PurchaseJsonUtil {
	public static Purchase getPurchaseBean(JSONObject jsonObject){
		Purchase purchase=new Purchase();
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject purch=json.getJSONObject("data");
		purchase.setGoodsAllNum(purch.getInt("goodsAllNum"));
		purchase.setGoodsTotalPrices(purch.getString("goodsTotalPrices"));
		purchase.setPurchaseCode(DateUtil.purchaseCode());
		purchase.setRemark(purch.getString("remark"));
		purchase.setStoreCode(purch.getString("storeCode"));
		purchase.setSupplierCode(purch.getString("supplierCode"));
		purchase.setUserName(purch.getString("userName"));
		purchase.setWarehouse(purch.getString("warehouse"));
		return purchase;
	}
}
