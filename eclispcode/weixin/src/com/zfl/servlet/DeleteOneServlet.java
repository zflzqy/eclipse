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
 * ����ɾ��
 * */
@WebServlet("/DeleteOneServlet")
public class DeleteOneServlet extends HttpServlet {

    public DeleteOneServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		// �õ�ҳ���ֵ
		String id = request.getParameter("id");
		// ͨ��������ʼ��ҳ��
		Maintainservice maintainservice =new Maintainservice();
		maintainservice.deleteOne(id);
		// ��תָ��ҳ��
		request.getRequestDispatcher("/ListServlet").forward(request, response);
	}

}
