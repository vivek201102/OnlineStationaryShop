package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.order.Orderdetail;

public class RowMappingOrderDetail implements RowMapper<Orderdetail>{

	@Override
	public Orderdetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			Orderdetail od = new Orderdetail();
			od.setId(rs.getInt("id"));
			od.setCartId(rs.getInt("cartId"));
			od.setOrderId(rs.getString("orderId"));
			od.setUserId(rs.getInt("userId"));
			od.setOrderingDate(rs.getString("orderingDate"));
			od.setTotal(rs.getInt("total"));
			od.setGrandTotal(rs.getInt("grandTotal"));
			return od;
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				return null;
			}
	}

}
