package com.biz.bo;

import java.util.Date;
import java.util.List;

public class ComponentDetailsBo {
	private String id;
	private String description;
	private Date publishedDate;
	private List<HtmlUrlBo> links;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public List<HtmlUrlBo> getLinks() {
		return links;
	}

	public void setLinks(List<HtmlUrlBo> links) {
		this.links = links;
	}

}
