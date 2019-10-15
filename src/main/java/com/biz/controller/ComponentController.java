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
		comDetails.setDescription("RMS");

		Component com = new Component();
		com.setComponentName("Component");
		com.setComponentDetail(comDetails);
		com.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		// Level 2
		ComponentDetail comDetails1 = new ComponentDetail();
		comDetails1.setDescription("RMS 1");
		ComponentDetail comDetails2 = new ComponentDetail();
		comDetails2.setDescription("RMS 2");
		ComponentDetail comDetails3 = new ComponentDetail();
		comDetails3.setDescription("RMS 3");

		Component com1 = new Component();
		com1.setComponentName("Component 1");
		com1.setComponentDetail(comDetails1);
		com1.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		Component com2 = new Component();
		com2.setComponentName("Component 2");
		com2.setComponentDetail(comDetails2);
		com2.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		Component com3 = new Component();
		com3.setComponentName("Component 3");
		com3.setComponentDetail(comDetails3);
		com3.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		// Level 3
		ComponentDetail comDetails11 = new ComponentDetail();
		comDetails11.setDescription("RMS 11");
		ComponentDetail comDetails22 = new ComponentDetail();
		comDetails22.setDescription("RMS 22");
		ComponentDetail comDetails33 = new ComponentDetail();
		comDetails33.setDescription("RMS 33");

		Component com11 = new Component();
		com11.setComponentName("Component 11");
		com11.setComponentDetail(comDetails11);
		com11.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		Component com22 = new Component();
		com22.setComponentName("Component 22");
		com22.setComponentDetail(comDetails22);
		com22.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		Component com33 = new Component();
		com33.setComponentName("Component 33");
		com33.setComponentDetail(comDetails33);
		com33.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");

		List<Component> list1 = new ArrayList<Component>();
		list1.add(com1);
		list1.add(com2);
		list1.add(com3);

		List<Component> list11 = new ArrayList<Component>();
		list11.add(com11);
		list11.add(com22);
		list11.add(com33);

		com1.setSubComponets(list11);
		com1.setHasChildrens(true);

		com.setSubComponets(list1);
		com1.setHasChildrens(false);

		componetService.save(com);

	}

}
