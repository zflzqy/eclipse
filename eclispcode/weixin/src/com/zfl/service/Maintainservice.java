package com.zfl.service;

import java.util.ArrayList;
import java.util.List;

import com.zfl.DAO.dao;
import com.zfl.bean.Message;

/*
 * ά������,service�����е����ݽ��д���
 * */
public class Maintainservice {
	// ����ɾ��
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			dao d = new dao();
			d.deleteOne(Integer.valueOf(id));
		}
	}

	// ����ɾ��
	public void deleteBatch(String[] ids) {
		List<Integer> lids = new ArrayList<>();
		for (String id : ids) {
			if (id != null && !"".equals(id.trim())) {
				lids.add(Integer.parseInt(id));
			}
		}
		dao d =new dao();
		d.deleteBatch(lids);
	}
	//���ӹ���
	public boolean AddMessage(String command,String description,String content) {
		Message message =new Message();
		if(command!=null&&!"".equals(command.trim()))
			message.setCommand(command);
		if(description!=null&&!"".equals(description.trim()))
			message.setDescription(description);
		if(content!=null&&!"".equals(content.trim()))
			message.setContent(content);
		dao d =new dao();
		int key = d.AddMessage(message);
		if(key==-1)
			return false;
		else
			return true;
	}

}
