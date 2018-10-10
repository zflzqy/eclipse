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
			//读入流，序列化
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);
			people pl = new people(1, "赵飞龙", 22, "this is a boy");
			oos.writeObject(pl);
			oos.flush();
			//读出流，反序列
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
		 * 对子类进行反序列化时，如果其父类实现了序列化，那么他的构造函数不会被调用，
		 * 反之，如果父类没有实现序列化，那么他的构造函数会被调用
		 * */
	}

}
