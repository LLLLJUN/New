package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.Purchase;
import com.ws.model.PurchaseDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class PurchaseDetailUtil {
	public static List<PurchaseDetail> getPurchaseDetailBean(JSONObject jsonObject,Purchase purchase){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject purchaseData=json.getJSONObject("data");
		List<PurchaseDetail> purchaseDetailList=new ArrayList<>();
		JSONArray array=purchaseData.getJSONArray("goodsInfos");
		for (int i = 0; i < array.size(); i++) {
			PurchaseDetail purchaseDetail=new PurchaseDetail();
			String goods=array.getString(i);
			JSONObject goodsInfos=JSONObject.fromObject(goods);
			purchaseDetail.setColor(goodsInfos.getString("color"));
			purchaseDetail.setPurchaseCode(purchase.getPurchaseCode());
			purchaseDetail.setPurchaseNum(goodsInfos.getInt("purchaseNum"));
			purchaseDetail.setPurchasePrice(goodsInfos.getString("purchasePrice"));
			purchaseDetail.setSize(goodsInfos.getString("size"));
			purchaseDetail.setSku(goodsInfos.getString("sku"));
			purchaseDetailList.add(purchaseDetail);
		}
		
		return purchaseDetailList;
	}
}
