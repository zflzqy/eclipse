<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>pageContext对象</h1>
	<!-- 如果获取的属性页面是关闭的则为空 -->
	获取会话中的属性值：<%=pageContext.getSession().getAttribute("name") %><br>
	<%
		//跳转页面
		//pageContext.forward("login.jsp");
		//包含其他页面或文件
		pageContext.include("nine x nine.jsp");
	%>
</body>
</html>