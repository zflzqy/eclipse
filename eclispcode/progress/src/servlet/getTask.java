package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Bean.Task;
import DB.DBdao;
import DB.DBdaoImpl;

@WebServlet(asyncSupported = true, urlPatterns = { "/getTask" })
public class getTask extends HttpServlet {
	private DBdao dao;// ���ݿ��������
	private Gson gson;// gson����

	public getTask() {
		dao = new DBdaoImpl();
		gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		response.setCharacterEncoding("utf-8");// ��ֹ�����������
		// ����
		Task task = new Task();// task����
		List<Task> mTask = new ArrayList<>();//���ؼ���
		String ACTION;// �������
		String rs;// ���ظ��ͻ��˵Ľ��
		// �߼�
		PrintWriter pw = response.getWriter();
		ACTION = request.getParameter("ACTION");
		String t = request.getParameter("task");
		System.out.println(ACTION + "     " + t);
		task = gson.fromJson(t, Task.class);
		/*
		 * ��ѯ����
		 * */
		// �ҵ�����
		if (ACTION.equals("MYTASK")) {
			try {
				mTask=dao.findtask(task, ACTION);
				rs = gson.toJson(mTask);
				pw.println(rs);
				System.out.println("���ǲ�ѯ�Ľ��:" + rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//�쳣����
		if(ACTION.equals("EXCEPTIONTASK")) {
			try {
				mTask=dao.findtask(task,ACTION);
				rs =gson.toJson(mTask);
				pw.write(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//������
		if(ACTION.equals("APPRISETASK")) {
			try {
				mTask =dao.findtask(task, ACTION);
				rs =gson.toJson(mTask);
				pw.write(rs);
				System.out.println("���ǽ������"+rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		//�����
		if(ACTION.equals("FINISHEDTASK")) {
			try {
				mTask=dao.findtask(task,ACTION);
				rs =gson.toJson(mTask);
				pw.write(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// �������񣬰����򷵻ؽ����
		if (ACTION.equals("OTHERTASK")) {
			try {
				mTask=dao.findtask(task, ACTION);
				rs = gson.toJson(mTask);
				pw.println(rs);
				System.out.println("����other�Ľ��:" + rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// ��������
		if (ACTION.equals("RECEIVE")) {
			try {
				mTask=dao.findtask(task, ACTION);
				rs = gson.toJson(mTask);
				pw.println(rs);
				System.out.println("����receive�Ľ��:" + rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/*
		 * �ı�����
		 * */
		// ��������
		if (ACTION.equals("GIVEUPTASK")) {
				try {
					// ����ȡ�󱻷����Ĵ���ڸ��������쳣������
					dao.changetask(task, ACTION);
					pw.print("giveupsuccess");
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}
		// ��������
		if (ACTION.equals("ISSUETASK")) {
			try {
				dao.issuetask(task);
				pw.print("success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// �������
		if (ACTION.equals("FINISHETASK")) {
			try {
				dao.changetask(task, ACTION);
				pw.write("FINISHTASK");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//��������
		if(ACTION.equals("APPRISECOT")) {
			try {
				dao.changetask(task, ACTION);
				pw.write("APPRISE");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// pay
		if (ACTION.equals("PAY")) {
			//
			System.out.println("�������������");
		}
		// ��ȡ����
		if (ACTION.equals("GETTASK")) {
			System.out.println(ACTION + "		�����ϴ�task" + task.toString());
			try {
				dao.changetask(task, ACTION);
				pw.print("gettasksuccess");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
