package com.biz.service;

import java.util.List;

import com.biz.bean.Component;

public interface ComponentService {
	public List<Component> findAll();

	public void save(Component component);

	public Component findOne(String id);

	public void deleteById(String id);

	public void delete(Component component);
	
	public Component findByComponentName(String name);

}