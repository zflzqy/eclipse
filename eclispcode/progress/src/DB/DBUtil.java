package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * ���ݿ���
 * */
public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/zfl?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static Connection conn =null ;	
	//��̬��ִ���������ݿ�
	static {			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ���似��
	}	
	//��¶��ȡ���ӷ���
	public static Connection getConn() {
		// 2.������ݿ������
		if(conn==null) {
			try {
				return conn =DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}
