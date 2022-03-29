package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.Items.Pen;
import com.stationary.Items.Pen;

public class RowMappingPen implements RowMapper<Pen>{

	@Override
	public Pen mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
		Pen c = new Pen();
		c.setCompName(rs.getString("compName"));
		c.setDes(rs.getString("des"));
		c.setId(rs.getInt("id"));
		c.setImage(rs.getString("image"));
		c.setpId(rs.getString("pId"));
		c.setpName(rs.getString("pName"));
		c.setPrice(rs.getInt("price"));
		c.setStock(rs.getInt("stock"));
		c.setColor(rs.getString("color"));
		return c;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
