package com.biz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	public Student findById(long id);
}