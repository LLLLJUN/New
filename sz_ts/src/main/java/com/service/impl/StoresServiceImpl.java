package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.StoresDao;
import com.model.Condition;
import com.model.Page;
import com.model.Stores;
import com.service.StoresService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;

/**
 * @author lujun
 * @date 2018年7月26日
 */

@Service
public class StoresServiceImpl implements StoresService {
	@Resource
	private StoresDao storesDao;
	
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryStores(String storeCode) {
		try {
			List<Map<String, Object>> storesInfoList=new ArrayList<>();
			if(storeCode==null || storeCode.equals("")){
				storesInfoList=storesDao.selectAllStore();
			}else{
				Map<String, Object> storesInfo=storesDao.selectByStoreCode(storeCode);
				storesInfoList.add(storesInfo);
			}
			if(storesInfoList!=null){
				return RespResultGenerator.genOK(storesInfoList, "获取成功");
			}
			return RespResultGenerator.genError(null, "获取失败");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}
	
	public ResponseEntity<ResponseResult<String>> increaseStore(Stores store) {
		try {
			if(store!=null&&!store.equals("")){
				int num=storesDao.increaseStore(store);
				if(num>0){
					return RespResultGenerator.genOK(null, "增加成功");
				}
				return RespResultGenerator.genError(null, "增加失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
			} catch (Exception e) {
				e.printStackTrace();
				return RespResultGenerator.genError(null, "操作错误");
		}
		
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> pageQueryStore(String storeCode,String storeArea, Integer pageRow
			) {
		try {
			if(pageRow==null){
				pageRow=1;
			}
			Page page=new Page();
			Condition condition=new Condition();
			condition.setStoreArea(storeArea);
			condition.setStoreCode(storeCode);
			page.setPageRow(pageRow);
			page.setCondition(condition);
			page.setCountAll(storesDao.queryCount(condition));
			List<Map<String, Object>> storeList= storesDao.pageQueryStores(page);
			//session.setAttribute("page", page);
			Map<String, Object> json=new HashMap<String,Object>();
			json.put("page", page);
			json.put("storeList", storeList);
			return RespResultGenerator.genOK(json, "获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<String>> deleteStore(String storeCode) {
		try {
			if(storeCode!=null && !storeCode.equals("")){
				int num =storesDao.deleteStore(storeCode);
				if(num>0){
					return RespResultGenerator.genOK(null, "删除成功");
				}else{
					return RespResultGenerator.genError(null, "删除失败");
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}


	public ResponseEntity<ResponseResult<String>> updateStore(Stores stores) {
		try {
			if(stores!=null&&!stores.equals("")){
				int num=storesDao.updateStore(stores);
				if(num>0){
					return RespResultGenerator.genOK(null, "修改成功");
				}else{
					return RespResultGenerator.genError(null, "修改失败");
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryStoreCodeAndStoreName() {
		return RespResultGenerator.genOK(storesDao.selectStoreNameAndStoreCode(), "获取成功");
	}

	@Override
	public String says() {
		return "hello webservice";
	}



}
