package L;

import java.lang.reflect.Method;

public class ClassmethodInfo {
	public static void main(String[] args) {
		Class c1 = int.class;// int��������
		Class c2 = String.class;// string��������
		Class c3 = void.class;

		/*
		 * �����������ͣ�void������������
		 */
//		System.out.println(c1.getName());// �õ����ȫ��
//		System.out.println(c2.getName());
//		System.out.println(c2.getSimpleName());// ������������
		
		//��ȡ����Ϣ
		String s="hai";
//		Classutil.printClassMethod(s);
		int i1=0;
//		Classutil.printClassMethod(i1);
//		Classutil.printClassField(i1);
		Classutil.printClassCons(s);
	}
}
