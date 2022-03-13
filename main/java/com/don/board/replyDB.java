package com.don.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
}
