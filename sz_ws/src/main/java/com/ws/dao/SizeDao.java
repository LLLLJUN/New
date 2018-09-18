package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Size;

public interface SizeDao {
	
	/**
	 *
	 *新增尺码
	 *@param size 
	 *@return
	 */
	int insertSize(Size size);
	
	/**
	 *
	 *获取所有尺码
	 *@param 
	 *@return
	 */
	List<Map<String, Object>> selectTotalSize();
	
	/**
	 *
	 *获取对应的颜色名称
	 *@param size
	 *@return
	 */
	String selectBySize(String size);
	
	int selectSizeExsit(String sizeCode);

}
