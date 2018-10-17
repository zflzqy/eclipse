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
 * web.xml��������˳��ִ�й�������ע�ⰴ����������
 * */
@WebFilter(filterName="/FirstFilter",
		urlPatterns="/*")
/*
 *   ���/*�����������
 * */
public class FirstFilter implements Filter {

    public FirstFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// pass the request along the filter chain
		System.out.println("doFilter---first");//��ִ��
		chain.doFilter(req, res);
		System.out.println("doFilter----first");//ִ�����
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

}
