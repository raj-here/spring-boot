package com.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biz.bean.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

	public List<Category> findByCategoryName(String categoryName);
	
//	public List<Category> findBySubcategoriesId(long id);
//	
//	public List<Category> findBySubcategoriesIsNotNull();
	
//	@Query("select c from Category c where c.subcategories.id is null")
//	public List<Category> tanuMethod();
}