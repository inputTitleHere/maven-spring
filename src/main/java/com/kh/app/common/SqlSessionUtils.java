package com.kh.app.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {

	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		String resource="/mybatis-config.xml";
		// 1. FactoryBuilder (factory 만듦)
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 2. Factory (sqlsession 만들기)
		InputStream is = null;
		try {
			is=Resources.getResourceAsStream(resource); // 특정 파일을 읽어서 String 으로 반환
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory factory = builder.build(is);
		// 3. SqlSession 찍어내기
		sqlSession = factory.openSession(false); // false는 autocommit false으로 설정한다.
		
		return sqlSession; // connection처럼 사용하면 된다.
	}

}
