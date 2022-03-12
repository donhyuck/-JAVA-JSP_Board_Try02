package com.don.board;

public class Member {

	private int idx;
	private String regDate;
	private String loginId;
	private String loginPw;
	private String name;

	public Member(int idx, String regDate, String loginId, String loginPw, String name) {
		super();
		this.idx = idx;
		this.regDate = regDate;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
