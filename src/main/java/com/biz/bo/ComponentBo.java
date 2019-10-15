package com.biz.bo;

import java.util.List;

import com.biz.bean.Component;
import com.biz.bean.ComponentDetail;

public class ComponentBo {
	private String id;
	private String componentName;
	private boolean hasChildrens;
	private String iconUrl;
	private ComponentDetail componentDetail;
	private List<Component> subComponets;

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

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
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

}
