package com.stationary.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.entities.admin;

public class RowMappingAdmin implements RowMapper<admin>{

	@Override
	public admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
			admin a = new admin();
			a.setId(rs.getInt("id"));
			a.setUserId(rs.getInt("userId"));
			return a;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
