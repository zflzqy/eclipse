package L;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Classutil {
	//类名称和方法信息
	public static void printClassMethod(Object obj) {
		// 要获取类信息，先获取类类型，传递的是哪个子类的对象，c 就是该子类的类类型
		Class c = obj.getClass();
		System.out.println("类的名称是:" + c.getName());
		/*
		 * method类，方法的对象，一个成员方法就是一个method对象 getMethods()获得的是所有public函数，包括父类继承而来的
		 * getDeclaredMethods()获得的是自己声明的方法，不问权限
		 */
		Method[] ms = c.getMethods();// c.getDeclaredMethods();
		for (int i = 0; i< ms.length; i++) {
			//得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName()+" ");
			//得到方法的名称
			System.out.print(ms[i].getName()+"(");
			//获取参数类型--->得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
	//类成员变量的信息
	public static void printClassField(Object obj) {
		/*
		 *成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息
		 * getDeclaredFields获取的是该类自己声明的成员变量的信息
		 * */
		Class c = obj.getClass();
		Field[] fields =c.getDeclaredFields();
		for (Field field : fields) {
			//得到成本变量的类型的类类型
			Class fieldType =field.getType();
			//得到成员变量的类型名称和成员变量名称
			System.out.println(fieldType.getName()+"	"+field.getName());
		}
	}
	/*
	 * 打印对象的构造函数的信息
	 */
	public static void printClassCons(Object obj){
		Class c = obj.getClass();
		/*
		 * 构造函数也是对象
		 * java.lang. Constructor中封装了构造函数的信息
		 * getConstructors获取所有的public的构造函数
		 * getDeclaredConstructors得到所有的构造函数
		 */
		//Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			//获取构造函数名称
			System.out.print(constructor.getName()+"(");
			//获取构造函数的参数列表--->得到的是参数列表的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
