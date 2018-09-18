package com.ws.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.InStoreDao;
import com.ws.dao.InStoreDetailDao;
import com.ws.dao.PurchaseDao;
import com.ws.dao.PurchaseDetailDao;
import com.ws.dao.StorageDao;
import com.ws.model.Condition;
import com.ws.model.InStore;
import com.ws.model.InStoreDetail;
import com.ws.model.Page;
import com.ws.model.Purchase;
import com.ws.model.ResponseResult;
import com.ws.model.Storage;
import com.ws.service.InStoreService;
import com.ws.util.DateUtil;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.InStoreDetailJsonUtil;
import com.ws.util.jsonbeanutil.InStoreJsonUtil;
import com.ws.util.jsonbeanutil.StorageJsonUtil;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月3日
 */
@Service
public class InStoreServiceImpl implements InStoreService {
	
	@Resource
	private InStoreDao inStoreDao;
	@Resource
	private PurchaseDao purchaseDao;
	@Resource
	private PurchaseDetailDao purchaseDetailDao;
	@Resource
	private InStoreDetailDao inStoreDetailDao;
	@Resource 
	private StorageDao storageDao;
	
	@Transactional
	public ResponseEntity<ResponseResult<String>> insertInStore(JSONObject jsonObject) {
		if(jsonObject!=null&& !jsonObject.equals("")){
			//解析json
			InStore inStore=InStoreJsonUtil.getInStoreBean(jsonObject);
			Purchase purchase=new Purchase();
			purchase.setPurchaseCode(inStore.getPurchaseCode());
			purchase.setInStoreState(inStore.getInStoreState());
			//修改采购单的入库状态
			int updateInStoreStateNum=purchaseDao.updateInStoreState(purchase);
			//解析json得到入库商品详细信息
			List<InStoreDetail> inStoreDetailList=InStoreDetailJsonUtil.getInStoreDetailBean(jsonObject, inStore);
			//解析json得到库存信息
			List<Storage> storageList=StorageJsonUtil.getStorageBean(jsonObject, inStore);
			//入库单插入
			int inStoreNum=inStoreDao.insertInStore(inStore);
			//商品详细信息入库单插入
			int inStoreDetailNum=inStoreDetailDao.insertInStoreDetailList(inStoreDetailList);
			//库存插入
			int storageNum=storageDao.insertStorage(storageList);
			if(inStoreNum>0&&inStoreDetailNum>0&&storageNum>0&&updateInStoreStateNum>0){
					return RespResultGenerator.genOK(null, "新增成功");
			}else{
				return RespResultGenerator.genError(null, "新增失败");
			}
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectNoInStoreList(String storeCode,
		Integer pageRow) {
		try {
			if(storeCode!=null && !storeCode.equals("")){
				Page page=new Page();
				Condition condition=new Condition();
				condition.setStoreCode(storeCode);
				page.setCountAll(inStoreDao.selectAllCount(condition));
				page.setPageRow(pageRow);
				page.setCondition(condition);
				List<Map<String, Object>> NoInStoreList=inStoreDao.selectNoInStoreList(page);
				if(NoInStoreList!=null){
					return RespResultGenerator.genOK(NoInStoreList, "获取成功");
				}
			}
			return RespResultGenerator.genError(null, "参数错误"); 
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误"+e.toString());
		}
		
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> selectYesInStoreList(
		String storeCode,Integer pageRow) {
		if(pageRow==null){
			pageRow=1;
		}
		Page page=new Page();
		Condition condition=new Condition();
		condition.setStoreCode(storeCode);
		page.setCountAll(inStoreDao.selectAllYesCount(condition));
		page.setPageRow(pageRow);
		page.setCondition(condition);
		List<Map<String, Object>> mapList=inStoreDao.selectYesInStoreList(page);
		if(mapList!=null){
			return RespResultGenerator.genOK(mapList, "获取成功");
		}else{
			return RespResultGenerator.genError(null, "获取失败");
		}
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCodeYesInStore(String inStoreCode) {
		if(inStoreCode!=null){
			Map<String, Object> map=inStoreDao.selectByPurchaseCodeYesInStore(inStoreCode);
			if(map!=null){
				return RespResultGenerator.genOK(map, "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败");
			}
		}
		return RespResultGenerator.genError(null, "参数错误");
		
	}
	
	public ResponseEntity<ResponseResult<Map<String, Object>>> selectByPurchaseCodeStorage(String purchaseCode) {
		if(purchaseCode!=null){
			Map<String, Object> map=new HashMap<String,Object>();
			Map<String, Object> purchaseCodeMap=purchaseDao.selectByPurchaseCodeNoInStore(purchaseCode);
			List<Map<String, Object>> list=inStoreDetailDao.selectInStoreNum(purchaseCode);
			List<Map<String, Object>> inStoreDetailList=purchaseDao.selectPurchaseDetail(purchaseCode);
			for (int i = 0; i < inStoreDetailList.size(); i++) {
				if(!list.isEmpty()){
					inStoreDetailList.get(i).put("purchaseNum",(int)inStoreDetailList.get(i).get("purchaseNum")-(int)list.get(i).get("inStoreNum") );
				}
			}
			if(purchaseCodeMap!=null){
				map.put("inStoreCode", DateUtil.inStoreCode());
				map.putAll(purchaseCodeMap);
				map.put("goodsInfos", inStoreDetailList);
				return RespResultGenerator.genOK(map, "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败");
			}
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	

}
