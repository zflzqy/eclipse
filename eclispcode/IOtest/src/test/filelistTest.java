package test;

import java.io.File;
import java.io.IOException;

import util.IOutil;
import util.filelistUtil;

public class filelistTest {

	public static void main(String[] args)throws IOException {
//		filelistUtil.listfile(new File("E:\\eclipse\\eclipsdm\\mytest"));//�����ļ�Ŀ¼���
		
//		IOutil.printHex("E:\\eclipse\\eclipsdm\\log.txt");//����ļ�����
		
//		IOutil.printHexbyte("E:\\eclipse\\eclipsdm\\IOutil.java");//����ļ����ֽ����
		
		/*
		 * 1��409337		2��164		3��242250 	4��190
		 * ���۵�һ�������������ֽڻ�����죬������������壬Ȼ���Ǵ����壬�������̰߳�ȫ����������΢������
		 * ������ʵ���Ǵ������������ͬ�ڻ����
		 * */
		File srcFile = new File("E:\\eclipse\\eclipsdm\\a.kux");
		File destFile = new File("E:\\eclipse\\eclipsdm\\b.kux");
		File destFile1 = new File("E:\\eclipse\\eclipsdm\\c.kux");
		File destFile2 = new File("E:\\eclipse\\eclipsdm\\d.kux");
		File destFile3 = new File("E:\\eclipse\\eclipsdm\\e.kux");
		long start = System.currentTimeMillis();
		
//		IOutil.copyfile(srcFile,destFile);//���ֽڸ����ļ�
//		long end = System.currentTimeMillis();
//		IOutil.copyfileBybytes(srcFile, destFile1);//�����ֽڸ����ļ�
//		long end1 = System.currentTimeMillis();
//		IOutil.copyfileBybuffer(srcFile,destFile2);//���ֽ������帴��
//		long end2 = System.currentTimeMillis();
		IOutil.copyfileBybufferbytes(srcFile,destFile3);//�������ֽ������帴��
		long end3 = System.currentTimeMillis();
		
		
		System.out.println(end3-start);
	}

}
