<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session对象</h1>
	<!-- 只要有页面存在即为同一个会话(同一浏览器) 
		session销毁方式
		1、session.invalidate()
		2、会话超时
		3、服务器重启，默认的Tomcat是支持Session持久化的在、conf/contetx.xml文件中		
	-->
	<%	long s =session.getCreationTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date date = new Date(s);
		session.setAttribute("name", "赵飞龙");
		session.setAttribute("age", 22);
		//session.setMaxInactiveInterval(10);//设置本次会话存活时间最大为10秒鈡，10秒后将会有新的会话，或者在web.xml中设置
		
	%>
	<!-- 跳转可保存姓名年龄（同一会话），直到用户关闭本次会话所有页面，本次会话结束 -->
	创建时间：<%=sdf.format(date) %><br>
	sessionID:<%=session.getId() %><br>
	获得名字和年龄：<%=session.getAttribute("name") %><%=session.getAttribute("age") %><br>
	<a href="login.jsp" target="_blank">以新开页面方式跳转到login</a><br>
	<% //session.invalidate();//销毁会话    %>
</body>
</html>