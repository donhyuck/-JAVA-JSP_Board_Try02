package com.don.board.model.address;

public class Address {

	private int idx;
	private String addr;
	private String phone;
	private String name;

	public Address(int idx, String addr, String phone, String name) {
		super();
		this.idx = idx;
		this.addr = addr;
		this.phone = phone;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
