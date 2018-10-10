package servert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;

public class userServlet extends HttpServlet {
    public userServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		user u =new user();
		String name, password, email,sex,introduce,accept;
		Date birthday = null;
		String[] favorites;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			name = request.getParameter("name");
			password = request.getParameter("password");
			email = request.getParameter("email");
			sex =request.getParameter("sex");
			introduce = request.getParameter("introduce");
			//�ж������Ƿ�δ��д
			if(request.getParameter("birthday").equals("")) {
				request.getSession().setAttribute("fail","����δ��д");
				response.sendRedirect("../reg.jsp");
			}
			birthday = sdf.parse(request.getParameter("birthday"));
			//��ȡ�������
			favorites = request.getParameterValues("favorite");
			//��ֵ
			u.setName(name);
			u.setEmail(email);
			u.setSex(sex);
			u.setIntroduce(introduce);
			u.setBirthday(birthday);
			u.setFavorites(favorites);
			//ȷ������
			if(password.equals(request.getParameter("confirmpass"))) {
				u.setPassword(password);
			}else {
				request.getSession().setAttribute("fail","���벻һ��");
				response.sendRedirect("../reg.jsp");
			}
			//�Ƿ�ͬ��
			if (request.getParameter("isAccept") != null) {
				if ((accept = request.getParameter("isAccept")).equals("true")) {
					u.setAccept(true);
				}
			} else {
					u.setAccept(false);
			}
			//ע�ᵽsession��  
			request.getSession().setAttribute("register",u);
			//ת��
			request.getRequestDispatcher("../userinfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
}
