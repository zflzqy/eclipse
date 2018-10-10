package com.zfl.ann;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)//[rɪˈtɛnʃən]保留
@Inherited
@Documented
/*
 * 注解的继承只能作用于类不能作用于接口（interface）,
 * 且子类只能继续父类的类上的注解，不能继承父类方法上的注解
 * */
public @interface Description{

String value();//成员以无参无异常方式声明

}