package com.stationary.Items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductDriver {
private String name,pid,description,companey;
private int price,stock;
@OneToOne(mappedBy = "p")
private Book b;
@OneToOne(mappedBy = "p")
private Desk d;
@OneToOne(mappedBy = "p")
private Pen p;
@OneToOne(mappedBy = "p")
private Calc c;
public ProductDriver() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductDriver(String name, String pid, String description, int price, int stock) {
	super();
	this.name = name;
	this.pid = pid;
	this.description = description;
	this.price = price;
	this.stock = stock;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
@Override
public String toString() {
	return "ProductDriver [name=" + name + ", pid=" + pid + ", description=" + description + ", price=" + price
			+ ", stock=" + stock + "]";
}

}
