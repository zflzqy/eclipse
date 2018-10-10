package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOutil {
	/*
	 * 将文件内容以16进制输出
	 * */
	public static void printHex(String fileName)throws IOException{
		File file = new File(fileName);
		if(!file.isFile()) {
			throw new IOException("您选择的不是一个文件");
		}
		FileInputStream in = new FileInputStream(file);//构建文件输出流
		int b;
		int i = 1;//i用于换行
		while((b=in.read())!=-1) {
			if(b <= 0xf) {
				System.out.print("0");//如果是单位数则补0
			}
			System.out.print(Integer.toHexString(b)+"	");
			if(i++%10==0) {
				System.out.println();//每10个换行
			}
		}
		in.close();//关闭输入流
	}
	/*
	 * 以字节输出内容
	 * */
	public static void printHexbyte(String fileName)throws IOException {
		File file = new File(fileName);
		if(!file.isFile()) {
			throw new IOException("您选择的不是文件");
		}
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[8*1024];//8个字节
		int bytes = 0;
		int j = 1;
//		  当文件读完的时候in.read返回-1，当未读完的时候就返回读到的字节数组，用于防止缓冲字节数组不够大
		  while((bytes = in.read(buf,0,buf.length))!=-1){
			  System.out.println("这是字节数组长度"+buf.length+"这是返回的字节"+bytes);
			  for(int i = 0 ; i < bytes;i++){
//				  & 0xff是因为int是32位，byte8位，避免数据转换错误将高24位清零
				  System.out.print(Integer.toHexString(buf[i] & 0xff)+"	");
				  if(j++%10==0){
					  System.out.println();
				  }
			  }
		  }
		  in.close();
	}
	/*
	 * 单字节复制文件
	 * */
	public static void copyfile(File srcfile,File destfile)throws IOException {
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("不存在"+srcfile+"文件");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"不是一个文件");
		}
		FileInputStream in = new FileInputStream(srcfile);//读取文件
		FileOutputStream out =new FileOutputStream(destfile);//写入（拷贝）文件
		int b;//读取缓冲,存储读到的字节数
		while((b=in.read())!=-1) {
			out.write(b);//读取b个长度字节 的文件,写入时时追加写入
			out.flush();//最好写上，将缓冲池内的数据写入进去，当没有缓冲池时，可以不必写入
		}
		in.close();
		out.close();
	}
	/*
	 *批量字节复制文件
	 * */
	public static void copyfileBybytes(File srcfile,File destfile)throws IOException {
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("不存在"+srcfile+"文件");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"不是一个文件");
		}
		FileInputStream in = new FileInputStream(srcfile);//读取文件
		FileOutputStream out =new FileOutputStream(destfile);//写入（拷贝）文件
		byte[] bytes = new byte[8*1024];//拷贝缓冲数组
		int b;//读取缓冲,存储读到的字节数
		while((b=in.read(bytes,0,bytes.length))!=-1) {
			out.write(bytes, 0, b);//从bytes中读取内容出来，从0开始读取，读取b个长度 的文件,写入时时追加写入
			out.flush();//最好写上，有缓冲池或者缓冲数组必写上
		}
		in.close();
		out.close();
	}
	/*
	 * 用字节流缓冲进行复制文件，效率更高,线程安全
	 * */
	public static void copyfileBybuffer(File srcfile,File destfile)throws IOException{
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("文件"+srcfile+"不存在");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"不是一个文件");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcfile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destfile));
		int b;
		while((b = bis.read())!=-1) {
			bos.write(b);
			bos.flush();//有缓冲池必须写上
		}
		bis.close();
		bos.close();
	}
	/*
	 * 用批量字节流缓冲进行复制文件
	 * 	 * */
	public static void copyfileBybufferbytes(File srcfile,File destfile)throws IOException{
		if(!srcfile.exists()) {
			throw new IllegalArgumentException("文件"+srcfile+"不存在");
		}
		if(!srcfile.isFile()) {
			throw new IllegalArgumentException(srcfile+"不是一个文件");
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
