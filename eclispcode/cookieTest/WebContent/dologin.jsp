<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jsp动作元素</title>
</head>
<body>
<h1>查看用户信息</h1>
<a href="user.jsp">查看用户信息</a>
	<% 
		request.setCharacterEncoding("utf-8");
		String name ="",password ="";
		Cookie[] cookies = request.getCookies();
		//判断用户是否登录
		String[] iscookie = request.getParameterValues("iscookie");
		if(iscookie!=null&&iscookie.length>0)
		{
			//设置cookie编码，防止中文乱码
			name = URLEncoder.encode(request.getParameter("name"),"utf-8");
			password = URLEncoder.encode(request.getParameter("password"),"utf-8");
			Cookie nameCookie = new Cookie("name",name);
			Cookie passwordCookie = new Cookie("password",password);
			//设置coolie的生存期限为3天
			nameCookie.setMaxAge(259200);
			passwordCookie.setMaxAge(259200);
			//添加cookie
			response.addCookie(nameCookie);
			response.addCookie(passwordCookie);
		}else{
			if(cookies!=null&&cookies.length>0)
			{
				for(Cookie c:cookies)
				{
					if(c.getName().equals("name")||c.getName().equals("password"))
					{
						//如果用户不勾选则清除记录的信息,重新保存
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
		}
	%>
</body>
</html>