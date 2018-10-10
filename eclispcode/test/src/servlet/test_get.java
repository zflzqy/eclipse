package servlet;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/test_get" })
		public class test_get extends HttpServlet {
	
    public test_get() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String fileName = request.getParameter("name");//获取文件名，通过参数传上来
		String password =request.getParameter("password");
		BufferedInputStream in = new BufferedInputStream(request.getInputStream());
		System.out.println(fileName+"    "+password);
		File dir = new File("e:\\","dir");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		//存储目录
		byte[] bytes = new byte[4*1024];
		File file = new File(dir,fileName);
		if(!file.exists()) {
			file.createNewFile( );
		}
		FileOutputStream out = new FileOutputStream(file);
		int len = 0;
		while((len=in.read(bytes))!=-1) {
			out.write(bytes, 0, len);
			out.flush();
		}
		in.close();
		out.close();
	}

}
