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
		Socket sc = null ;//��ǰ�߳����sc
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
				 in = sc.getInputStream();//��ȡ�ֽ�������
				 //���տͻ��˷��͵�����
				 isr = new InputStreamReader(in);
				 br = new BufferedReader(isr);
				 String line;
				 while((line = br.readLine())!=null) {
					 System.out.println("�ͷ��˷��͵���Ϣ"+line);
				 }
					sc.shutdownInput();//�ر�������
				 //��Ӧ�ͻ���
				 os = sc.getOutputStream();
				 pw = new PrintWriter(os);
				 pw.write("��������Ӧ���룺connection successful��������");
				 pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					//�ر���Դ
//					sc.close();//�ر��˶�Ӧ�������Ҳ�ر���
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