package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import bean.people;

public class objectSer {

	public static void main(String[] args) {
		File file = new File("fileout/peopel.txt");
		FileOutputStream out = null;
		FileInputStream in = null;
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			//�����������л�
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);
			people pl = new people(1, "�Է���", 22, "this is a boy");
			oos.writeObject(pl);
			oos.flush();
			//��������������
			in = new FileInputStream(file);
			ois = new ObjectInputStream(in);
			people s = (people) ois.readObject();
			System.out.println(s.getId()+"   "+s.getName()+"   "+s.getAge()+"  "+s.getDes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
				oos.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		/*
		 * ��������з����л�ʱ������丸��ʵ�������л�����ô���Ĺ��캯�����ᱻ���ã�
		 * ��֮���������û��ʵ�����л�����ô���Ĺ��캯���ᱻ����
		 * */
	}

}
