package com.stationary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Rowmapper.RowMappingOrderDetail;
import com.stationary.order.Orderdetail;

@Repository
public class Orderdetaildao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;
	
	@Transactional
	public int insertOrder(Orderdetail o)
	{
		this.ht.save(o);
		return 1;
	}
	
	public List<Orderdetail> getorder(int userId)
	{
		try {
		String query = "select * from orderdetail where userId = ?";
		List<Orderdetail> od = this.jt.query(query, new RowMappingOrderDetail(), userId);
		return od;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public Orderdetail getcurrent(int userId, int cartId)
	{
		try {
			String query = "select * from orderdetail where userId = ? and cartId = ?";
			Orderdetail od = this.jt.queryForObject(query, new RowMappingOrderDetail(), userId, cartId);
			return od;
		}
		
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
