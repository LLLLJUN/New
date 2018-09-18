package com.service;



import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Advertising;
import com.util.ResponseResult;
public interface AdvertisingService {
	
	 /**
	  * 批量上传图片功能
	  */
	 Map<String, Object> insertImg(MultipartFile[] file, Integer adVersion);
	
	 /**
	  * 根据id更新图片，及版本号
	  * @param file
	  * @param ad_Version
	  * @param id
	  * @return
	  */
	 Map<String, Object> updateImg(MultipartFile file, Integer adVersion, Integer id);
	 
	 /**
	  * 根据版本号查询图片
	  * @param ad_version
	  * @return
	  */
	 List<Advertising> selectImg(int adVersion);
	 
	 /**
	  * 查询所有图片
	  * 
	  */
	 ModelAndView selectAllImg();
	 
	 /**
	  * 
	  * 根据id查询
	  */
	 ModelAndView selectById(int id);
	 
	 /**
	  * 根据版本号查看是否更新
	  */
	 List<Advertising> selectCount();
	 
	 /**
	  * 查询出所以的图片路径
	  * @return
	  */	 
	 ResponseEntity<ResponseResult<Map<String,Object>>> selectAllUrl(int adVersion);
}
