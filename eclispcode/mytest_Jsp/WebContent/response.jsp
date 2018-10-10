<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*
		*out对象总是比pw后输出，当加入out.flush时强制输出out就会先输出，
		*由于重定向要保存response信息，所以out.flush强制输出缓存信息导致无法保存
		*最终导致报错，response对象先被刷新了
		*/
		//response.setContentType("type=text/html; charset=utf-8");//设置响应的mime类型抛出异常，出现下载
		out.println("<h2>这是out对象发出的</h2>");
		out.print("<br>");
		//out.flush();
		
		PrintWriter pw = response.getWriter();
		pw.println("这是response对象的printwriter的实例对象输出的");
		/*
		*请求重定向是A去b局办事，b说不归他处理让a去c局处理，a自己退出b自己前往c,两次请求，前一次的请求不会保存
		*请求转发是b局在后台请求c处理，页面还是在b，请求的对象会被保存下来，重定向是客户端行为，转发是服务器行为
		*/		
		//response.sendRedirect("login.jsp");//重定向页面，请求重定向
		request.getRequestDispatcher("login.jsp").forward(request, response);//请求转发
		
	%>
</body>
</html>