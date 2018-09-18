package com.ws.util;

import java.text.SimpleDateFormat;

/**
 * @author lujun
 * @date 2018年7月2日
 */
public class DateUtil {
	
	/**
	 *
	 *生产编码
	 *@param codeType（编码类型）
	 *@return
	 */
	public static String createCode(String codeType){
		if(!codeType.equals("") && codeType!=null){
			int randomThreeNumber=(int)((Math.random()*9+1)*100);
			int randomfourNumber=(int)((Math.random()*9+1)*1000);
			int randomTwoNum=(int)((Math.random()*9+1)*10);
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			SimpleDateFormat sdfAll = new SimpleDateFormat("yyMMddhhmmssSSS");
			StringBuffer sb=new StringBuffer();
			String string=null;
			if(codeType.equals("supplierCode")){
				sb.append("S"+randomThreeNumber);
			}
			if(codeType.equals("purchaseCode")){
				sb.append("P"+sdf.format(new java.util.Date())+randomThreeNumber);
			}
			if(codeType.equals("checkBillCode")){
				sb.append("C"+sdf.format(new java.util.Date())+randomThreeNumber);
			}
			if(codeType.equals("inStoreCode")){
				sb.append("I"+sdfAll.format(new java.util.Date()));
			}
			if(codeType.equals("transferCode")){
				sb.append("T"+sdf.format(new java.util.Date())+randomThreeNumber);
			}
			if(codeType.equals("outStoreCode")){
				sb.append("O"+sdf.format(new java.util.Date())+randomThreeNumber);
			}
			if(codeType.equals("colorCode")){
				sb.append("c"+randomTwoNum);
			}
			if(codeType.equals("sizeCode")){
				sb.append("s"+randomTwoNum);
			}
			if(codeType.equals("saleBillNo")){
				sb.append("S"+sdfAll.format(new java.util.Date())+randomfourNumber);
			}
			string=sb.toString();
			return string;
		}
		return "参数问题";	
		
	}
	
	
	public static String supplierCode(){
		int x=(int)((Math.random()*9+1)*100);
	       StringBuffer sb=new StringBuffer();
	       sb.append("S");
	       sb.append(x);
	       String string=sb.toString();
	       return string;
	}
	
	public static String purchaseCode(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        int x=(int)((Math.random()*9+1)*100);
        StringBuffer sb=new StringBuffer();
        sb.append("P"+sdf.format(new java.util.Date())+x);
        String string=sb.toString();
		return string;
	}
	
	public static String checkBillCode(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        int x=(int)((Math.random()*9+1)*100);
        StringBuffer sb=new StringBuffer();
        sb.append("C"+sdf.format(new java.util.Date())+x);
        String string=sb.toString();
		return string;
	}
	
	public static String inStoreCode(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSSS");
		StringBuffer sb=new StringBuffer();
		sb.append("I"+sdf.format(new java.util.Date()));
		String string =sb.toString();
		return string;
				
	}
	
	public static String transferCode(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		int x=(int)((Math.random()*9+1)*100);
		StringBuffer sb=new StringBuffer();
		sb.append("T"+sdf.format(new java.util.Date())+x);
		String string =sb.toString();
		return string;
				
	}
	
	public static String outStoreCode(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        int x=(int)((Math.random()*9+1)*100);
        StringBuffer sb=new StringBuffer();
        sb.append("O"+sdf.format(new java.util.Date())+x);
        String string=sb.toString();
		return string;
				
	}
}
