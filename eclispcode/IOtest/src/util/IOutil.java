package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOutil {
	/*
	 * ���ļ�������16�������
	 * */
	public static void printHex(String fileName)throws IOException{
		File file = new File(fileName);
		if(!file.isFile()) {
			throw new IOException("��ѡ��Ĳ���һ���ļ�");
		}
		FileInputStream in = new FileInputStream(file);//�����ļ������
		int b;
		int i = 1;//i���ڻ���
		while((b=in.read())!=-1) {
			if(b <= 0xf) {
				System.out.print("0");//����ǵ�λ����0
			}
			System.out.print(Integer.toHexString(b)+"	");
			if(i++%10==0) {
				System.out.println();//ÿ10������
			}
		}
		in.close();//�ر�������
	}
	/*
	 * ���ֽ��������
	 * */
	public static void printHexbyte(String fileName)throws IOException {
		File file = new File(fileName);
		if(!file.isFile()) {
			throw new IOException("��ѡ��Ĳ����ļ�");
		}
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[8*1024];//8���ֽ�
		int bytes = 0;
		int j = 1;
//		  ���ļ������ʱ��in.read����-1����δ�����ʱ��ͷ��ض������ֽ����飬���ڷ�ֹ�����ֽ����鲻����
		  while((bytes = in.read(buf,0,buf.length))!=-1){
			  System.out.println("�����ֽ����鳤��"+buf.length+"���Ƿ��ص��ֽ�"+bytes);
			  for(int i = 0 ; i < bytes;i++){
//				  & 0xff����Ϊint��32λ��byte8λ����������ת�����󽫸�24λ����
				  System.out.print(Integer.toHexString(buf[i] & 0xff)+"	");
				  if(j++%10==0){
					  System.out.println();
				  }
			  }
		  }
		  in.close();
	}
	/*
	 * ���ֽڸ����ļ�
	 * */
	public static void copyfile(File srcfile,File destfile)throws IOException {
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("������"+srcfile+"�ļ�");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"����һ���ļ�");
		}
		FileInputStream in = new FileInputStream(srcfile);//��ȡ�ļ�
		FileOutputStream out =new FileOutputStream(destfile);//д�루�������ļ�
		int b;//��ȡ����,�洢�������ֽ���
		while((b=in.read())!=-1) {
			out.write(b);//��ȡb�������ֽ� ���ļ�,д��ʱʱ׷��д��
			out.flush();//���д�ϣ���������ڵ�����д���ȥ����û�л����ʱ�����Բ���д��
		}
		in.close();
		out.close();
	}
	/*
	 *�����ֽڸ����ļ�
	 * */
	public static void copyfileBybytes(File srcfile,File destfile)throws IOException {
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("������"+srcfile+"�ļ�");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"����һ���ļ�");
		}
		FileInputStream in = new FileInputStream(srcfile);//��ȡ�ļ�
		FileOutputStream out =new FileOutputStream(destfile);//д�루�������ļ�
		byte[] bytes = new byte[8*1024];//������������
		int b;//��ȡ����,�洢�������ֽ���
		while((b=in.read(bytes,0,bytes.length))!=-1) {
			out.write(bytes, 0, b);//��bytes�ж�ȡ���ݳ�������0��ʼ��ȡ����ȡb������ ���ļ�,д��ʱʱ׷��д��
			out.flush();//���д�ϣ��л���ػ��߻��������д��
		}
		in.close();
		out.close();
	}
	/*
	 * ���ֽ���������и����ļ���Ч�ʸ���,�̰߳�ȫ
	 * */
	public static void copyfileBybuffer(File srcfile,File destfile)throws IOException{
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("�ļ�"+srcfile+"������");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"����һ���ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcfile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destfile));
		int b;
		while((b = bis.read())!=-1) {
			bos.write(b);
			bos.flush();//�л���ر���д��
		}
		bis.close();
		bos.close();
	}
	/*
	 * �������ֽ���������и����ļ�
	 * 	 * */
	public static void copyfileBybufferbytes(File srcfile,File destfile)throws IOException{
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("�ļ�"+srcfile+"������");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"����һ���ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcfile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destfile));
		byte[] bytes = new byte[8*1024];
		int b;
		while((b = bis.read(bytes,0,bytes.length))!=-1) {
			bos.write(bytes,0,b);
			bos.flush();
		}
		bis.close();
		bos.close();
	}
}
