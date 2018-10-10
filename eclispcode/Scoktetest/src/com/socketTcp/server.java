package com.socketTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class server {
	/*
	 * 服务端
	 * */
	public static void main(String[] args) {
		ServerSocket ss;
//		Socket sc = null;
//		InputStream in = null;
//		InputStreamReader isr = null;
//		OutputStream os = null;
//		PrintWriter pw = null;
//		BufferedReader br = null;
//		try {
//			 ss = new ServerSocket(8181);//建立服务端口
//			 sc = ss.accept();//监听客服端发送的信息
//			 in = sc.getInputStream();//获取字节输入流
//			 //接收客户端发送的请求
//			 isr = new InputStreamReader(in);
//			 br = new BufferedReader(isr);
//			 String line;
//			 while((line = br.readLine())!=null) {
//				 System.out.println("客服端发送的信息"+line);
//			 }
//				sc.shutdownInput();//关闭输入流
//			 //响应客户端
//			 os = sc.getOutputStream();
//			 pw = new PrintWriter(os);
//			 pw.write("服务器响应代码：connection successful！！！！");
//			 pw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				//关闭资源
//				sc.close();
//				in.close();
//				isr.close();
//				br.close();
//				os.close();
//				pw.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			ss = new ServerSocket(8181);
			Socket sc = null;
			int count =0 ;//记录客户端数量
			//死循环创建线程,由于开启新的线程所以，最终打印的顺序不一致
			while(true) {
				sc = ss.accept();
				multthreadserver mts = new multthreadserver(sc);
				mts.start();//启动线程
				InetAddress add = sc.getInetAddress();
				count++;
				System.out.println("客户端数量："+count+"		"+add.getHostName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
