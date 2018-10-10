package L;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassMethd {
	public static void main(String[] args) {
		// 要获取print(int ,int )方法 1.要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2.获取方法 名称和参数列表来决定 
		 * getMethod获取的是public的方法
		 * getDelcaredMethod自己声明的方法
		 */
		try {
			//可变参数    ...   有两种写法
//			Method m = c.getDeclaredMethod("print",new Class[] {int.class,int.class});
			Method m =c.getDeclaredMethod("print",int.class,int.class);
			//方法的反射操作  
	    	//a1.print(10, 20);方法的反射操作是用m对象来进行方法调用 和a1.print调用的效果完全相同
	        //方法如果没有返回值返回null,有返回值返回具体的返回值
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