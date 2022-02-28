package com.stationary.Items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Book {
private int pages;
private String pid;
private byte[] image;
@OneToOne
private ProductDriver p;
public ProductDriver getP() {
	return p;
}
public void setP(ProductDriver p) {
	this.p = p;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(int pages, String pid) {
	super();
	this.pages = pages;
	this.pid = pid;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
@Override
public String toString() {
	return "Book [pages=" + pages + ", pid=" + pid + "]";
}

}
