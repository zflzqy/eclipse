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
			//判断日期是否未填写
			if(request.getParameter("birthday").equals("")) {
				request.getSession().setAttribute("fail","日期未填写");
				response.sendRedirect("../reg.jsp");
			}
			birthday = sdf.parse(request.getParameter("birthday"));
			//获取多个爱好
			favorites = request.getParameterValues("favorite");
			//赋值
			u.setName(name);
			u.setEmail(email);
			u.setSex(sex);
			u.setIntroduce(introduce);
			u.setBirthday(birthday);
			u.setFavorites(favorites);
			//确认密码
			if(password.equals(request.getParameter("confirmpass"))) {
				u.setPassword(password);
			}else {
				request.getSession().setAttribute("fail","密码不一致");
				response.sendRedirect("../reg.jsp");
			}
			//是否同意
			if (request.getParameter("isAccept") != null) {
				if ((accept = request.getParameter("isAccept")).equals("true")) {
					u.setAccept(true);
				}
			} else {
					u.setAccept(false);
			}
			//注册到session中  
			request.getSession().setAttribute("register",u);
			//转发
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
