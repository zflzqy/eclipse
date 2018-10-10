package com.zfl.ann;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class parseAnn {
	public static void main(String[] args) {
		try {
			//1.ʹ���������������
			Class c = Class.forName("com.zfl.ann.Child");
			//2.�ҵ����ϱߵ�ע��
			boolean isExists = c.isAnnotationPresent(Description.class);
			if(isExists) {
				//3.�õ�ע��ʵ��
				Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			//4.�ҵ�����ע��
			Method[] ms = c.getMethods();//�õ����з���
			for (Method m : ms) {//��������
				boolean isMexists = m.isAnnotationPresent(Description.class);
				if(isMexists) {
					Description d = (Description) m.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			System.out.println("=====================");
			//��һ�ֽ�����ʽ
			for (Method m : ms) {
				Annotation[] as= m.getAnnotations();
				for (Annotation a : as) {
					Description d= (Description)a;
					System.out.println(d.value());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
