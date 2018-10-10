package util;

import java.io.File;
import java.io.IOException;

public class filelistUtil {
	public static void listfile(File dir)throws IOException{
		if(!dir.exists()) {
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if(!dir.isDirectory()) {
			throw new IOException(dir+"不是目录");
		}
		//仅仅只能输出当前目录下的所有文件和目录，不包括子目录etc
//		String[] fileName = dir.list();
//		for (String file : fileName) {
//			System.out.println(file);
//		}
		//输出当前目录所有的目录（包括子目录）的和文件（不打印目录）
		File[] files = dir.listFiles(); 
		if(files!=null&&files.length > 0) {
			for (File file : files) {
				if(file.isDirectory()) {
					System.out.println(file);//打印目录
					listfile(file);//递归					
				}else {
					System.out.println(file);
				}
			}
		}
	}
}
