<%@page import="sun.security.util.Password"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="response.jsp" name ="login.jsp" method="post">
		<table>
		<tr>
			<td>
				<td>用户名:</td>
				<td><input type="text" name = "name"></td>
			</td>
		<tr>
			<td>
				<td>密码：</td>
				<td><input type="password" name = "password" ></td>
			</td>
		</tr>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="LOGIN"></td>
		</tr>
		</table>
	</form>
</body>
</html>