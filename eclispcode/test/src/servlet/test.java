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
		System.out.println("���ǿͻ��˷���������"+name);
//		//��������
//		System.out.println("�����Ƿ��������������Կͻ��˵�����"+"     "
//		+new String(name.getBytes("iso-8859-1"),"utf-8")+"			"
//				+new String(password.getBytes("iso-8859-1"),"utf-8"));
		//�������ݸ��ͻ���
		pw.println("���Ƿ����������������");//�������ݸ��ͻ���	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
