<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	String multi(){
		String s = "";
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				s+=j+"*"+i+"&nbsp;"+"="+"&nbsp;"+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			s+="<br>";
		}
		return s;
	}
	%>
	<%=multi() %>
	<h2>诗歌</h2>
	<%
		out.println("第一行<br>");
		out.println("第二行<br>");
		out.flush();//flush将缓冲区内容输出，会让缓冲剩余空间变大，之后不能使用out.clear(),但可以使用out.clearBuffer()
		out.println("第三行<br>");
		out.println("第四行<br>");
	%>	
	大小：<%=out.getBufferSize() %>
	剩余 :<%=out.getRemaining() %>
	是否：<%=out.isAutoFlush() %>
</body>
</html>