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
@WebServlet("/DeleteBatchServlet")
public class DeleteBatchServlet extends HttpServlet {

    public DeleteBatchServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		// �õ�ҳ���ֵ
		String[] ids = request.getParameterValues("id");
		// ͨ��������ʼ��ҳ��
		Maintainservice maintainservice =new Maintainservice();
		maintainservice.deleteBatch(ids);
		// ��תָ��ҳ��
		request.getRequestDispatcher("/ListServlet").forward(request, response);
	}

}