package com.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Component;

public interface ComponentRepository extends JpaRepository<Component, String> {

	public List<Component> findByComponentName(String componentName);

	public Component findById(long id);

}