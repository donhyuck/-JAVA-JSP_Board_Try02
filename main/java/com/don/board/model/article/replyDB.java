package com.don.board.model.article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class replyDB {

	CommonDB cdb = new CommonDB();

	// 댓글 등록하기
	public void replyWrite(int articleIdx, String body, String name) {

		String sql = String.format(
				"INSERT INTO articleReply SET regDate=NOW(), articleIdx=%d, `body`='%s', `name`='%s'", articleIdx, body,
				name);

		cdb.updateQuery(sql);

	}

	// 게시글에 해당하는 댓글 목록 가져오기
	public ArrayList<Reply> getReplyListByArticleIdx(int articleIdx) {

		String sql = String.format("SELECT * FROM articleReply WHERE articleIdx=%d", articleIdx);

		return cdb.selectList(sql, new ReplyRowMapper());
	}

	public Reply getReplyByIdx(int idx) {

		String sql = String.format("SELECT * FROM articleReply WHERE idx=%d", idx);

		return cdb.getOne(sql, new ReplyRowMapper());
	}

	public void replyModify(int idx, String body) {

		String sql = String.format("UPDATE articleReply SET regDate=NOW(), `body`='%s' WHERE idx='%d'", body, idx);

		cdb.updateQuery(sql);
	}

	public void replyDelete(int idx) {

		String sql = String.format("DELETE FROM articleReply WHERE idx=%d", idx);

		cdb.updateQuery(sql);
	}
}
