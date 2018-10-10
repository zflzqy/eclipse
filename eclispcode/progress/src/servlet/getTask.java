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
	private DBdao dao;// 数据库操作对象
	private Gson gson;// gson对象

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
		response.setCharacterEncoding("utf-8");// 防止输出中文乱码
		// 变量
		Task task = new Task();// task对象
		List<Task> mTask = new ArrayList<>();//返回集合
		String ACTION;// 动作标记
		String rs;// 返回给客户端的结果
		// 逻辑
		PrintWriter pw = response.getWriter();
		ACTION = request.getParameter("ACTION");
		String t = request.getParameter("task");
		System.out.println(ACTION + "     " + t);
		task = gson.fromJson(t, Task.class);
		/*
		 * 查询任务
		 * */
		// 我的任务
		if (ACTION.equals("MYTASK")) {
			try {
				mTask=dao.findtask(task, ACTION);
				rs = gson.toJson(mTask);
				pw.println(rs);
				System.out.println("这是查询的结果:" + rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//异常任务
		if(ACTION.equals("EXCEPTIONTASK")) {
			try {
				mTask=dao.findtask(task,ACTION);
				rs =gson.toJson(mTask);
				pw.write(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//待评价
		if(ACTION.equals("APPRISETASK")) {
			try {
				mTask =dao.findtask(task, ACTION);
				rs =gson.toJson(mTask);
				pw.write(rs);
				System.out.println("这是结果集："+rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		//已完成
		if(ACTION.equals("FINISHEDTASK")) {
			try {
				mTask=dao.findtask(task,ACTION);
				rs =gson.toJson(mTask);
				pw.write(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 可领任务，按区域返回结果集
		if (ACTION.equals("OTHERTASK")) {
			try {
				mTask=dao.findtask(task, ACTION);
				rs = gson.toJson(mTask);
				pw.println(rs);
				System.out.println("这是other的结果:" + rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 已领任务
		if (ACTION.equals("RECEIVE")) {
			try {
				mTask=dao.findtask(task, ACTION);
				rs = gson.toJson(mTask);
				pw.println(rs);
				System.out.println("这是receive的结果:" + rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/*
		 * 改变任务
		 * */
		// 放弃任务
		if (ACTION.equals("GIVEUPTASK")) {
				try {
					// 当领取后被放弃的存放在个人中心异常任务中
					dao.changetask(task, ACTION);
					pw.print("giveupsuccess");
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}
		// 发布任务
		if (ACTION.equals("ISSUETASK")) {
			try {
				dao.issuetask(task);
				pw.print("success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 完成任务
		if (ACTION.equals("FINISHETASK")) {
			try {
				dao.changetask(task, ACTION);
				pw.write("FINISHTASK");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//评价任务
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
			System.out.println("付款任务进行啦");
		}
		// 领取任务
		if (ACTION.equals("GETTASK")) {
			System.out.println(ACTION + "		这是上传task" + task.toString());
			try {
				dao.changetask(task, ACTION);
				pw.print("gettasksuccess");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
