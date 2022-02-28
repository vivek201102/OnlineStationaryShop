package com.stationary.Items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Calc {
private String type,pid;
private byte[] image;
@OneToOne
private ProductDriver p;
public ProductDriver getP() {
	return p;
}
public void setP(ProductDriver p) {
	this.p = p;
}
public Calc() {
	super();
	// TODO Auto-generated constructor stub
}
public Calc(String type, String pid) {
	super();
	this.type = type;
	this.pid = pid;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
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
	return "Calc [type=" + type + ", pid=" + pid + "]";
}

}
