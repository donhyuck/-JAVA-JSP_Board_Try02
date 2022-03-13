package com.don.board.model.address;

import java.util.ArrayList;

import com.don.board.model.article.CommonDB;

public class AddressDB {

	CommonDB cdb = new CommonDB();

	public ArrayList<Address> getAddresses() {

		String sql = "SELECT * FROM address";

		return cdb.selectList(sql, new AddressRowMapper());
	}

}
