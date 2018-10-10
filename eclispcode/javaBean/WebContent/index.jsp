<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="Bean.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h1>普通方式使用javabean</h1>
	<%
		user users = new user();
		users.setName("赵飞龙");
		users.setPassword(12312312);
	%>
	用户名：<%=users.getName() %><br>
	密码：<%=users.getPassword() %> --%>
	<h1>使用jsp动作元素</h1>
	<jsp:useBean id="users" class="Bean.user" scope="page"></jsp:useBean><!-- 实例化 -->
	用户名：<%=users.getName() %><br>
	密码：<%=users.getPassword() %>
</body>
</html>