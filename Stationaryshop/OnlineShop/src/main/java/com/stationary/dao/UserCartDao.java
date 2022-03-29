package com.stationary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Rowmapper.RowMappingUserCart;
import com.stationary.order.UserCart;

@Repository
public class UserCartDao {
	@Autowired
	private HibernateTemplate ht;
	@Autowired
	private JdbcTemplate jt;
	
	@Transactional
	public int insertCart(UserCart uc)
	{
		this.ht.save(uc);
		return 1;
	}
	
	public List<UserCart> getcart(int userid)
	{
		try {
			String query = "select * from usercart where userId = ?";
			List<UserCart> cart = this.jt.query(query, new RowMappingUserCart(), userid);
			return cart;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public boolean checkCart(int cartid, String prodId)
	{
		try {
			String query = "select * from usercart where cartId = ? and prodId = ?";
			RowMapper<UserCart> row = new RowMappingUserCart();
			UserCart cartitem = this.jt.queryForObject(query, row, cartid, prodId);
			if(cartitem == null)
			{
				return false;
			}
			else {
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
	
	public List<UserCart> getcurrentCart(int cartid, int userId)
	{
		try {
			String query = "select * from usercart where cartId = ? and userId = ?";
			RowMapper<UserCart> row = new RowMappingUserCart();
			List<UserCart> usercart = this.jt.query(query, row, cartid, userId);
			return usercart;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	@Transactional
	public int incrementItem(int cartId, String productId, int qty, int price) {
		try {
			int total = qty * price;
			jt.update("update UserCart set prodCount = ?, prodTotal = ? where cartId = ? and prodId = ?",qty, total,cartId,productId);
			return 1;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
	
	@Transactional
	public int deleteItem(int cartId, String productId) {
		try {
			jt.update("delete from UserCart where cartId = ? and prodId = ?",cartId,productId);
			return 1;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
}
