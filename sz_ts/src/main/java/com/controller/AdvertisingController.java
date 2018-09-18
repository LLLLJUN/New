package com.controller;
 
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.AdvertisingService;
import com.util.ResponseResult;

import io.swagger.annotations.ApiOperation;



@Controller
public class AdvertisingController {
	
	@Resource
	private AdvertisingService advertisingService;
	
	@RequestMapping(value="insertImg",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertImg(@RequestParam("file")MultipartFile[] file,@RequestParam("adVersion") Integer ad_Version){		
		return advertisingService.insertImg(file,ad_Version); 
	}
	
	/**
	 * 修改图片
	 */
	@RequestMapping(value="updateImg",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateImg(@RequestParam("ad_Url")MultipartFile file,@RequestParam("adVersion") Integer ad_Version,@RequestParam("id") Integer id){
		return advertisingService.updateImg(file, ad_Version,id); 
	}
	
	/**
	 * 
	 * 查看图片列表
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="selectAllImg",method = RequestMethod.GET)
	public ModelAndView selectAllImg(HttpServletResponse resp){
		return advertisingService.selectAllImg();
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectById" ,method=RequestMethod.GET)
	public ModelAndView selectById(int id){
		
		return advertisingService.selectById(id);
		
	}
	/**
	 * 对接接口
	 */
	@ApiOperation(value="试一屏图片更新接口")
	@RequestMapping(value="updateImgByVersion",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String,Object>>> updateImgByVersion(@RequestParam("adVersion")Integer adVersion){
		return advertisingService.selectAllUrl(adVersion);
	}
	
	@RequestMapping(value="bese/image", method= RequestMethod.GET)
	@ResponseBody
	public ModelAndView urlset(HttpServletRequest requst,HttpServletResponse response){
		response.setContentType("txt/html;Charset=UTF-8");
		return new ModelAndView("imgList");
	};
}
