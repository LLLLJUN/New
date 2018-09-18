package com.ws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ws.model.InStoreDetail;

/**
 * @author lujun
 * @date 2018年7月4日
 */
public interface InStoreDetailDao {
	
	/**
	 *
	 *增加入库商品
	 *@param inStoreDetailList
	 *@return
	 */
	int insertInStoreDetailList(@Param("inStoreDetailList")List<InStoreDetail> inStoreDetailList);
	
	List<Map<String, Object>> selectInStoreNum(String purchaseCode);

}
