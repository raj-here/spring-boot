package com.biz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Address;
import com.biz.bean.Student;
import com.biz.service.AddressService;
import com.biz.service.StudentService;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AddressService addressService;

	@RequestMapping(path = "/getStudents", method = RequestMethod.GET)
	public List<Student> getStudents() {
		return studentService.getAll();
	}
	
	@RequestMapping(path = "/getAddresses", method = RequestMethod.GET)
	public List<Address> getAddresses() {
		return addressService.getAll();
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveStudent() {
		Address address = new Address();
		address.setCityName("Chandigarh");
		
		Address address2 = new Address();
		address2.setCityName("Delhi");
		
		Address address3 = new Address();
		address3.setCityName("Lucknow");

		List<Address> set = new ArrayList<Address>();
		
		set.add(address);
		set.add(address2);
		set.add(address3);
		
		Student student = new Student();
		student.setName("Raj");
		student.setAddress(set);

		studentService.save(student);
	}
}
