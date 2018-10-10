package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.cart;
import Bean.shop;
import DAO.shopdao;

@WebServlet(asyncSupported = true, urlPatterns = { "/cartServlet" })
public class cartServlet extends HttpServlet {
	private String ACTION ;//�жϺ��ֶ���
	private shopdao sd;//��Ʒ�߼�
    public cartServlet() {
        sd = new shopdao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		if(request.getParameter("action")!=null) {
			this.ACTION = request.getParameter("action");
			if(ACTION.equals("add"))//�����Ʒ
			{
				if(addTocart(request,response)) 
				{
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				else 
				{
					request.getRequestDispatcher("/fail.jsp").forward(request, response);
				}
			}
			if(ACTION.equals("show"))//չʾ���ﳵ 
			{
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if(ACTION.equals("delete")) {
				if(removeGoods(request,response)) 
				{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
				else 
				{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
	}
	//ɾ�����ﳵ����Ʒ
	private boolean removeGoods(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		cart c = (cart) request.getSession().getAttribute("cart");
		if(c.removeGoods(sd.getShopByid(Integer.parseInt(id)))){
			return true;
		}
		else {
			return false;
		}
		
	}
	//�����Ʒ
	private boolean addTocart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		shop s= sd.getShopByid(Integer.parseInt(id));//���һ����Ʒʵ��
		//�Ƿ��ǵ�һ�����
		if(request.getSession().getAttribute("cart")==null) {
			cart c = new cart();
			request.getSession().setAttribute("cart",c);
		}
		cart c = (cart) request.getSession().getAttribute("cart");//����������ȡ�Ự����
		if(c.addGoodsIncart(s, Integer.parseInt(number))) 
		{
			return true;
		}
		else {
			return false;
		}
	}

}
