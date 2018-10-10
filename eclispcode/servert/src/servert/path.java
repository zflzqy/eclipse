package servert;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class path extends HttpServlet {
    public path() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			//请求重定向
		//这是serveletpathDirection/servelet的路径，无法跳转
		//response.sendRedirect("reg.jsp");//("/reg.jsp")也无法
		//获取上下文环境，
		//response.sendRedirect(request.getContextPath()+"/reg.jsp");//("../reg.jsp")可以
			//请求转发,这里的/代表服务器根目录
		//request.getRequestDispatcher("reg.jsp").forward(request, response);//无法访问
		//request.getRequestDispatcher("/reg.jsp").forward(request, response);
		request.getRequestDispatcher("../reg.jsp").forward(request, response);
		
	}

}
