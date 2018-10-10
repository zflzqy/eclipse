<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");//处理中文乱码无法解决url传参的中文乱码  
	request.setAttribute("password", "赵飞龙啊啊！！！！");
	%>
	<h1>获取并处理注册信息</h1>
	获取的用户名：<%=request.getParameter("username") %>
	获取的编号：<%
				if(request.getParameterValues("number")!=null){
					String[] s = request.getParameterValues("number");
					for(int i=0;i<s.length;i++){
						out.println(s[i]+"&nbsp;&nbsp");
					}
				}
			%><br>
         密码：<%=request.getAttribute("password") %><br> 
         请求体的MIME类型:<%=request.getContentType() %><br>
         协议类型及版本号:  <%=request.getProtocol() %><br>
         服务器主机名 :<%=request.getServerName() %><br>
         服务器端口号：<%=request.getServerPort() %><BR>
         请求文件的长度 ：<%=request.getContentLength() %><BR>
         请求客户端的IP地址：<%=request.getRemoteAddr() %><BR><!-- 动态地址是一个错误的值 -->
         请求的真实路径：<%=request.getRealPath("request.jsp") %><br>
         请求的上下文路径：<%=request.getContextPath() %><BR>       
</body>
</html>