package com.biz.service;

import java.util.List;

import com.biz.bean.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public void saveEmployee(Employee employee);

	public Employee findOne(long id);

	public void deleteById(long id);
	
	public void delete(Employee employee);

	public List<Employee> findByName(String name);
	
	public Employee update(Employee employee);
}