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
	 * �ͻ���
	 * */
	public static void main(String[] args) {
		Socket sc = null;
		OutputStream os = null;
		PrintWriter pw = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			//���������������
			sc = new Socket("localhost",8181);
			os = sc.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("�û�����zfltwo  ���룺654321");
			pw.flush();
			sc.shutdownOutput();
			//���շ���������Ӧ
			in = sc.getInputStream();
			isr = new InputStreamReader(in);//��װ���ַ���
			br = new BufferedReader(isr);//�����ַ���
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
