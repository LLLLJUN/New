package com.ws.util.jsonbeanutil;

import com.ws.model.InStore;
import com.ws.util.DateUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class InStoreJsonUtil {
	public static InStore getInStoreBean(JSONObject jsonObject){
		InStore inStore=new InStore();
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		inStore.setGoodsAllNum(data.getInt("goodsAllNum"));
		inStore.setGoodsTotalPrices(data.getString("goodsTotalPrices"));
		inStore.setInStoreCode(DateUtil.inStoreCode());
		inStore.setPurchaseCode(data.getString("purchaseCode"));
		inStore.setRemark(data.getString("remark"));
		inStore.setStoreCode(data.getString("storeCode"));
		inStore.setSupplierCode(data.getString("supplierCode"));
		inStore.setUserName(data.getString("userName"));
		inStore.setWarehouse(data.getString("warehouse"));
		inStore.setInStoreState(data.getInt("inStoreState"));
		return inStore;
	}
}
