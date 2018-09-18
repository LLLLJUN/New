package com.ws.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lujun
 * @date 2018年7月9日
 */
public class Util {
	/*
	 * 向路径为filepath的文件中写入数据 
	 * @param filepath
	 * @param msg
	 * @return
	 */
	public static boolean writeToTxt(String filepath, String msg){
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			// 创建FileWriter对象，用来写入字符流 
			fw = new FileWriter(filepath, true);
			// 将缓冲对文件的输出
			bw = new BufferedWriter(fw);
			
			bw.write(msg + "\n");// 写入文件 
			bw.newLine();
			bw.flush(); // 刷新该流的缓冲 
			bw.close();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			try {
				bw.close();
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}		
		
	}

}
