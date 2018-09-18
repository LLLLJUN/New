package com.ws.util.jsonbeanutil;

import java.util.ArrayList;
import java.util.List;

import com.ws.model.InStore;
import com.ws.model.Storage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月20日
 */
public class StorageJsonUtil {
	public static List<Storage> getStorageBean(JSONObject jsonObject,InStore inStore){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		JSONArray array=data.getJSONArray("goodsInfos");
		List<Storage> storageList=new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			Storage storage=new Storage();
			String goods=array.getString(i);
			JSONObject goodsInfos=JSONObject.fromObject(goods);
			storage.setColor(goodsInfos.getString("color"));
			storage.setStoreCode(inStore.getStoreCode());
			storage.setNum(goodsInfos.getInt("inStoreNum"));
			storage.setSize(goodsInfos.getString("size"));
			storage.setSku(goodsInfos.getString("sku"));
			storageList.add(storage);
		}
		return storageList;
	}
}
