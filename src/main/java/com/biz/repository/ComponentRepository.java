package com.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {

	public List<Component> findByComponentName(String componentName);

}