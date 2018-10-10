package com.zfl.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zfl.bean.Message;
import com.zfl.db.DBAccess;

public class dao {
	//mybatis����
	DBAccess access = new DBAccess();//���ݿ��������
	SqlSession sqlsession=null;//���ݿ�����Ự
	//��ѯ
	public List<Message> getMessages(String command,String description){
		
		List<Message> messages = null;
		Message message =new Message();
		try {
			sqlsession=access.getSqlSession();
			//ͨ��sqlsessionִ��sql���
			messages =new ArrayList<>();
			message.setCommand(command);
			message.setDescription(description);
			//Message.xml�ļ���select��ǩidΪgetMessages
			messages =sqlsession.selectList("Message.getMessages",message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlsession!=null)
			sqlsession.close();
		}
		return messages;
	}
	//����ɾ��
	public void deleteOne(int id) {
		Message message =new Message();
		try {
			sqlsession=access.getSqlSession();
			//ͨ��sqlsessionִ��sql���
			sqlsession.delete("Message.deleteOne",id);
			sqlsession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlsession!=null)
			sqlsession.close();
		}
	}
	//����ɾ��
		public void deleteBatch(List<Integer> ids) {
			Message message =new Message();
			try {
				sqlsession=access.getSqlSession();
				//ͨ��sqlsessionִ��sql���
				sqlsession.delete("Message.deleteBatch",ids);
				sqlsession.commit();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(sqlsession!=null)
				sqlsession.close();
			}
		}
	//������Ϣ
		public int AddMessage(Message message) {
			int key=-1;
			try {
				sqlsession=access.getSqlSession();
				key =sqlsession.insert("Message.addMessage",message);
				sqlsession.commit();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(sqlsession!=null)
				sqlsession.close();
			}
			return key;
			
		}
//	private Connection conn;
//	private PreparedStatement pstm =null;
//	private StringBuffer sb;

	//jdbc����
//	public List<Message> getMessages(String command,String description){
//		Connection conn = DBUtil.getConnection();
//		List<Message> messages = null;
//		StringBuffer sql =new StringBuffer("SELECT id,command,description,content FROM message WHERE 1=1");
//		List<String> params =new ArrayList<>();
//		if(command!=null&&!"".equals(command.trim())) {
//			sql.append(" AND command =?");
//			params.add(command);
//		}
//		if(description!=null&&!"".equals(description.trim())) {
//			sql.append(" AND description like '%' ? '%'");
//			params.add(description);
//		}
//		try {
//			PreparedStatement pstm = conn.prepareStatement(sql.toString());
//
//			System.out.println(sql.toString());
//			for(int i=0;i<params.size();i++) {
//				pstm.setString(i+1,params.get(i));
//			}
//			ResultSet rs= pstm.executeQuery();
//			messages = new ArrayList<>();
//			Message message;
//			while(rs.next()) {
//				message =new Message();
//				message.setId(rs.getInt("id"));
//				message.setCommand(rs.getString("command"));
//				message.setDescription(rs.getString("description"));
//				message.setContent(rs.getString("content"));
//				System.out.println(message.getCommand());
//				messages.add(message);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return messages;
//	}
}