package com.ws.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import com.ws.model.ResponseResult;
import com.ws.util.resp.ResponsePageResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月5日
 */
public interface CheckService {
	/**
	 *
	 *增加盘点单
	 *@param jsonObject
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> insertCheck(@Param("jsonObject")JSONObject jsonObject);
	
	/**
	 *
	 *获得对应盘点单信息
	 *@param checkBillCode
	 *@return
	 */
	ResponseEntity<ResponsePageResult<Map<String, Object>>> selectCheckByCheckBillCode(@Param("checkBillCode")String checkBillCode);

	/**
	 *
	 *获得盘点单列表
	 *@param pageRow ,storeCode
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectCheckList(@Param("pageRow")Integer pageRow,@Param("storeCode")String storeCode);
	
	/**
	 *
	 *获得已盘点单列表
	 *@param pageRow
	 *@return
	 */
	ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectYesCheckList(@Param("pageRow")Integer pageRow,@Param("storeCode")String storeCode);

	/**
	 *
	 *修改盘点单
	 *@param jsonObject 
	 *@return
	 */
	ResponseEntity<ResponseResult<String>> updateCheck(@Param("jsonObject") JSONObject jsonObject);
}
