package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Goods;
import com.ws.model.Page;

/**
 * @author lujun
 * @date 2018年6月29日
 */
public interface GoodsDao {
	
	/**
	 *
	 *查看对应商品是否存在
	 *@param sku
	 *@return
	 */
	int selectBySku(String sku);
	
	/**
	 *
	 *增加商品
	 *@param goods
	 *@return
	 */
	int insertGoods(Goods goods);
	
	/**
	 *
	 *删除商品
	 *@param sku
	 *@return
	 */
	int deleteGoodsBySku(String sku);
	
	/**
	 *
	 *修改商品
	 *@param goods
	 *@return
	 */
	int updateGoods(Goods goods);
	
	/**
	 *
	 *获得商品总数
	 *@param 
	 *@return
	 */
	int selectAllCount();
	
	/**
	 *
	 *获得商品列表
	 *@param 
	 *@return
	 */
	List<Map<String,Object>> Goodspage(Page page);
	
	/**
	 *
	 *获取对应商品信息
	 *@param sku
	 *@return
	 */
	Map<String, Object> selectGoodsBySku(String sku);
	
	/**
	 *
	 *获取全部商品信息
	 *@param 
	 *@return
	 */
	List<Map<String, Object>> selectAllGoods();
}
