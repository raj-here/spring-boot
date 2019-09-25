package com.biz.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	@Column(name = "category_name")
	private String cotegoryName;

	@NotNull
	@Column(name = "has_childrens")
	private boolean hasChildrens;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private CategoryDetails cotegoryDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Set<Category> subcategories;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCotegoryName() {
		return cotegoryName;
	}

	public void setCotegoryName(String cotegoryName) {
		this.cotegoryName = cotegoryName;
	}

	public boolean isHasChildrens() {
		return hasChildrens;
	}

	public void setHasChildrens(boolean hasChildrens) {
		this.hasChildrens = hasChildrens;
	}

	public CategoryDetails getCotegoryDetails() {
		return cotegoryDetails;
	}

	public void setCotegoryDetails(CategoryDetails cotegoryDetails) {
		this.cotegoryDetails = cotegoryDetails;
	}

	public Set<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<Category> subcategories) {
		this.subcategories = subcategories;
	}

}
