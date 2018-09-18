package com.dao;

import java.util.List;
import java.util.Map;

/**
 * @author lujun
 * @date 2018年7月26日
 */
public interface ImgManageDao {
	//查询离线图片更新
	List<Map<String, Object>> selectImgManage(int version);
}
