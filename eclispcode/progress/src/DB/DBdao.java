package DB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Bean.Task;
import Bean.User;
import jdk.internal.org.objectweb.asm.tree.TableSwitchInsnNode;
//数据库操作接口
public interface DBdao {
	/*
	 * 账号
	 * */
	//添加（账号）
	public void add(User user) throws SQLException;
	//更新（账号）
	public void update(User user) throws SQLException;
	//查找账号信息
	public User findByacc(int account) throws SQLException;
	//登录
	public User findByaccAndpass(User user) throws SQLException;
	//释放资源
	public void close() throws SQLException;
	/*
	 * 任务
	 * */
	//获取任务,返回一个task集合，
	public List<Task> findtask(Task task,String type) throws SQLException;
	//发布任务
	public void issuetask(Task task)throws SQLException;
	//更改任务
	public void changetask(Task task,String type)throws SQLException ;
}
