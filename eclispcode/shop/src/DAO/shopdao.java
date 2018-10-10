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
	//获取所有商品信息
	public ArrayList<shop> getAllshop() {
		Connection conn = null;// 连接对象
		PreparedStatement pstm = null;
		ResultSet rs = null;// 结果集

		ArrayList<shop> lists = new ArrayList<>();// 商品集合
		try {
			conn = db.getConnection();
			String sql = "SELECT * FROM shop";// sql语句
			pstm = conn.prepareStatement(sql);// 执行sql语句
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
		}//finally语句块
	}
	//根据商品编号获取商品详细信息
	public shop getShopByid(int id) {
		Connection conn = null;// 连接对象
		PreparedStatement pstm = null;
		ResultSet rs = null;// 结果集

		try {
			conn = db.getConnection();
			String sql = "SELECT * FROM shop WHERE id=?";// sql语句
			pstm = conn.prepareStatement(sql);// 执行sql语句
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
				return null;//没有返回空
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
		}//finally语句块
	}
	//获取最近浏览的前五条记录
	public ArrayList<shop> getFive(String list){
		ArrayList<shop> shoplist = new ArrayList<>();
		int count = 5;//最近浏览的前五条记录
		if(list!=null&list.length()>0) {
			//去重
			String[] arr = strWay1(list).split("#");
			//如果记录大于5
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
			return null;//如果没有就返回空
		}
	}
	//去重
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
