package com.biz.bo;

import java.util.List;

import com.biz.bean.Component;
import com.biz.enums.ReseachToolEnum.CategotyType;

public class CategoryBo {

	private String id;
	private String categoryName;
	private CategotyType type;
	private String iconUrl;
	private List<Component> components;

	public String getId() {
		return id;
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

	public List<Component> getComponent() {
		return components;
	}

	public void setComponent(List<Component> components) {
		this.components = components;
	}

}
