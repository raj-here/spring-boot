package com.biz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	public Optional<Student> findById(String id);
}