package com.don.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleDB {

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

	// 게시글 작성
	public void articleWrite(String title, String body, String name) {

		String sql = String.format(
				"INSERT INTO article SET regDate=NOW(), updateDate=NOW(), title='%s', `body`='%s', `name`='%s'", title,
				body, name);

		Connection conn = getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("게시글 작성 중 문제발생");
		}
	}

	// 게시글 목록 가져오기(sql에 따라 한개 혹은 여러개)
	public ArrayList<Article> getArticleList(String sql) {

		Connection conn = getConnection();

		ArrayList<Article> articleList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int idx = rs.getInt("idx");
				String regDate = rs.getString("regDate");
				String updateDate = rs.getString("updateDate");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String name = rs.getString("name");

				Article article = new Article(idx, regDate, updateDate, title, body, name);
				articleList.add(article);
			}

		} catch (SQLException e) {
			System.out.println("게시글 목록 가져오는 중 문제발생");
		}

		return articleList;
	}

	// 한개 가져오기
	public Article getArticleByIdx(int idx) {

		Article foundArticle = null;

		String sql = String.format("SELECT * FROM article WHERE idx=%d", idx);

		ArrayList<Article> articleList = getArticleList(sql);

		if (articleList.size() > 0) {
			foundArticle = articleList.get(0);
		}

		return foundArticle;
	}

	// 여러개 가져오기
	public ArrayList<Article> getArticles() {

		String sql = "SELECT * FROM article";

		ArrayList<Article> articles = getArticleList(sql);

		return articles;
	}

	// 게시글 수정하기
	public void articleModify(int idx, String title, String body) {

		String sql = String.format("UPDATE article SET updateDate=NOW(), title='%s', `body`='%s' WHERE idx=%d", title,
				body, idx);

		Connection conn = getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("게시글 수정 중 문제발생");
		}

	}

	// 게시글 삭제하기
	public void articleDelete(int idx) {

		String sql = String.format("DELETE FROM article WHERE idx=%d", idx);

		Connection conn = getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("게시글 삭제 중 문제발생");
		}

	}
}
