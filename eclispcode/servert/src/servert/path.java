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
			//�����ض���
		//����serveletpathDirection/servelet��·�����޷���ת
		//response.sendRedirect("reg.jsp");//("/reg.jsp")Ҳ�޷�
		//��ȡ�����Ļ�����
		//response.sendRedirect(request.getContextPath()+"/reg.jsp");//("../reg.jsp")����
			//����ת��,�����/�����������Ŀ¼
		//request.getRequestDispatcher("reg.jsp").forward(request, response);//�޷�����
		//request.getRequestDispatcher("/reg.jsp").forward(request, response);
		request.getRequestDispatcher("../reg.jsp").forward(request, response);
		
	}

}
