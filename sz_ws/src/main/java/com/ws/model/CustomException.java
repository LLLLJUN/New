package com.ws.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lujun
 * @date 2018年7月20日
 */
@Getter
@Setter
public class CustomException extends Exception {
	private String message;
	
	public CustomException(String message){
        this.message=message;
    }
	
	
}
