package com.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public List<Category> findByCotegoryName(String categoryName);

}