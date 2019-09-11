package com.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	List<Employee> findByName(String name);
	List<Employee> findByNameAndAge(String name, int age);
	List<Employee> findByDesignation(String designation);

}