package edu.ccai6.cs221.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccai6.cs221.mapper.IFIDFMapper;
import edu.ccai6.cs221.mapper.URLMapper;

public class URLDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public URL getURL(String docID) {
		String sql = "SELECT * FROM urlset WHERE id_URL = ?";
		URL rsl = jdbcTemplateObject.queryForObject(sql, new Object[] { docID }, new URLMapper());
		return rsl;
	}
}
