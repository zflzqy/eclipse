package com.zfl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/zfl";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static Connection con ;
	//静态块执行连接数据库
	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");// 反射技术
			// 2.获得数据库的连接
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	//暴露获取连接方法
	public static Connection getConn() {
		return con;
	}
//	public static void main(String[] args) throws Exception {
//		
////		//3.操作数据库
////		Statement st = con.createStatement();//创建st对象
////		ResultSet rs = st.executeQuery("SELECT * FROM zfl_test");//获得查询的结果集
////		while(rs.next()) {
////			System.out.println(rs.getString("user_name")+"      "+rs.getInt("age"));
////		}
//	}

}
