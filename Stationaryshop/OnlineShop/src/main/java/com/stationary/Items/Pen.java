package com.stationary.Items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Pen {
private String color,pid;
private byte[] image;
@OneToOne
private ProductDriver p;
public ProductDriver getP() {
	return p;
}
public void setP(ProductDriver p) {
	this.p = p;
}
public Pen() {
	super();
	// TODO Auto-generated constructor stub
}
public Pen(String color, String pid) {
	super();
	this.color = color;
	this.pid = pid;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
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
	return "Pen [color=" + color + ", pid=" + pid + "]";
}


}
