package DAO;

import Bean.user;

public class dao {
	//�û��Ƿ���
	public boolean login(user user) {
		if(user.getName().equals("zfl")&&String.valueOf(user.getPassword()).equals("123456")) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
