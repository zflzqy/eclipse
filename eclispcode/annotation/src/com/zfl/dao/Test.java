package com.zfl.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {

		Filter f1 = new Filter();
		f1.setId(10);// ��ѯid=10

		Filter f2 = new Filter();
		f2.setUserName("lucy");// ��ѯ�û�Ϊlucy

		Filter f3 = new Filter();
		f3.setEmail("1@sina.com,2@163.com,3@qq.com");// ��ѯ����Ϊ��������һ�����û�

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
		//ƴװsql���ַ���
		StringBuffer sb = new StringBuffer();
		//1.�õ��������
		Class c = f.getClass();
		boolean isExist = c.isAnnotationPresent(Table.class);
		if (!isExist) {
			return null;
		}
		//ͨ���������õ����ϵ�ע��
		Table t = (Table) c.getAnnotation(Table.class);
		//ͨ��ע���õ�����
		String tableName = t.value();
		//ƴװ����sql
		sb.append(" select * from ").append(tableName).append(" 1=1 ");
		//�õ���Ա������ͨ������
		Field[] fArray = c.getDeclaredFields();
		for (Field field : fArray) {
			boolean fExist = field.isAnnotationPresent(Column.class);
			if (!fExist) {
				continue;
			}
			//ͨ����Ա�������õ���Ա����ע��
			Column column = field.getAnnotation(Column.class);
			/*ͨ����Ա����ע�⣬�õ���Ա��������
			 * field.getName();Ϊɶ��ͨ����Ա����ֱ���õ���Ա��������,
			 * ������ע��������ݿ��б��ֶε�����			 * 
			 * */
			String columnName = column.value();
			/*1.ͨ����Ա�������õ���Ա��������
			 * 2.ͨ����Ա���������õ���Ա������get OR SET����
			 * */
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Object fieldValue = null;
			try {
				//ͨ���������ƻ�ȡ������ȡ��������
				Method getMethod = c.getMethod(getMethodName);
				//ͨ���������󣬲����������յõ�ֵ
				fieldValue = getMethod.invoke(f);
			} catch (Exception e) {
			}
			if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
				continue;
			}
			//ƴװ����sql��䣬�Ը��ֻ������ͽ���if else �ж�
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
