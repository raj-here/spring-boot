package com.biz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Component;

public interface ComponentRepository extends JpaRepository<Component, String> {

	public Component findOneByComponentName(String componentName);

	public Optional<Component> findById(String id);


}