package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.GoodsTransfer;
import com.ws.model.GoodsTransferDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class GoodsTransferDetailJsonUtil {
	public static List<GoodsTransferDetail> getGoodsTransferDetailBean(JSONObject jsonObject,GoodsTransfer goodsTransfer){
		List<GoodsTransferDetail> goodsTransferDetailList=new ArrayList<>();
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		JSONArray array=data.getJSONArray("goodsInfos");
		for (int i = 0; i < array.size(); i++) {
			GoodsTransferDetail goodsTransferDetail=new GoodsTransferDetail();
			 String goods=array.getString(i);
			 JSONObject	goodsInfos=JSONObject.fromObject(goods);
			 goodsTransferDetail.setColor(goodsInfos.getString("color"));
			 goodsTransferDetail.setPurchasePrice(goodsInfos.getString("purchasePrice"));
			 goodsTransferDetail.setSize(goodsInfos.getString("size"));
			 goodsTransferDetail.setSku(goodsInfos.getString("sku"));
			 goodsTransferDetail.setTransferCode(goodsTransfer.getTransferCode());
			 goodsTransferDetail.setTransferNum(goodsInfos.getInt("transferNum"));
			 goodsTransferDetailList.add(goodsTransferDetail);
		}
		return goodsTransferDetailList;
	}
}
