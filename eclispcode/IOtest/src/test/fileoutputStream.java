package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import util.IOutil;

public class fileoutputStream {
	public static void main(String[] args)throws IOException {
		File file = new File("fileout");
		if(!file.exists()) {
			file.mkdir();//创建文件夹
		}
//		如果该文件不存在则创建，后边参数加true则为可追加文件内容，否则是删除重新创建
		FileOutputStream fileout = new FileOutputStream("fileout/zfl.txt");
		String name = "赵飞龙";
		byte[] bytes = name.getBytes();
		fileout.write(bytes);
		fileout.close();
		IOutil.printHex("fileout/zfl.txt");
	}

}
