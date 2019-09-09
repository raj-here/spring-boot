package com.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bean.Book;
import com.biz.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);

	}

	@Override
	public Book findOne(long id) {
		return bookRepository.getOne(id);
	}

	@Override
	public void deleteById(long id) {
		bookRepository.deleteById(id);

	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);

	}

	@Override
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}

	@Override
	public List<Book> findByNameAndAuthor(String name, String author) {
		return bookRepository.findByNameAndAuthor(name, author);
	}

	@Override
	public List<Book> findByPrice(long price) {
		return bookRepository.findByPrice(price);
	}

}