package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.MatchDataDao;
import com.model.MatchData;
import com.service.MatchDataService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月26日
 */
@Service
public class MatchDataServiceImpl implements MatchDataService {
	
	@Resource
	private MatchDataDao matchDataDao;
	
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryMatchData(String storeCode, String time) {
		try {
			if(storeCode!=null && !storeCode.equals("") && !time.equals("") && time!=null){
				MatchData matchData=new MatchData();
				matchData.setCreateTime(time);
				matchData.setStoreCode(storeCode);
				List<Map<String, Object>> matchDataList= matchDataDao.selectMatchData(matchData);
				if(matchDataList.size()>0){
					return RespResultGenerator.genOK(matchDataList, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<String>> batchInsertMatchData(HttpServletRequest requ, JSONObject jsonObject) {
		
		try {
			if(jsonObject!=null && !jsonObject.equals("")){
				JSONObject json=JSONObject.fromObject(jsonObject);
				JSONArray array=json.getJSONArray("data");
				List<MatchData> matchDataList=new ArrayList<>();
				for (int i = 0; i < array.size(); i++) {
					String data=array.getString(i);
					MatchData matchData=new MatchData();
					JSONObject object= JSONObject.fromObject(data);
					matchData.setCreateTime(object.getString("createTime"));
					matchData.setEquipment(object.getString("equipment"));
					matchData.setMatchStyle(object.getString("matchStyle"));
					matchData.setStoreCode(object.getString("storeCode"));
					matchData.setStyle(object.getString("style"));
					matchDataList.add(matchData);
				}
				final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Collections.sort(matchDataList,new Comparator<MatchData>(){
					@Override
					public int compare(MatchData o1, MatchData o2) {
						int mark = 1;
						   try {
								Date date0 = sdf.parse(o1.getCreateTime());
								Date date1 = sdf.parse(o2.getCreateTime());
								if(date0.getTime() < date1.getTime()){
								    mark =  -1;
								}
								if(o1.getCreateTime().equals(o2.getCreateTime())){
								    mark =  0;
								}
						   } catch (ParseException e) {
							   e.printStackTrace();
						   }
						   return mark;
					}
				});
				if(matchDataList.size()>0){
					int num=matchDataDao.batchInsertMatchData(matchDataList);
					if(num>0){
						return RespResultGenerator.genOK(null, "增加成功");
					}else{
						return RespResultGenerator.genError(null, "增加失败");
					}
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误"+e.toString());
		}
	}

}
