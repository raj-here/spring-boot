package test;

import com.fasterxml.jackson.annotation.*;

public class RTFMetaData {
	private long wordCount;
	private String author;

	public RTFMetaData(long wordCount, String author) {
		super();
		this.wordCount = wordCount;
		this.author = author;
	}

	@JsonProperty("wordCount")
	public long getWordCount() {
		return wordCount;
	}

	@JsonProperty("wordCount")
	public void setWordCount(long value) {
		this.wordCount = value;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String value) {
		this.author = value;
	}
}