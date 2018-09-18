package com.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/** 
 * 
 * @author lujun
 * @version 2018年6月19日
 */
@Data
@ApiModel(value = "ResponseResult",description = "统一请求返回结果bean")
public class ResponseResult<T> {
	 
	@ApiModelProperty(value = "true:成功、false：失败")
	private int code;
	 
	@ApiModelProperty(value = "返回信息")
    private String message;
	 
	@ApiModelProperty(value = "返回对象")
    private T data;

    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 
    private String errorCode;*/

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<T>();
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



	
	
}
