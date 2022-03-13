package com.don.board.model.article;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {

	@Override
	public Article getRow(ResultSet rs) throws SQLException {

		int idx = rs.getInt("idx");
		String regDate = rs.getString("regDate");
		String updateDate = rs.getString("updateDate");
		String title = rs.getString("title");
		String body = rs.getString("body");
		String name = rs.getString("name");

		Article article = new Article(idx, regDate, updateDate, title, body, name);

		return article;
	}

}
