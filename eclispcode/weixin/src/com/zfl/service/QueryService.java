package com.zfl.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import com.zfl.DAO.dao;
import com.zfl.bean.Message;

/*
 * 列表页面初始化和查询
 * */
public class QueryService {
	//当指令没有匹配时的常量
	public static String NO_CONTENT ="对不起，我听不懂你在讲什么";
	public static String HELP ="帮助";
	// 页面初始化
	public List<Message> getMessages(String command, String description) {
		dao d = new dao();
		return d.getMessages(command, description);
	}
	//通过指令查看自动回复内容
	public String QueryByCommand(String command) {
		dao d =new dao();
		List<Message> messages =new ArrayList<>();
		if(HELP.equals(command)) {
			messages=d.getMessages(null, null);
			StringBuilder sb =new StringBuilder();
			for(int i=0;i<messages.size();i++) {
				if(i!=0) {
					sb.append("</br>");//第二行开始换行
				}
				sb.append("回复["+messages.get(i).getCommand()+"]可以查看"+messages.get(i).getDescription());
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
