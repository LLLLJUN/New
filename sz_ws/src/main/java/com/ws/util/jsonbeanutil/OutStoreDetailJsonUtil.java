

package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.OutStore;
import com.ws.model.OutStoreDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class OutStoreDetailJsonUtil {
	public static List<OutStoreDetail> getOutStoreDetailBean(JSONObject jsonObject,OutStore outStore){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		JSONArray array=data.getJSONArray("goodsInfos");
		List<OutStoreDetail> outStoreDetailList=new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			OutStoreDetail outStoreDetail=new OutStoreDetail();
			String goods=array.getString(i);
			JSONObject goodsInfos=JSONObject.fromObject(goods);
			outStoreDetail.setColor(goodsInfos.getString("color"));
			outStoreDetail.setOutStoreCode(outStore.getOutStoreCode());
			outStoreDetail.setOutStoreNum(goodsInfos.getInt("outStoreNum"));
			outStoreDetail.setPurchasePrice(goodsInfos.getString("purchasePrice"));
			outStoreDetail.setSize(goodsInfos.getString("size"));
			outStoreDetail.setSku(goodsInfos.getString("sku"));
			outStoreDetailList.add(outStoreDetail);
		}
		return outStoreDetailList;
		
	}
}
