package L;

public class lei {
	public static void main(String[] args) {
		fu f1 =new fu();//fu��ʵ������
		//�κ�һ���඼��Class��ʵ�������������������ֱ�ʾ��ʽ
		
		//�κ�һ���඼��һ�������ľ�̬��Ա����class
		Class c1 = fu.class;
		
		//ͨ����֪��Ķ���ͨ��getClass����
		Class c2 =f1.getClass();
		
		/*c1,c2��ʾ��fu��������ͣ���Ϊfu��Class���ʵ������
		 * fu��һ������c1,c2��fu�����ʵ������
		 * fu���������ָ����Class�Ķ���
		 */ 
		//c1 �� c2��������fu��������ͣ�һ����ֻ������Class���һ��ʵ������
		System.out.println(c1==c2);
		
		//�����ֱ�﷽ʽ����̬�����࣬����ʱ��������̬���ر������õ��඼���ڣ������ڵ�ǰĿ¼��
		try {
			Class c3 = Class.forName("L.fu");//���ȫ�ƣ�����
			System.out.println(c2==c3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//����ͨ����������ʹ��������ʵ������--��c1,c2,c3�������ʵ������
		try {
			fu f2=(fu) c1.newInstance();//˭�������ͣ��ʹ���˭�Ķ���,����Ҫ���޲ι���
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