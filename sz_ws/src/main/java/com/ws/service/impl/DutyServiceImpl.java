package com.ws.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ws.dao.DutyDao;
import com.ws.model.Duty;
import com.ws.service.DutyService;

/**
 * @author lujun
 * @date 2018年7月12日
 */
@Service
public class DutyServiceImpl implements DutyService {
	@Resource
	private DutyDao permissionsDao;

	public List<String> queryAllPermission() {
		return permissionsDao.selectAllUserPermission();
	}

	public int addPermission(Duty permissions) {
		return permissionsDao.insertPermission(permissions);
	}

	public List<String> selectByUserCodePermission(String userCode) {
		return permissionsDao.selectByUserCodePermission(userCode);
	}

}
