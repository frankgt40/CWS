package edu.ccai6.cs221.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.ccai6.cs221.dao.IFIDF;

public class IFIDFMapper implements RowMapper<IFIDF> {
	public IFIDF mapRow(ResultSet rs, int rowNum) throws SQLException {
		IFIDF ifidf = new IFIDF();
		ifidf.set_token(rs.getString("token"));
		ifidf.set_value(rs.getString("ifidf_value"));
		return ifidf;
	}
}