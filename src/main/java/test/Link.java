package test;

import com.fasterxml.jackson.annotation.*;

public class Link {
	private String url;
	private String text;
	
	public Link(String url, String text) {
		super();
		this.url = url;
		this.text = text;
	}

	@JsonProperty("url")
	public String getURL() {
		return url;
	}

	@JsonProperty("url")
	public void setURL(String value) {
		this.url = value;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String value) {
		this.text = value;
	}
}