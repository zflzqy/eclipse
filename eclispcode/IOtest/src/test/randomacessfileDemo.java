package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class randomacessfileDemo {

	public static void main(String[] args)throws IOException {
		File randAcFile = new File("randAcFile");//不指定目录则创建在当前目录下
		if(!randAcFile.exists()) {
			randAcFile.mkdir();
		}		
		File file = new File(randAcFile,"zfl.txt");
		if(!file.exists()) {
			file.createNewFile();
		}		
		//randomAccessFile创建文件，raf.write和raf.read都只写或读一个字节
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println(raf.getFilePointer());//打印指针，默认指向0
		
		/*
		 * 写入时转换成字节数组,当写入过更长的字符,再写入短字符时，
		 * 会指针在0位开始写，覆盖短字符长度的文件内容，所以当奇数的的中文和字母写入时出现乱码，
		 * gbk编码中文2个字符英文1个字符，编码占用导致乱码
		 */
		String s = "赵飞龙";//每个字符占二个字节，从0 开始，指针指向下一个字节
		byte[] b = s.getBytes();//转换成字节写入,默认是GBK可以不指定
		raf.write(b);
		System.out.println(raf.getFilePointer());
		
		//读操作
		raf.seek(0);//读的时候先让指针指向头部
		byte[] buf = new byte[(int)raf.length()];//raf.length()返回一个long型数据
		raf.read(buf);//读入到字节数组中
		String s1 = Arrays.toString(buf);//输出的是字符数组
		System.out.println(s1);//出现乱码是因为java的字符串编码是utf-16be而读取的是GBK的字符编码
		
		raf.close();//用完后一定要关闭
	}

}
