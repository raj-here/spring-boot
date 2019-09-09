package com.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Book;
import com.biz.service.BookService;

@RestController
public class TestController {

	@Autowired
	private BookService bookService;

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

}
