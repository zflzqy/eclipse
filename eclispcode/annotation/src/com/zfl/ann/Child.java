package com.zfl.ann;

@Description("i am class")
public class Child implements People{

	//@Override���߱�����������������¸����ˣ�jdk�Դ�ע��
	/*
	 * ע����ࣺ---�����л��Ʒ�
	 * Դ��ע�⣺ע��ֻ��Դ����ڣ������.class�Ͳ�������
	 * ����ʱע�⣺��.class�ļ���Դ���д��ڣ�jdk�Դ�ע�����ڱ���ʱע��
	 * ����ʱע�⣺�����н׶������ã�����Ӱ�������߼�
	 * 
	 * --��������Դ
	 * ����jdkע�⣺
	 * ���Ե�����ע�⣺
	 * �Զ���ע�⣺
	 * Ԫע�⣻��ע�����ע���Ԫע��  
	 * */
	@Description("i am method")
	public String name() {
		return null;
	}

	public int age() {
		return 0;
	}

	public void sing() {
		
	}

}
