package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class isrAndosw {

	public static void main(String[] args)throws IOException {
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream("E:\\eclipse\\eclipsdm\\a.txt"));
		OutputStreamWriter osw = new OutputStreamWriter(
				new FileOutputStream("E:\\eclipse\\eclipsdm\\b.txt"));
		char[] buf = new char[8*1024];//�ַ���������
		int c ;
//		while((c = isr.read())!=-1) {
//			System.out.print((char)c);
//		}
		while((c = isr.read(buf,0,buf.length))!=-1) {
			String s = new String(buf,0,c);
			System.out.println(s);
			osw.write(buf,0,c);
			osw.flush();
		}
		isr.close();
		osw.close();
		//��ǰ�����������ʽ��һ��ʱ�ᵼ�����룬��Ҫ��FileInputStream��FileOutputStream-->�ļ�����д
//		FileReader fr = new FileReader("E:\\eclipse\\eclipsdm\\a.txt");
//		FileWriter fw = new FileWriter("E:\\eclipse\\eclipsdm\\c.txt");
//		while((c = fr.read(buf,0,buf.length))!=-1) {
//			fw.write(buf,0,c);
//			fw.flush();
//		}
//		fr.close();
//		fw.close();
	}

}
