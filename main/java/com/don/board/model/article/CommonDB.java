package com.don.board.model.article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommonDB {

	// DBMS 접속정보 세팅
	String url = "jdbc:mysql://localhost:3306/jsptry?serverTimezone=UTC";
	String user = "root";
	String pass = "";

	// 드라이버 정보
	String driver = "com.mysql.cj.jdbc.Driver";

	public Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			System.out.println("Connection 중 문제 발생");
		}

		return conn;
	}

	// 연결과 쿼리 부분에서의 공통부분을 묶는다.
	public void updateQuery(String sql) {

		Connection conn = getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public <T> ArrayList<T> selectList(String sql, RowMapper<T> mapper) {

		Connection conn = getConnection();

		ArrayList<T> resultList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// 데이터 형에 따라 구분
				T row = mapper.getRow(rs);
				resultList.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	// 한개 가져오기
	public <T> T getOne(String sql, RowMapper<T> mapper) {

		T result = null;

		ArrayList<T> resultList = selectList(sql, mapper);

		if (resultList.size() > 0) {
			result = resultList.get(0);
		}

		return result;
	}

}
