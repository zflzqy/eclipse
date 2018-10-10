package com.zfl.control;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.zfl.DAO.dao;
import com.zfl.model.zfl_test;

public class control {

	public static void main(String[] args){
		dao d = new dao();
		//查询所有
//		List<zfl_test> zfl_tests  = d.query();
//		for(zfl_test zt:zfl_tests) {			
//			System.out.println(zt.getUser_name()+"    "+zt.getAge());
//		}
		//查询单个,先输入查找的列,日期格式2018-07-16
		zfl_test  zt = d.queryOne("age","2");
		System.out.println(zt.getUser_name()+"    "+zt.getAge()+"    "+zt.getBirthday());
		//添加
//		zfl_test zt = new zfl_test();
//		zt.setUser_name("赵飞龙");
//		zt.setSex(1);
//		zt.setAge(12);
//		zt.setBirthday(new Date());
//		zt.setEmail("1396954535@qq.com");
//		zt.setMobile("12345689");
//		zt.setCreate_user("zfl");
//		zt.setUpdate_user("zfl");
//		zt.setIsdel(1);
//		d.add(zt);
		//更新
//		zfl_test zt = new zfl_test();
//		zt.setUser_name("赵飞龙one");
//		zt.setSex(1);
//		zt.setAge(12);
//		zt.setBirthday(new Date());
//		zt.setEmail("1396954535@qq.com");
//		zt.setMobile("12345689");
//		zt.setUpdate_user("zfl");
//		zt.setIsdel(1);
//		zt.setId(6);
//		d.update(zt);
		//删除
//		d.delete(6);
	}

}
