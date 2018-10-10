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
	 * ��ӷ���
	 * current_date()-->sql������ǰʱ��
	 * */
	public void add(zfl_test zt) throws SQLException {
	String sql = ""+"INSERT INTO zfl_test"+
					"(user_name,sex,age,birthday,email,mobile,"+
					"create_user,create_date,update_user,update_date,isdel)"+
					"VALUES("+
					"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
	PreparedStatement pstm = DBUtil.getConn().prepareStatement(sql);//�ȼ��ؽ���
	pstm.setString(1,zt.getUser_name());
	pstm.setInt(2,zt.getSex());
	pstm.setInt(3, zt.getAge());
	pstm.setDate(4,new Date(zt.getBirthday().getTime()));//����������util����dateת��sql��Date
	pstm.setString(5,zt.getEmail());
	pstm.setString(6,zt.getMobile());
	pstm.setString(7,zt.getCreate_user());
	pstm.setString(8, zt.getUpdate_user());
	pstm.setInt(9,zt.getIsdel());
	pstm.execute();//ִ��sql���
	}
	/*
	 * ɾ������
	 * */
	public void delete(int id) throws SQLException {
		String sql =" DELETE FROM zfl_test " +
					" WHERE id =?";
		PreparedStatement pstm = DBUtil.getConn().prepareStatement(sql);// �ȼ��ؽ���
		pstm.setInt(1,id);
		pstm.execute();// ִ��sql���
	}
	/*
	 * ���·���,�������ʱ��ǰ�߼ӿո񣬲�Ȼ��sql�﷨������Ϊ����ƴ�ӳɹ��Ļ���
	 * ���ӿո�Ὣǰ��ƴ����һ�𣬾ͻᱨ�﷨����
	 * */
	public void update(zfl_test zt) throws SQLException {
		String sql = ""+
				" UPDATE zfl_test"+
				" SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"+
				" update_user=?,update_date=current_date(),isdel=?"+
				" WHERE id = ?";
		PreparedStatement pstm = DBUtil.getConn().prepareStatement(sql);//�ȼ��ؽ���
		pstm.setString(1,zt.getUser_name());
		pstm.setInt(2,zt.getSex());
		pstm.setInt(3, zt.getAge());
		pstm.setDate(4,new Date(zt.getBirthday().getTime()));//����������util����dateת��sql��Date
		pstm.setString(5,zt.getEmail());
		pstm.setString(6,zt.getMobile());
		pstm.setString(7, zt.getUpdate_user());
		pstm.setInt(8,zt.getIsdel());
		pstm.setInt(9,zt.getId());
		pstm.execute();//ִ��sql���
	}
	/*
	 * ��ѯ���з���
	 *����ѭ���ڽ���ʵ������ÿѭ��һ�θ�ֵʱ������ʵ������
	 *����ѭ����ʱ��ֻʵ����һ�Σ�����ֻ��һ����������ֻ�����һ��ֵ
	 * */
	public List<zfl_test> query() throws SQLException{
		List<zfl_test> zfl_tests = new ArrayList<zfl_test>();
		zfl_test zt = null;
		Statement st =DBUtil.getConn().createStatement();//������Ӳ�����statement����
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
	 * ��ѯ��������
	 * �����ݿ��ж���ʱ����Ҫ��sql��dateת����util��date����Ϊutil��date��sql�ĸ���
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
			pstm = DBUtil.getConn().prepareStatement(sb.toString());// Ԥ����
			if (isInteger(value)) {
				pstm.setInt(1, Integer.parseInt(value));
			} else if (isValidDate(value)) {
				pstm.setDate(1, (Date) StrToDate(value));
			} else {
				pstm.setString(1, value);
			}
			rs = pstm.executeQuery();// ִ��sql���,����һ�������
			// ��ѯΪ�մ���
			if (!rs.next()) {
				System.out.println("û����ص���ϢŶ������");
				return null;
			}
			while (rs.next()) {
				zt = new zfl_test();// new��һ������
				zt.setUser_name(rs.getString("user_name"));
				zt.setAge(rs.getInt("age"));
				zt.setBirthday(rs.getDate("birthday"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		try {
			//�ͷ���Դ
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return zt;
	}

	/*
	 * �ж��Ƿ�������
	 */
	private static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/*
	 * �ж��Ƿ�������
	 */
	public static boolean isValidDate(String str) {
	      boolean convertSuccess=true;
//	���������� ָ�����ڸ�ʽΪ��λ��/��λ�·�/��λ���ڣ�ע��yyyy/MM/dd���ִ�Сд��
	       SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	       try {
//	������������lenientΪfalse. ����SimpleDateFormat��ȽϿ��ɵ���֤���ڣ�����2007/02/29�ᱻ���ܣ���ת����2007/03/01
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}

	/*
	 * �ַ���ת��������
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
