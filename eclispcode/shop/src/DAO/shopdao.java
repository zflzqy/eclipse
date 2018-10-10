package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.regexp.internal.recompile;

import Bean.shop;
import util.db;

public class shopdao {
	private String rs;
	//��ȡ������Ʒ��Ϣ
	public ArrayList<shop> getAllshop() {
		Connection conn = null;// ���Ӷ���
		PreparedStatement pstm = null;
		ResultSet rs = null;// �����

		ArrayList<shop> lists = new ArrayList<>();// ��Ʒ����
		try {
			conn = db.getConnection();
			String sql = "SELECT * FROM shop";// sql���
			pstm = conn.prepareStatement(sql);// ִ��sql���
			rs = pstm.executeQuery();
			shop s;
			while (rs.next()) {
				s = new shop();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCity(rs.getString("city"));
				s.setNumber(rs.getInt("number"));
				s.setPrice(rs.getInt("price"));
				s.setPicture(rs.getString("picture"));
				lists.add(s);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (rs!=null||pstm!=null) {
				try {
					rs.close();
					pstm.close();
					rs = null;
					pstm = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//finally����
	}
	//������Ʒ��Ż�ȡ��Ʒ��ϸ��Ϣ
	public shop getShopByid(int id) {
		Connection conn = null;// ���Ӷ���
		PreparedStatement pstm = null;
		ResultSet rs = null;// �����

		try {
			conn = db.getConnection();
			String sql = "SELECT * FROM shop WHERE id=?";// sql���
			pstm = conn.prepareStatement(sql);// ִ��sql���
			pstm.setInt(1,id);
			rs = pstm.executeQuery();
			shop s = null;
			if (rs.next()) {
				s = new shop();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCity(rs.getString("city"));
				s.setNumber(rs.getInt("number"));
				s.setPrice(rs.getInt("price"));
				s.setPicture(rs.getString("picture"));
				return s;
			}
			else {
				return null;//û�з��ؿ�
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (rs!=null||pstm!=null) {
				try {
					rs.close();
					pstm.close();
					rs = null;
					pstm = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//finally����
	}
	//��ȡ��������ǰ������¼
	public ArrayList<shop> getFive(String list){
		ArrayList<shop> shoplist = new ArrayList<>();
		int count = 5;//��������ǰ������¼
		if(list!=null&list.length()>0) {
			//ȥ��
			String[] arr = strWay1(list).split("#");
			//�����¼����5
			if(arr.length>5) {
				for(int i=arr.length-1;i>=arr.length-count;i--) {
					shoplist.add(getShopByid(Integer.parseInt(arr[i])));
				}
			}
			else {
				for(int i=arr.length-1;i>=0;i--) {
					shoplist.add(getShopByid(Integer.parseInt(arr[i])));
				}
			}
			return shoplist;
		}
		else {
			return null;//���û�оͷ��ؿ�
		}
	}
	//ȥ��
	 public static String strWay1(String text) {
	        String[] str = text.split("#");        
	        if(str.length == 0) {            
	            return null;
	        }
	        List<String> list = new ArrayList<String>();
	        StringBuffer sb = new StringBuffer();
	        for(int i = 0;i < str.length; i++) {
	            if(!list.contains(str[i])){
	                list.add(str[i]);
	                sb.append(str[i]+"#");
	            }
	        }        
	        return sb.toString().substring(0,sb.toString().length()-1);
	    }
}
