package com.zfl.ann;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class parseAnn {
	public static void main(String[] args) {
		try {
			//1.使用类加载器加载类
			Class c = Class.forName("com.zfl.ann.Child");
			//2.找到类上边的注解
			boolean isExists = c.isAnnotationPresent(Description.class);
			if(isExists) {
				//3.拿到注解实例
				Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			//4.找到方法注解
			Method[] ms = c.getMethods();//拿到所有方法
			for (Method m : ms) {//遍历方法
				boolean isMexists = m.isAnnotationPresent(Description.class);
				if(isMexists) {
					Description d = (Description) m.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			System.out.println("=====================");
			//另一种解析方式
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
