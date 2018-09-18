package com.ws.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.ColorDao;
import com.ws.model.Color;
import com.ws.model.ResponseResult;
import com.ws.service.ColorService;
import com.ws.util.DateUtil;
import com.ws.util.RespResultGenerator;

@Service
public class ColorServiceImpl implements ColorService {
	
	@Resource
	private ColorDao colorDao;

	public ResponseEntity<ResponseResult<Map<String, Object>>> increaseColor(String colorName,HttpServletRequest requ) {
		try {
			if(colorName!=null && !colorName.equals("")){
				Color color=new Color();
				int colorNum=0;
				String colorCode=null;
				do{
					colorCode=DateUtil.createCode("colorCode");
					colorNum=colorDao.selectColorExsit(colorCode);
				}while(colorNum>0);
				color.setColor(colorCode);
				color.setColorName(colorName);
				int num=colorDao.insertColor(color);
				if(num>0){
					Map<String, Object> map=new HashMap<>();
					map.put("color",color.getColor());
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

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTotalColorInfo() {
		try {
			List<Map<String, Object>> colorList= colorDao.selectTotalColor();
			if(colorList.size()>0){
				return RespResultGenerator.genOK(colorList, "获取成功");
			}
			return RespResultGenerator.genError(null, "获取失败");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

}
