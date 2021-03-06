package com.zfl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfl.service.QueryService;

/**
 * 自动恢复类
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AutoReplyServlet" })
public class AutoReplyServlet extends HttpServlet {
       
    public AutoReplyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码
		response.setContentType("text/html;Charset=utf-8");
		//获取输出对象
		PrintWriter pw = response.getWriter();
		//获取service层
		QueryService queryService =new QueryService();
		pw.write(queryService.QueryByCommand(request.getParameter("content")));
		pw.flush();
		pw.close();
		
		
	}

}
