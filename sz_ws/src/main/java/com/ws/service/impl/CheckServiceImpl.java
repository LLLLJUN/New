package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.CheckDao;
import com.ws.dao.CheckDetailDao;
import com.ws.model.Check;
import com.ws.model.Condition;
import com.ws.model.Page;
import com.ws.model.ResponseResult;
import com.ws.service.CheckService;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.CheckDetailJsonUtil;
import com.ws.util.jsonbeanutil.CheckJsonUtil;
import com.ws.util.resp.ResponsePageResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月5日
 */
@Service
public class CheckServiceImpl implements CheckService {
	@Resource
	private CheckDao checkDao;
	@Resource
	private CheckDetailDao checkDetailDao;
	
	public ResponseEntity<ResponseResult<String>> insertCheck(JSONObject jsonObject) {
			if(jsonObject!=null&&!jsonObject.equals("")){
				Check check=CheckJsonUtil.getCheckBean(jsonObject);
				int checkNum=checkDao.insertCheck(check);
				int checkDetailNum=checkDetailDao.insertCheckDetailList(CheckDetailJsonUtil.getCheckDetailBean(jsonObject, check));
				if(checkNum>0&&checkDetailNum>0){
					return RespResultGenerator.genOK(null, "上传成功");
				}else{
					return RespResultGenerator.genOK(null, "上传失败");
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponsePageResult<Map<String, Object>>> selectCheckByCheckBillCode(String checkBillCode) {
		try {
			if(checkBillCode!=null){
				List<Map<String, Object>> map=checkDao.selectCheckByCheckBillCode(checkBillCode);
				if(map!=null && !map.equals("")){
					return com.ws.util.resp.RespResultGenerator.genOK(map, null, "获取成功");
				}else{
					return com.ws.util.resp.RespResultGenerator.genError(null, null, "没有该商品信息");
				}
			}
			return com.ws.util.resp.RespResultGenerator.genError(null, null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return com.ws.util.resp.RespResultGenerator.genError(null, null, "操作错误");
		}
	}
	
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectCheckList(Integer pageRow,
			String storeCode) {
		try {
			if(pageRow==null){
				pageRow=1;
			}
			Page page=new Page();
			Condition condition=new Condition();
			condition.setStoreCode(storeCode);
			page.setCondition(condition);
			page.setCountAll(checkDao.selectAllCount(condition));
			page.setPageRow(pageRow);
			if(checkDao.selectCheckList(page)!=null){
				return RespResultGenerator.genOK(checkDao.selectCheckList(page), "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectYesCheckList(Integer pageRow,
			String storeCode) {
			if(pageRow==null){
				pageRow=1;
			}
			Page page=new Page();
			Condition condition=new Condition();
			condition.setStoreCode(storeCode);
			page.setCondition(condition);
			page.setCountAll(checkDao.selectYesAllCount(condition));
			page.setPageRow(pageRow);
			if(checkDao.selectYesCheckList(page)!=null){
				return RespResultGenerator.genOK(checkDao.selectYesCheckList(page), "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败"); 
			}
	}

	public ResponseEntity<ResponseResult<String>> updateCheck(JSONObject jsonObject) {
			/*if(jsonObject!=null&& !jsonObject.equals("")){
				Check check=CheckJsonUtil.getCheckBean(jsonObject);
				int checkNum=checkDao.updateCheck(check);
				int checkDetailNum=checkDetailDao.updateCheck(CheckDetailJsonUtil.getCheckDetailBean(jsonObject, check));
				if(checkNum>0&&checkDetailNum>0){
					return RespResultGenerator.genOK(null, "上传成功");
				}else{
					return RespResultGenerator.genError(null, "上传失败");
				}
			}*/
			return RespResultGenerator.genError(null, "参数错误");
	}

}
