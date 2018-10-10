<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="Bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>javabean四个作用域范围</h1>
	<jsp:useBean id="users" class="Bean.user" scope="page"></jsp:useBean>
	用户名：<jsp:getProperty property="name" name="users"/><br>
	密码：<jsp:getProperty property="password" name="users"/><hr>
	<!-- application作用域范围 -->
	<%-- 用户名：<%=((user)application.getAttribute("users")).getName()  %><br>
	密码：<%=((user)application.getAttribute("users")).getPassword() %><br> --%>
	<!-- session作用范围 -->
	<%-- 用户名：<%=((user)session.getAttribute("users")).getName()  %><br>
	密码：<%=((user)session.getAttribute("users")).getPassword() %><br> --%>
	<!-- request作用域范围，要用请求转发保存request对象 -->
	<%-- 用户名： <%=((user)request.getAttribute("users")).getName() %><br>
	密码：<%=((user)request.getAttribute("users")).getPassword() %><br> --%>
	<!-- page作用域范围，无法访问前边页面提交的数据 -->
	<%
		String name ="";
		String password ="";
		if(pageContext.getAttribute("users")!=null){
			name = ((user)pageContext.getAttribute("users")).getName();
			password =String.valueOf(((user)pageContext.getAttribute("users")).getPassword());
		}
	%>
	用户名：<%=name %><br>
	密码：<%=password %>
</body>
</html>