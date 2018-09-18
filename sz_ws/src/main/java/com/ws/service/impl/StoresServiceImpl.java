package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.StoresDao;
import com.ws.model.ResponseResult;
import com.ws.service.StoresService;
import com.ws.util.RespResultGenerator;

@Service
public class StoresServiceImpl implements StoresService {
	
	@Resource
	private StoresDao storesDao;
	
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalStore() {
		try {
			return RespResultGenerator.genOK(storesDao.selectTotalStore(), "获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
		
	}

}
