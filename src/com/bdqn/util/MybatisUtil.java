package com.bdqn.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			factory = sfb.build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return factory.openSession(true);
	}
	
	
	
	
	/*
	 * private static SqlSessionFactory factory;
	 * 
	 * static{ try { InputStream is =
	 * Resources.getResourceAsStream("mybatis-config.xml"); factory = new
	 * SqlSessionFactoryBuilder().build(is); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 * public static SqlSession getsession() { SqlSession sqlSession =
	 * factory.openSession(true); return sqlSession;
	 * 
	 * }
	 */
}
