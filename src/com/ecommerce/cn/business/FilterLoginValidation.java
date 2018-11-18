package com.ecommerce.cn.business;

import java.io.IOException;
import javax.servlet.Filter;
import java.util.Enumeration;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;




public class FilterLoginValidation implements Filter {

    public FilterLoginValidation() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*Enumeration<String> enums = request.getParameterNames();
		while(enums.hasMoreElements()) {
			System.out.println(enums.nextElement());
		}*/

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}