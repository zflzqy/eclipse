package com.zfl.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {

		Filter f1 = new Filter();
		f1.setId(10);// 查询id=10

		Filter f2 = new Filter();
		f2.setUserName("lucy");// 查询用户为lucy

		Filter f3 = new Filter();
		f3.setEmail("1@sina.com,2@163.com,3@qq.com");// 查询邮箱为其中任意一个的用户

		String sql1 = query(f1);
		String sql2 = query(f2);
		String sql3 = query(f3);

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		Filter2 F2 =new Filter2();
		F2.setCount(10);
		System.out.println(query(F2));
	}

	public static String query(Object f) {
		//拼装sql的字符串
		StringBuffer sb = new StringBuffer();
		//1.拿到类的类型
		Class c = f.getClass();
		boolean isExist = c.isAnnotationPresent(Table.class);
		if (!isExist) {
			return null;
		}
		//通过类类型拿到类上的注解
		Table t = (Table) c.getAnnotation(Table.class);
		//通过注解拿到表名
		String tableName = t.value();
		//拼装部分sql
		sb.append(" select * from ").append(tableName).append(" 1=1 ");
		//得到成员变量，通过反射
		Field[] fArray = c.getDeclaredFields();
		for (Field field : fArray) {
			boolean fExist = field.isAnnotationPresent(Column.class);
			if (!fExist) {
				continue;
			}
			//通过成员变量，拿到成员变量注解
			Column column = field.getAnnotation(Column.class);
			/*通过成员变量注解，拿到成员变量名称
			 * field.getName();为啥不通过成员变量直接拿到成员变量名称,
			 * 可能是注解的是数据库中表字段的名称			 * 
			 * */
			String columnName = column.value();
			/*1.通过成员变量，拿到成员变量名称
			 * 2.通过成员变量名称拿到成员变量的get OR SET方法
			 * */
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Object fieldValue = null;
			try {
				//通过方法名称获取方法获取方法对象
				Method getMethod = c.getMethod(getMethodName);
				//通过方法对象，操作对象，最终得到值
				fieldValue = getMethod.invoke(f);
			} catch (Exception e) {
			}
			if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
				continue;
			}
			//拼装最终sql语句，对各种基本类型进行if else 判断
			sb.append(" and ").append(columnName);
			if (fieldValue instanceof String) {
				if (((String) fieldValue).contains(",")) {
					String[] values = ((String) fieldValue).split(",");
					sb.append(" in ( ");
					for (String v : values) {
						sb.append("'").append(v).append("',");
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append(" )");
				} else {
					sb.append(" = '").append(fieldValue).append("' ");
				}
			} else if (fieldValue instanceof Integer) {
				sb.append(" = ").append(fieldValue).append(" ");
			}

		}
		return sb.toString();
	}
}
