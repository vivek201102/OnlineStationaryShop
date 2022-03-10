package com.stationary.jdbc;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Book;
import com.stationary.Items.Calc;
import com.stationary.Items.Desk;
import com.stationary.Items.Pen;
import com.stationary.Items.ProductDriver;
import com.stationary.entities.User;

public class ImplimentInterfaceQuery implements InterfaceQuery {
private HibernateTemplate ht;
	@Override
	public int insertProduct(ProductDriver p) {
		return (int) ht.save(p);
	}

	@Override
	public int insertBook(Book b) {
		return (int) ht.save(b);
	}

	@Override
	public int insertPen(Pen p) {
		return (int) ht.save(p);
	}

	@Override
	public int insertCalc(Calc c) {
		return (int) ht.save(c);
	}

	@Override
	public int insertDesk(Desk d) {
		return (int) ht.save(d);
	}

	@Override
	public int insertUser(User u) {
		return (int) ht.save(u);
	}
	
	public HibernateTemplate getHt() {
		return ht;
	}
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
