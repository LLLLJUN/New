package com.ws.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ws.dao.RoleDao;
import com.ws.model.ResponseResult;
import com.ws.service.RoleService;
import com.ws.util.RespResultGenerator;

/**
 * @author lujun
 * @date 2018年7月12日
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Resource
    private RoleDao roleDao;

    public List<String> selectAllRole() {
        return roleDao.selectAllRole();
    }

    public List<String> selectByUserCodeRole(String userCode) {
        return roleDao.selectByUserCodeRole(userCode);
    }

	public ResponseEntity<ResponseResult<List<Map<String, Object>>>> seleceAllRoleInfo() {
		try {
			List<Map<String, Object>> map=roleDao.selectAllRoleInfo();
			if(map!=null && !map.equals("")){
				return RespResultGenerator.genOK(map, "获取成功");
			}else{
				return RespResultGenerator.genError(null, "获取失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespResultGenerator.genError(null, "操作错误");
		}
	}
}
