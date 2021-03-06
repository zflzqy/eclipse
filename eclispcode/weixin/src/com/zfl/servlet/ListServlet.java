package com.zfl.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfl.DAO.dao;
import com.zfl.service.QueryService;

@SuppressWarnings("serial")
@WebServlet(asyncSupported = true, urlPatterns = { "/ListServlet" })
public class ListServlet extends HttpServlet {

    public ListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//得到页面的值
		String command = request.getParameter("command");
		String description =request.getParameter("description");
		//request设置页面的值
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		//通过服务层初始化页面
		QueryService queryService =new QueryService();
		request.setAttribute("messageList", queryService.getMessages(command,description));
		//跳转指定页面
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
	}

}
