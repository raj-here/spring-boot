package com.biz.service;

import java.util.List;

import com.biz.bean.Component;

public interface ComponentService {
	public List<Component> findAll();

	public void save(Component component);

	public Component findOne(long id);

	public void deleteById(long id);

	public void delete(Component component);

}