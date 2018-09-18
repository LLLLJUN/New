package com.ws.util.jsonbeanutil;

import com.ws.model.OutStore;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class OutStoreJsonUtil {
	public static OutStore getOutStoreBean(JSONObject jsonObject){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		OutStore outStore=new OutStore();
		outStore.setGoodsAllNum(data.getInt("goodsAllNum"));
		outStore.setGoodsTotalPrices(data.getString("goodsTotalPrices"));
		outStore.setOutStoreCode(data.getString("outStoreCode"));
		outStore.setOutStoreMode(data.getInt("outStoreMode"));
		outStore.setRelevanceCode(data.getString("relevanceCode"));
		outStore.setRemark(data.getString("remark"));
		outStore.setUserName(data.getString("userName"));
		outStore.setWarehouse(data.getString("warehouse"));
		outStore.setStoreCode(data.getString("storeCode"));
		outStore.setOutStoreState(data.getInt("outStoreState"));
		return outStore;
	}
}
