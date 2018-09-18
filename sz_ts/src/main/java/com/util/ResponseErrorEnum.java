package com.util;

import java.util.HashMap;
import java.util.Map;


public class ResponseErrorEnum {
 
	private String code;
	 
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

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
