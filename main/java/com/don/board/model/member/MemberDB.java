package com.don.board.model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.don.board.model.article.ArticleRowMapper;
import com.don.board.model.article.CommonDB;

public class MemberDB {

	CommonDB cdb = new CommonDB();

	// 회원가입
	public void memberJoin(String loginId, String loginPw, String name) {

		String sql = String.format("INSERT INTO `member` SET regDate=NOW(), loginId='%s', loginPw='%s', `name`='%s'",
				loginId, loginPw, name);

		cdb.updateQuery(sql);
	}

	// 로그인 정보와 일치하는 회원번호 가져오기
	public int getMemberIdxByLoginInfo(String loginId, String loginPw) {

		String sql = String.format("SELECT idx FROM `member` WHERE loginId='%s' AND loginPw='%s'", loginId, loginPw);

		return getMemberIdx(sql);
	}

	// 이름과 일치하는 회원번호 가져오기
	public int getMemberIdxByName(String name) {

		String sql = String.format("SELECT idx FROM `member` WHERE `name`='%s'", name);

		return getMemberIdx(sql);
	}

	// 공통코드 처리, 회원번호 가져오기
	private int getMemberIdx(String sql) {

		Connection conn = cdb.getConnection();
		int memberIdx = 0;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				memberIdx = rs.getInt("idx");
			}

		} catch (Exception e) {
			System.out.println("회원정보를 가져오는 중 문제 발생");
		}

		return memberIdx;
	}

	// 회원번호에 해당하는 회원객체 가져오기
	public Member getMemberBymemberIdx(int memberIdx) {

		String sql = String.format("SELECT * FROM `member` WHERE idx=%d", memberIdx);

		return cdb.getOne(sql, new MemberRowMapper());
	}

}
