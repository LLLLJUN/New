package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Check;
import com.ws.model.Condition;
import com.ws.model.Page;

/**
 * @author lujun
 * @date 2018年7月5日
 */
public interface CheckDao {
	
	/**
	 *
	 *新建盘点单
	 *@param check
	 *@return
	 */
	int insertCheck(Check check);
	
	/**
	 *
	 *获得盘点单的详细信息
	 *@param checkBillCode
	 *@return
	 */
	List<Map<String, Object>> selectCheckByCheckBillCode(String checkBillCode);
	
	/**
	 *
	 *获得待盘点单列表
	 *@param page
	 *@return
	 */
	List<Map<String , Object>> selectCheckList(Page page);
	
	/**
	 *
	 *获得带盘点单的总数
	 *@param condition
	 *@return
	 */
	int selectAllCount(Condition condition);
	
	/**
	 *
	 *获得已盘点单列表
	 *@param page
	 *@return
	 */
	List<Map<String , Object>> selectYesCheckList(Page page);
	
	/**
	 *
	 *获得已盘点单总数
	 *@param condition
	 *@return
	 */
	int selectYesAllCount(Condition condition);
	
	/**
	 *
	 *盘点信息完成上传
	 *@param check
	 *@return
	 */
	int updateCheck(Check check);
	
	
}
