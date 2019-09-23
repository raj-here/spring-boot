package com.biz.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bean.Component;
import com.biz.repository.ComponentRepository;

@Service
@Transactional
public class ComponetServiceImpl implements ComponentService {

	@Autowired
	private ComponentRepository componentRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Component> findAll() {
		return componentRepository.findAll();
	}

	@Override
	public void save(Component component) {
		componentRepository.save(component);

	}

	@Override
	public Component findOne(long id) {
		return componentRepository.getOne(id);
	}

	@Override
	public void deleteById(long id) {
		componentRepository.deleteById(id);
	}

	@Override
	public void delete(Component component) {
		componentRepository.delete(component);
	}

}