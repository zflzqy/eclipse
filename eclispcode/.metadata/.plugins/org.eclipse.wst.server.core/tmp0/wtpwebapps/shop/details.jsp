<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
    pageEncoding="utf-8"%>
    <%@ page import="DAO.*"%>
<%@ page import="Bean.*"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shopdetails</title>
<script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
    <script type="text/javascript">
      function selflog_show(id)
      { 
         var num =  document.getElementById("number").value; 
         J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/cartServlet?id='+id+'&num='+num+'&action=add', cover:true});
      }
      function add()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num<100)
         {
            document.getElementById("number").value = ++num;
         }
      }
      function sub()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num>1)
         {
            document.getElementById("number").value = --num;
         }
      }
     
    </script>
<style type="text/css">
	   hr{
	     
	     border-color:FF7F00; 
	   }
	   
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	     
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	   div #cart
	   {
	     margin:0px auto;
	     text-align:right; 
	   }
	   span{
	     padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
	   }
	   a{
	      text-decoration: none; 
	   }
	</style>
</head>
<body>
	<h1>商品详情</h1>
	<h4 align="center">关闭浏览器后，购物车自动清空</h4>
    <hr>
    <center>
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <!-- 商品详情 -->
          <% 
             shopdao sd = new shopdao();
             shop s = sd.getShopByid(Integer.parseInt(request.getParameter("id")));
             if(s!=null)
             {
          %>
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="4"><img src="images/<%=s.getPicture()%>" width="200" height="160"/></td>
               </tr>
               <tr>
                 <td><B><%=s.getName() %></B></td> 
               </tr>
               <tr>
                 <td>产地：<%=s.getCity()%></td>
               </tr>
               <tr>
                 <td>价格：<%=s.getPrice() %>￥</td>
               </tr> 
               <tr>
                 <td>购买数量：<span id="sub" onclick="sub();">-</span><input type="text" id="number" name="number" value="1" size="2"/><span id="add" onclick="add();">+</span></td>
               </tr> 
             </table>
             <div id="cart">
               <img src="images/buy_now.png"><a href="javascript:selflog_show(<%=s.getId()%>)">
               <img src="images/in_cart.png"></a>
               <a href="<%=path %>/cartServlet?action=show"><img src="images/view_cart.jpg"/></a>
             </div>
          </td>
          <% 
            }
          %>
          <%
          	String list = "";
          	Cookie[] cookies = request.getCookies();//从客户端获取cookie
          	//遍历cookie
          	if (cookies != null && cookies.length > 0) {
          		for (Cookie c : cookies) {
          			if (c.getName().equals("shopcookie")) {
          				list = c.getValue();
          			}
          		}
          	}
          	list += request.getParameter("id") + "#";          	
          	//记录超过1000条清零
          	String[] arr = list.split("#");
          	if (arr != null && arr.length > 0) {
          		if (arr.length > 1000) {
          			list = "";
          		}
          	}
          	Cookie cookie = new Cookie("shopcookie",list);
          	cookie.setMaxAge(846000);//设置cookie有效时间10天
          	response.addCookie(cookie);
          %>
             <!-- 浏览过的商品 -->
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b>您浏览过的商品</b><br>
             <!-- 循环开始 -->
             <% 
                ArrayList<shop> shops = sd.getFive(list);
                if(shops!=null&&shops.size()>0 )
                {
                   for(shop i:shops)
                   {
                         
             %>
             <div>
             <dl>
               <dt>
                 <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture() %>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=i.getName() %></dd> 
               <dd class="dd_city">产地:<%=i.getCity() %>&nbsp;&nbsp;价格:<%=i.getPrice() %> ￥ </dd> 
             </dl>
             </div>
             <% 
                   }
                }
             %>
             <!-- 循环结束 -->
          </td>
          </tr>
          </table>
          </center>
 		
</body>
</html>