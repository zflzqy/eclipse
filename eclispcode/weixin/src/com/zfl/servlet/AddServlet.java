package com.zfl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfl.bean.Message;
import com.zfl.service.Maintainservice;

import sun.nio.cs.ext.MacArabic;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		String ADD ="";
		ADD=request.getParameter("add");
		if (request.getParameter("add")!=null) {
			// 获取页面的值
			String command = request.getParameter("command");
			String description = request.getParameter("description");
			String content = request.getParameter("content");
			Maintainservice add = new Maintainservice();
			boolean issuccess = add.AddMessage(command, description, content);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/back/add.jsp").forward(request, response);
	}

}
