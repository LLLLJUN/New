package com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Stores;
import com.service.StoresService;
import com.util.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 
 * @date 2018年7月26日
 */
@Controller
@Api(value="门店接口")
public class StoresController {
	
	@Resource
	private StoresService storesService;
	
	@RequestMapping(value="queryStore",method=RequestMethod.GET)
	@ApiOperation(value="获取门店信息接口")
	@ResponseBody
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryStore(@RequestParam("storeCode")String storeCode,
			HttpServletRequest requ){
		return storesService.queryStores(storeCode);
	}
	
	@RequestMapping(value="increaseStore",method=RequestMethod.POST)
	@ApiOperation(value="增加门店信息接口")
	@ResponseBody
	public ResponseEntity<ResponseResult<String>> increaseStore(Stores store,HttpServletRequest requ,HttpServletResponse resp){
		return storesService.increaseStore(store);
	}
	
	@RequestMapping(value="pageQueryStore",method=RequestMethod.GET)
	@ApiOperation(value="分页获取门店信息接口")
	@ResponseBody
	public ResponseEntity<ResponseResult<Map<String, Object>>> pageQueryStore( String storeCode, String storeArea,Integer pageRow,
			HttpSession session,HttpServletRequest requ){
		return storesService.pageQueryStore(storeCode,storeArea, pageRow);
	}
	
	@RequestMapping(value="deleteStore",method=RequestMethod.GET)
	@ApiOperation(value="删除门店信息接口")
	@ResponseBody
	public ResponseEntity<ResponseResult<String>> deleteStore(@RequestParam("storeCode")String storeCode,HttpServletRequest requ,HttpServletResponse resp){
		 return storesService.deleteStore(storeCode);
	}
	
	@RequestMapping(value="updateStores",method=RequestMethod.POST)
	@ApiOperation(value="修改门店信息接口")
	@ResponseBody
	public ResponseEntity<ResponseResult<String>> updateStores(Stores stores,HttpServletRequest requ,HttpServletResponse resp){
		return storesService.updateStore(stores);
	}
	
	@RequestMapping(value="queryStoreCodeAndStoreName",method=RequestMethod.GET)
	@ApiOperation(value="获取全部门店信息接口")
	@ResponseBody
	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> queryStoreCodeAndStoreName(
			HttpServletRequest requ){
		return storesService.queryStoreCodeAndStoreName();
	}
	
}
