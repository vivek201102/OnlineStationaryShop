package com.stationary.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private int cartId;
	private String datetime;
	private String prodName;
	private String prodId;
	private int prodPrice;
	private int prodCount;
	private String prodImage;
	private int prodTotal;
	
	public UserCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCart(int id, int userId, int cartId, String datetime, String prodName, String prodId, int prodPrice,
			int prodCount, String prodImage) {
		super();
		this.id = id;
		this.userId = userId;
		this.cartId = cartId;
		this.datetime = datetime;
		this.prodName = prodName;
		this.prodId = prodId;
		this.prodPrice = prodPrice;
		this.prodCount = prodCount;
		this.prodImage = prodImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdCount() {
		return prodCount;
	}
	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public int getProdTotal() {
		return prodTotal;
	}

	public void setProdTotal(int prodTotal) {
		this.prodTotal = prodTotal;
	}
	
	public void count()
	{
		this.prodTotal = this.prodCount * this.prodPrice;
	}
}
