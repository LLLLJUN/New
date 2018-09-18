package com.ws.util.jsonbeanutil;

import com.ws.model.Check;
import com.ws.util.DateUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月12日
 */
public class CheckJsonUtil {
	public static Check getCheckBean(JSONObject jsonObject){
		JSONObject json=JSONObject.fromObject(jsonObject);
		JSONObject data=json.getJSONObject("data");
		Check check=new Check();
		check.setCheckBillCode(DateUtil.checkBillCode());
		check.setCheckMakeMan(data.getString("checkMakeMan"));
		check.setCheckMode(data.getInt("checkMode"));
		check.setCheckState(data.getInt("checkState"));
		check.setStoreCode(data.getString("storeCode"));
		check.setPlanAllNum(data.getInt("planAllNum"));
		return check;
	}

}
