package com.chen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.entity.Customer;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//String str1= request.getRemoteAddr();
		
		Customer user =(Customer) request.getSession().getAttribute("customer");
		String path = request.getServletPath();
		/*
		 * 判断 当用户没有登录的时候 访问的连接不是登录页面和customer.action的
		 * 时候才拦截 因为如果用户本身访问的是登录页面，然后还去过滤的话 就会一直存在也
		 * 死循环
		 */
		if(user==null&&!path.equals("/login.jsp")&&!path.equals("/customer.action")){
			response.sendRedirect("/Exam-12757-20161219-1/login.jsp");
		}else{
			arg2.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
