package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.ColorDao;
import com.ws.dao.GoodsDao;
import com.ws.dao.SizeDao;
import com.ws.model.Goods;
import com.ws.model.Page;
import com.ws.model.ResponseResult;
import com.ws.service.GoodsService;
import com.ws.util.RespResultGenerator;
import com.ws.util.jsonbeanutil.GoodsJsonUtil;
import com.ws.util.resp.ResponsePageResult;

import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年6月29日
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private SizeDao sizeDao;
	@Resource
	private ColorDao colorDao;
	
	@Transactional
	public ResponseEntity<ResponseResult<Map<String, Object>>> insertGoods(JSONObject jsonObject) {
		if(jsonObject!=null &&!jsonObject.equals("")){
			Goods goods=GoodsJsonUtil.getGoodsBean(jsonObject);
			int count=goodsDao.selectBySku(goods.getSku());
			if(count>0){
				return RespResultGenerator.genError1(null, "商品已存在");
			}else{
				int num=goodsDao.insertGoods(goods);
				if(num>0){
					return RespResultGenerator.genOK(null, "上传成功");
				}else{
					return RespResultGenerator.genError(null, "上传失败");
				}
			}
		}
		return RespResultGenerator.genError(null, "参数错误");	
	}

	@Transactional
	public ResponseEntity<ResponseResult<Map<String, Object>>> deleteGoodsBySku(String sku) {
			if(sku!=null){
				int num=goodsDao.deleteGoodsBySku(sku);
				if(num>0){
					return RespResultGenerator.genOK(null, "删除成功");
				}else{
					return RespResultGenerator.genError(null, "删除失败");
				}
			}
			return RespResultGenerator.genError(null, "参数为空");
	}

	@Transactional
	public ResponseEntity<ResponseResult<Map<String, Object>>> updateGoods(JSONObject jsonObject) {
			if(jsonObject!=null && !jsonObject.equals("")){
				Goods goods=GoodsJsonUtil.getGoodsBean(jsonObject);
				int num=goodsDao.updateGoods(goods);
				if(num>0){
					return RespResultGenerator.genOK(null, "修改成功");
				}else{
					return RespResultGenerator.genError(null, "修改失败");
				}
			}
			return  RespResultGenerator.genError(null, "参数为空");
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> pageGoods(Integer pageRow) {
		try {
			Page page=new Page();
			page.setPageRow(pageRow);
			page.setCountAll(goodsDao.selectAllCount());
			List<Map<String, Object>> list=goodsDao.Goodspage(page);
			return RespResultGenerator.genOK(list, "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
		
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> selectGoodsBySku(String sku) {
			if(sku!=null&&!sku.equals("")){
				Map<String, Object> map=goodsDao.selectGoodsBySku(sku);
				/*Set<Entry<String, Object>> es=map.entrySet();
				Iterator<Entry<String, Object>> it=es.iterator();
				while(it.hasNext()){
					Entry<String, Object> en= it.next();
					en.getKey();
					en.getValue();
				}*/
				map.size();
				String colors=map.get("colors").toString();
				String sizes=map.get("sizes").toString();
				if(sizes!=null && !sizes.equals("")){
					String [] sizeArr=sizes.split("/");
					StringBuffer sbSize=new StringBuffer();
					for (int i = 0; i < sizeArr.length; i++) {
						String size = sizeDao.selectBySize(sizeArr[i]);
						sbSize.append(size).append("/");
					}
					sbSize.deleteCharAt(sbSize.length()-1);
					map.put("sizes", sbSize);
				}
				if(colors!=null && !colors.equals("")){
					String [] colorArr= colors.split("/");
					StringBuffer sbColor=new StringBuffer();
					for (int i = 0; i < colorArr.length; i++) {
						String color = colorDao.selectByColor(colorArr[i]);
						sbColor.append(color).append("/");
					}
					sbColor.deleteCharAt(sbColor.length()-1);
					map.put("colors", sbColor);
				}
				if(map!=null && !map.equals("")){
					return RespResultGenerator.genOK(map, "查询成功");
				}else{
					return RespResultGenerator.genError(null, "没有该商品");
				}
			}
			return RespResultGenerator.genError(null, "参数为空");
	}

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryAllGoods() {
		try {
			List<Map<String, Object>>goodsList= goodsDao.selectAllGoods();
			for (Map<String, Object> map : goodsList) {
				String colors=map.get("colors").toString();
				String sizes=map.get("sizes").toString();
				if(sizes!=null && !sizes.equals("")){
					String [] sizeArr=sizes.split("/");
					StringBuffer sbSize=new StringBuffer();
					
					for (int i = 0; i < sizeArr.length; i++) {
						String size = sizeDao.selectBySize(sizeArr[i]);
						sbSize.append(size).append("/");
					}
					sbSize.deleteCharAt(sbSize.length()-1);
					map.put("sizes", sbSize);
				}
				if(colors!=null && !colors.equals("")){
					String [] colorArr= colors.split("/");
					StringBuffer sbColor=new StringBuffer();
					for (int i = 0; i < colorArr.length; i++) {
						String color = colorDao.selectByColor(colorArr[i]);
						sbColor.append(color).append("/");
					}
					sbColor.deleteCharAt(sbColor.length()-1);
					map.put("colors", sbColor);
				}
				
			}
			if(goodsList!=null&&!goodsList.equals("")){
				return RespResultGenerator.genOK(goodsList, "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
			
	}

	@Override
	public ResponseEntity<ResponsePageResult<Map<String, Object>>> pageGoods1(Integer pageRow) {
		try {
			Page page=new Page();
			page.setPageRow(pageRow);
			page.setCountAll(goodsDao.selectAllCount());
			List<Map<String, Object>> list=goodsDao.Goodspage(page);
			return com.ws.util.resp.RespResultGenerator.genOK(list, null, "获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			return com.ws.util.resp.RespResultGenerator.genError(null, null, "操作错误");
		}
	}

	

}
 