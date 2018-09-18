package com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.ImgManageDao;
import com.service.ImgManageService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;

/**
 * @author lujun
 * @date 2018年7月26日
 */
@Service
public class ImgManageServiceImp implements ImgManageService {
	@Resource 
	private ImgManageDao imgManageDao;
	
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryImgManage(int imgVersion) {
		try {
			if(imgVersion>=0){
				List<Map<String, Object>>imgManageList= imgManageDao.selectImgManage(imgVersion);
				if(imgManageList.size()>0){
					return RespResultGenerator.genOK(imgManageList, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取成功");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

}
