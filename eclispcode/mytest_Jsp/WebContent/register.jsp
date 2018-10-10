<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册信息</h1>
	<form action="request.jsp" name="register" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>编号：</td>
				<td><input type="checkbox" name="number" value="第一个">one
					<input type="checkbox" name="number" value="第二个">two 
					<input type="checkbox" name="number" value="第三个">three
					<input type="checkbox" name="number" value="第四个">four
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
	<a href="request.jsp?username=赵飞龙">url传参</a><!-- 通过修改tomcat的server.xml文件解决中文乱码 -->
</body>
</html>