package com.zfl.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 数据库访问
 * */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		//通过配置文件获取数据库连接信息
		Reader reader = Resources.getResourceAsReader("com/zfl/configure/Configuration.xml");
		//通过配置文件构建一个SqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory创建一个sqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		return sqlSession;
	}
}
