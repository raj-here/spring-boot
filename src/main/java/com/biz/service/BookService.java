package com.biz.service;

import java.util.List;

import com.biz.bean.Book;

public interface BookService {
	public List<Book> findAll();

	public void saveBook(Book book);

	public Book findOne(long id);

	public void deleteById(long id);
	
	public void delete(Book book);

	public List<Book> findByName(String name);

	public List<Book> findByNameAndAuthor(String name, String author);

	public List<Book> findByPrice(long price);
	
	public Book update(Book book);
	
	public void detachedEntity(Book book);
}