package com.zfl.ann;

@Description("i am class")
public class Child implements People{

	//@Override告诉编译器，这个方法重新覆盖了，jdk自带注解
	/*
	 * 注解分类：---》运行机制分
	 * 源码注解：注解只在源码存在，编译成.class就不存在了
	 * 编译时注解：在.class文件和源码中存在，jdk自带注解属于编译时注解
	 * 运行时注解：在运行阶段起作用，甚至影响运行逻辑
	 * 
	 * --》按照来源
	 * 来自jdk注解：
	 * 来自第三方注解：
	 * 自定义注解：
	 * 元注解；给注解进行注解叫元注解  
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
