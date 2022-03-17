package com.stationary.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Rowmapper.RowMappingUser;
import com.stationary.entities.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;
	
	public HibernateTemplate getHt() {
		return ht;
	}
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public int insertObj(User p) {
		// TODO Auto-generated method stub
		this.ht.save(p);
		return 0;
	}

	@Transactional
	public int deleteObj(User p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional
	public int updateObj(User p) {
		// TODO Auto-generated method stub
		return 0;
	}


	public User getOneObj(String email) {
		// TODO Auto-generated method stub
		try {
			String query = "select * from user where email=?";
			RowMapper<User> row  = new RowMappingUser();
			User s = jt.queryForObject(query, row, email);
			return s;
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				return null;
			}
	}
	
	
	
	public User getUser(String email, String pass)
	{
		try {

			String query = "select * from user where email=? and password = ?";
			RowMapper<User> row  = new RowMappingUser();
			User s = jt.queryForObject(query, row, email, pass);
			return s;
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				return null;
			}
	}

}