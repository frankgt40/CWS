package edu.ccai6.cs221.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccai6.cs221.mapper.TextMapper;
import edu.ccai6.cs221.mapper.URLMapper;

public class TextDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Text getText(String docID) {
		String sql = "SELECT * FROM text_set WHERE id_URL = ?";
		Text rsl = jdbcTemplateObject.queryForObject(sql, new Object[] { docID }, new TextMapper());
		return rsl;
	}
}
