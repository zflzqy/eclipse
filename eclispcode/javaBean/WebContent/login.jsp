<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
	<form action="dologin.jsp?myname=zdffs" name ="login.jsp" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name ="name" value=""></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name = "password" value=""></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="登录" ></td>
			</tr>
		</table>
	</form>
</body>
</html>