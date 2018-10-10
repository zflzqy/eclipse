package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/zfl";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static Connection conn = null;//数据库连接
	
	//静态块加载数据库
	static {
		try {
			Class.forName(DRIVER);//加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}
	
	//单列模式返回数据库连接
	public static Connection getConnection() throws SQLException {
		if(conn==null) {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = db.getConnection();
		if(conn!=null) {
			System.out.println("数据库连接成功");
		}else {
			System.out.println("数据库连接失败");
		}
	}
	
}
