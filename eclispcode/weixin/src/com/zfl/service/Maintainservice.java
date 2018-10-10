package com.zfl.service;

import java.util.ArrayList;
import java.util.List;

import com.zfl.DAO.dao;
import com.zfl.bean.Message;

/*
 * 维护功能,service对其中的数据进行处理
 * */
public class Maintainservice {
	// 单条删除
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			dao d = new dao();
			d.deleteOne(Integer.valueOf(id));
		}
	}

	// 多条删除
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
	//增加功能
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
