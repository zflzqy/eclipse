package com.zfl.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import com.zfl.DAO.dao;
import com.zfl.bean.Message;

/*
 * �б�ҳ���ʼ���Ͳ�ѯ
 * */
public class QueryService {
	//��ָ��û��ƥ��ʱ�ĳ���
	public static String NO_CONTENT ="�Բ��������������ڽ�ʲô";
	public static String HELP ="����";
	// ҳ���ʼ��
	public List<Message> getMessages(String command, String description) {
		dao d = new dao();
		return d.getMessages(command, description);
	}
	//ͨ��ָ��鿴�Զ��ظ�����
	public String QueryByCommand(String command) {
		dao d =new dao();
		List<Message> messages =new ArrayList<>();
		if(HELP.equals(command)) {
			messages=d.getMessages(null, null);
			StringBuilder sb =new StringBuilder();
			for(int i=0;i<messages.size();i++) {
				if(i!=0) {
					sb.append("</br>");//�ڶ��п�ʼ����
				}
				sb.append("�ظ�["+messages.get(i).getCommand()+"]���Բ鿴"+messages.get(i).getDescription());
			}
			return sb.toString();
		}
		messages=d.getMessages(command, null);
		if(messages.size()>0) {
			return messages.get(0).getContent();
		}
		return NO_CONTENT;
	}
}