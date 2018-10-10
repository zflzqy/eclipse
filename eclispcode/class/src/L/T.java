package L;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class T {
	public static void main(String[] args) {
		ArrayList list1 =new ArrayList<>();
		ArrayList<String> list2 =new ArrayList<String>();
		
		Class c1 =list1.getClass();
		Class c2 =list2.getClass();
		
		list2.add("hello");
//		list2.add(20);//����ģ�����׶β�ͨ��
		System.out.println(c1==c2);//����ȵ�

		/*
		 * c1==c2�������true˵������֮�󼯺ϵķ�����ȥ���ͻ���
		 * Java�м��ϵķ��ͣ��Ƿ�ֹ��������ģ�ֻ�ڱ���׶���Ч��
		 * �ƹ��������Ч��
		 * ��֤�����ǿ���ͨ�������ķ������������ƹ�����
		 */
		
		try {
			Method m = c2.getMethod("add",Object.class);
			m.invoke(list2, 20);//�ƹ��������
			System.out.println(list2.size());
			System.out.println(list2);
//			for (String string : list2) {
//				System.out.println(string);
//			}//���ڲ�����������
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

