package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.Items.Calc;

public class RowMappingCalc implements RowMapper<Calc>{

	@Override
	public Calc mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
		Calc c = new Calc();
		c.setCompName(rs.getString("compName"));
		c.setDes(rs.getString("des"));
		c.setId(rs.getInt("id"));
		c.setImage(rs.getString("image"));
		c.setpId(rs.getString("pId"));
		c.setpName(rs.getString("pName"));
		c.setPrice(rs.getInt("price"));
		c.setStock(rs.getInt("stock"));
		c.setType(rs.getString("type"));
		return c;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
