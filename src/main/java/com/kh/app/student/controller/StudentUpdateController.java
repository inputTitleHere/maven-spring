package com.kh.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.kh.app.common.AbstractController;
import com.kh.app.student.model.dto.Student;
import com.kh.app.student.model.service.StudentService;

public class StudentUpdateController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentUpdateController.class);
	private StudentService studentService;
	
	public StudentUpdateController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		student.setNo(no);
		student.setName(name);
		student.setTel(tel);
		
		int result = studentService.updateStudent(student);
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson("true",response.getWriter());
		
		return null;
	}
	
}
