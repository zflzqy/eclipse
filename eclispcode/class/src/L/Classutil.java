package L;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Classutil {
	//�����ƺͷ�����Ϣ
	public static void printClassMethod(Object obj) {
		// Ҫ��ȡ����Ϣ���Ȼ�ȡ�����ͣ����ݵ����ĸ�����Ķ���c ���Ǹ������������
		Class c = obj.getClass();
		System.out.println("���������:" + c.getName());
		/*
		 * method�࣬�����Ķ���һ����Ա��������һ��method���� getMethods()��õ�������public��������������̳ж�����
		 * getDeclaredMethods()��õ����Լ������ķ���������Ȩ��
		 */
		Method[] ms = c.getMethods();// c.getDeclaredMethods();
		for (int i = 0; i< ms.length; i++) {
			//�õ������ķ���ֵ���͵�������
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName()+" ");
			//�õ�����������
			System.out.print(ms[i].getName()+"(");
			//��ȡ��������--->�õ����ǲ����б�����͵�������
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
	//���Ա��������Ϣ
	public static void printClassField(Object obj) {
		/*
		 *��Ա����Ҳ�Ƕ���
		 * java.lang.reflect.Field
		 * Field���װ�˹��ڳ�Ա�����Ĳ���
		 * getFields()������ȡ�������е�public�ĳ�Ա��������Ϣ
		 * getDeclaredFields��ȡ���Ǹ����Լ������ĳ�Ա��������Ϣ
		 * */
		Class c = obj.getClass();
		Field[] fields =c.getDeclaredFields();
		for (Field field : fields) {
			//�õ��ɱ����������͵�������
			Class fieldType =field.getType();
			//�õ���Ա�������������ƺͳ�Ա��������
			System.out.println(fieldType.getName()+"	"+field.getName());
		}
	}
	/*
	 * ��ӡ����Ĺ��캯������Ϣ
	 */
	public static void printClassCons(Object obj){
		Class c = obj.getClass();
		/*
		 * ���캯��Ҳ�Ƕ���
		 * java.lang. Constructor�з�װ�˹��캯������Ϣ
		 * getConstructors��ȡ���е�public�Ĺ��캯��
		 * getDeclaredConstructors�õ����еĹ��캯��
		 */
		//Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			//��ȡ���캯������
			System.out.print(constructor.getName()+"(");
			//��ȡ���캯���Ĳ����б�--->�õ����ǲ����б��������
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
