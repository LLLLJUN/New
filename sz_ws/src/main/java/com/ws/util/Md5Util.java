package com.ws.util;

import org.apache.shiro.crypto.hash.Md5Hash;


/**
 * @author lujun
 * @date 2018年7月13日
 */
public class Md5Util {
	public static String md5(String userPsw,String userCode){
		 Md5Hash hash = new Md5Hash(userPsw, userCode, 3);
		 return hash.toString();
	}
}
