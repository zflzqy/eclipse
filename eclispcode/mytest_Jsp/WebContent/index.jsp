 <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>这是第一个jsp页面</title>
</head>
<body>
	<h1>Hello World</h1>
	<%
	/*
	*这是jsp脚本
	*/
	out.println("Hello World!");
	%>
	<hr><!--这是横线 -->
	<%!
		String name = "zfl";//这是变量要加！
		int sum(int x,int y){//这是函数
			return x+y;
		}
	%>
	hi,<%=name %><!-- 这是表达式加 =号，后边没有分号 -->
	<br>
	sum is <%=sum(3,2) %><!-- 函数运算 -->
	<hr>
	<%
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日");
		String s = sdf.format(new Date());
	%>
	今天的日期是：<%=s %>
</body>
</html>