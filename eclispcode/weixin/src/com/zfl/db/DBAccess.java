package com.zfl.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * ���ݿ����
 * */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader = Resources.getResourceAsReader("com/zfl/configure/Configuration.xml");
		//ͨ�������ļ�����һ��SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ��SqlSessionFactory����һ��sqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		return sqlSession;
	}
}
