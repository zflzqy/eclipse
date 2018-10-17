package com.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * web.xml按照配置顺序执行过滤器，注解按照类名排序
 * */
@WebFilter(filterName="/FirstFilter",
		urlPatterns="/*",
		dispatcherTypes =DispatcherType.REQUEST
		)
/*
 *   这个/*代表过滤所有
 * */
public class ErrorFilter implements Filter {

    public ErrorFilter() {
    	
    }

	public void destroy() {
		System.out.println("destory");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// pass the request along the filter chain
		System.out.println("doFilter-error");//先执行
		System.out.println(req.getRequestURI());
		System.out.println("异常");//执行这句
		if(!req.getRequestURI().equals("/JavaWebFilter/index.jsp")) {
			req.getRequestDispatcher("fail.jsp").forward(req,res);
		}
		System.out.println("doFilter--error");//执行这句
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init");
	}

}
