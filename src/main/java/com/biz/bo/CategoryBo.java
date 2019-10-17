package com.biz.bo;

import java.util.List;
import java.util.stream.Collectors;

import com.biz.bean.Category;
import com.biz.enums.ReseachToolEnum.CategotyType;

public class CategoryBo {

	private String id;
	private String categoryName;
	private CategotyType type;
	private String iconUrl;
	private List<ComponentBo> components;

	public String getId() {
		return id;
	}

	public CategoryBo(Category category) {
		this.id = category.getId();
		this.categoryName = category.getCategoryName();
		this.type = category.getType();
		this.iconUrl = category.getIconUrl();
		this.components = category.getComponent().stream().map(ComponentBo::new).collect(Collectors.toList());
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategotyType getType() {
		return type;
	}

	public void setType(CategotyType type) {
		this.type = type;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public List<ComponentBo> getComponent() {
		return components;
	}

	public void setComponent(List<ComponentBo> components) {
		this.components = components;
	}

}
