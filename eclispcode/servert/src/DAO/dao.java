package DAO;

import Bean.loginUser;

public class dao {
	//�û��Ƿ���
	public static boolean login(loginUser user) {
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
