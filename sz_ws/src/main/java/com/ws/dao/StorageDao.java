package com.ws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ws.model.Storage;

/**
 * @author lujun
 * @date 2018年7月3日
 */
public interface StorageDao {
	 
	/**
	 *
	 *入库完成后新增库存信息
	 *@param storageList
	 *@return
	 */
	int insertStorage(@Param("storageList")List<Storage> storageList);
	 
	/**
	 *
	 *获得对应门店库存
	 *@param storeCode
	 *@return
	 */
	List<Map<String,Object>> selectAllStorage(String storeCode);

}
