package com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EpcStyleDao;
import com.dao.MatchDataDao;
import com.dao.TryOnDataDao;
import com.model.MatchData;
import com.model.TryOnData;
import com.service.EpcStyleService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;

/**
 * @author lujun
 * @date 2018年6月21日
 */
@Service
public class EpcStyleServiceImp implements EpcStyleService {
	
	@Resource
	private EpcStyleDao epcStyleDao;
	
	@Resource
	private MatchDataDao matchDataDao;
	
	@Resource 
	private TryOnDataDao tryOnDataDao;
	
	@Transactional
	public ResponseEntity<ResponseResult<Map<String, Object>>> insertByEpc(String epc,String storeCode) {
		try {
			if(epc!=null){
				Map<String, Object> map=epcStyleDao.selectByEpc(epc);
				TryOnData tryOnData=new TryOnData();
				if(map!=null){
					tryOnData.setStoreCode(storeCode);
					tryOnData.setStyle((String) map.get("style"));
					int num=tryOnDataDao.insertTryOnData(tryOnData);
					if(num>0){
						return RespResultGenerator.genOK(epcStyleDao.selectByEpc(epc), "获取成功");
					}else{
						return RespResultGenerator.genError(null, "获取失败");
					}
				}else{
					return RespResultGenerator.genOK(null, "没有该数据");
				}
			}else{
				return RespResultGenerator.genError(null, "epc为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作失败");
		}
	}
	
	@Transactional
	public ResponseEntity<ResponseResult<Map<String, Object>>> insertByMatchStyle(String matchStyle,String style,String storeCode) {
		try {
			if(matchStyle!=null&& style!=null){
				Map<String, Object> epcStyle=epcStyleDao.selectByMatchStyle(matchStyle);
			 	if(epcStyle!=null){
			 		MatchData matchData=new MatchData();
			 		matchData.setMatchStyle(matchStyle);
			 		matchData.setStyle(style);
			 		matchData.setStoreCode(storeCode);
			 		int num=matchDataDao.insertMatchData(matchData);
			 		if(num>0){
			 			return RespResultGenerator.genOK(epcStyle, "获取成功");
			 		}else{
			 			return RespResultGenerator.genError(null, "获取失败");
			 		}
			 	}else{
			 		return RespResultGenerator.genError(null, "没有该数据");
			 	}
			}else{
				return RespResultGenerator.genError(null, "参数为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作失败");
		}
		
	}

}
