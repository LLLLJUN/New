package com.ws.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ws.model.OutStoreDetail;

/**
 * @author lujun
 * @date 2018年7月9日
 */
public interface OutStoreDetailDao {
	
	/**
	 *
	 *新增出库商品详细信息
	 *@param outStoreDetailList
	 *@return
	 */
	int insertOutStoreList(@Param("outStoreDetailList")List<OutStoreDetail> outStoreDetailList);
}
