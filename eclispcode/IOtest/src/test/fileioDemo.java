package test;

import java.io.File;
import java.io.IOException;

public class fileioDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ļ�����
//		File file = new File("E:\\eclipse\\eclipsdm");
//		System.out.print(file.exists());
		
		//�����ļ�Ŀ¼
//		File file1 = new File("E:\\eclipse\\eclipsdm\\zfl");
//		if(!file1.exists()) {
//		file1.mkdir();//һ��Ŀ¼����
//		file1.mkdirs();//�����༶��Ŀ¼ʱ		
//		System.out.println(file1.isDirectory());//�ж��ǲ���һ��Ŀ¼
//		System.out.println(file1.isFile());//�ж��ǲ���һ���ļ�
//		}else {
//			file1.delete();
//		}
		
		//�����ļ�
//		File file2 = new File("E:\\eclipse\\log.txt");
		File file2 = new File("E:\\eclipse","log.txt");//���ִ����ļ���ʽ
		if(!file2.exists()) {
			try {
				file2.createNewFile();//��������ļ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
//			file2.delete();
		}
		//����file����API
		System.out.println(file2);
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.getParentFile());
	}

}
