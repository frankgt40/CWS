package edu.ccai6.cs221.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccai6.cs221.mapper.HTMLMapper;

public class HTMLDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public HTML getHTML(String docID) {
		String sql = "SELECT * FROM html_set WHERE id_URL = ?";
		HTML rsl = jdbcTemplateObject.queryForObject(sql, new Object[] { docID }, new HTMLMapper());
		return rsl;
	}
}
