package edu.ccai6.cs221.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.ccai6.cs221.dao.IFIDF;
import edu.ccai6.cs221.dao.URL;

public class URLMapper implements RowMapper<URL> {
	public URL mapRow(ResultSet rs, int rowNum) throws SQLException {
		URL url = new URL();
		url.set_id(""+rs.getInt("id_URL"));
		url.set_url(rs.getString("URL"));
		return url;
	}
}