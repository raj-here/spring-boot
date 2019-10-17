package com.biz.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.biz.bo.HtmlUrlBo;

@Entity
@Table(name = "html_url")
public class HtmlUrl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Size(max = 100)
	@Column(name = "url_text")
	private String text;

	@Size(max = 100)
	@Column(name = "url_href")
	private String href;
	
	public HtmlUrl() {
		super();
	}
	
	public HtmlUrl(HtmlUrlBo htmlUrlBo) {
		super();
		this.id = htmlUrlBo.getId();
		this.text = htmlUrlBo.getText();
		this.href = htmlUrlBo.getHref();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
