package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Condition;
import com.ws.model.GoodsTransfer;
import com.ws.model.Page;

/**
 * @author lujun
 * @date 2018年7月6日
 */
public interface GoodsTransferDao {
	
   /**
	 *
	 *增加转货单
	 *@param goodsTransfer
	 *@return
	 */
  int insertGoodsTransfer(GoodsTransfer goodsTransfer);
  
   /**
	 *
	 *删除转货单
	 *@param transferCode
	 *@return
	 */
	int deleteGoodsTransfer(String transferCode);
	
   /**
	 *
	 *获得转货单详情
	 *@param transferCode
	 *@return
	 */
	List<Map<String, Object>> selectByTransferCode(String transferCode);
	
   /**
	 *
	 *获得转货单列表
	 *@param page
	 *@return
	 */
	List<Map<String, Object>> selectGoodsTransferList(Page page);
	
   /**
	 *
	 *获得转货单总数
	 *@param condition
	 *@return
	 */
	int selectAllCount(Condition condition);
	}
