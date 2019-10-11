package com.biz.service;

import java.util.List;

import com.biz.bean.Category;

public interface CategoryService {

	public List<Category> findAll();

	public void save(Category category);
	
	public void saveAll(List<Category> categories);

	public Category findOne(String id);

	public void deleteById(String id);

	public void delete(Category category);
	
	public List<Category> finAllRootCategory();

}