package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class brAndbwOrPw {

	public static void main(String[] args)throws IOException {
		//������
		FileInputStream in = new FileInputStream("E:\\eclipse\\eclipsdm\\a.txt");
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		//д����
		FileOutputStream out = new FileOutputStream("E:\\eclipse\\eclipsdm\\d.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);
		//pwд����
		PrintWriter pw = new PrintWriter("E:\\eclipse\\eclipsdm\\e.txt");
		String line ;
		while((line = br.readLine())!=null) {
			System.out.print(line);//���ỻ��,����̨���
//			bw.write(line);
//			bw.newLine();//��������
//			bw.flush();
			pw.println(line);//pw.print(line)����ִ�л��У�д�뵽e.txt
			pw.flush();
		}
		br.close();
		bw.close();
		pw.close();
	}

}
