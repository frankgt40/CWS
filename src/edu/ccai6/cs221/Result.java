package edu.ccai6.cs221;

public class Result {
	private String title;
	private String url;
	private String paragraph;
	private String rank;
	public Result(String title, String url, String paragraph, String rank) {
		super();
		this.title = title;
		this.url = url;
		this.paragraph = paragraph;
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParagraph() {
		return paragraph;
	}
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
