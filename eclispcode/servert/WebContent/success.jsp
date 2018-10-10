<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功</title>
</head>
<body>
	<%
		String name ="";		
		if(session.getAttribute("name").toString()!=null){
			name = session.getAttribute("name").toString();
		}
	%>
	servlet登录欢迎你:<font color="green"><%=name %> </font>
</body>
</html>