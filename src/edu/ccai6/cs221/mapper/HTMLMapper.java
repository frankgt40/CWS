package edu.ccai6.cs221.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.ccai6.cs221.dao.HTML;
import edu.ccai6.cs221.dao.IFIDF;

public class HTMLMapper implements RowMapper<HTML>{
	public HTML mapRow(ResultSet rs, int rowNum) throws SQLException {
		HTML html = new HTML();
		html.set_id(""+rs.getInt("id_URL"));
		html.set_html(rs.getString("html"));
		return html;
	}
}
