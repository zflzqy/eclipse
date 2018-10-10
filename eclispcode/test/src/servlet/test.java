package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/test" })
public class test extends HttpServlet {
       private String name="zfl";
    public test() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		name= request.getParameter("user");
//		String password = request.getParameter("password");
//		setName(name);
		System.out.println("这是客户端发来的数据"+name);
//		//会有乱码
//		System.out.println("这里是服务器，接收来自客户端的数据"+"     "
//		+new String(name.getBytes("iso-8859-1"),"utf-8")+"			"
//				+new String(password.getBytes("iso-8859-1"),"utf-8"));
		//发送数据给客户端
		pw.println("这是服务器发给你的数据");//发送数据给客户端	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
