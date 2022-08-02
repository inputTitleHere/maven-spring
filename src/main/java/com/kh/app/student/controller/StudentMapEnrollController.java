package com.kh.app.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kh.app.common.AbstractController;
import com.kh.app.student.model.service.StudentService;

public class StudentMapEnrollController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentMapEnrollController.class);
	
	private StudentService studentSerivce;

	public StudentMapEnrollController(StudentService studentSerivce) {
		super();
		this.studentSerivce = studentSerivce;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// studentDto -> Map<String, Object>
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",name);
		map.put("tel",tel);
		log.debug(map);
		
		int result=studentSerivce.insertStudentMap(map);
		request.getSession().setAttribute("msg", "학생 정보 입력하였습니다.");
		
		return "redirect:/student/studentEnroll.do";
	}
	
}
