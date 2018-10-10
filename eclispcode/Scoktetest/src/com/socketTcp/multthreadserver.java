package com.socketTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class multthreadserver extends Thread
	{
		Socket sc = null ;//当前线程相关sc
		public multthreadserver(Socket sc) {
			this.sc = sc;
		}
		@Override
		public void run() 
		{
			InputStream in = null;
			InputStreamReader isr = null;
			OutputStream os = null;
			PrintWriter pw = null;
			BufferedReader br = null;
			try {
				 in = sc.getInputStream();//获取字节输入流
				 //接收客户端发送的请求
				 isr = new InputStreamReader(in);
				 br = new BufferedReader(isr);
				 String line;
				 while((line = br.readLine())!=null) {
					 System.out.println("客服端发送的信息"+line);
				 }
					sc.shutdownInput();//关闭输入流
				 //响应客户端
				 os = sc.getOutputStream();
				 pw = new PrintWriter(os);
				 pw.write("服务器响应代码：connection successful！！！！");
				 pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					//关闭资源
//					sc.close();//关闭了对应的输出流也关闭了
					in.close();
					isr.close();
					br.close();
					os.close();
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}