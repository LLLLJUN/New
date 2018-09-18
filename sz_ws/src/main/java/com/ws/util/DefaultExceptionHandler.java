package com.ws.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ws.model.CustomException;

/**
 * @author lujun
 * @date 2018年7月16日
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		CustomException  customException=null;
        if (ex instanceof CustomException) {
            customException=(CustomException)ex;
        }else {
            customException=new CustomException("未知错误");
        }
        //错误信息
        String message=customException.getMessage();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");
        return modelAndView;
	}
	

}
