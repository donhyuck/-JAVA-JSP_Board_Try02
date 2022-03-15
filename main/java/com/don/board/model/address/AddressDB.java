package com.don.board.model.address;

import java.util.ArrayList;

import com.don.board.model.article.CommonDB;

public class AddressDB {

	CommonDB cdb = new CommonDB();

	public ArrayList<Address> getAddresses() {

		String sql = "SELECT * FROM address";

		return cdb.selectList(sql, new AddressRowMapper());
	}

	// 주소록 등록하기
	public void addressWrite(String addr, String phone, String name) {

		String sql = String.format("INSERT INTO address SET addr='%s', phone='%s', `name`='%s'", addr, phone, name);

		cdb.updateQuery(sql);
	}

	// 주소록 검색하기
	public ArrayList<Address> getAddressListByKeyword(String infoType, String keyword) {

		String sql = String.format("SELECT * FROM address WHERE `%s` LIKE CONCAT('%%', '%s', '%%')", infoType, keyword);

		return cdb.selectList(sql, new AddressRowMapper());
	}

	public Address getAddressByIdx(int idx) {

		String sql = String.format("SELECT * FROM address WHERE idx=%d", idx);

		return cdb.getOne(sql, new AddressRowMapper());
	}

	// 주소록 수정하기
	public void addressModify(int idx, String addr, String phone) {

		String sql = String.format("UPDATE address SET addr='%s', phone='%s' WHERE idx=%d", addr, phone, idx);

		cdb.updateQuery(sql);
	}

}
