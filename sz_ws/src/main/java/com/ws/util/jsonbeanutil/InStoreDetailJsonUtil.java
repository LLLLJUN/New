package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.InStore;
import com.ws.model.InStoreDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class InStoreDetailJsonUtil {
	public static List<InStoreDetail> getInStoreDetailBean(JSONObject jsonObject,InStore inStore){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		JSONArray array=data.getJSONArray("goodsInfos");
		List<InStoreDetail> inStoreDetailList=new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			InStoreDetail inStoreDetail=new InStoreDetail();
			String goods=array.getString(i);
			JSONObject goodsInfos=JSONObject.fromObject(goods);
			inStoreDetail.setColor(goodsInfos.getString("color"));
			inStoreDetail.setInStoreCode(inStore.getInStoreCode());
			inStoreDetail.setInStoreNum(goodsInfos.getInt("inStoreNum"));
			inStoreDetail.setPurchasePrice(goodsInfos.getString("purchasePrice"));
			inStoreDetail.setSize(goodsInfos.getString("size"));
			inStoreDetail.setSku(goodsInfos.getString("sku"));
			inStoreDetailList.add(inStoreDetail);
		}
		return inStoreDetailList;
	}
}
