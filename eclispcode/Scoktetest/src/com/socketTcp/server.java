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
	 * �����
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
//			 ss = new ServerSocket(8181);//��������˿�
//			 sc = ss.accept();//�����ͷ��˷��͵���Ϣ
//			 in = sc.getInputStream();//��ȡ�ֽ�������
//			 //���տͻ��˷��͵�����
//			 isr = new InputStreamReader(in);
//			 br = new BufferedReader(isr);
//			 String line;
//			 while((line = br.readLine())!=null) {
//				 System.out.println("�ͷ��˷��͵���Ϣ"+line);
//			 }
//				sc.shutdownInput();//�ر�������
//			 //��Ӧ�ͻ���
//			 os = sc.getOutputStream();
//			 pw = new PrintWriter(os);
//			 pw.write("��������Ӧ���룺connection successful��������");
//			 pw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				//�ر���Դ
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
			int count =0 ;//��¼�ͻ�������
			//��ѭ�������߳�,���ڿ����µ��߳����ԣ����մ�ӡ��˳��һ��
			while(true) {
				sc = ss.accept();
				multthreadserver mts = new multthreadserver(sc);
				mts.start();//�����߳�
				InetAddress add = sc.getInetAddress();
				count++;
				System.out.println("�ͻ���������"+count+"		"+add.getHostName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
