package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/zfl";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static Connection conn = null;//���ݿ�����
	
	//��̬��������ݿ�
	static {
		try {
			Class.forName(DRIVER);//��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}
	
	//����ģʽ�������ݿ�����
	public static Connection getConnection() throws SQLException {
		if(conn==null) {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = db.getConnection();
		if(conn!=null) {
			System.out.println("���ݿ����ӳɹ�");
		}else {
			System.out.println("���ݿ�����ʧ��");
		}
	}
	
}
