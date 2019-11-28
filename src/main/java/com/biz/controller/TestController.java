package com.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Student;
import com.biz.service.StudentService;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/getStudents")
	public List<Student> getStudents() {
		return studentService.getAll();
	}

}
