package com.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author lujun
 * @date 2018年6月21日
 */
public interface EpcStyleDao {
	//根据epc信息查询商品的详细信息
	Map<String,Object> selectByEpc(@Param("epc")String epc);
	//根据搭配款的款式查询出该搭配款的详细信息
	Map<String, Object> selectByMatchStyle(@Param("matchStyle")String matchStyle);
}
