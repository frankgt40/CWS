package edu.ccai6.cs221.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccai6.cs221.mapper.IFIDFMapper;

public class IFIDFDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public List<IFIDF> listIFIDFs() {
		String sql = "SELECT * FROM ifidf_table_bak";
		List<IFIDF> list = jdbcTemplateObject.query(sql, new IFIDFMapper());
		return list;
	}
	public IFIDF getIFIDF(String token) {
		String sql = "SELECT * FROM ifidf_table WHERE token = ?";
		IFIDF rsl = new IFIDF();
		try{
		rsl = jdbcTemplateObject.queryForObject(sql, 
                new Object[]{token}, new IFIDFMapper());
		} catch (Exception e) {
			e.printStackTrace();
			rsl.set_token("");
			rsl.set_value("");
		}
		return rsl;
	}
}
