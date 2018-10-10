package test;

import java.io.File;
import java.io.IOException;

public class fileioDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//文件操作
//		File file = new File("E:\\eclipse\\eclipsdm");
//		System.out.print(file.exists());
		
		//创建文件目录
//		File file1 = new File("E:\\eclipse\\eclipsdm\\zfl");
//		if(!file1.exists()) {
//		file1.mkdir();//一级目录创建
//		file1.mkdirs();//创建多级的目录时		
//		System.out.println(file1.isDirectory());//判断是不是一个目录
//		System.out.println(file1.isFile());//判断是不是一个文件
//		}else {
//			file1.delete();
//		}
		
		//创建文件
//		File file2 = new File("E:\\eclipse\\log.txt");
		File file2 = new File("E:\\eclipse","log.txt");//两种创建文件方式
		if(!file2.exists()) {
			try {
				file2.createNewFile();//创建这个文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
//			file2.delete();
		}
		//常用file对象API
		System.out.println(file2);
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.getParentFile());
	}

}
