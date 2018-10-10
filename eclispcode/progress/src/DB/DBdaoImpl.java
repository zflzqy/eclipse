package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Bean.Task;
import Bean.User;
import util.Datechange;

//数据库操作实现类
public class DBdaoImpl<T> implements DBdao {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public DBdaoImpl() {
		conn = DBUtil.getConn();
	}

	/*
	 * 账号操作
	 */
	// 添加账号
	@Override
	public void add(User user) throws SQLException {
		conn.setAutoCommit(false);// 关闭自动提示，开启事务
		String sql = " INSERT INTO user (account,password ) VALUES (?,?)";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, user.getAccount());
		pstm.setString(2, user.getPassword());
		pstm.execute();// 执行sql语句
		conn.commit();// 提交事务

	}

	// 更新账号
	@Override
	public void update(User user) throws SQLException {
		conn.setAutoCommit(false);
		String sql = " UPDATE  user  " + " SET name=?,age=?,sex=?,school=?,path=? " + " WHERE account =?";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getName());
		pstm.setInt(2, user.getAge());
		pstm.setString(3, user.getSex());
		pstm.setString(4, user.getSchool());
		pstm.setString(5, user.getPath());
		pstm.setInt(6, user.getAccount());
		pstm.execute();// 执行sql语句
		conn.commit();
	}

	// 查找账号信息
	@Override
	public User findByacc(int account) throws SQLException {
		pstm = null;
		rs = null;
		User u =new User();
		String sql = "SELECT * FROM user WHERE account=? ";
		pstm = conn.prepareStatement(sql);// 预加载
		pstm.setInt(1, account);
		rs = pstm.executeQuery();
		while (rs.next()) {
			u.setAccount(rs.getInt("account"));
			u.setAge(rs.getInt("age"));
			u.setName(rs.getString("name"));
			u.setOtheraccout(rs.getString("otheraccount"));
			u.setPath(rs.getString("path"));
			u.setCredit(rs.getInt("credit"));
			u.setSchool(rs.getString("school"));
		}
		return u;
	}

	//登录
	@Override
	public User findByaccAndpass(User user) throws SQLException {
		pstm = null;
		rs = null;
		String sql = "SELECT * FROM user WHERE account=? and password =?";
		pstm = conn.prepareStatement(sql);// 预加载
		pstm.setInt(1, user.getAccount());
		pstm.setString(2, user.getPassword());
		rs = pstm.executeQuery();
		User u = new User();
		while (rs.next()) {
			u.setAccount(rs.getInt("account"));
			u.setPassword(rs.getString("password"));
			u.setAge(rs.getInt("age"));
			u.setName(rs.getString("name"));
			u.setOtheraccout(rs.getString("otheraccount"));
			u.setPath(rs.getString("path"));
			u.setSex(rs.getString("sex"));
			u.setCredit(rs.getInt("credit"));
			u.setSchool(rs.getString("school"));
		}
		return u;
	}

	// 获取任务
	@Override
	public List<Task> findtask(Task task, String type) throws SQLException {
		pstm = null;
		rs = null;
		String sql = null;
		List<Task> mTask = null;// 任务集合
		Task task1;
		if (type.equals("MYTASK")) {
			// 查询我的任务
			sql = "SELECT * FROM issue_task AS it " 
					+ "	LEFT JOIN receivetask AS re ON it.id=re.id"
					+ "	WHERE issue_account =? " 
					+ " AND giveup=0" 
					+ " AND finished =0";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, task.getIssue_account());
			rs = pstm.executeQuery();
			mTask = new ArrayList<>();
			while (rs.next()) {
				task1 = new Task();
				task1.setId(rs.getInt("id"));
				task1.setRequest(rs.getString("request"));
				task1.setIssue_account(rs.getInt("issue_account"));
				task1.setReceive_account(rs.getInt("receiveaccount"));
				task1.setPrice(rs.getFloat("price"));
				task1.setType(rs.getString("type"));
				task1.setStarttime(rs.getString("starttime"));
				task1.setEndtime(rs.getInt("endtime"));
				task1.setAccept(rs.getInt("accept"));
				task1.setGiveup(rs.getInt("giveup"));
				mTask.add(task1);
			}
		}
		if(type.equals("OTHERTASK")) {
		//查询他人发布的任务
			sql ="SELECT * FROM `user` FULL JOIN (" + 
					"	SELECT *  FROM issue_task " + 
					"	WHERE accept=0 "+
					"	AND giveup=0"+ 
					"	AND issue_account!=?" + 
					"	AND issue_account =ANY (SELECT account FROM `user` WHERE school = " + 
					"	(SELECT school FROM `user` WHERE account = ?))  )AS A" + 
					"	WHERE account= A.issue_account ORDER BY credit DESC";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,task.getIssue_account());
		pstm.setInt(2,task.getIssue_account());
		rs = pstm.executeQuery();
		mTask =new ArrayList<>();
		while(rs.next()) {
			task1 =new Task();
			task1.setId(rs.getInt("id"));
			task1.setRequest(rs.getString("request"));
			task1.setIssue_account(rs.getInt("issue_account"));
			task1.setPrice(rs.getFloat("price"));
			task1.setType(rs.getString("type"));
			task1.setEndtime(rs.getInt("endtime"));
			task1.setGiveup(rs.getInt("giveup"));
			mTask.add(task1);
		}
	}
		if (type.equals("RECEIVE")) {
			// 查询已领任务
			sql = "SELECT * FROM receivetask AS re  	" 
					+ "	LEFT JOIN  issue_task AS it ON  it.id=re.id	"
					+ "	LEFT JOIN `user` AS u ON it.issue_account=u.account" 
					+ "	WHERE receiveaccount =?"
					+ " AND giveup=0 " + "	AND finished =0";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, task.getIssue_account());
			rs = pstm.executeQuery();
			mTask = new ArrayList<>();
			while (rs.next()) {
				task1 = new Task();
				task1.setId(rs.getInt("id"));
				task1.setIssue_account(rs.getInt("issue_account"));
				task1.setReceive_account(rs.getInt("receiveaccount"));
				task1.setRequest(rs.getString("request"));
				task1.setPrice(rs.getFloat("price"));
				task1.setType(rs.getString("type"));
				task1.setStarttime(rs.getString("starttime"));
				task1.setEndtime(rs.getInt("endtime"));
				task1.setFinised(rs.getInt("finished"));
				mTask.add(task1);
			}
		}
		if (type.equals("EXCEPTIONTASK")) {
			// 查询异常任务集合
			sql = "SELECT * FROM `user` "
					+ "	FULL JOIN("
					+ "	SELECT issue_task.*,receivetask.finishtime,receivetask.receiveaccount FROM issue_task"
					+ " LEFT JOIN receivetask ON receivetask.id=issue_task.id) "
					+ "AS ir "
					+ "WHERE account=? AND ir.giveup!=0";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, task.getIssue_account());
			rs = pstm.executeQuery();
			mTask = new ArrayList<>();
			while (rs.next()) {
				task1 = new Task();
				task1.setId(rs.getInt("id"));
				task1.setIssue_account(rs.getInt("issue_account"));
				task1.setReceive_account(rs.getInt("receiveaccount"));
				task1.setRequest(rs.getString("request"));
				task1.setPrice(rs.getFloat("price"));
				task1.setType(rs.getString("type"));
				task1.setGiveup(rs.getInt("giveup"));
				task1.setStarttime(rs.getString("starttime"));
				task1.setEndtime(rs.getInt("endtime"));
				task1.setFinised(rs.getInt("finished"));
				mTask.add(task1);
			}
		}
		if(type.equals("APPRISETASK")) {			
			//查询待评价任务
			sql ="SELECT * FROM issue_task " + 
					"	LEFT JOIN receivetask ON issue_task.id=receivetask.id" + 
					"	WHERE finished=2 AND issue_account=?";
			pstm =conn.prepareStatement(sql);
			System.out.println("发布人账号:"+task.getIssue_account());
			pstm.setInt(1, task.getIssue_account());
			rs =pstm.executeQuery();
			mTask= new ArrayList<>();
			while(rs.next()) {
				task1 =new Task();
				task1.setId(rs.getInt("id"));
				task1.setRequest(rs.getString("request"));
				task1.setIssue_account(rs.getInt("issue_account"));
				task1.setReceive_account(rs.getInt("receiveaccount"));
				task1.setPrice(rs.getFloat("price"));
				task1.setType(rs.getString("type"));
				task1.setStarttime(rs.getString("starttime"));
				task1.setEndtime(rs.getInt("endtime"));
				task1.setFinised(rs.getInt("finished"));
				task1.setAppraise(rs.getString("appraise"));
				task1.setAppraiselevel(rs.getInt("appraiselevel"));
				mTask.add(task1);
			}
		}
		return mTask;// 返回集合
	}
	// 发布任务
	@Override
	public void issuetask(Task task) throws SQLException {
		conn.setAutoCommit(false);
		String sql = " INSERT INTO issue_task" + " (request,issue_account,price,type,endtime,accept,giveup,finished )"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, task.getRequest());
		pstm.setInt(2, task.getIssue_account());
		pstm.setFloat(3, task.getPrice());
		pstm.setString(4, task.getType());
		pstm.setInt(5, task.getEndtime());
		pstm.setInt(6, task.getAccept());
		pstm.setInt(7, task.getGiveup());
		pstm.setInt(8, task.getFinised());
		pstm.execute();// 执行sql语句
		conn.commit();
	}

	// 更改任务
	@Override
	public void changetask(Task task, String type) throws SQLException {
		conn.setAutoCommit(false);
		String sql = null;
		PreparedStatement pstm_re = null;// 处理receive表
		if (type.equals("GIVEUPTASK")) {
			// 放弃任务,
			sql = " UPDATE  issue_task SET giveup=? WHERE id=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, task.getGiveup());// 放弃任务
			pstm.setInt(2, task.getId());
			if (task.getGiveup()==3||task.getGiveup()==4) {// 3.4代表双方同意
				// 处理同意放弃
				String sql_re = "UPDATE  receivetask SET finishtime=? WHERE id=?";
				pstm_re = conn.prepareStatement(sql_re);
				try {
					java.sql.Timestamp date = new java.sql.Timestamp(
							Datechange.stringToDate(task.getFinishtime()).getTime());
					pstm_re.setTimestamp(1, date);// 设置结束时间
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pstm_re.setInt(2, task.getId());
				pstm_re.execute();
			}
			pstm.execute();
		}
		if (type.equals("GETTASK")) {
			// 领取任务的sql语句
			// 插入接收领取任务表
			System.out.println("领取任务操作");
			String sql_re = " INSERT INTO receivetask (id,receiveaccount) VALUES (?,?)";
			pstm_re = conn.prepareStatement(sql_re);
			pstm_re.setInt(1, task.getId());
			pstm_re.setInt(2, task.getReceive_account());
			pstm_re.execute();// 执行sql语句
			sql = "UPDATE issue_task SET accept =?,starttime=? WHERE id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, task.getAccept());
			try {
				// util转sql
				java.sql.Timestamp date = new java.sql.Timestamp(
						Datechange.stringToDate(task.getStarttime()).getTime());
				pstm.setTimestamp(2, date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			pstm.setInt(3, task.getId());
			pstm.execute();// 执行sql语句
		}
		if (type.equals("FINISHETASK")) {
			// 完成任务
			sql = "UPDATE  issue_task  SET  finished =?  WHERE id =?";
			System.out.println(sql + task.getId() + task.getFinised());
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, task.getFinised());
			pstm.setInt(2, task.getId());
			pstm.execute();
		}
		if(type.equals("")) {
			//评价任务
//			sql ="UPDATE issue_task SET app";
//			pstm=conn.prepareStatement(sql);
//			pstm_re.setInt(1, x);
//			pstm_re.execute()
		}
		conn.commit();
		pstm_re.close();

	}

	// 关闭资源
	@Override
	public void close() throws SQLException {
		if (conn != null)
			conn.close();
		if (pstm != null)
			pstm.close();
		if (rs != null)
			rs.close();
	}

}
