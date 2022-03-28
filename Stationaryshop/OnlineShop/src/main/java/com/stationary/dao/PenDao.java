package com.stationary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Book;
import com.stationary.Items.Desk;
import com.stationary.Items.Pen;
import com.stationary.Rowmapper.RowMappingBook;
import com.stationary.Rowmapper.RowMappingPen;

@Repository
public class PenDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;

	@Transactional
	public int insertObj(Pen p) {
		// TODO Auto-generated method stub
		ht.save(p);
		return 1;
	}


	public int deleteObj(Pen p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	@Transactional
	public int updateObj(Pen p) {
		// TODO Auto-generated method stub
		this.ht.update(p);
		return 1;
	}

	public Pen getOneObj(int id) {
		// TODO Auto-generated method stub
		Pen pen = this.ht.get(Pen.class, id);
		return pen;
	}
	
	public Pen getById(String pId)
	{
		try {
		Pen p = this.jt.queryForObject("select * from pen where pId = ?", new RowMappingPen(), pId);
		return p;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public List<Pen> getall()
	{
		return this.ht.loadAll(Pen.class);
	}

}
