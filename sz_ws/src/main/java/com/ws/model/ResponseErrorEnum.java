package com.ws.model;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "ResponseErrorEnum",description = "统一错误码bean")
public class ResponseErrorEnum {
 
	@ApiModelProperty(value = "错误码")
	private String code;
	 
	@ApiModelProperty(value = "错误信息")
    private String message;
    
    private ResponseErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 序列化enum
    private Map<String, Object> serialize() {
        Map<String, Object> valueMap = new HashMap<String, Object>(2);
        valueMap.put("code", this.code);
        valueMap.put("message", this.message);
        return valueMap;
    }

    
}
