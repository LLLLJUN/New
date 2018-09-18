package com.ws.dao;

import java.util.List;
import java.util.Map;

import com.ws.model.Page;
import com.ws.model.Supplier;

/**
 * @author lujun
 * @date 2018年7月2日
 */
public interface SupplierDao {
	 
	/**
	 *
	 *增加供应商
	 *@param supplier
	 *@return
	 */
	int insertSupplier(Supplier supplier);
	 
	/**
	 *
	 *删除供应商
	 *@param supplierCode
	 *@return
	 */
	int deleteBySupplierCode(String supplierCode);
	 
	/**
	 *
	 *修改供应商信息
	 *@param supplier
	 *@return
	 */
	int updateSupplier(Supplier supplier);
	 
	/**
	 *
	 *获得对应供应商信息
	 *@param supplierCode
	 *@return
	 */
	Map<String, Object> selectBySupplierCode(String supplierCode);
	 
	/**
	 *
	 *获得供应商列表
	 *@param page
	 *@return
	 */
	List<Map<String,Object>> selectAllSupplier(Page page);
	 
	/**
	 *
	 *获得供应商总数
	 *@param 
	 *@return
	 */
	int selectCount();
}
