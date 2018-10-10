package servert;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.loginUser;
import DAO.dao;

public class login extends HttpServlet {
	
    public login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginUser lu = new loginUser();
		lu.setName(request.getParameter("name"));
		lu.setPassword(request.getParameter("password"));
		if(dao.login(lu)) {
			request.getSession().setAttribute("name", lu.getName());
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/fail.jsp");
		}
		
	}

}
