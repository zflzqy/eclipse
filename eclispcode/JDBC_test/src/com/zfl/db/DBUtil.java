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
	//��̬��ִ���������ݿ�
	static {
		try {
			// 1.������������
			Class.forName("com.mysql.jdbc.Driver");// ���似��
			// 2.������ݿ������
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	//��¶��ȡ���ӷ���
	public static Connection getConn() {
		return con;
	}
//	public static void main(String[] args) throws Exception {
//		
////		//3.�������ݿ�
////		Statement st = con.createStatement();//����st����
////		ResultSet rs = st.executeQuery("SELECT * FROM zfl_test");//��ò�ѯ�Ľ����
////		while(rs.next()) {
////			System.out.println(rs.getString("user_name")+"      "+rs.getInt("age"));
////		}
//	}

}
