package DB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Bean.Task;
import Bean.User;
import jdk.internal.org.objectweb.asm.tree.TableSwitchInsnNode;
//���ݿ�����ӿ�
public interface DBdao {
	/*
	 * �˺�
	 * */
	//��ӣ��˺ţ�
	public void add(User user) throws SQLException;
	//���£��˺ţ�
	public void update(User user) throws SQLException;
	//�����˺���Ϣ
	public User findByacc(int account) throws SQLException;
	//��¼
	public User findByaccAndpass(User user) throws SQLException;
	//�ͷ���Դ
	public void close() throws SQLException;
	/*
	 * ����
	 * */
	//��ȡ����,����һ��task���ϣ�
	public List<Task> findtask(Task task,String type) throws SQLException;
	//��������
	public void issuetask(Task task)throws SQLException;
	//��������
	public void changetask(Task task,String type)throws SQLException ;
}
