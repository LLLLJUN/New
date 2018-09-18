package test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @author lujun
 * @date 2018年7月6日
 */
public class Test {
	public static void main(String[] args) {
		String s="a";
		List<String> stringList=new ArrayList<String>();
		stringList.add(s);
		System.out.println(JSON.toJSONString(s));
		System.out.println(4>>2);
	}
	
	
}
