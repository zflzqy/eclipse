package test;

import java.io.File;
import java.io.IOException;

import util.IOutil;
import util.filelistUtil;

public class filelistTest {

	public static void main(String[] args)throws IOException {
//		filelistUtil.listfile(new File("E:\\eclipse\\eclipsdm\\mytest"));//测试文件目录输出
		
//		IOutil.printHex("E:\\eclipse\\eclipsdm\\log.txt");//输出文件内容
		
//		IOutil.printHexbyte("E:\\eclipse\\eclipsdm\\IOutil.java");//输出文件以字节输出
		
		/*
		 * 1、409337		2、164		3、242250 	4、190
		 * 结论第一种最慢，批量字节缓冲最快，其次批量带缓冲，然后是带缓冲，由于是线程安全，可能有稍微的慢速
		 * 批量其实就是创建缓冲数组等同于缓冲池
		 * */
		File srcFile = new File("E:\\eclipse\\eclipsdm\\a.kux");
		File destFile = new File("E:\\eclipse\\eclipsdm\\b.kux");
		File destFile1 = new File("E:\\eclipse\\eclipsdm\\c.kux");
		File destFile2 = new File("E:\\eclipse\\eclipsdm\\d.kux");
		File destFile3 = new File("E:\\eclipse\\eclipsdm\\e.kux");
		long start = System.currentTimeMillis();
		
//		IOutil.copyfile(srcFile,destFile);//单字节复制文件
//		long end = System.currentTimeMillis();
//		IOutil.copyfileBybytes(srcFile, destFile1);//批量字节复制文件
//		long end1 = System.currentTimeMillis();
//		IOutil.copyfileBybuffer(srcFile,destFile2);//带字节流缓冲复制
//		long end2 = System.currentTimeMillis();
		IOutil.copyfileBybufferbytes(srcFile,destFile3);//批量带字节流缓冲复制
		long end3 = System.currentTimeMillis();
		
		
		System.out.println(end3-start);
	}

}
