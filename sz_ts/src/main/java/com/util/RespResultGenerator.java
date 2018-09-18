package com.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/** 
 * 统一的RestController结果生成器
 * @author lujun
 * @version 2018年6月18日
 */
public class RespResultGenerator {
 
	   
	   /**
	     * 生成响应成功(带正文)的结果
	     *
	     * @param data    结果正文
	     * @param message 成功提示信息
	     * @return ResponseEntity<ResponseResult<T>>
	     */
	   public static <T> ResponseEntity<ResponseResult<T>> genOK(T data,String message){
				   
		   ResponseResult<T> result = ResponseResult.newInstance();
	       result.setCode(1);
	       result.setData(data);
	       result.setMessage(message); 
	       return new ResponseEntity<ResponseResult<T>>(result, HttpStatus.OK);
	   }
	   
 
	   
	   /**
	     * 生成响应成功(不带正文)的结果
	     * @param data    结果正文
	     * @param message 成功提示信息
	     * @return ResponseEntity<ResponseResult<T>>
	     */
	   @SuppressWarnings("rawtypes")
	   public static ResponseEntity<ResponseResult> genOK(String message){
		   
		   ResponseResult result = ResponseResult.newInstance();
	       result.setCode(1);
	       result.setMessage(message); 
	       return new ResponseEntity<ResponseResult>(result, HttpStatus.OK);
	   }
	   
	   /**
	     * 生成响应失败(带正文)的结果
	     * @param data    结果正文
	     * @param message 失败提示信息
	     * @return ResponseEntity<ResponseResult<T>>
	     */
	   public static <T> ResponseEntity<ResponseResult<T>> genError(T data,String erroMessage){
				   
		   ResponseResult<T> result = ResponseResult.newInstance();
	       result.setCode(0);
	       result.setData(data);
	       result.setMessage(erroMessage); 
	       return new ResponseEntity<ResponseResult<T>>(result, HttpStatus.OK);
	   }
	   
	   /**
	     * 生成响应失败(不带正文)的结果
	     * @param data    结果正文
	     * @param message 成功提示信息
	     * @return ResponseEntity<ResponseResult<T>>
	     */
	   @SuppressWarnings("rawtypes")
	   public static ResponseEntity<ResponseResult> genError(String erroMessage){
		   
		   ResponseResult result = ResponseResult.newInstance();
	       result.setCode(0);
	       result.setMessage(erroMessage); 
	       return new ResponseEntity<ResponseResult>(result, HttpStatus.OK);
	   }
	   
	   /**
	     * 生成响应失败(带errorCode)的结果
	     * @param data    结果正文
	     * @param message 成功提示信息
	     * @return ResponseEntity<ResponseResult<T>>
	     */
	   @SuppressWarnings("rawtypes")
	   public static <T> ResponseEntity<ResponseResult> genError(ResponseErrorEnum responseErrorEnum){
		   
		   ResponseResult result = ResponseResult.newInstance();
	       result.setCode(0);
	       result.setErrorInfo(responseErrorEnum); 
	       return new ResponseEntity<ResponseResult>(result, HttpStatus.OK);
	   }

}
