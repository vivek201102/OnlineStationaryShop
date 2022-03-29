package com.stationary.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Rowmapper.RowMappingAdmin;
import com.stationary.entities.User;
import com.stationary.entities.admin;

@Repository
public class AdminDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;
	
	public boolean getAdmin(User user)
	{
		admin a = this.jt.queryForObject("select * from admin where userId = ?", new RowMappingAdmin(), user.getId());
		if(a == null)
			return false;
		return true;
	}
}
