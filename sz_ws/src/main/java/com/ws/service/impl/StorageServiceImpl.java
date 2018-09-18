package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.StorageDao;
import com.ws.model.ResponseResult;
import com.ws.service.StorageService;
import com.ws.util.RespResultGenerator;

/**
 * @author lujun
 * @date 2018年7月3日
 */
@Service
public class StorageServiceImpl implements StorageService {
	
	@Resource
	private StorageDao storageDao;
	
	@Transactional
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectAllStorage(String storeCode) {
			if(storeCode!=null){
				List<Map<String, Object>> storageList=storageDao.selectAllStorage(storeCode);
				if(!storageList.isEmpty()){
					return RespResultGenerator.genOK(storageList, "获取成功");
				}else{
					return RespResultGenerator.genError(null, "获取失败");
				}
			}
			return RespResultGenerator.genError(null, "参数出错");
	}

}
