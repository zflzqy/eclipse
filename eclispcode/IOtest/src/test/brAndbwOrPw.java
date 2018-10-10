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
		//读入流
		FileInputStream in = new FileInputStream("E:\\eclipse\\eclipsdm\\a.txt");
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		//写入流
		FileOutputStream out = new FileOutputStream("E:\\eclipse\\eclipsdm\\d.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);
		//pw写入流
		PrintWriter pw = new PrintWriter("E:\\eclipse\\eclipsdm\\e.txt");
		String line ;
		while((line = br.readLine())!=null) {
			System.out.print(line);//不会换行,控制台输出
//			bw.write(line);
//			bw.newLine();//单独换行
//			bw.flush();
			pw.println(line);//pw.print(line)不会执行换行，写入到e.txt
			pw.flush();
		}
		br.close();
		bw.close();
		pw.close();
	}

}
