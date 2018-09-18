package com.ws.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lujun
 * @date 2018年7月17日
 */
public class SimpleCORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;  
		resp.setHeader("Access-Control-Allow-Origin", "*");  
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
		resp.setHeader("Access-Control-Max-Age", "3600");  
		resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");  
        chain.doFilter(request, resp);  
      
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
