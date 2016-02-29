package edu.ccai6.cs221.queryBeans;

public class QueryWords {
	private String query = null;

	public QueryWords(String query) {
		super();
		this.query = query;
	}

	public QueryWords() {
		super();
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
