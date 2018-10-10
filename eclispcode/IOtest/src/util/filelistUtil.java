package util;

import java.io.File;
import java.io.IOException;

public class filelistUtil {
	public static void listfile(File dir)throws IOException{
		if(!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼"+dir+"������");
		}
		if(!dir.isDirectory()) {
			throw new IOException(dir+"����Ŀ¼");
		}
		//����ֻ�������ǰĿ¼�µ������ļ���Ŀ¼����������Ŀ¼etc
//		String[] fileName = dir.list();
//		for (String file : fileName) {
//			System.out.println(file);
//		}
		//�����ǰĿ¼���е�Ŀ¼��������Ŀ¼���ĺ��ļ�������ӡĿ¼��
		File[] files = dir.listFiles(); 
		if(files!=null&&files.length > 0) {
			for (File file : files) {
				if(file.isDirectory()) {
					System.out.println(file);//��ӡĿ¼
					listfile(file);//�ݹ�					
				}else {
					System.out.println(file);
				}
			}
		}
	}
}
