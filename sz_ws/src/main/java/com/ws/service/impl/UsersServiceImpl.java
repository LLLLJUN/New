package com.ws.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ws.dao.DutyDao;
import com.ws.dao.UsersDao;
import com.ws.model.Condition;
import com.ws.model.Duty;
import com.ws.model.Page;
import com.ws.model.ResponseResult;
import com.ws.model.Users;
import com.ws.service.UsersService;
import com.ws.util.Md5Util;
import com.ws.util.PermissionNameUtil;
import com.ws.util.RespResultGenerator;
import com.ws.util.cache.RedisCache;

/**
 * @author lujun
 * @date 2018年6月29日
 */
@Service
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersDao usersDao;
	@Resource
	private DutyDao permissionsDao;
	@Resource
	private RequestMappingHandlerMapping rmhm;
	@Resource
	private RedisCache redisCache;

	public ResponseEntity<ResponseResult<Map<String, Object>>> selectLogin(@Param("userName")String userCode,@Param("userPsw")String userPsw,
			HttpServletResponse resp,HttpServletRequest requ,HttpSession session) {
		try {
			if(userCode!=null && userPsw!=null){
				Users users=new Users();
				users.setUserCode(userCode);
				users.setUserPsw(Md5Util.md5(userPsw, userCode));
				Map<String, Object> map=usersDao.selectLogin(users);
				if(map!=null && !map.equals("")){
					session.setAttribute("user", map);
					return RespResultGenerator.genOK(map, "获取成功");
				}else{
					return RespResultGenerator.genError(null, "获取失败");
				}				
			}else{
				return RespResultGenerator.genError(null, "用户名，密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误"+e.toString());
		}
			
		
	}
	
	public Users queryByUserCode(String userCode) {
		Users users=usersDao.selectByUsersCode(userCode);
		if(users!=null){
			//查询数据库中所有的权限
			List<String> permissionList=permissionsDao.selectAllUserPermission();
			//获取controller中所有待requestMapper的标签
			Map<RequestMappingInfo, HandlerMethod> handlerMethods= rmhm.getHandlerMethods();
			Collection<HandlerMethod> methods=handlerMethods.values();
			for (HandlerMethod method : methods) {
				RequiresPermissions anno=method.getMethodAnnotation(RequiresPermissions.class);
				if(anno!=null){
					String userPermission=anno.value()[0];
					if(permissionList.contains(userPermission)){//数据库存在，跳出
	                    continue;
	                }
					Duty permissions=new Duty();
					permissions.setUserPermission(userPermission);
					permissions.setUserDuty(method.getMethodAnnotation(PermissionNameUtil.class).value());
					permissionsDao.insertPermission(permissions);
				}
			}
		}
		return users;
	}

	public ResponseEntity<ResponseResult<String>> addOrUpdateUsers(Users users) {
		if(users!=null){
			int num=0;
			users.setUserPsw(Md5Util.md5(users.getUserPsw(), users.getUserCode()));
			System.out.println(users);
			if(users.getId()>0){
				num=usersDao.updateUsers(users);
				if(num>0){
					return RespResultGenerator.genOK(null, "修改成功");
				}else{
					return RespResultGenerator.genError(null, "修改失败");
				}
			}else{
				num=usersDao.insertUser(users);
				if(num>0){
					return RespResultGenerator.genOK(null, "新增成功");
				}else{
					return RespResultGenerator.genError(null, "新增失败");
				}
			}
			
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<String>> delUsers(String[] userCode) {
		boolean flag=true;
		if(userCode!=null){
			for (String code : userCode) {
				int num=usersDao.deleteUsers(code);
				if(num==0){
					flag=false;
				}
			}
		}
		if(flag){
			return RespResultGenerator.genOK(null, "删除成功");
		}else{
			RespResultGenerator.genError(null, "删除失败");
		}
		return RespResultGenerator.genError(null, "参数错误");
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryUserCodeInfo(String userCode) {
		try {
			if(userCode!=null&&!userCode.equals("")){
				Map<String,Object> map=usersDao.selectByUsersCodeInfo(userCode);
				if(map!=null && !map.equals("")){
					return RespResultGenerator.genOK(map, "获取成功");
				}else{
					return RespResultGenerator.genError(null, "获取失败");
				}
			}
			return RespResultGenerator.genError(null, "参数错误");
		} catch (Exception e) {
		}
		return RespResultGenerator.genError(null, "操作错误");
	}

	public ResponseEntity<ResponseResult<Map<String, Object>>> queryUserList(Condition condition, Integer pageRow,HttpSession session) {
		
		try {
			if(pageRow==null){
				pageRow=1;
			}
			Page page=new Page(); 
			page.setPageRow(pageRow);
			page.setCondition(condition);
			page.setCountAll(usersDao.selectCount(condition));
			List<Map<String, Object>> userList=usersDao.selectUserList(page);
			session.setAttribute("page", page);
			Map<String, Object> json=new HashMap<String,Object>();
			json.put("page", page);
			json.put("userList", userList);
			return RespResultGenerator.genOK(json, "获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
		
	}

}
