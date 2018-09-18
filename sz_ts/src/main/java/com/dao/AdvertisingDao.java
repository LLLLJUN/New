package com.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Advertising;

public interface AdvertisingDao {
	
	int insertImg(Advertising advertising);
	
	int updateImg(Advertising advertising);
	
	List<Advertising> selectImg(@Param("adVersion")int adVersion);
	
	List<Advertising> selectAllImg();
	
	Advertising selectById(@Param("id")int id);
	
	List<Advertising> selectCount();
	
	String selectAllUrl(@Param("version")int version);
	
}
