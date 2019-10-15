package com.biz.bo;

import java.util.List;

import com.biz.bean.Component;
import com.biz.bean.ComponentDetail;

public class ComponentBo {
	private String id;
	private String componentName;
	private boolean hasChildrens;
	private String iconUrl;
	private ComponentDetailsBo componentDetail;
	private List<ComponentBo> subComponets;

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

	public ComponentDetailsBo getComponentDetail() {
		return componentDetail;
	}

	public void setComponentDetail(ComponentDetailsBo componentDetail) {
		this.componentDetail = componentDetail;
	}

	public List<ComponentBo> getSubComponets() {
		return subComponets;
	}

	public void setSubComponets(List<ComponentBo> subComponets) {
		this.subComponets = subComponets;
	}

}
