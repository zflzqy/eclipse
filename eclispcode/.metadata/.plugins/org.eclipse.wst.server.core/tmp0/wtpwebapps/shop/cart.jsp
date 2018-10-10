<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="Bean.*" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'cart.jsp' starting page</title>
    <style>
        .total{
            margin:10px 0 0 250px;
        }
    </style>
 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script language="javascript">
	    function delcfm() {
	        if (!confirm("确认要删除？")) {
	            window.event.returnValue = false;
	        }
	    }
   </script>
  </head>
  
  <body>
   <h1>我的购物车</h1>
   <a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
   <hr> 
   <div id="shopping">
   <form action="" method=""c >		
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<% 
				   //首先判断session中是否有购物车对象
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
				<!-- 循环的开始 -->
				     <% 
				         cart cart = (cart)request.getSession().getAttribute("cart");
				         HashMap<shop,Integer> goods = cart.getGoods();
				         Set<shop> items = goods.keySet();
				         Iterator<shop> it = items.iterator();
				         
				         while(it.hasNext())
				         {
				            shop i = it.next();
				     %> 
				<tr name="products" id="product_id_1">
					<td class="thumb"><img src="images/<%=i.getPicture()%>" width="80" height="50"/>
					<a href=""><%=i.getName()%></a></td>
					<td class="number"><%=i.getPrice() %></td>
					<td class="price" id="price_id_1">
						<span><%=i.getPrice()*goods.get(i) %></span>
						<input type="hidden" value="" />
					</td>
					<td class="number">
                     	<%=goods.get(i)%>					
					</td>                        
                    <td class="delete">
					  <a href="<%=path %>/cartServlet?action=delete&id=<%=i.getId()%>" onclick="delcfm();">删除</a>					                  
					</td>
				</tr>
				     <% 
				         }
				     %>
				<!--循环的结束-->
				
			</table>
			 <div class="total" ><span id="total">总计：<%=cart.getTotalprice() %>￥</span></div>
			  <% 
			    }
			 %>
			 </form>
	</div>
  </body>
</html>
