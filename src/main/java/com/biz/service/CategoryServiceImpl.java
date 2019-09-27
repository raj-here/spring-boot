package com.biz.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bean.Category;
import com.biz.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	@Override
	public void saveAll(List<Category> categories) {
		categoryRepository.saveAll(categories);
	}

	@Override
	public Category findOne(long id) {
		return categoryRepository.getOne(id);
	}

	@Override
	public void deleteById(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public List<Category> finAllRootCategory() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Category> finAllRootCategory() {
//		return categoryRepository.tanuMethod();
//	}

}