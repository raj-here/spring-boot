package com.biz.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.biz.bo.ComponentBo;

@Entity
@Table(name = "components")
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Size(max = 100)
	@Column(name = "component_name")
	private String componentName;

	@NotNull
	@Column(name = "has_childrens")
	private boolean hasChildrens;

	@NotNull
	@Size(max = 100)
	@Column(name = "icon_url")
	private String iconUrl;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private ComponentDetail componentDetail;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private List<Component> subComponets;

	public Component() {
		super();
	}
	
	public Component(ComponentBo componentBo) {
		super();
		this.id = componentBo.getId();
		this.componentName = componentBo.getComponentName();
		this.hasChildrens = componentBo.isHasChildrens();
		this.iconUrl = componentBo.getIconUrl();
//		this.componentDetail = componentBo.getComponentDetail();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public boolean isHasChildrens() {
		return hasChildrens;
	}

	public void setHasChildrens(boolean hasChildrens) {
		this.hasChildrens = hasChildrens;
	}

	public ComponentDetail getComponentDetail() {
		return componentDetail;
	}

	public void setComponentDetail(ComponentDetail componentDetail) {
		this.componentDetail = componentDetail;
	}

	public List<Component> getSubComponets() {
		return subComponets;
	}

	public void setSubComponets(List<Component> subComponets) {
		this.subComponets = subComponets;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

}
