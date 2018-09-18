package com.util;


/** 
 * 统一请求返回结果model
 * @author lujun
 * @version 2018年6月19日
 */
 
public class ResponseResult<T> {
	 
	private int code;
	 
    private String message;
	 
    private T data;

    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 
    private String errorCode;*/

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<T>();
    }

    

    public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    // 设置错误信息
    public void setErrorInfo(ResponseErrorEnum responseErrorEnum) {
        this.message = responseErrorEnum.getMessage();
    }

	public ResponseResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResponseResult() {
		super();
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
}
