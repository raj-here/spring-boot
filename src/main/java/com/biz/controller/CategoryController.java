package com.biz.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bean.CategoryDetails;
import com.biz.bean.Category;
import com.biz.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = { "", "/getAll" })
	public List<Category> getBooks() {
		return categoryService.findAll();
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveComponent() {

		// Level 1
		CategoryDetails catDeatsils = new CategoryDetails();
		catDeatsils.setName("RMS");

		Category cat = new Category();
		cat.setCotegoryName("Category");
		cat.setHasChildrens(true);
		cat.setCotegoryDetails(catDeatsils);
		cat.setHasChildrens(true);

		// Level 2
		CategoryDetails catDeatsils1 = new CategoryDetails();
		catDeatsils1.setName("RMS 1");
		CategoryDetails catDeatsils2 = new CategoryDetails();
		catDeatsils2.setName("RMS 2");
		CategoryDetails catDeatsils3 = new CategoryDetails();
		catDeatsils3.setName("RMS 3");

		Category cat1 = new Category();
		cat1.setCotegoryName("Category 1");
		cat1.setHasChildrens(true);
		cat1.setCotegoryDetails(catDeatsils1);
		cat1.setHasChildrens(true);

		Category cat2 = new Category();
		cat2.setCotegoryName("Category 2");
		cat2.setHasChildrens(true);
		cat2.setCotegoryDetails(catDeatsils2);
		cat2.setHasChildrens(true);

		Category cat3 = new Category();
		cat3.setCotegoryName("Category 3");
		cat3.setHasChildrens(true);
		cat3.setCotegoryDetails(catDeatsils3);
		cat3.setHasChildrens(true);

		// Level 3
		CategoryDetails catDeatsils11 = new CategoryDetails();
		catDeatsils11.setName("RMS 11");
		CategoryDetails catDeatsils22 = new CategoryDetails();
		catDeatsils22.setName("RMS 22");
		CategoryDetails catDeatsils33 = new CategoryDetails();
		catDeatsils33.setName("RMS 33");

		Category cat11 = new Category();
		cat11.setCotegoryName("Category 11");
		cat11.setHasChildrens(true);
		cat11.setCotegoryDetails(catDeatsils11);
		cat11.setHasChildrens(true);

		Category cat22 = new Category();
		cat22.setCotegoryName("Category 22");
		cat22.setHasChildrens(true);
		cat22.setCotegoryDetails(catDeatsils22);
		cat22.setHasChildrens(true);

		Category cat33 = new Category();
		cat33.setCotegoryName("Category 33");
		cat33.setHasChildrens(true);
		cat33.setCotegoryDetails(catDeatsils33);
		cat33.setHasChildrens(true);

		Set<Category> set1 = new HashSet<Category>();
		set1.add(cat1);
		set1.add(cat2);
		set1.add(cat3);

		Set<Category> set2 = new HashSet<Category>();
		set2.add(cat11);
		set2.add(cat22);
		set2.add(cat33);

		cat1.setSubCategories(set2);
		cat.setSubCategories(set1);

		categoryService.save(cat);

	}

}
