package com.stationary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Book;
import com.stationary.Items.Calc;
import com.stationary.Items.Desk;
import com.stationary.Rowmapper.RowMappingBook;
import com.stationary.Rowmapper.RowMappingCalc;
import com.stationary.entities.User;

@Repository
public class CalcDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;
	
	@Transactional
	public int insertObj(Calc p) {
		// TODO Auto-generated method stub
		ht.save(p);
		return 1;
	}

	@Transactional
	public int deleteObj(Calc p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	@Transactional
	public int updateObj(Calc p) {
		// TODO Auto-generated method stub
		this.ht.update(p);
		return 1;
	}

	public Calc getById(String pId)
	{
		try {
		Calc c = this.jt.queryForObject("select * from calc where pId = ?", new RowMappingCalc(), pId);
		return c;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	public Calc getOneObj(int id) {
		// TODO Auto-generated method stub
		Calc c = ht.get(Calc.class, id);
		return c;
	}
	
	public List<Calc> getall()
	{
		return this.ht.loadAll(Calc.class);
	}
	
	public int countCalc()
	{
		List<Calc> calc = this.ht.loadAll(Calc.class);
		return calc.size();
	}
}