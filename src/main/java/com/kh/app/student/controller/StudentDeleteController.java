package com.kh.app.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.kh.app.common.AbstractController;
import com.kh.app.student.model.service.StudentService;

public class StudentDeleteController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentDeleteController.class);
	private StudentService studentService;
	public StudentDeleteController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no=Integer.parseInt(request.getParameter("no"));
		int result = studentService.deleteStudent(no);
		
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson("true",response.getWriter());
		return null;
	}
	
	
}
