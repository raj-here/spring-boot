package com.biz.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.biz.bo.HtmlUrlBo;

@Entity
@Table(name = "component_details")
public class ComponentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Size(max = 100)
	@Column(name = "description")
	private String description;

	@NotNull
	@Size(max = 100)
	@Column(name = "published_date")
	private Date publishedDate;

	@JoinColumn(name = "link_id")
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
