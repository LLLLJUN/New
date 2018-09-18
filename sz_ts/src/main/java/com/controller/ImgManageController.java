package com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.ImgManageService;
import com.util.ResponseResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author lujun
 * @date 2018年7月26日
 */
@Controller
public class ImgManageController {
	
	@Resource
	private ImgManageService imgManageService;
	
	
	@RequestMapping(value="queryImgManage",method=RequestMethod.GET)
	@ApiOperation(value="离线图片更新")
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryImgManage(@RequestParam("imgVersion")int imgVersion){
		return imgManageService.queryImgManage(imgVersion);
	}
}
