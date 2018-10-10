package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class randomacessfileDemo {

	public static void main(String[] args)throws IOException {
		File randAcFile = new File("randAcFile");//��ָ��Ŀ¼�򴴽��ڵ�ǰĿ¼��
		if(!randAcFile.exists()) {
			randAcFile.mkdir();
		}		
		File file = new File(randAcFile,"zfl.txt");
		if(!file.exists()) {
			file.createNewFile();
		}		
		//randomAccessFile�����ļ���raf.write��raf.read��ֻд���һ���ֽ�
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println(raf.getFilePointer());//��ӡָ�룬Ĭ��ָ��0
		
		/*
		 * д��ʱת�����ֽ�����,��д����������ַ�,��д����ַ�ʱ��
		 * ��ָ����0λ��ʼд�����Ƕ��ַ����ȵ��ļ����ݣ����Ե������ĵ����ĺ���ĸд��ʱ�������룬
		 * gbk��������2���ַ�Ӣ��1���ַ�������ռ�õ�������
		 */
		String s = "�Է���";//ÿ���ַ�ռ�����ֽڣ���0 ��ʼ��ָ��ָ����һ���ֽ�
		byte[] b = s.getBytes();//ת�����ֽ�д��,Ĭ����GBK���Բ�ָ��
		raf.write(b);
		System.out.println(raf.getFilePointer());
		
		//������
		raf.seek(0);//����ʱ������ָ��ָ��ͷ��
		byte[] buf = new byte[(int)raf.length()];//raf.length()����һ��long������
		raf.read(buf);//���뵽�ֽ�������
		String s1 = Arrays.toString(buf);//��������ַ�����
		System.out.println(s1);//������������Ϊjava���ַ���������utf-16be����ȡ����GBK���ַ�����
		
		raf.close();//�����һ��Ҫ�ر�
	}

}
