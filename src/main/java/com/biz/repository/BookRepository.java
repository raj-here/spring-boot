package com.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByName(String name);

	public List<Book> findByNameAndAuthor(String name, String author);

	public List<Book> findByPrice(long price);

}