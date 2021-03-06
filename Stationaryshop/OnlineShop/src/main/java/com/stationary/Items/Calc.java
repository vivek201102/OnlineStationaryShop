package com.stationary.Items;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Calc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pId;
	private String pName;
	private String des;
	private String compName;
	private int price;
	private int stock;
	private String type;
	private String image;

	public Calc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calc(String pId, String pName, String des, String compName, int price, int stock, String type,
			String image) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.des = des;
		this.compName = compName;
		this.price = price;
		this.stock = stock;
		this.type = type;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Calc [pId=" + pId + ", pName=" + pName + ", des=" + des + ", compName=" + compName + ", price=" + price
				+ ", stock=" + stock + ", type=" + type + ", image=" + image + "]";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
