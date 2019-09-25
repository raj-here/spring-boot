package com.biz.service;

import java.util.List;

import com.biz.bean.Student;

public interface StudentService {

	public void save(Student student);
	
	public List<Student> getAll();

}