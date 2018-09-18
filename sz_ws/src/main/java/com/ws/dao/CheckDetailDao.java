package com.ws.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ws.model.CheckDetail;

/**
 * @author lujun
 * @date 2018年7月5日
 */
public interface CheckDetailDao {
	
	/**
	 *
	 *增加盘点单商品信息
	 *@param checkDetailList
	 *@return
	 */
	int insertCheckDetailList(@Param("checkDetailList")List<CheckDetail> checkDetailList);
	
	/**
	 *
	 *盘点完成信息上传
	 *@param checkDetailList
	 *@return
	 */
	int updateCheck(@Param("checkDetailList")List<CheckDetail> checkDetailList);
	

}
