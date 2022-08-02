package com.kh.app.student.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.app.common.SqlSessionUtils.getSqlSession;

import java.util.Map;

import com.kh.app.student.model.dao.StudentDao;
import com.kh.app.student.model.dto.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public int insertStudent(Student student) {
		SqlSession sqlSession = getSqlSession(); // ibatis이다(mybatis 옛버전)
		int result=0;
		try {
			result=studentDao.insertStudent(sqlSession, student);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			throw e;
		}finally {
			sqlSession.close();
		}
		return result;
	}
	
	@Override
	public int insertStudentMap(Map<String, Object> map) {
		int result = 0;
		SqlSession sqlSession = getSqlSession();
		try {
			result=studentDao.insertStudentMap(sqlSession,map);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			throw e;
		}finally {
			sqlSession.close();
		}
		
		return result;
	}
	
	@Override
	public int getTotalCount() {
		try(SqlSession sqlSession = getSqlSession()){
			return studentDao.getTotalCount(sqlSession);
		}
	}
	
	@Override
	public Student selectOneStudent(int no) {
		try(SqlSession sqlSession = getSqlSession()){
			return studentDao.selectOneStudent(sqlSession,no);
		}
	}
	
	@Override
	public int updateStudent(Student student) {
		int result=0;
		SqlSession sqlSession = getSqlSession();
		try {
			result = studentDao.updateStudent(sqlSession, student);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			throw e;
		}finally {
			sqlSession.close();
		}
		
		return result;
	}
	
	@Override
	public int deleteStudent(int no) {
		int result=0;
		SqlSession sqlSession=getSqlSession();
		try {
			result=studentDao.deleteStudent(sqlSession, no);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			throw e;
		}finally {
			sqlSession.close();
		}
		return result;
	}
	
}
