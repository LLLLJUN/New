package com.ws.util.jsonbeanutil;

import com.ws.model.Goods;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class GoodsJsonUtil {
	public static Goods getGoodsBean(JSONObject jsonObject){
		Goods goods=new Goods();
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONArray array=json.getJSONArray("data");
		for (int i = 0; i < array.size(); i++) {
			String s=array.getString(i);
			JSONObject data = JSONObject.fromObject(s);
			goods.setColors(data.getString("colors"));
			goods.setListPrice(data.getString("listPrice"));
			goods.setLowerLimitNum(data.getInt("lowerLimitNum"));
			goods.setName(data.getString("name"));
			goods.setSizes(data.getString("sizes"));
			goods.setStyle(data.getString("style"));
			goods.setUnit(data.getString("unit"));
			goods.setUpperLimitNum(data.getInt("upperLimitNum"));
			goods.setCurPrice(data.getString("curPrice"));
			goods.setPurchasePrice(data.getString("purchasePrice"));
			goods.setSku(data.getString("sku"));
		}
		return goods;
	}

}
