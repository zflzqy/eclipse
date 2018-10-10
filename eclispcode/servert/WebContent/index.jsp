<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
%>
<body>
	<h1>第一个servert</h1>
	<!-- 相对路径访问 ，/servert/sr前边的/代表服务器根目录，加上则访问不到该页面-->
	
	<a href="servert/sr">doget</a>
	<a href="<%=path%>/servert/sr">绝对路径访问</a><br>	<br><br>
	<a href="servert/path">servlet请求重定向跳转页面</a><br><br><br>
	<a href="servert/path">servlet请求转发跳转页面</a><br><br><br>
	<a href="getInitparam">servlet获取初始化参数</a><br><br><br>
	<form action="servert/sr" method="post">
		<input type="submit" value="dopost">
	</form>
</body>
</html>