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
import com.stationary.entities.User;

@Repository
public class BookDao{
	
	@Autowired
	HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;
	
	@Transactional
	public int insertObj(Book p) {
		// TODO Auto-generated method stub
		this.ht.save(p);
		return 1;
	}

	@Transactional
	public int deleteObj(Book p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	
	@Transactional
	public int updateObj(Book p) {
		// TODO Auto-generated method stub
		this.ht.update(p);
		return 1;
	}

	
	public Book getById(String pId)
	{
		try {
		Book b = this.jt.queryForObject("select * from book where pId = ?", new RowMappingBook(), pId);
		return b;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public Book getOneObj(int id) {
		// TODO Auto-generated method stub
		Book b = ht.get(Book.class, id);
		return b;
	}
	
	public List<Book> getall()
	{
		return this.ht.loadAll(Book.class);
	}
	
	public int countBook()
	{
		List<Book> book = this.ht.loadAll(Book.class);
		return book.size();
	}
}