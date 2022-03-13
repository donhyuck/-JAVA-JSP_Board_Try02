package com.don.board;

public class Reply {

	private int idx;
	private String regDate;
	private int articleIdx;
	private int memberIdx;
	private String body;
	private String name;

	public Reply(int idx, String regDate, int articleIdx, int memberIdx, String body, String name) {
		super();
		this.idx = idx;
		this.regDate = regDate;
		this.articleIdx = articleIdx;
		this.memberIdx = memberIdx;
		this.body = body;
		this.name = name;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
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

	public int getArticleIdx() {
		return articleIdx;
	}

	public void setArticleIdx(int articleIdx) {
		this.articleIdx = articleIdx;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
