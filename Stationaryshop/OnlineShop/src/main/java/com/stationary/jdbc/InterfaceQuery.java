package com.stationary.jdbc;

import com.stationary.Items.Book;
import com.stationary.Items.Calc;
import com.stationary.Items.Desk;
import com.stationary.Items.Pen;
import com.stationary.Items.ProductDriver;

public interface InterfaceQuery {
public int insertProduct(ProductDriver p);
public int insertBook(Book b);
public int insertPen(Pen p);
public int insertCalc(Calc c);
public int insertDesk(Desk d);
}
