package com.don.board.model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDB {

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

	// 회원가입
	public void memberJoin(String loginId, String loginPw, String name) {

		String sql = String.format("INSERT INTO `member` SET regDate=NOW(), loginId='%s', loginPw='%s', `name`='%s'",
				loginId, loginPw, name);

		updateQuery(sql);
	}

	// 로그인 정보와 일치하는 회원번호 가져오기
	public int getMemberIdxByLoginInfo(String loginId, String loginPw) {

		String sql = String.format("SELECT idx FROM `member` WHERE loginId='%s' AND loginPw='%s'", loginId, loginPw);

		Connection conn = getConnection();
		int foundMemberIdx = 0;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				foundMemberIdx = rs.getInt("idx");
			}

		} catch (Exception e) {
			System.out.println("로그인 정보를 가져오는 중 문제 발생");
		}

		return foundMemberIdx;
	}

	// 회원번호에 해당하는 회원객체 가져오기
	public Member getMemberBymemberIdx(int memberIdx) {

		Member foundMember = null;

		String sql = String.format("SELECT * FROM `member` WHERE idx=%d", memberIdx);

		ArrayList<Member> memberList = getMemberList(sql); // 전체 회원 중 회원번호와 일치하는 회원 가져오기

		if (memberList.size() > 0) {
			foundMember = memberList.get(0);
		}

		return foundMember;
	}

	// 전체 회원 가져오기
	private ArrayList<Member> getMemberList(String sql) {

		Connection conn = getConnection();

		ArrayList<Member> memberList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int idx = rs.getInt("idx");
				String regDate = rs.getString("regDate");
				String loginId = rs.getString("loginId");
				String loginPw = rs.getString("loginPw");
				String name = rs.getString("name");

				Member member = new Member(idx, regDate, loginId, loginPw, name);
				memberList.add(member);
			}

		} catch (SQLException e) {
			System.out.println("회원 목록 가져오는 중 문제발생");
		}

		return memberList;
	}

}
