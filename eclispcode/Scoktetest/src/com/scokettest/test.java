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
			System.out.println("��������"+ieAdd.getHostName()+"ip��ַ��"+ieAdd.getHostAddress());
			byte[] bytes = ieAdd.getAddress();
			System.out.println(Arrays.toString(bytes)+ieAdd);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��ȡ����ʵ��
	}

}
