package com.stationary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Book;
import com.stationary.Items.Desk;
import com.stationary.Rowmapper.RowMappingBook;
import com.stationary.Rowmapper.RowMappingDesk;

@Repository
public class DeskDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;
	
	
	@Transactional
	public int insertObj(Desk p) {
		// TODO Auto-generated method stub
		this.ht.save(p);
		return 1;
	}

	
	public int deleteObj(Desk p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	
	@Transactional
	public int updateObj(Desk p) {
		// TODO Auto-generated method stub
		this.ht.update(p);
		return 0;
	}
	
	public Desk getById(String pId)
	{
		try {
		Desk d = this.jt.queryForObject("select * from desk where pId = ?", new RowMappingDesk(), pId);
		return d;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public List<Desk> getall()
	{
		return this.ht.loadAll(Desk.class);
	}
	
	public Desk getOneObj(int id) {
		// TODO Auto-generated method stub
		Desk d = this.ht.get(Desk.class, id);
		return d;
	}

}