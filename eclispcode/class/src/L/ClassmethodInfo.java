package L;

import java.lang.reflect.Method;

public class ClassmethodInfo {
	public static void main(String[] args) {
		Class c1 = int.class;// int的类类型
		Class c2 = String.class;// string的类类型
		Class c3 = void.class;

		/*
		 * 基本数据类型，void都存在类类型
		 */
//		System.out.println(c1.getName());// 得到类的全称
//		System.out.println(c2.getName());
//		System.out.println(c2.getSimpleName());// 不包含类名称
		
		//获取类信息
		String s="hai";
//		Classutil.printClassMethod(s);
		int i1=0;
//		Classutil.printClassMethod(i1);
//		Classutil.printClassField(i1);
		Classutil.printClassCons(s);
	}
}
