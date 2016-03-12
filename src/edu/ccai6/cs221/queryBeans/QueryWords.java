package edu.ccai6.cs221.queryBeans;

public class QueryWords {
	private String query = null;
	private boolean improvedVersion = false;
	public QueryWords() {
		super();
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public boolean isImprovedVersion() {
		return improvedVersion;
	}
	public void setImprovedVersion(boolean improvedVersion) {
		this.improvedVersion = improvedVersion;
	}

}
