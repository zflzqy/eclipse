package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import util.IOutil;

public class fileoutputStream {
	public static void main(String[] args)throws IOException {
		File file = new File("fileout");
		if(!file.exists()) {
			file.mkdir();//�����ļ���
		}
//		������ļ��������򴴽�����߲�����true��Ϊ��׷���ļ����ݣ�������ɾ�����´���
		FileOutputStream fileout = new FileOutputStream("fileout/zfl.txt");
		String name = "�Է���";
		byte[] bytes = name.getBytes();
		fileout.write(bytes);
		fileout.close();
		IOutil.printHex("fileout/zfl.txt");
	}

}
