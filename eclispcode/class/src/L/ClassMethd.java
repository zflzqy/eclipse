package L;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassMethd {
	public static void main(String[] args) {
		// Ҫ��ȡprint(int ,int )���� 1.Ҫ��ȡһ���������ǻ�ȡ�����Ϣ����ȡ�����Ϣ����Ҫ��ȡ���������
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2.��ȡ���� ���ƺͲ����б������� 
		 * getMethod��ȡ����public�ķ���
		 * getDelcaredMethod�Լ������ķ���
		 */
		try {
			//�ɱ����    ...   ������д��
//			Method m = c.getDeclaredMethod("print",new Class[] {int.class,int.class});
			Method m =c.getDeclaredMethod("print",int.class,int.class);
			//�����ķ������  
	    	//a1.print(10, 20);�����ķ����������m���������з������� ��a1.print���õ�Ч����ȫ��ͬ
	        //�������û�з���ֵ����null,�з���ֵ���ؾ���ķ���ֵ
//			a1.print(10, 20);
			m.invoke(a1, new Object[] {10,20});
			System.out.println("=======================");
						
			Method m1 = c.getDeclaredMethod("print",String.class,String.class);
			m1.invoke(a1,"hello","word");
			System.out.println("=======================");
				
			Method m2 =c.getDeclaredMethod("print");
			m2.invoke(a1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

class A {
	public void print() {
		System.out.println("hello word");
	}
	public void print(int a, int b) {
		System.out.println(a + "		" + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + b.toUpperCase());
	}
}