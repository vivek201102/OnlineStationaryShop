package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.order.UserCart;

public class RowMappingUserCart implements RowMapper<UserCart>{

	@Override
	public UserCart mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
			UserCart usercart = new UserCart();
			usercart.setId(rs.getInt("id"));
			usercart.setCartId(rs.getInt("cartId"));
			usercart.setDatetime(rs.getString("datetime"));
			usercart.setProdCount(rs.getInt("prodCount"));
			usercart.setProdId(rs.getString("prodId"));
			usercart.setProdName(rs.getString("prodName"));
			usercart.setProdPrice(rs.getInt("prodPrice"));
			usercart.setUserId(rs.getInt("userId"));
			return usercart;
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				return null;
			}
	}
	
}
