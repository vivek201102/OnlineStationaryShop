package com.stationary.order;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Orderdetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	private String orderingDate;
	private String orderId;
	private int userId;
	private int cartId;
	@OneToMany
	private List<UserCart> itemPerOrder;
	private int total;
	private int grandTotal;
	public Orderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Orderdetail(int id, String orderingDate, String orderId, int userId, int cartId, List<UserCart> itemPerOrder,
			int total, int grandTotal) {
		super();
		this.id = id;
		this.orderingDate = orderingDate;
		this.orderId = orderId;
		this.userId = userId;
		this.cartId = cartId;
		this.itemPerOrder = itemPerOrder;
		this.total = total;
		this.grandTotal = grandTotal;
	}



	public int getGrandTotal() {
		return grandTotal;
	}



	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}



	public List<UserCart> getItemPerOrder() {
		return itemPerOrder;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderingDate() {
		return orderingDate;
	}
	public void setOrderingDate(String orderingDate) {
		this.orderingDate = orderingDate;
	}
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setMyOrderId(String orderId, String userId) {
		
		this.orderId = "ORD-STANRY-UR-" + userId +"-ORD-#256202" + orderId;
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
	public List<UserCart> getitemPerOrder() {
		return itemPerOrder;
	}
	public void setitemPerOrder(List<UserCart> itemPerOrder) {
		this.itemPerOrder = itemPerOrder;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void grandTotaol()
	{
		int tax = (int) (this.total * 0.1);
		this.grandTotal = this.total + tax;
	}
	
	public void calTot()
	{
		this.total = 0;
		for(UserCart u: this.itemPerOrder)
		{
			total += u.getProdCount() * u.getProdPrice();
		}
	}
}
