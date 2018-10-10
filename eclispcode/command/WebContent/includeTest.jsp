<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>include指令用法</h1><hr>
	<%@ include file="date.jsp" %><hr>
	<h1>include动作用法</h2>
	<!-- include动作用法,page代表包含的内容,flush代表是否从缓冲区读取，true代表是 -->
	<jsp:include page="date.jsp" flush="false"></jsp:include>
		<!-- 
		include指令与include动作的比较

                        include指令                                              			  jsp:include动作        

				语法格式：<%@include file="yemian "%>         		 <jsp:include page="...">

				发生作用的时间：页面转换的期间                           				请求期间

				包含的内容：文件的实际内容(包含源码)     					 页面的输出（引用输出结果）

				转换的servlet:主页面和包含页面的转换为一个servlet   		 主页面和包含页面转换为独立的servlet

				编译时间：较慢-资源必须被解析                                  				 较快

				执行时间：稍快                                                          				较慢---每次资源必须被解析
				动作的include指令包含的页面类会解析成独立的类
	 -->
	 <!-- forward动作指令跟request.getRequestDispatcher("login.jsp").forward(request, response);
	 		的效果是一致的	  -->
		<%-- 	 <jsp:forward page="login.jsp"></jsp:forward> --%>

		<!-- param跟forward一同使用，既可以传递一个没有的参数，也可以修改已有的参数 -->
		<%-- <jsp:param value="123456@qq.com" name="email"/>
		<jsp:param value="654321" name="password"/> --%>
 </body>
</html>