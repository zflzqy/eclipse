<%@page import="com.sun.xml.internal.bind.v2.runtime.Name"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path =request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增消息</title>
</head>
<body>
	<form action="<%= basepath %>AddServlet">
		<table class="tab1">
			<tbody>
				<tr>
				<tr>
					<td width="90" align="right">指令：</td>
					<td><input name="command" type="text" class="allInput" /></td>
				</tr>
				<tr>
					<td width="90" align="right">描述：</td>
					<td><input name="description" type="text" class="allInput" />
					</td>
				</tr>
				<tr>
					<td width="90"  align="right">内容：</td>
					
				</tr>
				<tr>
					<td width="90"  align="right"></td>
					<td><input style="height:200px;" name="content" type="text" class="allInput" /></td>
				</tr>
				<td width="85" align="right">
				<input type="hidden" name="add" value="addMessage">
				<input type="submit" style="" value="提 交" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	<a href="<%= basepath %>ListServlet">返回列表页</a>
</body>
</html>