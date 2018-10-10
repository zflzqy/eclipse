package com.socketTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	/*
	 * 客户端
	 * */
	public static void main(String[] args) {
		Socket sc = null;
		OutputStream os = null;
		PrintWriter pw = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			//向服务器发送请求
			sc = new Socket("localhost",8181);
			os = sc.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("用户名：zfltwo  密码：654321");
			pw.flush();
			sc.shutdownOutput();
			//接收服务器的响应
			in = sc.getInputStream();
			isr = new InputStreamReader(in);//包装成字符流
			br = new BufferedReader(isr);//缓冲字符流
			String line ;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
				pw.close();
				in.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}
