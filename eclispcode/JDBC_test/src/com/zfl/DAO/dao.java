package com.zfl.DAO;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.zfl.db.DBUtil;
import com.zfl.model.zfl_test;

public class dao {
	/*
	 * 添加方法
	 * current_date()-->sql函数当前时间
	 * */
	public void add(zfl_test zt) throws SQLException {
	String sql = ""+"INSERT INTO zfl_test"+
					"(user_name,sex,age,birthday,email,mobile,"+
					"create_user,create_date,update_user,update_date,isdel)"+
					"VALUES("+
					"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
	PreparedStatement pstm = DBUtil.getConn().prepareStatement(sql);//先加载进来
	pstm.setString(1,zt.getUser_name());
	pstm.setInt(2,zt.getSex());
	pstm.setInt(3, zt.getAge());
	pstm.setDate(4,new Date(zt.getBirthday().getTime()));//将传进来的util类型date转换sql的Date
	pstm.setString(5,zt.getEmail());
	pstm.setString(6,zt.getMobile());
	pstm.setString(7,zt.getCreate_user());
	pstm.setString(8, zt.getUpdate_user());
	pstm.setInt(9,zt.getIsdel());
	pstm.execute();//执行sql语句
	}
	/*
	 * 删除方法
	 * */
	public void delete(int id) throws SQLException {
		String sql =" DELETE FROM zfl_test " +
					" WHERE id =?";
		PreparedStatement pstm = DBUtil.getConn().prepareStatement(sql);// 先加载进来
		pstm.setInt(1,id);
		pstm.execute();// 执行sql语句
	}
	/*
	 * 更新方法,更新语句时，前边加空格，不然报sql语法错误，因为正常拼接成功的话，
	 * 不加空格会将前后拼接在一起，就会报语法错误
	 * */
	public void update(zfl_test zt) throws SQLException {
		String sql = ""+
				" UPDATE zfl_test"+
				" SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"+
				" update_user=?,update_date=current_date(),isdel=?"+
				" WHERE id = ?";
		PreparedStatement pstm = DBUtil.getConn().prepareStatement(sql);//先加载进来
		pstm.setString(1,zt.getUser_name());
		pstm.setInt(2,zt.getSex());
		pstm.setInt(3, zt.getAge());
		pstm.setDate(4,new Date(zt.getBirthday().getTime()));//将传进来的util类型date转换sql的Date
		pstm.setString(5,zt.getEmail());
		pstm.setString(6,zt.getMobile());
		pstm.setString(7, zt.getUpdate_user());
		pstm.setInt(8,zt.getIsdel());
		pstm.setInt(9,zt.getId());
		pstm.execute();//执行sql语句
	}
	/*
	 * 查询所有方法
	 *放在循环内进行实例化，每循环一次赋值时都进行实例化，
	 *放在循环外时，只实例化一次，导致只有一个对象，最终只有最后一个值
	 * */
	public List<zfl_test> query() throws SQLException{
		List<zfl_test> zfl_tests = new ArrayList<zfl_test>();
		zfl_test zt = null;
		Statement st =DBUtil.getConn().createStatement();//获得连接并创建statement对象
		ResultSet rs = st.executeQuery("SELECT*FROM zfl_test");
		while(rs.next()) {
			zt =new zfl_test();
			zt.setUser_name(rs.getString("user_name"));
			zt.setAge(rs.getInt("age"));
			zfl_tests.add(zt);
		}
		return zfl_tests;
	}
	/*
	 * 查询单条数据
	 * 从数据库中读的时候不需要把sql的date转换成util的date，因为util的date是sql的父类
	 * */
	public zfl_test queryOne(String path, String value) {

		zfl_test zt = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM zfl_test WHERE ");
		sb.append(path);
		sb.append(" = ?");
		try {
			pstm = DBUtil.getConn().prepareStatement(sb.toString());// 预加载
			if (isInteger(value)) {
				pstm.setInt(1, Integer.parseInt(value));
			} else if (isValidDate(value)) {
				pstm.setDate(1, (Date) StrToDate(value));
			} else {
				pstm.setString(1, value);
			}
			rs = pstm.executeQuery();// 执行sql语句,返回一个结果集
			// 查询为空处理
			if (!rs.next()) {
				System.out.println("没有相关的信息哦！！！");
				return null;
			}
			while (rs.next()) {
				zt = new zfl_test();// new出一个对象
				zt.setUser_name(rs.getString("user_name"));
				zt.setAge(rs.getInt("age"));
				zt.setBirthday(rs.getDate("birthday"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		try {
			//释放资源
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return zt;
	}

	/*
	 * 判断是否是整数
	 */
	private static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/*
	 * 判断是否是日期
	 */
	public static boolean isValidDate(String str) {
	      boolean convertSuccess=true;
//	　　　　　 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
	       SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	       try {
//	　　　　设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}

	/*
	 * 字符串转换成日期
	 */
	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = (Date) format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
