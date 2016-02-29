package edu.ccai6.cs221.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.ccai6.cs221.dao.IFIDF;
import edu.ccai6.cs221.dao.Text;

public class TextMapper implements RowMapper<Text> {
	public Text mapRow(ResultSet rs, int rowNum) throws SQLException {
		Text text = new Text();
		text.set_id(""+rs.getInt("id_URL"));
		text.set_text(rs.getString("text"));
		return text;
	}
}
