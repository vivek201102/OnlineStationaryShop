package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.Items.Desk;
import com.stationary.Items.Desk;

public class RowMappingDesk implements RowMapper<Desk>{

	@Override
	public Desk mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
		Desk c = new Desk();
		c.setCompName(rs.getString("compName"));
		c.setDes(rs.getString("des"));
		c.setId(rs.getInt("id"));
		c.setImage(rs.getString("image"));
		c.setpId(rs.getString("pId"));
		c.setpName(rs.getString("pName"));
		c.setPrice(rs.getInt("price"));
		c.setStock(rs.getInt("stock"));
		c.setMaterial(rs.getString("material"));
		return c;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
