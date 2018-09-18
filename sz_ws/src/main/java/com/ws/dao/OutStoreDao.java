package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Condition;
import com.ws.model.OutStore;
import com.ws.model.Page;

/**
 * @author lujun
 * @date 2018年7月9日
 */
public interface OutStoreDao {
	 
	/**
	 *
	 *获得待出库列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectNoOutStoreList(Page page);
	 
	/**
	 *
	 *获得待出库总数
	 *@param condition
	 *@return
	 */
	int selectNoAllCount(Condition condition);
	 
	/**
	 *
	 *出库完成商品信息上传
	 *@param outStore
	 *@return
	 */
	int insertOutStore(OutStore outStore);
 
	/**
	 *
	 *修改转货单状态
	 *@param outStore
	 *@return
	 */
	int updateGoodsTransfer(OutStore outStore);
 
	/**
	 *
	 *获得已出库列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectYesOutStoreList(Page page);
 
	/**
	 *
	 *获得已出库单总数
	 *@param condition
	 *@return
	 */
	int selectYesAllCount(Condition condition);
	 
	/**
	 *
	 *获得待出库单详细信息
	 *@param transferCode
	 *@return
	 */
	Map<String, Object> selectByTransferCode(String transferCode);
	 
	/**
	 *
	 *获得已出库单详细信息
	 *@param outStoreCode
	 *@return
	 */
	List<Map<String, Object>> selectByOutStoreCode(String outStoreCode);
}
