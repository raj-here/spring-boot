package com.biz.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.biz.bo.ComponentDetailsBo;

@Entity
@Table(name = "component_details")
public class ComponentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@Size(max = 100)
	@Column(name = "description")
	private String description;

	@NotNull
	@Size(max = 100)
	@Column(name = "published_date")
	private Date publishedDate;

	@JoinColumn(name = "link_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<HtmlUrl> links;
	
	public ComponentDetail() {
		super();
	}

	public ComponentDetail(ComponentDetailsBo componentDetailsBo) {
		super();
		this.id = componentDetailsBo.getId();
		this.description = componentDetailsBo.getDescription();
		this.publishedDate = componentDetailsBo.getPublishedDate();
		this.links = componentDetailsBo.getLinks().stream().map(HtmlUrl::new).collect(Collectors.toList());
	}

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

	public List<HtmlUrl> getLinks() {
		return links;
	}

	public void setLinks(List<HtmlUrl> links) {
		this.links = links;
	}

}
