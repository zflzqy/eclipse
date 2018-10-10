package com.zfl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfl.service.QueryService;
import com.zfl.service.Maintainservice;
/*
 * 单条删除
 * */
@WebServlet("/DeleteOneServlet")
public class DeleteOneServlet extends HttpServlet {

    public DeleteOneServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		// 得到页面的值
		String id = request.getParameter("id");
		// 通过服务层初始化页面
		Maintainservice maintainservice =new Maintainservice();
		maintainservice.deleteOne(id);
		// 跳转指定页面
		request.getRequestDispatcher("/ListServlet").forward(request, response);
	}

}
