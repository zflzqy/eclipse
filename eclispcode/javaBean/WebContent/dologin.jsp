<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jsp动作元素</title>
</head>
<body>
	<% 	request.setCharacterEncoding("utf-8");%>
	<h1>jsp动作元素使用javaBean</h1>
	<jsp:useBean id="users" class="Bean.user" scope="page"></jsp:useBean>
	
	<!-- 使用*用表单跟javabean所有属性自动匹配属性 -->
	<%-- <jsp:setProperty property="*" name="users"/> --%>
	
	<!-- 表单跟javabean部分属性自动匹配属性,这里的property是表单name赋的值，必须和javaBean名称一致 -->
	<%-- <jsp:setProperty property="name" name="users"/>
	<jsp:setProperty property="password" name="users"/> --%>
	
	<!-- 不使用表单，手动给javabean属性自动匹配属性 -->
	<%-- <jsp:setProperty property="name" name="users" value="赵飞龙"/>
	<jsp:setProperty property="password" name="users" value="123456"/> --%>
	
	<!-- 使用url传参 -->
	<%-- <jsp:setProperty property="name" name="users" param="myname"/>
	<jsp:setProperty property="password" name="users"/>  --%>
	
	<%-- 用户名：<%=users.getName() %><br>
	密码：<%=users.getPassword() %> --%>
	
	<!-- 使用getproperty方式获取 -->
	<jsp:setProperty property="*" name="users"/>
	<%-- 用户名：<jsp:getProperty property="name" name="users"/><br>
	密码：<jsp:getProperty property="password" name="users"/><br>
	<a href="scop.jsp">javaBean作用范围测试</a>
	<%
		request.getRequestDispatcher("scop.jsp").forward(request, response);
	%> --%>
	<jsp:setProperty property="*" name="users"/>
	<jsp:useBean id="dao" class="DAO.dao" scope="page"></jsp:useBean>
	<%
		request.setCharacterEncoding("utf-8");
		String name = "";
		String password = "";
		name = users.getName();
		password = String.valueOf(users.getPassword());
		if(dao.login(users)){
			session.setAttribute("name", name);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			response.sendRedirect("fail.jsp");
		}
	%>
</body>
</html>