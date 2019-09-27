package com.biz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Component;
import com.biz.bean.ComponentDetail;
import com.biz.service.ComponentService;

@RestController
@RequestMapping(value = "/component")
public class ComponentController {

	@Autowired
	private ComponentService componetService;

	@RequestMapping(path = { "", "/getAll" })
	public List<Component> getAllComponents() {
		return componetService.findAll();
	}

	@RequestMapping(path = "/save")
	public void saveComponents() {
		// Level 1
		ComponentDetail comDetails = new ComponentDetail();
		comDetails.setName("RMS");

		Component com = new Component();
		com.setComponentName("Component");
		com.setHasChildrens(true);
		com.setComponentDetail(comDetails);

		// Level 2
		ComponentDetail comDetails1 = new ComponentDetail();
		comDetails1.setName("RMS 1");
		ComponentDetail comDetails2 = new ComponentDetail();
		comDetails2.setName("RMS 2");
		ComponentDetail comDetails3 = new ComponentDetail();
		comDetails3.setName("RMS 3");

		Component com1 = new Component();
		com1.setComponentName("Component 1");
		com1.setHasChildrens(true);
		com1.setComponentDetail(comDetails1);
		com1.setHasChildrens(true);

		Component com2 = new Component();
		com2.setComponentName("Component 2");
		com2.setHasChildrens(true);
		com2.setComponentDetail(comDetails2);
		com2.setHasChildrens(true);

		Component com3 = new Component();
		com3.setComponentName("Component 3");
		com3.setHasChildrens(true);
		com3.setComponentDetail(comDetails3);
		com3.setHasChildrens(true);

		// Level 3
		ComponentDetail comDetails11 = new ComponentDetail();
		comDetails11.setName("RMS 11");
		ComponentDetail comDetails22 = new ComponentDetail();
		comDetails22.setName("RMS 22");
		ComponentDetail comDetails33 = new ComponentDetail();
		comDetails33.setName("RMS 33");

		Component com11 = new Component();
		com11.setComponentName("Component 11");
		com11.setHasChildrens(true);
		com11.setComponentDetail(comDetails11);
		com11.setHasChildrens(true);

		Component com22 = new Component();
		com22.setComponentName("Component 22");
		com22.setHasChildrens(true);
		com22.setComponentDetail(comDetails22);
		com22.setHasChildrens(true);

		Component com33 = new Component();
		com33.setComponentName("Component 33");
		com33.setHasChildrens(true);
		com33.setComponentDetail(comDetails33);
		com33.setHasChildrens(true);

		List<Component> list1 = new ArrayList<Component>();
		list1.add(com1);
		list1.add(com2);
		list1.add(com3);

		List<Component> list11 = new ArrayList<Component>();
		list11.add(com11);
		list11.add(com22);
		list11.add(com33);

		com1.setSubComponets(list11);

		com.setSubComponets(list1);

		componetService.save(com);

	}

}
