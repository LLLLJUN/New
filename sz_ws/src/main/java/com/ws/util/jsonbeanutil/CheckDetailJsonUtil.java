package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.Check;
import com.ws.model.CheckDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class CheckDetailJsonUtil {
	public static List<CheckDetail> getCheckDetailBean(JSONObject jsonObject,Check check){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		JSONArray array=data.getJSONArray("goodsInfos");
		List<CheckDetail> checkDetailList=new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			CheckDetail checkDetail=new CheckDetail();
			String goods=array.getString(i);
			JSONObject goodsInfos=JSONObject.fromObject(goods);
			checkDetail.setCheckBillCode(check.getCheckBillCode());
			checkDetail.setColor(goodsInfos.getString("color"));
			checkDetail.setSku(goodsInfos.getString("sku"));
			checkDetail.setSize(goodsInfos.getString("size"));
			checkDetail.setPlanNum(goodsInfos.getInt("planNum"));
			checkDetailList.add(checkDetail);
		}
		return checkDetailList;
	}
}
