package com.stationary.Items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Desk {
private String material,pid;
private byte[] image;
@OneToOne
private ProductDriver p;
public Desk() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductDriver getP() {
	return p;
}
public void setP(ProductDriver p) {
	this.p = p;
}
public Desk(String material, String pid) {
	super();
	this.material = material;
	this.pid = pid;
}
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
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
	return "Desk [material=" + material + ", pid=" + pid + "]";
}

}
