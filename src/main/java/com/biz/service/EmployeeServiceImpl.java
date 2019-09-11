package com.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bean.Employee;
import com.biz.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public Employee findOne(long id) {
		return employeeRepository.getOne(id);
	}

	@Override
	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employee);

	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

}