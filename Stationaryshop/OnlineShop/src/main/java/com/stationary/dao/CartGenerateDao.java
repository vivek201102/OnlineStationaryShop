package com.stationary.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Rowmapper.RowMappingCartGenerate;
import com.stationary.order.CartGenerate;

@Repository
public class CartGenerateDao {
	@Autowired
	HibernateTemplate ht;
	@Autowired
	JdbcTemplate jt;
	
	
	@Transactional
	public int insertCart(CartGenerate c)
	{
		this.ht.save(c);
		return 1;
	}
	
	public CartGenerate getCart(int userid)
	{
		try {
			String query = "select * from cartgenerate where userId = ?";
			RowMapper<CartGenerate> row = new RowMappingCartGenerate();
			CartGenerate cart = jt.queryForObject(query, row, userid);
			return cart;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	
}
