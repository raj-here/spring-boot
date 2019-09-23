package com.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Component;
import com.biz.service.ComponentService;

@RestController
@RequestMapping(value = "/component")
public class ComponentController {

	@Autowired
	private ComponentService componentService;

	@RequestMapping(path = { "", "/getAll" })
	public List<Component> getBooks() {
		return componentService.findAll();
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveComponent(@ModelAttribute("component") Component component) {
		componentService.save(component);
	}

}
