package DAO;

import Bean.loginUser;

public class dao {
	//用户登方法
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
