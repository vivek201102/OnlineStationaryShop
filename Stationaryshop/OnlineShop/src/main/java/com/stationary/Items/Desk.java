package com.stationary.Items;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Desk {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
private String pId;
private String pName;
private String des;
private String compName;
private int price;
private int stock;
private String material;

private String image;
public Desk() {
	super();
	// TODO Auto-generated constructor stub
}
public Desk(String pId, String pName, String des, String compName, int price, int stock, String material,
		String image) {
	super();
	this.pId = pId;
	this.pName = pName;
	this.des = des;
	this.compName = compName;
	this.price = price;
	this.stock = stock;
	this.material = material;
	this.image = image;
}
@Override
public String toString() {
	return "Desk [pId=" + pId + ", pName=" + pName + ", des=" + des + ", compName=" + compName + ", price=" + price
			+ ", stock=" + stock + ", material=" + material + ", image=" + image + "]";
}
public String getpId() {
	return pId;
}
public void setpId(String pId) {
	this.pId = pId;
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
public String getCompName() {
	return compName;
}
public void setCompName(String compName) {
	this.compName = compName;
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
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}




}
