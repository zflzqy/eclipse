<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name ="",password="";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null&&cookies.length>0){
			for(Cookie c:cookies){
				if(c.getName().equals("name")){
					name = URLDecoder.decode(c.getValue(),"utf-8");
				}
				if(c.getName().equals("password")){
					password = URLDecoder.decode(c.getValue(),"utf-8");
				}
			}
		}
	%>
	<form action="dologin.jsp" name ="login.jsp" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name ="name" value="<%=name %>"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name = "password" value="<%=password %>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name ="iscookie"  checked="checked">三天内记住账号和密码</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="submit" value="登录" ><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>