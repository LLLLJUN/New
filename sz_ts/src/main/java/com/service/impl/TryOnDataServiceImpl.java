package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.MatchDataDao;
import com.dao.TryOnDataDao;
import com.model.MatchData;
import com.model.TryOnData;
import com.service.TryOnDataService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月26日
 */
@Service
public class TryOnDataServiceImpl implements TryOnDataService {
	
	@Resource
	private TryOnDataDao tryOnDataDao;
	@Resource
	private MatchDataDao matchDataDao;
	
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryTryOnData(String storeCode, String time) {
		try {
			if(storeCode!=null && !storeCode.equals("") && !time.equals("") && time!=null){
				TryOnData tryOnData=new TryOnData();
				tryOnData.setCreateTime(time);
				tryOnData.setStoreCode(storeCode);
				List<Map<String, Object>> tryOnDataList= tryOnDataDao.selectData(tryOnData);
				if(tryOnDataList.size()>0){
					return RespResultGenerator.genOK(tryOnDataList, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryToTalStoreTryOnData(String time,HttpServletRequest requ,HttpServletResponse resp) {
		try {
			if(time!=null&&!time.equals("")){
				Map<String, Object> json =new HashMap<>();
				TryOnData tryOnData=new TryOnData();
				tryOnData.setCreateTime(time);
				List<Map<String, Object>> totalTryOnData=tryOnDataDao.selectTryOnData(tryOnData);
				MatchData matchData=new MatchData();
				matchData.setCreateTime(time);
				List<Map<String, Object>> totalMatchData=matchDataDao.selectTotalStoreMatchData(matchData);
				if(totalTryOnData!=null && !totalTryOnData.equals("")&&totalMatchData!=null &&!totalMatchData.equals("")){
					json.put("tryOnData", totalTryOnData);
					json.put("matchData", totalMatchData);
					return RespResultGenerator.genOK(json, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryByStoreCodeAndTimeTryOnDataAndMatchData(String time,
			String storeCode,HttpServletRequest requ) {
		try {
			if(storeCode!=null && !storeCode.equals("")&&storeCode!=null&&!storeCode.equals("")){
				Map<String, Object> json=new HashMap<>();
				TryOnData tryOnData=new TryOnData();
				tryOnData.setCreateTime(time);
				tryOnData.setStoreCode(storeCode);
				List<Map<String, Object>> totalTryOnData=tryOnDataDao.selectByStoreCodeTotalTruOnData(tryOnData);
				MatchData matchData=new MatchData();
				matchData.setCreateTime(time);
				matchData.setStoreCode(storeCode);
				List<Map<String, Object>> tatalMatchData= matchDataDao.selectByStoreCodeTotalMatchData(matchData);
				if(totalTryOnData!=null && tatalMatchData!=null){
					json.put("tryOnData", totalTryOnData);
					json.put("matchData", tatalMatchData);
					return RespResultGenerator.genOK(json, "获取成功");
				}
				return RespResultGenerator.genError(null, "获取失败");
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
		
	}

	public ResponseEntity<ResponseResult<String>> batchInsertTryOnData(JSONObject jsonObject, HttpServletRequest requ) {
		try {
			if(jsonObject!=null && !jsonObject.equals("")){
				JSONObject json=JSONObject.fromObject(jsonObject);
				JSONArray array= json.getJSONArray("data");
				List<TryOnData> tryOnDataList= new ArrayList<>();
				for (int i = 0; i < array.size(); i++) {
					TryOnData tryOnData=new TryOnData();
					String data=array.getString(i);
					JSONObject object= JSONObject.fromObject(data);
					tryOnData.setCreateTime(object.getString("createTime"));
					tryOnData.setEquipment(object.getString("equipment"));
					tryOnData.setStoreCode(object.getString("storeCode"));
					tryOnData.setStyle(object.getString("style"));
					tryOnDataList.add(tryOnData);
				}
				final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Collections.sort(tryOnDataList,new Comparator<TryOnData>(){
					@Override
					public int compare(TryOnData o1, TryOnData o2) {
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
				if(tryOnDataList.size()>0){
					int num=tryOnDataDao.batchInsertTryOnDataList(tryOnDataList);
					if(num>0){
						return RespResultGenerator.genOK(null, "增加成功");
					}
					return RespResultGenerator.genError(null, "增加失败");
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误"+e.toString());
		}
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryByStoreCodeAndTimeGetData(String time,
			String storeCode, HttpServletRequest requ) {
		try {
			if(time!=null && !time.equals("")){
				List<Map<String , Object>> tryOnDataList=new ArrayList<>();
				Map<String, Object> json=new HashMap<>();
				Map<String, Object> tryOnTrend= new HashMap<>();
				TryOnData tryOnDataEntity=new TryOnData();
				tryOnDataEntity.setCreateTime(time);
				if(storeCode!=null){
					tryOnDataEntity.setStoreCode(storeCode);
				}
				//获得试穿/搭配最多款式和最少款式
				List<String> MostStyleAndLeastStyle=tryOnDataDao.selectByTimeAndStoreCodeGettryOnMostStyleAndTryOnLeastStyleData(tryOnDataEntity);
				if(time.equals("day")){
					//获得趋势数据
					json=tryOnDataDao.selectByStoreCodeAndTimeGetDataDay(tryOnDataEntity);
					
				}
				else if(time.equals("week")){
					//获得趋势数据
					tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataWeek(tryOnDataEntity);
					for (Map<String, Object> tryOnData : tryOnDataList) {
						String days=(String) tryOnData.get("weeks");
						json.put(days, tryOnData.get("count"));
					}
				}
				else if(time.equals("month")){
					String [] arr={"第一周","第二周","第三周","第四周"};
					tryOnDataList=tryOnDataDao.selectByTimeGetTotalStoreTryOnDataMonth(tryOnDataEntity);
					for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object> tryOnData= tryOnDataList.get(i);
						json.put(arr[i], tryOnData.get("count"));
					}
				}
				
				else if(time.equals("quarter")){
					String [] arr={"第一月","第二月","第三月"};
					tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataQuarter(tryOnDataEntity);
					for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object> tryOnData=tryOnDataList.get(i);
						json.put(arr[i],tryOnData.get("count"));
					}
					
				}
				else if(time.equals("year")){
					String [] arr={"第一季","第二季","第三季","第四季"};
					tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataYear(tryOnDataEntity);
					for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object> tryOnData=tryOnDataList.get(i);
						json.put(arr[i],tryOnData.get("count"));
					}
				}
				
				if(MostStyleAndLeastStyle.size()==6){
					tryOnTrend.put("tryOnLeastStyle", MostStyleAndLeastStyle.get(0));
					tryOnTrend.put("tryOnMostStyle", MostStyleAndLeastStyle.get(1));
					tryOnTrend.put("matchLeastStyle", MostStyleAndLeastStyle.get(2));
					tryOnTrend.put("matchMostStyle", MostStyleAndLeastStyle.get(3));
					tryOnTrend.put("matchTotalNum", MostStyleAndLeastStyle.get(4));
					tryOnTrend.put("tryOnTotalNum", MostStyleAndLeastStyle.get(5));
				}
				tryOnTrend.put("tryOnTrend", json);
				return RespResultGenerator.genOK(tryOnTrend, "获取成功");
			}else{
				return RespResultGenerator.genError(null, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryByTimeGetTotalStoreTryOnData(String time,
			HttpServletRequest requ) {
		try {
			if(time!=null &&!time.equals("")){
				Map<String, Object> totalData=new HashMap<>();
				List<Map<String, Object>> tryOnDataList=new ArrayList<>();
				Map<String, Object> json=new LinkedHashMap<>(); 
				List<Map<String, Object>> detailDataList=new ArrayList<>();
				TryOnData tryOnDataEntity=new TryOnData();
				List<Map<String, Object>> detailData=new ArrayList<>(); 
				tryOnDataEntity.setCreateTime(time);
				//获得当天的试穿数据
				if(time.equals("day")){
					json=tryOnDataDao.selectByStoreCodeAndTimeGetDataDay(tryOnDataEntity);
					detailDataList=tryOnDataDao.selectByTimeGetTotalStoreTryOnDataGroupByStoreCodeDay();
					for (Map<String, Object> Data : detailDataList) {
						Map<String, Object> data=new LinkedHashMap<>();
						Map<String, Object> tryOnDataArr=new HashMap<>();
						Map<String, Object> storeNameMap=new HashMap<>();
						String storeName=(String) Data.get("storeName");
						storeNameMap.put("storeName", storeName);
						data.put("10", (String) Data.get("10").toString());
						data.put("12", (String)Data.get("12").toString());
						data.put("14", (String) Data.get("14").toString());
						data.put("16", (String)Data.get("16").toString());
						data.put("18", (String) Data.get("18").toString());
						data.put("20", (String)Data.get("20").toString());
						data.put("22", (String) Data.get("22").toString());
						data.put("24", (String)Data.get("24").toString());
						tryOnDataArr.put("data", data);
						tryOnDataArr.putAll(storeNameMap);
						detailData.add(tryOnDataArr);
					}
					totalData.put("detailData", detailData);
					totalData.put("totalData", json);
					return RespResultGenerator.genOK(totalData, "获取成功");
				}
				else if(time.equals("week")){
					tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataWeek(tryOnDataEntity);
					List<Map<String, Object>> storeCodeAndStoreNameList=tryOnDataDao.selectByTimeTotalStoreCode(tryOnDataEntity);
					for (Map<String, Object> storeCodeAndStoreName : storeCodeAndStoreNameList) {
						tryOnDataEntity.setStoreCode(storeCodeAndStoreName.get("storeCode").toString().trim());
						List<Map<String, Object>> week= tryOnDataDao.selectByStoreCodeAndTimeGetDataWeek(tryOnDataEntity);
						Map<String, Object> tryOnDataArr=new HashMap<>();
						Map<String, Object> storeNameMap=new HashMap<>();
						if(storeCodeAndStoreName.get("storeName").toString()==null&&storeCodeAndStoreName.get("storeName").toString().equals("")){
							storeNameMap.put("storeName", null);
						}else{
							storeNameMap.put("storeName", storeCodeAndStoreName.get("storeName").toString());
						}
						Map<String, Object> data=new LinkedHashMap<>();
						for (Map<String, Object> map : week) {
							data.put(map.get("weeks").toString(), map.get("count"));
						}
						tryOnDataArr.put("data", data);
						tryOnDataArr.putAll(storeNameMap);
						detailData.add(tryOnDataArr);
					}	
					totalData=new HashMap<>();
					Map<String, Object> weeks=new LinkedHashMap<>();
					for (Map<String, Object> tryOnData : tryOnDataList) {
						weeks.put((String) tryOnData.get("weeks"), tryOnData.get("count").toString());
						totalData.put("totalData", weeks);
					}
					totalData.put("detailData", detailData);
					return RespResultGenerator.genOK(totalData, "获取成功");
				}
				else if(time.equals("month")){
					String [] arr={"第一周","第二周","第三周","第四周"};
					tryOnDataList=tryOnDataDao.selectByTimeGetTotalStoreTryOnDataMonth(tryOnDataEntity);
					List<Map<String, Object>> storeCodeAndStoreNameList=tryOnDataDao.selectByTimeTotalStoreCode(tryOnDataEntity);
					for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object>	tryOnData=tryOnDataList.get(i);
						json.put(arr[i], tryOnData.get("count"));
					}
					totalData.put("totalData", json);
					for (Map<String, Object> storeCodeAndStoreName : storeCodeAndStoreNameList) {
						tryOnDataEntity.setStoreCode(storeCodeAndStoreName.get("storeCode").toString().trim());
						tryOnDataList=tryOnDataDao.selectByTimeGetTotalStoreTryOnDataMonth(tryOnDataEntity);
						Map<String, Object> data=new LinkedHashMap<>();
						Map<String, Object> storeNameMap=new HashMap<>();
						Map<String, Object> tryOnDataArr=new HashMap<>();
						if(storeCodeAndStoreName.get("storeName").toString()==null&&storeCodeAndStoreName.get("storeName").toString().equals("")){
							storeNameMap.put("storeName", null);
						}else{
							storeNameMap.put("storeName", storeCodeAndStoreName.get("storeName").toString());
						}
						for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object> tryOnData=tryOnDataList.get(i);
						data.put(arr[i], tryOnData.get("count"));
						}
						tryOnDataArr.putAll(storeNameMap);
						tryOnDataArr.put("data", data);
						detailData.add(tryOnDataArr);
					}
					totalData.put("detailData", detailData);
					return RespResultGenerator.genOK(totalData, "获取成功");
				}
				else if(time.equals("quarter")){
					String [] arr={"第一月","第二月","第三月"};
					tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataQuarter(tryOnDataEntity);
					List<Map<String, Object>> storeCodeAndStoreNameList=tryOnDataDao.selectByTimeTotalStoreCode(tryOnDataEntity);
					for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object> tryOnData=tryOnDataList.get(i);
						json.put(arr[i],tryOnData.get("count"));
					}
					totalData.put("totalData", json);
					for (Map<String, Object> storeCodeAndStoreName : storeCodeAndStoreNameList) {
						tryOnDataEntity.setStoreCode(storeCodeAndStoreName.get("storeCode").toString().trim());
						tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataQuarter(tryOnDataEntity);
						Map<String, Object> data=new LinkedHashMap<>();
						Map<String, Object> storeNameMap=new HashMap<>();
						Map<String, Object> tryOnDataArr=new HashMap<>();
						if(storeCodeAndStoreName.get("storeName").toString()==null&&storeCodeAndStoreName.get("storeName").toString().equals("")){
							storeNameMap.put("storeName", null);
						}else{
							storeNameMap.put("storeName", storeCodeAndStoreName.get("storeName").toString());
						}						
						for (int i = 0; i < tryOnDataList.size(); i++) {
							Map<String, Object> tryOnData=tryOnDataList.get(i);
							data.put(arr[i], tryOnData.get("count"));
						}
						tryOnDataArr.putAll(storeNameMap);
						tryOnDataArr.put("data", data);
						detailData.add(tryOnDataArr);
					}
					totalData.put("detailData", detailData);
					return RespResultGenerator.genOK(totalData, "获取成功");
				}
				else if(time.equals("year")){
					String [] arr={"第一季","第二季","第三季","第四季"};
					tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataYear(tryOnDataEntity);
					List<Map<String, Object>> storeCodeAndStoreNameList=tryOnDataDao.selectByTimeTotalStoreCode(tryOnDataEntity);
					for (int i = 0; i < tryOnDataList.size(); i++) {
						Map<String, Object> tryOnData=tryOnDataList.get(i);
						json.put(arr[i],tryOnData.get("count"));
					}
					totalData.put("totalData", json);
					for (Map<String, Object> storeCodeAndStoreName : storeCodeAndStoreNameList) {
						tryOnDataEntity.setStoreCode(storeCodeAndStoreName.get("storeCode").toString().trim());
						tryOnDataList=tryOnDataDao.selectByStoreCodeAndTimeGetDataYear(tryOnDataEntity);
						Map<String, Object> data=new LinkedHashMap<>();
						Map<String, Object> storeNameMap=new HashMap<>();
						Map<String, Object> tryOnDataArr=new HashMap<>();
						if(storeCodeAndStoreName.get("storeName").toString()==null&&storeCodeAndStoreName.get("storeName").toString().equals("")){
							storeNameMap.put("storeName", null);
						}else{
							storeNameMap.put("storeName", storeCodeAndStoreName.get("storeName").toString());
						}						
						for (int i = 0; i < tryOnDataList.size(); i++) {
							Map<String, Object> tryOnData=tryOnDataList.get(i);
							data.put(arr[i], tryOnData.get("count"));
						}
						tryOnDataArr.putAll(storeNameMap);
						tryOnDataArr.put("data", data);
						detailData.add(tryOnDataArr);
					}
					totalData.put("detailData", detailData);
					return RespResultGenerator.genOK(totalData, "获取成功");
				}else{
					return RespResultGenerator.genOK(null, "参数错误");
				}
			}else{
				return RespResultGenerator.genError(null, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}

}
