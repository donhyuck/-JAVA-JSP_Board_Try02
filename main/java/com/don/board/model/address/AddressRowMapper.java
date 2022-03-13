package com.don.board.model.address;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.don.board.model.article.Article;
import com.don.board.model.article.RowMapper;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address getRow(ResultSet rs) throws SQLException {

		int idx = rs.getInt("idx");
		String addr = rs.getString("addr");
		String phone = rs.getString("phone");
		String name = rs.getString("name");

		Address address = new Address(idx, addr, phone, name);

		return address;
	}

}
