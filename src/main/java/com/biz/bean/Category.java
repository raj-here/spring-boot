package com.biz.bean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.biz.bo.CategoryBo;
import com.biz.enums.ReseachToolEnum.CategotyType;

@Entity
@Table(name = "Categories")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Size(max = 100)
	@Column(name = "category_name")
	private String categoryName;

	@NotNull
	@Column(name = "category_type")
	@Enumerated(EnumType.STRING)
	private CategotyType type;

	@NotNull
	@Size(max = 100)
	@Column(name = "icon_url")
	private String iconUrl;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private List<Component> components;

	public Category() {
		super();
	}

	public Category(CategoryBo categoryBo) {
		super();
		this.id = categoryBo.getId();
		this.categoryName = categoryBo.getCategoryName();
		this.type = categoryBo.getType();
		this.iconUrl = categoryBo.getIconUrl();
		this.components = categoryBo.getComponent().stream().map(Component::new).collect(Collectors.toList());
		;
	}

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
