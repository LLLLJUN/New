package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.OutStoreDao;
import com.ws.dao.OutStoreDetailDao;
import com.ws.model.Condition;
import com.ws.model.OutStore;
import com.ws.model.Page;
import com.ws.model.ResponseResult;
import com.ws.service.OutStoreService;
import com.ws.util.DateUtil;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.OutStoreDetailJsonUtil;
import com.ws.util.jsonbeanutil.OutStoreJsonUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月9日
 */
@Service
public class OutStoreServiceImpl implements OutStoreService {

	@Resource
	private OutStoreDao outStoreDao;
	@Resource
	private OutStoreDetailDao outStoreDetailDao;
	
	public ResponseEntity<ResponseResult<String>> addOutStore(JSONObject jsonObject) {
		if(jsonObject!=null&&!jsonObject.equals("")){
			OutStore outStore=OutStoreJsonUtil.getOutStoreBean(jsonObject);
			int outStoreNum=outStoreDao.insertOutStore(outStore);
			int updateGoodsTransferNum=outStoreDao.updateGoodsTransfer(outStore);
			int outStoreDetailNum=outStoreDetailDao.insertOutStoreList(
					OutStoreDetailJsonUtil.getOutStoreDetailBean(jsonObject, outStore));
			if(outStoreNum>0&&updateGoodsTransferNum>0&&outStoreDetailNum>0){
				return RespResultGenerator.genOK(null, "上传成功");
			}else{
				return RespResultGenerator.genError(null, "上传失败");
			}
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryByTransferCode(String transferCode) {
		if(transferCode!=null && !transferCode.equals("")){
			Map<String, Object> map=outStoreDao.selectByTransferCode(transferCode);
			map.put("outStoreCode", DateUtil.outStoreCode());
			map.put("outStoreMode", 1);
			map.put("relevanceCode", transferCode);
			return RespResultGenerator.genOK(map, "查询成功");
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryNoTransferList(Integer pageRow,
			String storeCode) {
		if(pageRow==null){
			pageRow=1;
		}
		Page page=new Page();
		Condition condition=new Condition();
		condition.setStoreCode(storeCode);
		page.setCountAll(outStoreDao.selectNoAllCount(condition));
		page.setPageRow(pageRow);
		page.setCondition(condition);
		return RespResultGenerator.genOK(outStoreDao.selectNoOutStoreList(page), "查询成功");
		
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryYesTransferList(Integer pageRow,
			String storeCode) {
		if(pageRow==null){
			pageRow=1;
		}
		Page page=new Page();
		Condition condition=new Condition();
		condition.setStoreCode(storeCode);
		page.setCountAll(outStoreDao.selectYesAllCount(condition));
		page.setPageRow(pageRow);
		page.setCondition(condition);
		return RespResultGenerator.genOK(outStoreDao.selectYesOutStoreList(page), "查询成功");
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryYesOutStoreCode(String outStoreCode) {
		if(outStoreCode!=null&&!outStoreCode.equals("")){
			return RespResultGenerator.genOK(outStoreDao.selectByOutStoreCode(outStoreCode), "获取成功");
		}else{
			return RespResultGenerator.genError(null, "获取失败");
		}
	}

}
