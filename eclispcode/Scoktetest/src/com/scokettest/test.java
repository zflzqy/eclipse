package com.scokettest;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		InetAddress ieAdd;
		try {
			ieAdd = InetAddress.getLocalHost();
			System.out.println("主机名："+ieAdd.getHostName()+"ip地址："+ieAdd.getHostAddress());
			byte[] bytes = ieAdd.getAddress();
			System.out.println(Arrays.toString(bytes)+ieAdd);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取本机实例
	}

}
