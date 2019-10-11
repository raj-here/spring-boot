package test;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RTFParsedData {
	private Link link;
	private String source;
	private Date publishedDate;
	private String language;
	private String description;
	private RTFMetaData metaData;
	
	public RTFParsedData(Link link, String source, Date publishedDate, String language, String description,
			RTFMetaData metaData) {
		super();
		this.link = link;
		this.source = source;
		this.publishedDate = publishedDate;
		this.language = language;
		this.description = description;
		this.metaData = metaData;
	}

	@JsonProperty("link")
	public Link getLink() {
		return link;
	}

	@JsonProperty("link")
	public void setLink(Link value) {
		this.link = value;
	}

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(String value) {
		this.source = value;
	}

	@JsonProperty("publishedDate")
	public Date getPublishedDate() {
		return publishedDate;
	}

	@JsonProperty("publishedDate")
	public void setPublishedDate(Date value) {
		this.publishedDate = value;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String value) {
		this.language = value;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String value) {
		this.description = value;
	}

	@JsonProperty("metaData")
	public RTFMetaData getMetaData() {
		return metaData;
	}

	@JsonProperty("metaData")
	public void setMetaData(RTFMetaData value) {
		this.metaData = value;
	}
}