package com.don.board.model.article;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyRowMapper implements RowMapper<Reply> {

	@Override
	public Reply getRow(ResultSet rs) throws SQLException {

		int idx = rs.getInt("idx");
		String regDate = rs.getString("regDate");
		int articleIdx = rs.getInt("articleIdx");
		String body = rs.getString("body");
		String name = rs.getString("name");

		Reply reply = new Reply(idx, regDate, articleIdx, body, name);

		return reply;
	}

}
