package com.biz.service;

import java.util.List;

import com.biz.bean.Category;

public interface CategoryService {

	public List<Category> findAll();

	public void save(Category category);

	public Category findOne(long id);

	public void deleteById(long id);

	public void delete(Category category);
	
	public List<Category> finAllRootCategory();

}