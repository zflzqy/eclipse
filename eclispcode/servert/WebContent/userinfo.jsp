<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"%>
<%@ page import="Bean.user" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <style type="text/css">
	 .title{
		 width: 30%;	
		 background-color: #CCC;
		 font-weight: bold;
	 }
	 .content{
	     width:70%;
	     background-color: #CBCFE5;
	 }	 
   </style>  
  </head>  
  <body>
    <h1>用户信息</h1>
    <hr>
    <center> 
    	<jsp:useBean id="register" class="Bean.user" scope="session"></jsp:useBean>
     <table width="600" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td class="title">用户名：</td>
          <td class="content">&nbsp;<jsp:getProperty property="name" name="register"/></td>
        </tr>
        <tr>
          <td class="title">密码：</td>
          <td class="content">&nbsp;<jsp:getProperty property="password" name="register"/></td>
        </tr>
        <tr>
          <td class="title">性别：</td>
          <td class="content">&nbsp;<jsp:getProperty property="sex" name="register"/></td>
        </tr>
        <tr>
          <td class="title">E-mail：</td>
          <td class="content">&nbsp;<jsp:getProperty property="email" name="register"/></td>
        </tr>
        <tr>
          <td class="title">出生日期：</td>
          <td class="content">&nbsp;
            	 <% 
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
               String date = sdf.format(register.getBirthday());
               
            %>
             <%=date%>
          </td>
        </tr>
        <tr>
          <td class="title">爱好：</td>
          <td class="content">&nbsp;
          <% 
               String[] favorites = register.getFavorites();
          		if(favorites!=null&&favorites.length>0){
                    for(String f:favorites)
               {
          %>
               		 <%=f%> &nbsp;&nbsp;
               	 
            <%  }  }%>
          </td>
        </tr>
        <tr>
          <td class="title">自我介绍：</td>
          <td class="content">&nbsp;<jsp:getProperty property="introduce" name="register"/></td>
        </tr>
        <tr>
          <td class="title">是否介绍协议：</td>
          <td class="content">&nbsp;<jsp:getProperty property="accept" name="register"/></td>
        </tr>
     </table>
    </center>
  </body>
</html>
