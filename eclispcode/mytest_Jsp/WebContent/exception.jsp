<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>exception对象</h1>
	<!-- isErrorPage="true"这个加上才能处理异常 -->
	<% response.setStatus(200); %>
	异常消息：<%=exception.getMessage() %><br>
	异常消息简短<%=exception.toString() %><br>
</body>
</html>