package com.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AdvertisingDao;
import com.model.Advertising;
import com.service.AdvertisingService;
import com.util.RespResultGenerator;
import com.util.ResponseResult;

@Service
public class AdvertisingServiceImp implements AdvertisingService {
	
	@Resource
	private AdvertisingDao advertisingDao;

	/**
	 * 单张图片上传，并带参数
	 */
	@Transactional
	public Map<String, Object> updateImg(MultipartFile file, Integer adVersion,Integer id) {
		Map<String,Object>map=new HashMap<String, Object>();
		Advertising a=new Advertising();
		try {
			String fileName=file.getOriginalFilename();//获取图片的名字
			String newName=fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();//截取后缀名
			if(newName.equals("jpg") || newName.equals("jpeg") || newName.equals("png") || newName.equals("gif")){
				String Url="http://www.echitec.com/image/sz_ts_xd/ad_image/"+UUID.randomUUID().toString()+"."+newName;
				a.setAdUrl(Url);
				a.setAdVersion(adVersion);
				a.setId(id);
				int num=advertisingDao.updateImg(a);
				if(num>0){
					file.transferTo(new File("http://www.echitec.com/image/sz_ts_xd/ad_image/"+UUID.randomUUID().toString()+"."+newName));
					map.put("meg", 200);
				}else{
					map.put("meg", 400);
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("messger", 301);
			return map;
		}
	}
	
	/**
	 * 
	 * 多文件上传，并带参数
	 */
	@Transactional
	public Map<String, Object> insertImg(MultipartFile[] file, Integer adVersion) {
		Map<String, Object> json=new HashMap<String, Object>();
		if(file!=null && file.length>0){
			Advertising advertising=new Advertising();
			String oldFileName=null;
			String suffix=null;
			String url=null;
			int num;
			try {
				for (MultipartFile multipartFile : file) {
					oldFileName=multipartFile.getOriginalFilename();// 获取上传文件的名字
					suffix=oldFileName.substring(oldFileName.lastIndexOf(".")+1).toLowerCase();// 截取上传文件的后缀
					if(suffix.equals("jpg") || suffix.equals("jpeg") || suffix.equals("png") || suffix.equals("gif")){
						url="http://www.echitec.com/image/sz_ts_xd/ad_image/"+UUID.randomUUID().toString()+"."+suffix;
						advertising.setAdUrl(url);
						advertising.setAdVersion(adVersion);
						num=advertisingDao.insertImg(advertising);
						if(num>0){
							multipartFile.transferTo(new File("http://www.echitec.com/image/sz_ts_xd/ad_image/"+UUID.randomUUID().toString()+"."+suffix));
							json.put("meg", 200);
						}else{
							json.put("meg", 400);
						}				
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				json.put("meg", 400);
				return json;
			}
		}
		return json;
	}

	public List<Advertising> selectImg(int adVersion) {
		return advertisingDao.selectImg(adVersion);
	}

	public ModelAndView selectAllImg() {
		
		ModelAndView mv=new ModelAndView();
		try {
			List<Advertising> advertisingList=advertisingDao.selectAllImg();
			mv.addObject(advertisingList);
			mv.setViewName("imgList");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("meg", 400);
			return mv;
		}
	}

	public ModelAndView selectById(int id) {
		ModelAndView mv=new ModelAndView();
		try {
			if(id>0){
				Advertising advertising=advertisingDao.selectById(id);
				mv.addObject(advertising);
				mv.setViewName("updateAdvertising");
				return mv;
			}
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("meg", 400);
			return mv;
		}
	}

	public List<Advertising> selectCount() {
		return advertisingDao.selectCount();
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> selectAllUrl(int adVersion) {
		int version=0;
		try {
				System.out.println(adVersion);
				List<Advertising> advertisingList=advertisingDao.selectCount();
				for (Advertising advertising : advertisingList) {
					 version=advertising.getAdVersion();
				}
				if(version>adVersion){
					String url=advertisingDao.selectAllUrl(version);
					Map<String,Object>map=new HashMap<String,Object>(); 
					map.put("url", url);
					map.put("version", version);
					return   RespResultGenerator.genOK(map, "获取成功"); 
				}else{
					return   RespResultGenerator.genError(null, "获取成功");
				}
		} catch (Exception e) {
			 e.printStackTrace();
			 return   RespResultGenerator.genError(null, "操作失败");
		}
	}
}
