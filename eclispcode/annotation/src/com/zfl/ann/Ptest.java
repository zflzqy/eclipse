package com.zfl.ann;

public class Ptest{
	//@SuppressWarnings("deprecation")代表忽略过时警告
	@SuppressWarnings("deprecation")
	public void sing() {
		People p = new Child();
		p.sing();
	}
}
