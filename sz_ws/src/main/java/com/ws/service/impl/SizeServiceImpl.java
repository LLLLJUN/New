package com.ws.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.SizeDao;
import com.ws.model.ResponseResult;
import com.ws.model.Size;
import com.ws.service.SizeService;
import com.ws.util.DateUtil;
import com.ws.util.RespResultGenerator;

@Service
public class SizeServiceImpl implements SizeService {
	@Resource
	private SizeDao sizeDao;

	public ResponseEntity<ResponseResult<Map<String, Object>>> increaseSize(String sizeName) {
		try {
			if(sizeName!=null && !sizeName.equals("")){
				Size size=new Size();
				size.setSizeName(sizeName);
				int sizeNum=0;
				String sizeCode=null;
				do{
					sizeCode=DateUtil.createCode("sizeCode");
					sizeNum=sizeDao.selectSizeExsit(sizeCode);
				}while(sizeNum>0);
					size.setSize(sizeCode);
				int num=sizeDao.insertSize(size);
				if(num>0){
					Map<String, Object> map =new HashMap<>();
					map.put("size", size.getSize());
					return RespResultGenerator.genOK(map, "增加成功");
				}
				return RespResultGenerator.genError(null, "增加失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalSizeInfo() {
		try {
			List<Map<String, Object>> sizeList= sizeDao.selectTotalSize();
			if(sizeList.size()>0){
				return RespResultGenerator.genOK(sizeList, "获取成功");
			}
			return RespResultGenerator.genError(null, "获取失败");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}
}
