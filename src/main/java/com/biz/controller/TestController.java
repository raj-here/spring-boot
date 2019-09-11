package com.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Book;
import com.biz.bean.Employee;
import com.biz.service.BookService;
import com.biz.service.EmployeeService;

@RestController
public class TestController {

	@Autowired
	private BookService bookService;

	@Autowired
	private EmployeeService empService;

	@RequestMapping(path = "/")
	public String home() {
		return "This is my first Page";
	}

	@RequestMapping(path = "/getAll")
	public List<Book> getBooks() {
		return bookService.findAll();
	}

	@RequestMapping(path = "/save")
	public void saveBook() {
		Book book = new Book();
		book.setAuthor("Raj");
		book.setName("Name");
		book.setPrice(250);

		bookService.saveBook(book);
	}

	@RequestMapping(path = "/save_emp")
	public void saveEmployee() {

		Employee emp = new Employee();
		emp.setName("Raj");
		emp.setDesignation("Java developer");
		emp.setAge(25);
		emp.setSalary(1000);

		empService.saveEmployee(emp);
	}

	@RequestMapping(path = "/save1")
	public void saveBook1() {
		Book book = new Book();
		book.setAuthor("Raj 1");
		book.setName("Name");
		book.setPrice(250);

		bookService.saveBook(book);
	}

	@RequestMapping(path = "/name")
	public List<Book> find() {
		return bookService.findByNameAndAuthor("Name", "Raj");
	}

	@RequestMapping(path = "/name1")
	public List<Book> find1() {
		return bookService.findByNameAndAuthor("Name", "Raj 1");
	}

	@RequestMapping(path = "/update")
	public Book update() {
		Book book = bookService.findOne(1);
		book.setAuthor("New Raj");
		return bookService.update(book);
	}

	@RequestMapping(path = "/update_again")
	public Book updateAgain() {
		Book book = bookService.findOne(1);
		book.setAuthor("New Raj 1");
		return bookService.update(book);
	}

	@RequestMapping(path = "/test")
	public void testOptimisticLocking() {
		Book book = bookService.findOne(1);
		System.out.println(book);
		update();
		System.out.println("Book Updated");
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			System.out.println("Exception 1: " + e);
		}
		
		try {
			System.out.println("Updating Again");
//			bookService.update(book);
			updateAgain();
		} catch (Exception e) {
			System.out.println("Exception 2: " + e);
		}


	}

}
