package com.don.board.model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

		Connection conn = cdb.getConnection();
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

		ArrayList<Member> memberList = cdb.selectList(sql, new MemberRowMapper()); // 전체 회원 중 회원번호와 일치하는 회원 가져오기

		if (memberList.size() > 0) {
			foundMember = memberList.get(0);
		}

		return foundMember;
	}
}
