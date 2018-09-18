package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Color;

/**
 *
 */
public interface ColorDao {
	
	/**
	 *
	 *新增颜色
	 *@param color
	 *@return
	 */
	int insertColor(Color color);
	
	
	/**
	 *
	 *获取全部颜色信息
	 *@param 
	 *@return
	 */
	List<Map<String, Object>> selectTotalColor();
	
	
	String selectByColor(String color);
	
	/**
	 *
	 *获取颜色是否存在
	 *@param 
	 *@return
	 */
	int selectColorExsit(String colorCode);
}
