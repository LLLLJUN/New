package com.ws.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.SupplierDao;
import com.ws.model.Page;
import com.ws.model.ResponseResult;
import com.ws.model.Supplier;
import com.ws.service.SupplierService;
import com.ws.util.DateUtil;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.SupplierJsonUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月2日
 */

@Service
public class SupplierServiceImpl implements SupplierService {
	@Resource
	private SupplierDao supplierDao;
	
	public ResponseEntity<ResponseResult<Map<String, Object>>> insertSupplier(JSONObject jsonObject) {
		if(jsonObject!=null && !jsonObject.equals("")){
			Supplier supplier=SupplierJsonUtil.getSupplierBean(jsonObject);
			supplier.setSupplierCode(DateUtil.supplierCode());
			if(supplierDao.insertSupplier(supplier)>0){
				Map<String, Object> map=new HashMap<String,Object>();
				map.put("supplierCode", supplier.getSupplierCode());
				return RespResultGenerator.genOK(map, "新增成功");
			}else{
				return RespResultGenerator.genError(null, "新增失败");
			}
		}
		return RespResultGenerator.genError(null, "参数为空");
	}

	@Transactional
	public ResponseEntity<ResponseResult<String>> deleteBySupplierCode(String supplierCode) {
		if(supplierCode!=null){
			if(supplierDao.deleteBySupplierCode(supplierCode)>0){
				return RespResultGenerator.genOK(null, "删除成功");
			}else{
				return RespResultGenerator.genError(null, "删除失败");
			}
		}
		return RespResultGenerator.genError(null, "参数为空");
	}
	
	@Transactional
	public ResponseEntity<ResponseResult<String>> updateBySupplier(JSONObject jsonObject) {
		if(jsonObject!=null && !jsonObject.equals("")){
			Supplier supplier=SupplierJsonUtil.getSupplierBean(jsonObject);
			if(supplierDao.updateSupplier(supplier)>0){
				return RespResultGenerator.genOK(null, "修改成功");
			}else{
				return RespResultGenerator.genError(null, "修改失败");
			}
		}
		return RespResultGenerator.genOK(null, "参数为空");

	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> selectBySupplierCode(String supplierCode) {
		if(supplierCode!=null){
			Map<String, Object>map= supplierDao.selectBySupplierCode(supplierCode);
			if(map!=null){
				return RespResultGenerator.genOK(map, "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败");
			}
		}
		return RespResultGenerator.genError(null, "参数为空");

	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectAllSupplier(Integer pageRow) {
		if(pageRow==null){
			pageRow=1;
		}
		Page page=new Page();
		page.setCountAll(supplierDao.selectCount());
		page.setPageRow(pageRow);
		return RespResultGenerator.genOK(supplierDao.selectAllSupplier(page), "获取成功");
		
	}
	
	

}
