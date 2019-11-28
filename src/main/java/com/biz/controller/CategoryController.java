package com.biz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.Category;
import com.biz.bean.Component;
import com.biz.bo.CategoryBo;
import com.biz.enums.ReseachToolEnum.CategotyType;
import com.biz.service.CategoryService;
import com.biz.service.ComponentService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ComponentService componetService;

	@RequestMapping(path = { "", "/getAll" }, method = RequestMethod.GET)
	public List<CategoryBo> getAllRootCategory() {
		return categoryService.findAll().stream().map(CategoryBo::new).collect(Collectors.toList());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Category getById(@PathVariable("id") String id) {
		System.out.println("id" + id);
		return categoryService.findOne(id);
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveComponent() {

		Category cat1 = new Category();
		cat1.setCategoryName("Onbording");
		cat1.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat1.setType(CategotyType.STANDARD);

		Category cat2 = new Category();
		cat2.setCategoryName("Knowledge Link");
		cat2.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat2.setType(CategotyType.STANDARD);

		Category cat3 = new Category();
		cat3.setCategoryName("Reaserch Analysis");
		cat3.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat3.setType(CategotyType.STANDARD);

		Category cat4 = new Category();
		cat4.setCategoryName("RMS Guidelines");
		cat4.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat4.setType(CategotyType.STANDARD);

		Category cat5 = new Category();
		cat5.setCategoryName("Navigator Tool");
		cat5.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat5.setType(CategotyType.STANDARD);

		Category cat6 = new Category();
		cat6.setCategoryName("DRS Workdesk");
		cat6.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat6.setType(CategotyType.STANDARD);

		Category cat7 = new Category();
		cat7.setCategoryName("DRS Collaborations");
		cat7.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat7.setType(CategotyType.STANDARD);

		Category cat8 = new Category();
		cat8.setCategoryName("PUBLIC SOURCE");
		cat8.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat8.setType(CategotyType.PUBLIC_SOURCE);

		Category cat9 = new Category();
		cat9.setCategoryName("QUICK PART");
		cat9.setIconUrl("https://image.flaticon.com/icons/png/512/97/97895.png");
		cat9.setType(CategotyType.QUICK_PART);

		List<Component> comList = new ArrayList<Component>();
		Component com = componetService.findByComponentName("Component");

		if (com != null) {
			System.out.println("Componnet Id - >" + com.getComponentName());
			comList.add(com);
			cat1.setComponent(comList);
		}

		List<Category> catList = new ArrayList<Category>();
		catList.add(cat1);
		catList.add(cat2);
		catList.add(cat3);
		catList.add(cat4);
		catList.add(cat5);
		catList.add(cat6);
		catList.add(cat7);
		catList.add(cat8);
		catList.add(cat9);

		categoryService.saveAll(catList);
	}

}
