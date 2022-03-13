package com.don.board.model.article;

import java.util.ArrayList;

public class ArticleDB {

	CommonDB cdb = new CommonDB();

	// 게시글 작성
	public void articleWrite(String title, String body, String name) {

		String sql = String.format(
				"INSERT INTO article SET regDate=NOW(), updateDate=NOW(), title='%s', `body`='%s', `name`='%s'", title,
				body, name);

		cdb.updateQuery(sql);
	}

	// 한개 가져오기
	public Article getArticleByIdx(int idx) {

		String sql = String.format("SELECT * FROM article WHERE idx=%d", idx);

		return cdb.getOne(sql, new ArticleRowMapper());
	}

	// 여러개 가져오기
	public ArrayList<Article> getArticles() {

		String sql = "SELECT * FROM article";

		return cdb.selectList(sql, new ArticleRowMapper());
	}

	// 게시글 수정하기
	public void articleModify(int idx, String title, String body) {

		String sql = String.format("UPDATE article SET updateDate=NOW(), title='%s', `body`='%s' WHERE idx=%d", title,
				body, idx);

		cdb.updateQuery(sql);
	}

	// 게시글 삭제하기
	public void articleDelete(int idx) {

		String sql = String.format("DELETE FROM article WHERE idx=%d", idx);

		cdb.updateQuery(sql);
	}
}
