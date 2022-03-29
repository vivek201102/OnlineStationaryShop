package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.order.CartGenerate;

public class RowMappingCartGenerate implements RowMapper<CartGenerate>{

	public CartGenerate mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try
		{
		CartGenerate cartgen = new CartGenerate();
		cartgen.setId(rs.getInt("id"));
		cartgen.setCartdate(rs.getString("cartdate"));
		cartgen.setUserId(rs.getInt("userId"));
		return cartgen;
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
}
