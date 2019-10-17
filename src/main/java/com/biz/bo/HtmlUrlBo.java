package com.biz.bo;

import com.biz.bean.HtmlUrl;

public class HtmlUrlBo {
	private String id;
	private String text;
	private String href;
	
	public HtmlUrlBo(HtmlUrl htmlUrl) {
		this.id = htmlUrl.getId();
		this.text = htmlUrl.getText();
		this.href = htmlUrl.getHref();
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
