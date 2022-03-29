package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.Items.Book;


public class RowMappingBook implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
		Book c = new Book();
		c.setCompName(rs.getString("compName"));
		c.setDes(rs.getString("des"));
		c.setId(rs.getInt("id"));
		c.setImage(rs.getString("image"));
		c.setpId(rs.getString("pId"));
		c.setpName(rs.getString("pName"));
		c.setPrice(rs.getInt("price"));
		c.setStock(rs.getInt("stock"));
		c.setAuthor(rs.getString("author"));
		c.setPages(rs.getInt("pages"));
		return c;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
