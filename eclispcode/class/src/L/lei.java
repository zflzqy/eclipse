package L;

public class lei {
	public static void main(String[] args) {
		fu f1 =new fu();//fu的实例对象
		//任何一个类都是Class的实例对象，这个类对象有三种表示方式
		
		//任何一个类都有一个隐含的静态成员变量class
		Class c1 = fu.class;
		
		//通过已知类的对象通过getClass方法
		Class c2 =f1.getClass();
		
		/*c1,c2表示了fu类的类类型，因为fu是Class类的实例对象，
		 * fu是一个对象，c1,c2是fu对象的实例对象
		 * fu类的类类型指的是Class的对象
		 */ 
		//c1 、 c2都代表了fu类的类类型，一个类只可能是Class类的一个实例对象
		System.out.println(c1==c2);
		
		//第三种表达方式，动态加载类，编译时不报错，静态加载必须所用的类都存在，列子在当前目录下
		try {
			Class c3 = Class.forName("L.fu");//类的全称，包名
			System.out.println(c2==c3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//可以通过类的类类型创建该类的实例对象--》c1,c2,c3创建类的实例对象
		try {
			fu f2=(fu) c1.newInstance();//谁的类类型，就创建谁的对象,，需要有无参构造
			f2.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}

class fu{
	void print() {
		System.out.println("fu");
	}	
	
	
}