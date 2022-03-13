package com.don.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class replyDB {

	// DBMS 접속정보 세팅
	String url = "jdbc:mysql://localhost:3306/jsptry?serverTimezone=UTC";
	String user = "root";
	String pass = "";

	// 드라이버 정보
	String driver = "com.mysql.cj.jdbc.Driver";

	private Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			System.out.println("Connection 중 문제 발생");
		}

		return conn;
	}

	private void updateQuery(String sql) {

		Connection conn = getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 댓글 등록하기
	public void replyWrite(int articleIdx, String body, String name) {

		String sql = String.format(
				"INSERT INTO articleReply SET regDate=NOW(), articleIdx=%d, `body`='%s', `name`='%s'", articleIdx, body,
				name);

		updateQuery(sql);

	}

	// 게시글에 해당하는 댓글 목록 가져오기
	public ArrayList<Reply> getReplyListByArticleIdx(int articleIdx) {

		String sql = String.format("SELECT * FROM articleReply WHERE articleIdx=%d", articleIdx);

		return getReplyList(sql);
	}

	// 댓글 목록 가져오기(sql에 따라 한개 혹은 여러개)
	private ArrayList<Reply> getReplyList(String sql) {

		Connection conn = getConnection();

		ArrayList<Reply> replyList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int idx = rs.getInt("idx");
				String regDate = rs.getString("regDate");
				int articleIdx = rs.getInt("articleIdx");
				String body = rs.getString("body");
				String name = rs.getString("name");

				Reply reply = new Reply(idx, regDate, articleIdx, body, name);
				replyList.add(reply);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return replyList;
	}
}
