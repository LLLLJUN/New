package com.ws.util.jsonbeanutil;

import com.ws.model.GoodsTransfer;
import com.ws.util.DateUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class GoodsTransferJsonUtil {
	public static GoodsTransfer getGoodsTransferBean(JSONObject jsonObject){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		GoodsTransfer goodsTransfer=new GoodsTransfer();
		goodsTransfer.setGoodsAllNum(data.getInt("goodsAllNum"));
		goodsTransfer.setGoodsTotalPrices(data.getString("goodsTotalPrices"));
		goodsTransfer.setOutStoreState(data.getInt("outStoreState"));
		goodsTransfer.setInStoreState(data.getInt("inStoreState"));
		goodsTransfer.setSendStoreCode(data.getString("sendStoreCode"));
		goodsTransfer.setSendStoreName(data.getString("sendStoreName"));
		goodsTransfer.setWarehouse(data.getString("warehouse"));
		goodsTransfer.setReceiveStoreCode(data.getString("receiveStoreCode"));
		goodsTransfer.setReceiveStoreName(data.getString("receiveStoreName"));
		goodsTransfer.setUserName(data.getString("userName"));
		goodsTransfer.setTransferCode(DateUtil.transferCode());
		goodsTransfer.setRemark(data.getString("remark"));
		return goodsTransfer;
	}
}
