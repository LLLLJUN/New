package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.GoodsTransferDao;
import com.ws.dao.GoodsTransferDetailDao;
import com.ws.model.Condition;
import com.ws.model.GoodsTransfer;
import com.ws.model.Page;
import com.ws.model.ResponseResult;
import com.ws.service.GoodsTransferService;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.GoodsTransferDetailJsonUtil;
import com.ws.util.jsonbeanutil.GoodsTransferJsonUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月6日
 */
@Service
public class GoodsTransferServiceImpl implements GoodsTransferService {
	@Resource
	private GoodsTransferDao goodsTransferDao;
	@Resource
	private GoodsTransferDetailDao goodsTransferDetailDao;

	public ResponseEntity<ResponseResult<String>> insertGoodsTransfer(JSONObject jsonObject) {
			if(jsonObject!=null&&!jsonObject.equals("")){
				GoodsTransfer goodsTransfer=GoodsTransferJsonUtil.getGoodsTransferBean(jsonObject);
				int goodsTransferNum=goodsTransferDao.insertGoodsTransfer(goodsTransfer);
				int goodsTransferDetailNum=goodsTransferDetailDao.insertGoodsTransferDetailList(
						GoodsTransferDetailJsonUtil.getGoodsTransferDetailBean(jsonObject, goodsTransfer));
				if(goodsTransferDetailNum>0&&goodsTransferNum>0){
					return RespResultGenerator.genOK(null, "上传成功");
				}else{
					return RespResultGenerator.genError(null, "上传失败");
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<String>> deleteGoodsTransfer(String transferCode) {
		if(transferCode!=null){
			if(goodsTransferDao.deleteGoodsTransfer(transferCode)>0){
				if(goodsTransferDetailDao.deleteGoodsTransferDetail(transferCode)>0){
					return RespResultGenerator.genOK(null, "删除成功");
				}
				return RespResultGenerator.genError(null, "删除失败");
			}else{
				return RespResultGenerator.genError(null, "删除失败");
			}
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectByTransferCode(String transferCode) {
		if(transferCode!=null){
			if(goodsTransferDao.selectByTransferCode(transferCode)!=null){
				return RespResultGenerator.genOK(goodsTransferDao.selectByTransferCode(transferCode), "查询成功"); 
			}else{
				return RespResultGenerator.genError(null, "查询失败");
			}
		}
		return RespResultGenerator.genError(null, "参数错误");
	}
	
	@Transactional
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectGoodsTransferList(Integer pageRow,
			String storeCode) {
			if(pageRow==null){
				pageRow=1;
			}
			Page page=new Page();
			Condition condition=new Condition();
			condition.setStoreCode(storeCode);
			page.setCondition(condition);
			page.setCountAll(goodsTransferDao.selectAllCount(condition));
			page.setPageRow(pageRow);
			if(goodsTransferDao.selectGoodsTransferList(page)!=null){
				return RespResultGenerator.genOK(goodsTransferDao.selectGoodsTransferList(page), "获取成功");
			}else{
				return RespResultGenerator.genError(null, "查询失败");
			}
	}

}
